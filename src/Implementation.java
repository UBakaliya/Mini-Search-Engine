/**
 * @file Implementation.java 
 * @author Uvaish Bakaliya
 * @since 12-23-2022
 * @apiNote The creator has granted full access to the user who is utilizing it.
 * @copyright Copyright © 2022 UB
 */

package src;

import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;

public class Implementation implements Interface {
    // store the file data (bodyText.splitWord --> urls.set)
    private Map<String, Set<String>> database;
    private Set<String> queryResult;

    public Implementation() {
        this.queryResult = new HashSet<>();
        this.database = new HashMap<>();
        database.clear();
    }

    public int size() {
        return this.database.size();
    }

    @Override
    public String cleanToken(String str) {
        // Check if the string is empty or null
        if (str == null || str.isEmpty()) {
            return str;
        }
        // Initialize variables to store the start and end indices of the string
        int start = 0;
        int end = str.length() - 1;
        // Iterate through the string from the front and back, until we find a
        // non-punctuation character
        while (start <= end && !Character.isLetterOrDigit(str.charAt(start))) {
            start++;
        }
        while (end >= start && !Character.isLetterOrDigit(str.charAt(end))) {
            end--;
        }
        // Return the substring from the start index to the end index
        return str.substring(start, end + 1).toLowerCase();
    }

    @Override
    public Set<String> gatherToken(String bodyText) {
        // split the string by spaces and insert the split string into set
        Set<String> GToken = new HashSet<String>(Arrays.asList(bodyText.split(" ")));
        return GToken;
    }

    @Override
    public void buildDB(String bodyText, String url) {
        Set<String> text = this.gatherToken(bodyText); // split the body text
        // add the split body text to data base with the appropriate url
        for (final String i : text) {
            String word = this.cleanToken(i);
            if (word.equals("") || word.equals(" ")) {
                continue;
            }
            this.database.computeIfAbsent(word, V -> new HashSet<>()).add(url);
        }
        text.clear();
    }

    // Use full for finding the query in data base quickly
    private Set<String> findQuery(String query) {
        // edge case (MUST ME HANDLED):- if a query is not in data base
        if (!this.database.containsKey(query))
            return new HashSet<>();
        return this.database.get(query);
    }

    @Override
    public Set<String> search(String query) {
        queryResult.clear();
        // split the string by spaces
        ArrayList<String> splitQuery = new ArrayList<>(Arrays.asList(query.split(" ")));

        // if the search term more then one term then:
        for (final String i : splitQuery) {
            if (i.charAt(0) == '+')
                this.queryResult.retainAll(this.findQuery(this.cleanToken(i)));
            else if (i.charAt(0) == '-')
                this.queryResult.removeAll(this.findQuery(this.cleanToken(i)));
            else
                this.queryResult.addAll(this.findQuery(this.cleanToken(i)));
        }
        return this.queryResult;
    }

}
