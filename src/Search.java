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
        Set<String> res = DB.search("vector +bool map set");
        // GUI_APP app = new GUI_APP();

        for (String i : res) {
            System.out.println(i);
        }
    }
}
