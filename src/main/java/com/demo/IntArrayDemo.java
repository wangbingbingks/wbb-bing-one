package com.demo;

import java.util.ArrayList;
import java.util.List;

public class IntArrayDemo {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 4};
        System.out.println("a = " + a);

        Integer aa = 5;
        int b = 5;
        System.out.println(aa.equals(b));


        List<Person> list = new ArrayList<>();
        Person person = new Person();
        person.setId(1);
        person.setName("wang");
        list.add(person);

        System.out.println();
    }
}
