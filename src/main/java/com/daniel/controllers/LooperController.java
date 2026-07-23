package com.daniel.controllers;

import java.util.LinkedList;
import java.util.Iterator;

import com.daniel.looper.Looper;

public class LooperController {
    public static void printTable(int input) {
        Looper looper = new Looper(input);
        LinkedList<String> table = looper.getTable();
        Iterator<String> it = table.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
