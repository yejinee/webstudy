package org.example;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QueryStringsTest {

    @Test
    void createTest() {
        // List<QueryString> 을 통해 여러개 검증
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55");
        assertThat(queryStrings).isNull();


    }
}
