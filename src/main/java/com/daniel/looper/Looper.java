package com.daniel.looper;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Looper implements ILooper {
    private int input;
    private List<Integer> factors = new LinkedList<Integer>();
    
    public Looper(int input) {
        this.input = input;

        for (int i = 1; i <= 10; i++) {
            this.factors.add(i);
        }
    }

    private int multiply(int input, int factor) {
        return input * factor;
    }

    private String getLine(int input, int factor) {
        StringBuilder line = new StringBuilder();
        line.append(input);
        line.append(" x ");
        line.append(factor);
        line.append(" = ");
        line.append(multiply(input, factor));
        return line.toString();
    }

    @Override
    public LinkedList<String> getTable() {
        Iterator<Integer> it = this.factors.iterator();
        LinkedList<String> table = new LinkedList<String>();

        while (it.hasNext()) {
            table.add(getLine(this.input, it.next()));
        }

        return table;
    }

}
