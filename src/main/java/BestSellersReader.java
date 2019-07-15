
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.ArrayList;

public class BestSellersReader {
    private ArrayList<BestSellers> data = new ArrayList<BestSellers>();

    public BestSellersReader(String fileName, int targetYear, int targetMonth) {
        try {
            Reader in = new FileReader(fileName);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                String publisher = record.get("publisher").trim();
                String dagger = record.get("dagger").trim();
                String book_review_link = record.get("book_review_link").trim();
                String author = record.get("author").trim();
                String primary_isbn10 = record.get("primary_isbn10").trim();
                String price = record.get("price").trim();
                String primary_isbn13 = record.get("primary_isbn13").trim();
                String sunday_review_link = record.get("sunday_review_link").trim();
                String date = record.get("date").trim();
                String first_chapter_link = record.get("first_chapter_link").trim();
                String contributor = record.get("contributor").trim();
                String title = record.get("title").trim();
                String age_group = record.get("age_group").trim();
                String weeks_on_list = record.get("weeks_on_list").trim();

                BestSellers bestSeller = new BestSellers(
                        publisher,
                        dagger,
                        book_review_link,
                        author,
                        primary_isbn10,
                        price,
                        primary_isbn13,
                        sunday_review_link,
                        date,
                        first_chapter_link,
                        contributor,
                        title,
                        age_group,
                        weeks_on_list
                );
                int year = Integer.parseInt(bestSeller.date.substring(bestSeller.date.length()-2));
                int month = getMonth(date);
                if(year == targetYear && month == targetMonth){
                    data.add(bestSeller);
                }


            }
        } catch (FileNotFoundException e) {
            System.err.println("Record missing");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("IO Exception");
            System.exit(1);
        }
    }

    private int getMonth(String date)
    {
        if (date.substring(1,2).equals("/")) {
            return Integer.parseInt(date.substring(0,1));
        }
        else
        {
            return Integer.parseInt(date.substring(0,2));
        }
    }

    public ArrayList<BestSellers> getData() {
        return data;
    }
}