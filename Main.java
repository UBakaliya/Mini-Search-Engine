
/**
 * @file Main.java (This file will run the program)
 * @author Uvaish Bakaliya
 *         {@summary} The application is a Java version of a C++-based mine
 *         search engine. There will be a "Graphical User Interface (GUI)" for
 *         this program. The software will have numerous files and be written
 *         entirely in OOP. The "src" folder contains every file.
 * @since 12-23-2022
 * @apiNote The creator has granted full access to the user who is utilizing it.
 * @copyright Copyright © 2022 UB
 */

/************************************************************************************
 * Layout:
 * 1. File with the interface methods.
 * 2. File with the implementing the methods.
 * 3. GUI application that will run the above number 2 file methods and display
 * the interface.
 * 4. This file will run the program. (By calling the number 3)
 * LASTLY: BUILD TEST CEASES!
 ************************************************************************************/

import src.Search;

public class Main {

    public static void main(String[] args) {
        Search SEARCH_ENGINE = new Search();
        SEARCH_ENGINE.RUN();
    }
}
