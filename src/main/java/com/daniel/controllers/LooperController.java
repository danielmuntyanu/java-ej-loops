package com.daniel.controllers;

import java.util.LinkedList;
import java.util.Iterator;

import com.daniel.looper.Looper;
import com.daniel.looper.LooperDTO;
import com.daniel.looper.LooperMapper;

public class LooperController {
    public static void printTable(LooperDTO dto) {
        Looper looper = LooperMapper.toEntity(dto);
        LinkedList<String> table = looper.getTable();
        Iterator<String> it = table.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
