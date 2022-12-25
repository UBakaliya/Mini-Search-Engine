package src;

import java.io.File;
import java.util.Scanner;

public class Search extends Implementation {

    private Interface DB;

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
            System.out.println("CAN'T LOAD THE DATA BASE. TRY AGAIN.");
            System.exit(0);
        }
    }

    public void querySearch(String s) {
        DB.search(s);
    }
    
}
