package com.yejin.springpractice.Service;

import com.yejin.springpractice.logic.Sort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Bean으로 인식시킴(Component와 기능 동일하나 Service의 역할을 함)
public class SortService {
    // 결합 떼기 (Dependency Insertion)
    // field에 주입 데이터 넣기
    private final Sort<String> sort;

    // Contructor Insertion 사용
    // @Qualifier : 이름에 해당하는 component를 가져온다 (이름 지정해도 되고, 지정하지 않았다면 class명가져옴)
    public SortService(@Qualifier("javaSort") Sort<String> sort) {
        this.sort = sort;
        System.out.println("Ans : " + sort.getClass().getName());
    }

    public List<String> doSort(List<String> list) {
        // Sort<String> sort = new JavaSort<>();

        return sort.sort(list);
    }
}
