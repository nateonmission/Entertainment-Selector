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
                    String date = record.get("weekid").trim();
                    String position = record.get("position").trim();
                    String song = record.get("song").trim();
                    String performer = record.get("performer").trim();
                    String weeksOnChart = record.get("weeks_on_chart").trim();

                    HitSongs hitSong = new HitSongs(
                            date,
                            position,
                            song,
                            performer,
                            weeksOnChart,
                    );
                    // System.out.println(bestSeller.date.substring(bestSeller.date.length()-2));
                    int year = Integer.parseInt(hitSong.date.substring(2,4));
                    int month = Integer.parseInt(hitSong.date.substring(5,7));
                    //System.out.println(month + " / " + year);
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

        public ArrayList<BestSellers> getData() {
            return data;
        }
    }
