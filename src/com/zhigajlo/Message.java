package com.zhigajlo;

import java.util.Objects;

public class Message {
    public String phoneNumber;
    public String message;

    public Message(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return Objects.equals(phoneNumber, message1.phoneNumber) && Objects.equals(message, message1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, message);
    }

    @Override
    public String toString() {
        return "Message{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
