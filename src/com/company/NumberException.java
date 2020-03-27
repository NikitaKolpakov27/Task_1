package com.company;

class ErrorWithNumberException extends Exception {
    private int number;

    public int getNumber() {
        return number;
    }

    ErrorWithNumberException(String message, int num) {
        super(message);
        number = num; //TODO: Спросить про необходимость num и number
    }
}
