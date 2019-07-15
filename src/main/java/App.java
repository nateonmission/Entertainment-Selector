import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class App
{
    public static void main(String[] args) {
        String NYTfilePath = ".\\books_uniq_weeks.csv";
        String BillboardPath = ".\\billboardData.csv";
        int targetYear = YearMenu();
        int targetMonth = MonthMenu();
        List<BestSellers> bestSellerList = BestSellers.ReadBooks(NYTfilePath, targetYear, targetMonth);
        List<HitSongs> hitSongList = HitSongs.ReadMusic(BillboardPath, targetYear, targetMonth);
        System.out.println("End of line");
    }

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




    private static int Two()
    {
        System.out.println("2");
        return 6;
    }

}

