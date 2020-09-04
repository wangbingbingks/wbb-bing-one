package com.demo.forwhile;

public class Fori {
    public static void main(String[] args) {
        Fori.info();
    }


    public static void info(){

        System.out.println("Fori.info()");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        info();

    }

}
