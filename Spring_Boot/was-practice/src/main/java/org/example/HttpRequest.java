package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final RequestLine requestLine;

    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine()); // 2. 1st 줄을 읽는다
    }

    public void getQueryString() {
    }

    public QueryStrings getQueryStrings() {
        return requestLine.getQueryStrings();
    }

    public boolean isGetRequest() {
        return requestLine.isGetRequest(); // RequestLine에 Get method를 알 수 있기 때문
    }

    public boolean matchPath(String requestPath) {
        return requestLine.matchPath(requestPath);
    }
}
