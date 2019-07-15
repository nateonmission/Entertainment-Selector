import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

// This is the READER of the Bilboard CSV
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
                    int year = Integer.parseInt(hitSong.date.substring(hitSong.date.length()-2));
                    int month = getMonth(date);
                    int positionInt = Integer.parseInt(hitSong.position);
                    if(year == targetYear && month == targetMonth && positionInt < 2){
                        if (!dupSong(hitSong, data)) {
                            data.add(hitSong);
                        }
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

        // Slices String date to get month
        private int getMonth(String date)
        {
            if (date.substring(1,2).equals("/"))
            {
                return Integer.parseInt(date.substring(0,1));
            }
            else
            {
                return Integer.parseInt(date.substring(0,2));
            }
        }

    // Scans songs in list to prevent duplicate songs in the list
    private boolean dupSong(HitSongs hitSong, List<HitSongs> data)
    {
        boolean duplicate = false;
        for(HitSongs song : data)
        {
            if (hitSong.song.equals(song.song))
            {
                duplicate = true;
            }
        }
        return duplicate;
    }
        public List<HitSongs> getData() {
            return data;
        }
    }
