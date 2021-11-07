package com.zhigajlo;

import java.time.LocalDateTime;

public class CallLog {

    public LocalDateTime dateTime;
    public int callDuration;
    public String numberTelephone;
    public TypeCall typeCall;


    public CallLog(LocalDateTime dateTime, int callDuration, String numberTelephone, TypeCall typeCall) {
        this.dateTime = dateTime;
        this.callDuration = callDuration;
        this.numberTelephone = numberTelephone;
        this.typeCall = typeCall;
    }
}
