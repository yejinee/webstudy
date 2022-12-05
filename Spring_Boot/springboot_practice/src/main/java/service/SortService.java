package service;

import logic.JavaSort;
import logic.Sort;

import java.util.List;

/*
Sort 구현체를 받아서 정렬해서 리턴
=> 정확히 어떤 구현체인지는 알 수 X
 */
public class SortService {
    // 결합 떼기 (Dependency Insertion)
    // field에 주입 데이터 넣기
    private final Sort<String> sort;
    // Contructor Insertion 사용
    public SortService(Sort<String> sort) {
        this.sort = sort;
        System.out.println("Ans : " + sort.getClass().getName());
    }
    public List<String> doSort(List<String> list){
        // Sort<String> sort = new JavaSort<>();

        return sort.sort(list);
    }
}
