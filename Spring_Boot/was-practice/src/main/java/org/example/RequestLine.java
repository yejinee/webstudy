package org.example;

import java.util.Objects;

public class RequestLine {
    private final String method; // GET
    private final String urlPath; // /calculate
    private String queryStrings; // operand1=11&operator=*&operand2=55

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    public RequestLine(String requestLine) {
        // GET /calculate?operand1=11&operator=*&operand2=55
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];
        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

        if (urlPathTokens.length == 2) {
            this.queryStrings = urlPathTokens[1];
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }

    public RequestLine(String method, String urlPath, String queryStrings) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = queryStrings;
    }
}
