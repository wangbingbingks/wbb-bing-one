package com.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    private static ExecutorService service = Executors.newSingleThreadExecutor();


    public static void exeTask(String string) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("察觉到线程池中又增加了数据");
                System.out.println("此次增加的数据是：" + string);
            }
        });
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            exeTask(i + "");
        }

        try {
            Thread.sleep(2000);
            exeTask("2秒之后的数据,2222222222");

            Thread.sleep(2000);
            exeTask("4秒之后的数据,4444444444");

            Thread.sleep(2000);
            exeTask("6秒之后的数据,4444444444");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
