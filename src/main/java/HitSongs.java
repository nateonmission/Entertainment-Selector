import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HitSongs
{

    public String date;
    public String position;
    public String song;
    public String performer;
    public String weeksOnChart;


    public HitSongs
            (
                    String date,
                    String position,
                    String song,
                    String performer,
                    String weeksOnChart
            )
    {
        this.date = date;
        this.position = position;
        this.song = song;
        this.performer = performer;
        this.weeksOnChart = weeksOnChart;
    }

    public static List<HitSongs> ReadMusic(String filePath, int targetYear, int targetMonth)
    {
        BufferedReader br = null;
        List<HitSongs> hitSong = new HitSongsReader(filePath, targetYear, targetMonth).getData();
        System.out.println("********** TOP SONGS **********");
        for (HitSongs temp : hitSong)
        {
            System.out.println(temp.song + " by " + temp.performer + " (" + temp.date + ")");

        }
        try
        {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null)
            {
                // System.out.println(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hitSong;
    }

}


