package com.brainacad.oop.testthread5;

public class Main {

    public static void main(String[] args) {

        Storage storage = new Storage();
        storage.setValueIncrement(100);
        Counter counter = new Counter();
        Printer printer = new Printer();
        storage.setCounter(counter);
        storage.setPrinter(printer);

        counter.setStorage(storage);
        printer.setStorage(storage);

        Thread thread1 = new Thread(counter);
        Thread thread2 = new Thread(printer);

        thread1.start();
        thread2.start();

    }
}
