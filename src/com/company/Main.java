package com.company;


public class Main {

    public static void main(String[] args) throws Exception {

        Time t = new Time(7220); // 86400 / 3600 = 24
        Time p = new Time(534532424);

        System.out.println(t.getAll());
	    System.out.println("t is: " + t.getSeconds());
        System.out.println("p is: " + p.getAll());

        t.setAll(-12,-36,50);
        System.out.println(t.getAll());





        // todo: сделать отдельные методы для system out println
	    // ОШИБКА СО ЗНАКОМ ВРЕМЕНИ(-)
        try {
            t.setAll(21, 45, 45);
            System.out.println(t.getAll());
        } catch (ErrorWithNumberException e) {
            negativeTime();
        }

        // НЕСООТВЕТСТВИЕ ПРОМЕЖУТКУ ОТ 0 ДО 24
        try {
            p.setAll(10,0,0);
            p.AmountAndResidualHours(10);
            System.out.println(p.getHours());
        } catch (ErrorWithNumberException e) {
            incorrectTime();
        }




    }

    private static void negativeTime() {
        System.out.println("ОШИБКА: Введены неверные данные. Время не может быть отрицательным!");
    }

    private static void incorrectTime() {
        System.out.println("ОШИБКА: Время в часах не соответствует промежутку от 0 до 24!");
    }

    private static void incorrectWord() {
        System.out.println("ОШИБКА: Пожалуйста, введите ОДНО из слов: \"hours\", \"minutes\", \"seconds\" или \"all\" ");
    }


}
