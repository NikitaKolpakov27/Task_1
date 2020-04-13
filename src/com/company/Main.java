package com.company;


public class Main {

    public static void main(String[] args) throws Exception {

        Time t = new Time(0);
        System.out.println(t.getAll());

        t.addHours(2);
        System.out.println(t.getAll());

        System.out.println(t.getMinutes());
        t.setAll(15, 410, 10);
        System.out.println(t.getAll());




    }
}
