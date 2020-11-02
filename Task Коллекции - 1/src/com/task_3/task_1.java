package com.task_3;

import java.util.Collection;
import java.util.HashSet;

public class task_1 {

    public static <T> Collection<T> removeDuplicates(Collection<T> coll) {
        return new HashSet<>(coll);
    }

}
