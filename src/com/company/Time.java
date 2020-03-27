package com.company;


public class Time {

    private static final int MAX_HOUR = 24;
    private static final int MAX_SIZE_MIN = 60;
    private static final int MAX_SIZE_SEC = 60;


    private int hours;
    private int minutes;
    private int seconds;

    TimeUnit timeUnit; //todo: что тут?


    public void negativeNumbers(int number) throws Exception {
        if (number < 0) {
            exceptionFunction(timeUnit, number);
        }
    }

    public Time(int seconds) throws Exception {
        this.seconds = seconds;
        //negativeNumbers(seconds);
    }

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }

    int getSeconds()  {
        return seconds;
    }

    public void setTime(int seconds) throws Exception {
        this.seconds = seconds;
    }

    public String getAll() throws Exception {
        timeConvertation();
        return hours + ":" + minutes + ":" + seconds;
    }

    public void setAll(int hours, int minutes, int seconds) throws Exception {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    public void AmountAndResidualHours(int n) throws Exception {
        timeUnit = TimeUnit.HOURS; //
        hours = hours + n;
        negativeNumbers(hours);
        if (hours  > MAX_HOUR) {
            throw new ErrorWithNumberException("Не может быть! Больше 24 часов!", hours);
        }
        if (hours == MAX_HOUR) {
            hours = 0;
        }
    }

    public void AmountAndResidualMinutes(int n) throws Exception {
        timeUnit = TimeUnit.MINUTES;
        minutes = minutes + n;
        negativeNumbers(minutes);
    }

    public void AmountAndResidualSeconds(int n) throws Exception {
        timeUnit = TimeUnit.SECONDS;
        seconds = seconds + n;
        negativeNumbers(seconds);
    }

    public void removeTime() {
        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;
    }

    public void timeConvertation() throws Exception {
        if (seconds >= MAX_SIZE_SEC) {
            minutes = secondsToMinutesToHours(0, seconds, minutes);
            seconds = seconds % MAX_SIZE_SEC;
        } timeUnit = TimeUnit.SECONDS;
        negativeNumbers(seconds);


        if (minutes >= MAX_SIZE_MIN) {
            hours = secondsToMinutesToHours(0, minutes, hours);
            minutes = minutes % MAX_SIZE_MIN;
        } timeUnit = TimeUnit.MINUTES;
        negativeNumbers(minutes);

        if (hours >= MAX_HOUR) {
            hours = 0;
        } timeUnit = TimeUnit.HOURS;
        negativeNumbers(hours);

    }

    public int secondsToMinutesToHours(int result, int hms, int hms2) {
        result = hms / 60;
        hms2 = hms2 + result;
        hms = hms % 60;
        return hms2;
    }

    private void exceptionFunction(TimeUnit timeUnit, int value) throws Exception {
        TimeUnitException tue;
        switch (timeUnit) {
            case HOURS:
                tue = new TimeUnitException("Hours are wrong! " + "Incorrect value is: " + value);
                break;
            case MINUTES:
                tue = new TimeUnitException("Minutes are wrong! " + "Incorrect value is: " + value);
                break;
            case SECONDS:
                tue = new TimeUnitException("Seconds are wrong! " + "Incorrect value is: " + value);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + timeUnit);
        }
        throw tue;
    }

    //todo: проверку нужно делать в сеттерах, а не в геттерах!
}
