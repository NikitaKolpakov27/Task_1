package com.company;


public class Time {

    private static final int HOURS_IN_DAY = 24;
    private static final int MIN_IN_DAY = 60;
    private static final int SEC_IN_DAY = 60;

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int seconds) throws Exception {
        this.seconds = seconds;
        calcTimeUnits();
    }

    private int checkSubtractedNumber(int timeElem, int num, int constTimeElem) throws Exception {
        if (timeElem > 0 && num <= constTimeElem) {
            timeElem = timeElem - num;
        } else {
            throw new TimeException("Subtracted number is too big! " + num);
        }

        if (timeElem == constTimeElem) {
            timeElem = 0;
        }

        if (timeElem > constTimeElem) {
            throw new TimeException("Time element out of his bounds " + timeElem);
        }

        return timeElem;
    }

    private int checkAddedNumber(int timeElem, int num, int constTimeElem) throws Exception {
        if (num > 0 && num < constTimeElem) {
            timeElem = timeElem + num;
        } else {
            throw new TimeException("Added number is too big or too small! " + num);
        }

        if (timeElem == constTimeElem) {
            timeElem = 0;
        }

        if (timeElem > constTimeElem) {
            throw new TimeException("Time element out of his bounds! " + timeElem);
        }

        return timeElem;
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
        calcTimeUnits();
    }

    public String getAll() {
        return (Integer.toString(hours) + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds));
    }

    public void setAll(int hours, int minutes, int seconds) throws Exception {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        calcTimeUnits();
    }

    public void addHours(int addedNumber) throws Exception {
        hours = checkAddedNumber(hours, addedNumber, HOURS_IN_DAY);
    }

    public void addMinutes(int addedNumber) throws Exception {
        minutes = checkAddedNumber(minutes, addedNumber, MIN_IN_DAY);
    }

    public void addSeconds(int addedNumber) throws Exception {
        seconds = checkAddedNumber(seconds, addedNumber, SEC_IN_DAY);
    }

    public void subtractHours(int subtractedNumber) throws Exception {
        hours = checkSubtractedNumber(hours, subtractedNumber, HOURS_IN_DAY);
    }

    public void subtractMinutes(int subtractedNumber) throws Exception {
        minutes = checkSubtractedNumber(minutes, subtractedNumber, MIN_IN_DAY);
    }

    public void subtractSeconds(int subtractedNumber) throws Exception {
        seconds = checkSubtractedNumber(seconds, subtractedNumber, SEC_IN_DAY);
    }


    private void calcTimeUnits() throws Exception {
        checkMinutesAndHours(minutes, hours);

        if (seconds < 0) {
            throw new TimeException("Negative seconds! " + "seconds:" + seconds);
        } else if (seconds > HOURS_IN_DAY * MIN_IN_DAY * SEC_IN_DAY) {
            throw new TimeException("Too many seconds! " + "seconds:" + seconds);
        } else {
            hours += seconds / (MIN_IN_DAY * SEC_IN_DAY);
            minutes += seconds % (MIN_IN_DAY * SEC_IN_DAY) / MIN_IN_DAY;
            seconds = seconds % SEC_IN_DAY;
        }
        checkMinutesAndHours(minutes, hours);
    }

    public void checkMinutesAndHours(int minutes, int hours) throws Exception {
        if (minutes < 0  || hours < 0) {
            throw new TimeException("Negative minutes or hours! " + "hours:" + hours + " " + "minutes:" + minutes);
        }

        if (minutes > MIN_IN_DAY || hours > HOURS_IN_DAY) {
            throw new TimeException("Too big minutes or hours! " + "hours:" + hours + " " + "minutes:" + minutes);
        }
    }


}
