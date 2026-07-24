package com.daniel.looper;

import java.util.LinkedList;

public interface ILooper {
    LinkedList<String> getTable();
    int multiply(int input, int factor);
    String getLine(int input, int factor);
}
