package com.brainacad.oop.testthread5;

public class Printer implements Runnable {

    private Storage storage;
    private boolean read;
    private Counter counter;
    private boolean endRead;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void setEndRead(boolean endRead) {
        this.endRead = endRead;
    }

    @Override
    public synchronized void run() {

        counter = storage.getCounter();

        while (!endRead) {
            synchronized (this) {
                while (!read) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
                this.read = false;
            }

            synchronized (counter) {
                System.out.println(storage.getCurrentValue());
                counter.setWrite(true);
                counter.notify();
            }
        }
    }
}



