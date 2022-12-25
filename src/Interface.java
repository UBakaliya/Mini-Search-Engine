/**
 * @file Interface.java 
 * @since 12-23-2022
 * {@summary} All of the interface functions that will be used will be in this file.
 * @copyright Copyright © 2022 UB
 */

package src;

import java.util.Set;

public interface Interface {
    // remove any punctuations from front and back
    String cleanToken(String s);

    // split the body text into words and will return set
    Set<String> gatherToken(String body);

    // assigned the body text words to a urls (set)
    void buildDB(String splitWord, String url);

    // search the query in the database (map)
    void search(String query);
}