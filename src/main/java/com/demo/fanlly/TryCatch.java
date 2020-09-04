package com.demo.fanlly;

public class TryCatch {
    public static void main(String[] args) {
        String s = "s";
        Integer.parseInt(s);

        try {
            System.out.println("1111");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("-->finally");
        }
    }
}
