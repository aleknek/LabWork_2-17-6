package com.brainacad.oop.testthread5;

public class Counter implements Runnable {

    private Storage storage;
    private boolean write;
    private Printer printer;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setWrite(boolean write) {
        this.write = write;
    }

    @Override
    public void run() {

        printer = storage.getPrinter();
        printer.setEndRead(false);
        int valueIncrement = storage.getValueIncrement();

        for (int i = 0; i < valueIncrement; i++) {

            if (i == valueIncrement - 1){
                printer.setEndRead(true);
            }

            synchronized (printer) {
                storage.setCurrentValue(i);
                printer.setRead(true);
                printer.notify();
            }

            synchronized (this) {
                while (!write) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
                this.write = false;
            }
        }
    }
}


