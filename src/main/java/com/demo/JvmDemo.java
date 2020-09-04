package com.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JvmDemo {
    public byte[] b1 = new byte[128 * 1024];

    public static void main(String[] args) {
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("start...");*/
        //fill(1000);

        /*String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);

        String s3 = new String("abc");
        System.out.println(s1 == s3.intern());*/

        /*File f = new File("C:\\Users\\86134\\Desktop\\fullImg\\22o.jpg");

        System.out.println(f.exists());*/
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        for (int i = 0; i < 2; i++) {
            if(i == 0){
                list.remove("a");
            }else if(i == 1){
                list.remove("b");
            }

        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }

    private static void fill(int n) {
        List<JvmDemo> jlist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jlist.add(new JvmDemo());
        }
    }
}
