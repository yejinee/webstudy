package logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaSortTest {
    @DisplayName("자바소트 - 리스트 넣으면 정렬결과 보여줌") //test의 제목
    @Test
    void given_list_WhenExecuting_ThenReturnSort() {
        // Given
        JavaSort<Integer> javaSort = new JavaSort<>();

        // When
        List<Integer> actual = javaSort.sort(List.of(5,3,2,4,1));

        // Then
        assertEquals(List.of(1,2,3,4,5), actual);
    }
}