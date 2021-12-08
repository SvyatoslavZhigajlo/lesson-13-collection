package com.zhigajlo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class PredicateFilter{

    public <T> Collection<T> predicateFilter(Collection <T> collection, T elementSearch){
        Collection<T> result = new ArrayList<T>();

    for (T element: collection) {
        Predicate<T> predicate = t -> t.equals(elementSearch);
        if (predicate.test(element)) {
            result.add(element);
        }
    }
    return result;
    }


}
