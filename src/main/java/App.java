import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        String NYTfilePath = ".\\books_uniq_weeks.csv";
        int targetYear = MainMenu();
        ReadPrimary(NYTfilePath, targetYear);
        System.out.println("End of line");
    }

    private static int MainMenu()
    {

        System.out.println("********** MAIN MENU **********");
        System.out.println("  11. 2011          14. 2014");
        System.out.println("  12. 2012          15. 2015");
        System.out.println("  13. 2013");
        System.out.println(" ");
        System.out.println("  00. Exit");
        System.out.println(" ");
        System.out.println("Please, make a selection: ");
        Scanner userSelection = new Scanner(System.in);
        int userSelectionInt = userSelection.nextInt();

        if (userSelectionInt > 10 || userSelectionInt < 16)
        {
            return userSelectionInt;
        }
        else if (userSelectionInt == 00)
        {
            return Two();
        }
        else
        {
            System.out.println("Goodbye!");
            return 3;
        }


    }

    private static int ReadPrimary(String filePath, int targetYear)
    {
        BufferedReader br = null;
        List<BestSellers> bestSeller = new BestSellersReader(filePath, targetYear).getData();
        for (BestSellers temp : bestSeller)
        {
            System.out.println(temp.title + " by " + temp.author + " (" + temp.date + ")");

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
        return 0;
    }


    private static int Two()
    {
        System.out.println("2");
        return 6;
    }

}

