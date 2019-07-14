import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

    public class HitSongsReader {
        private ArrayList<HitSongs> data = new ArrayList<HitSongs>();

        public HitSongsReader(String fileName, int targetYear, int targetMonth) {
            try {
                Reader in = new FileReader(fileName);
                Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
                for (CSVRecord record : records) {
                    String date = record.get("WeekID").trim();
                    String position = record.get("Peak Position").trim();
                    String song = record.get("Song").trim();
                    String performer = record.get("Performer").trim();
                    String weeksOnChart = record.get("Weeks on Chart").trim();

                    HitSongs hitSong = new HitSongs(
                            date,
                            position,
                            song,
                            performer,
                            weeksOnChart
                    );
                    // System.out.println(bestSeller.date.substring(bestSeller.date.length()-2));
                    // System.out.println(date);
                    int year = Integer.parseInt(hitSong.date.substring(hitSong.date.length()-2));
                    int month = getMonth(date);
                    //System.out.println(month + " / " + year);
                    //System.out.println("year: " + year + " month: " + month);
                    if(year == targetYear && month == targetMonth){
                        data.add(hitSong);
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
                // System.out.println("1 digit: " + date.substring(0,1) + " ... " + date.substring(1,2));
                return Integer.parseInt(date.substring(0,1));
            }
            else
            {
                // System.out.println("2 digit: " + date.substring(0,2) + " ... " + date.substring(1,2));
                return Integer.parseInt(date.substring(0,2));
            }
        }

        public ArrayList<HitSongs> getData() {
            return data;
        }
    }
