package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class QueryStrings {
    private List<QueryString> queryStrings = new ArrayList<>();
    public QueryStrings(String queryStringLine) {
        String[] queryStringTokens = queryStringLine.split("&");
        Arrays.stream(queryStringTokens)
                .forEach(queryString ->{
                    String[] values = queryString.split("=");
                    if(values.length != 2){
                        throw new IllegalArgumentException("Wrong QueryString Format");
                    }
                    queryStrings.add(new QueryString(values[0], values[1]));

                });

    }
}
