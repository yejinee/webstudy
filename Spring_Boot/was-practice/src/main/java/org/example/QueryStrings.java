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
    // key가 존재하면 value를 추출
    public String getValue(String key) {
        return this.queryStrings.stream().filter(queryString -> queryString.exists(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElse(null);
    }
}
