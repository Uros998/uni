package com.metropolitan.foodorderapp.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Hours {

    String Sunday;
    String Monday;
    String Tuesday;
    String Wednesday;
    String Thursday;
    String Friday;
    String Saturday;

    public String getSunday() {
        return Sunday;
    }

    public void setSunday(String Sunday) {
        this.Sunday = Sunday;
    }

    public String getMonday() {
        return Monday;
    }

    public void setMonday(String Monday) {
        this.Monday = Monday;
    }

    public String getTuesday() {
        return Tuesday;
    }

    public void setTuesday(String Tuesday) {
        this.Tuesday = Tuesday;
    }

    public String getWednesday() {
        return Wednesday;
    }

    public void setWednesday(String Wednesday) {
        this.Wednesday = Wednesday;
    }

    public String getThursday() {
        return Thursday;
    }

    public void setThursday(String Thursday) {
        this.Thursday = Thursday;
    }

    public String getFriday() {
        return Friday;
    }

    public void setFriday(String Friday) {
        this.Friday = Friday;
    }

    public String getSaturday() {
        return Saturday;
    }

    public void setSaturday(String Saturday) {
        this.Saturday = Saturday;
    }

    public String getTodaysHours() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());

        switch (day) {
            case "Sunday":
                return this.Sunday;
            case "Monday":
                return this.Monday;
            case "Tuesday":
                return this.Tuesday;
            case "Wednesday":
                return this.Wednesday;
            case "Thursday":
                return this.Thursday;
            case "Friday":
                return this.Friday;
            case "Saturday":
                return this.Saturday;
            default:
                return this.Sunday;
        }
    }

}