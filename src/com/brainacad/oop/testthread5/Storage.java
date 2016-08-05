package com.brainacad.oop.testthread5;

public class Storage {

    private int valueIncrement;
    private int currentValue;
    private Counter counter;
    private Printer printer;

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public int getValueIncrement() {
        return valueIncrement;
    }

    public void setValueIncrement(int valueIncrement) {
        this.valueIncrement = valueIncrement;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }
}

