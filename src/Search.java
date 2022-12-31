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
import javax.swing.JOptionPane;

public class Search extends Implementation {

    private Implementation DB;

    public Search(String fileName) {
        DB = new Implementation();
        File outFile = new File(fileName);
        String txt = fileName.substring(fileName.length() - 3, fileName.length());
        if (txt.equals("txt")) {
            try {
                Scanner scanner = new Scanner(outFile);

                while (scanner.hasNextLine()) {
                    String url = scanner.nextLine();
                    String bodyText = scanner.nextLine();
                    DB.buildDB(bodyText, url);
                    DB.buildBodyTextDB(url, bodyText);
                }
                scanner.close();
                this.RUN();
            } catch (Exception e) {
                this.RUN();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid 'txt'", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void RUN() {
        new GUI_APP(DB).RUN_GUI(DB);
        // -------------------------------------------------------------
        // @NOTE: BELOW CODE ONLY RUNS IN TERMINAL. USE FULL FOR DUBBING.
        // -------------------------------------------------------------
        // Set<String> result;
        // System.out.print("\033[H\033[2J");
        // System.out.println("### Welcome to Search Engine! ###\n");
        // System.out.println("* Database contains total: '" + DB.size() + "' queries
        // terms.\n");
        // Scanner queryEntry = new Scanner(System.in);
        // System.out.print("Enter a query to search: ");
        // String input = queryEntry.nextLine();
        // while (input != "") { // exit on enter
        // result = DB.search(input);
        // System.out.println("Total URLs: " + result.size() + "\n");
        // for (final String i : result) {
        // System.out.println(i);
        // }
        // System.out.print("\nEnter a query to search: ");
        // input = queryEntry.nextLine();
        // }
        // System.out.println("\nThank you for searching!");
        // queryEntry.close();
    }

}
