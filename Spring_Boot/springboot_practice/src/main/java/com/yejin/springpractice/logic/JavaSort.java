package com.yejin.springpractice.logic;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component // Bean으로 인식시킴
public class JavaSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public List<T> sort(List<T> list) {
        List<T> output = new ArrayList<>(list);
        Collections.sort(output);

        return output;
    }

}
