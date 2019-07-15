import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

// The object that represents the top song
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

    // Calls the READER to build a list of songs and prints to console
    public static List<HitSongs> ReadMusic(String filePath, int targetYear, int targetMonth)
    {
        BufferedReader br = null;
        List<HitSongs> hitSong = new HitSongsReader(filePath, targetYear, targetMonth).getData();
        System.out.println("********** TOP SONGS **********");
        for (HitSongs temp : hitSong)
        {
            System.out.println(temp.song + " by " + temp.performer + " (" + temp.date + ")");

        }

        return hitSong;
    }

}


