package src;

import java.util.*;

public class Implementation implements Interface {
    // store the file data (bodyText.splitWord --> urls.set)
    private Map<String, Set<String>> database;

    public Implementation() {
        this.database = new HashMap<>();
    }

    public int size() {
        return this.database.size();
    }

    @Override
    public String cleanToken(String str) {
        str = str.replaceAll("\\p{Punct}", "");
        str.toLowerCase();
        return str;
    }

    @Override
    public Set<String> gatherToken(String bodyText) {
        this.cleanToken(bodyText);
        Set<String> GToken = new HashSet<String>(Arrays.asList(bodyText.split(" ")));
        return GToken;
    }

    @Override
    public void buildDB(String bodyText, String url) {
        Set<String> text = this.gatherToken(bodyText);
        for (final String i : text) {
            if (i != "" && i != " ") {
                this.database.computeIfAbsent(i, VALUE -> new HashSet<>()).add(url);
            }
        }
    }

    private Set<String> findQuery(String query) {
        Set<String> res = this.database.get(query);
        return res;
    }

    private Set<String> queryUnion() {
        Set<String> unionSet = new HashSet<>();
        // TO DO
        // ...
        return unionSet;
    }

    private Set<String> queryIntersection() {
        Set<String> intersectionSet = new HashSet<>();
        // TO DO
        // ...
        return intersectionSet;
    }

    private Set<String> queryDifference() {
        Set<String> differenceSet = new HashSet<>();
        // TO DO
        // ...
        return differenceSet;
    }

    @Override
    public void search(String query) {
        query.toLowerCase();
        

    }

}
