package com.yejin.springpractice.logic;

import java.util.List;

public interface Sort<T> {
    List<T> sort(List<T> list);
}
