package com;

import java.util.concurrent.TimeUnit;

public class Test {
    public static ThreadLocal<Person> t1 = new ThreadLocal<Person>();

    public static void main(String[] args) {

        //线程1
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                t1.set(new Person());
            }
        }).start();

        //线程2
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(t1.get());
            }
        }).start();
    }
}

class Person {

}