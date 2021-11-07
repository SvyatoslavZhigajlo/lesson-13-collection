package com.zhigajlo;

import java.time.LocalDate;

public class Contact {
    public String name;
    public String phoneNumber;
    public LocalDate birthday;

    public Contact(String name, String phoneNumber, LocalDate birthday) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }
}
