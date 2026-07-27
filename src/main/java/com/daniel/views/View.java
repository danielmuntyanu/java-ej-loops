package com.daniel.views;

import java.util.Scanner;

public class View {

    protected static Scanner scanner;
    
    protected static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }    
    
    // for tests
    protected static void setScanner(Scanner customScanner) {
        scanner = customScanner;
    }

    // between tests
    protected static void resetScanner() {
        scanner = null;
    }
    

}
