/**
 * @file Search.java 
 * @author Uvaish Bakaliya
 * @since 12-23-2022
 * @apiNote The creator has granted full access to the user who is utilizing it.
 * @copyright Copyright © 2022 UB
 */

package src;

import java.io.File;
import java.util.Scanner;
import java.util.Set;

public class Search extends Implementation {

    private Implementation DB;

    public Search() {
        DB = new Implementation();

        try {
            File outFile = new File("src/database_Files/database.txt");
            Scanner scanner = new Scanner(outFile);

            while (scanner.hasNextLine()) {
                String url = scanner.nextLine();
                String bodyText = scanner.nextLine();
                DB.buildDB(bodyText, url);
            }
            scanner.close();

        } catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG");
            System.exit(0);
        }
    }

    public void RUN() {
        Set<String> result;
        System.out.println("Welcome to Search Engine!");
        System.out.println("Data base contains total: '" + DB.size() + "'. Queries terms.\n");
        Scanner queryEntry = new Scanner(System.in);
        System.out.print("Enter a query to search: ");
        String input = queryEntry.nextLine();
        while (input != "") { // exit on enter
            result = DB.search(input);
            System.out.println("Total URLs: " + result.size() + "\n");
            for (final String i : result) {
                System.out.println(i);
            }
            System.out.print("\nEnter a query to search: ");
            input = queryEntry.nextLine();
        }
        queryEntry.close();
    }
}
