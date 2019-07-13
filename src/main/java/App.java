import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        ReadPrimary();
        MainMenu();
        System.out.println("End of line");
    }

    private static int MainMenu()
    {

        System.out.println("********** MAIN MENU **********");
        System.out.println("1. Option 1");
        System.out.println("2. Option 2");
        System.out.println("3. Exit");
        System.out.println(" ");
        System.out.println("Please, make a selection: ");
        Scanner userSelection = new Scanner(System.in);
        int userSelectionStr = userSelection.nextInt();

        if (userSelectionStr == 1)
        {
            return One();
        }
        else if (userSelectionStr == 2)
        {
            return Two();
        }
        else if (userSelectionStr == 3)
        {
            System.out.println("Goodbye!");
            return 3;
        }
        else
        {
            return 4;
        }

    }

    private static int ReadPrimary()
    {
        String filePath = ".\\books_uniq_weeks.csv";
        BufferedReader br = null;

        try
        {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null)
            {
                System.out.println(line);
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

    private static int One()
    {
        System.out.println("1");
        return 5;
    }

    private static int Two()
    {
        System.out.println("2");
        return 6;
    }

}

