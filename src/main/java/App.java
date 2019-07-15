import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        // Setting up the environment
        String NYTfilePath = ".\\books_uniq_weeks.csv";
        String BillboardPath = ".\\billboardData.csv";
        // Get user INPUT
        int targetYear = YearMenu();
        int targetMonth = MonthMenu();
        // Create user OUTPUT filename
        String JSONFilePath = ".\\RESULTS-" + String.valueOf(targetYear) + "-" + String.valueOf(targetMonth) + ".JSON";
        // Read files and get objects back
        List<BestSellers> bestSellerList = BestSellers.ReadBooks(NYTfilePath, targetYear, targetMonth);
        List<HitSongs> hitSongList = HitSongs.ReadMusic(BillboardPath, targetYear, targetMonth);
        // Put those objects in another object
        Entertainment entertainment = new Entertainment(bestSellerList, hitSongList);
        // Convert to JSON and save file
        try {
            packAndSave(entertainment, JSONFilePath);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("End of line");
    }

    // MENUS
    // The first menu accepts a two-digit year
    private static int YearMenu()
    {
        System.out.println("********** YEAR MENU **********");
        System.out.println("  11. 2011          14. 2014");
        System.out.println("  12. 2012          15. 2015");
        System.out.println("  13. 2013");
        System.out.println(" ");
        System.out.println("  00. Exit");
        System.out.println(" ");
        System.out.println("Please, make a selection: ");
        Scanner userSelection = new Scanner(System.in);
        int userSelectionInt = 0;
        try
        {
            userSelectionInt = userSelection.nextInt();
        }
        catch (java.util.InputMismatchException e)
        {
            System.out.println(e);
            System.out.println("I expected a NUMBER....");
        }

        if (userSelectionInt > 10 && userSelectionInt < 16)
        {
            return userSelectionInt;
        }
        else if (userSelectionInt == 00)
        {
            System.out.println("Goodbye!");
            System.exit(0);
            return 0;
        }
        else
        {
            System.out.println("Wait... What? I don't understand.");
            System.out.println("I'm just gonna quit.");
            System.exit(0);
            return 0;
        }
    }

    // The second menu accepts a one- or two-digit month
    private static int MonthMenu()
    {
        System.out.println("********** MONTH MENU **********");
        System.out.println("1. January          7. July");
        System.out.println("2. February         8. August");
        System.out.println("3. March            9. September");
        System.out.println("4. April            10. October");
        System.out.println("5. May              11. November");
        System.out.println("6. June             12. December");
        System.out.println(" ");
        System.out.println("            00. Exit");
        System.out.println(" ");
        System.out.println("Please, make a selection: ");
        Scanner userSelection = new Scanner(System.in);
        int userSelectionInt = 0;
        try
        {
            userSelectionInt = userSelection.nextInt();
        }
        catch (java.util.InputMismatchException e)
        {
            System.out.println(e);
            System.out.println("I expected a NUMBER....");
        }

        if (userSelectionInt > 0 && userSelectionInt < 13)
        {
            return userSelectionInt;
        }
        else if (userSelectionInt == 00)
        {
            System.out.println("Goodbye!");
            System.exit(0);
            return 0;
        }
        else
        {
            System.out.println("Wait... What? I don't understand.");
            System.out.println("I'm just gonna quit.");
            System.exit(0);
            return 0;
        }
    }

    // Converts final object to JSON and saves to disk
    private static void packAndSave(Entertainment entertainment, String JSONFilePath) throws java.io.IOException
    {
       Gson entertainmentJSON = new GsonBuilder().setPrettyPrinting().create();
       FileWriter fw = new FileWriter(JSONFilePath);
       entertainmentJSON.toJson(entertainment, fw);
       fw.close();
    }
}

