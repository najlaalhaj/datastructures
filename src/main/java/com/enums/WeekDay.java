package com.enums;

public enum WeekDay {

   MONDAY("Working Day"),TUESDAY("Working Day"),WEDNESDAY("Working Day"), THURSDAY("Working Day"), FRIDAY("Working Day"), SATURDAY("Weekend Day"), SUNDAY("Weekend Day");

   String dayType;

    WeekDay(String dayType) {
        this.dayType = dayType;
    }

    public String getDayType(){
        return this.dayType;
    }
}
