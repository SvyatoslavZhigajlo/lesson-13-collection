package com.zhigajlo;

import java.util.Comparator;
import java.util.List;

public class Pair <T,U> {
    public final T t;
    public final U u;

    public Pair(T t, U u) {
        this.t = t;
        this.u = u;
    }

    @Override
    public String toString() {
        return  "Номер телефона: " + t +
                "\nКоличество звонков=" + u + "\n";
    }

}
