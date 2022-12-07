package service;

import logic.BubbleSort;
import logic.JavaSort;
import logic.Sort;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortServiceTest {
    // 다른 sort를 사용하고 싶은 경우 : 서비스로직을 사용하는 곳에서 다른 로직을 사용
    private SortService sut = new SortService(new BubbleSort<>());
    @Test
    void doSort() {
        // Given

        //When
        List<String> actual = sut.doSort(List.of("3","2","1"));
        //Then
        assertEquals(List.of("1","2","3"), actual);


    }
}