
/**
 * @file Main.java
 * @author Uvaish Bakaliya
 * {@summary} The application is a Java version of a C++ based mine
          search engine. There will be a "Graphical User Interface (GUI)" for
          this program. The software will have numerous files and be written
          entirely in OOP. The "src" folder contains every file.
 * @since 12-23-2022
 * @apiNote The creator has granted full access to the user who is utilizing it.
 * @copyright © 2022 Uvaish Bakaliya
 */

import src.Search;

public class Main {

    public static void main(String[] args) {
        new Search("src/database_Files/database.txt");
    }
}
