package com.zhigajlo;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallLog callLog = (CallLog) o;
        return callDuration == callLog.callDuration && Objects.equals(dateTime, callLog.dateTime) &&
                Objects.equals(numberTelephone, callLog.numberTelephone) && typeCall == callLog.typeCall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, callDuration, numberTelephone, typeCall);
    }
}
