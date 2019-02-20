package com.epam;

import java.time.LocalTime;

public class LocalTimeTest {

    public static void main(String[] args) throws InterruptedException {
        LocalTime start = LocalTime.now();
        Thread.sleep(10);
        LocalTime koniec = LocalTime.now();
        System.out.println("Start: " + start );
        System.out.println("Koniec: " + koniec );
        System.out.println(koniec.compareTo(start));

    }
}
