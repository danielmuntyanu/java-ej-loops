package com.daniel.views;

import com.daniel.controllers.LooperController;

public class HomeView extends View {
    public static void printGreeting() {
        String text = """


                === Welcome to LOOPS program! ===

                Enter the number to get a table of multiply. 
                ('q' to exit)
                """;
        
        System.out.println(text);
    }

    public static void printFarewell() {
        System.out.println("\n=== Goodbye ===\n\n");
    }
    
    public static int printMenu() {

        System.out.print("\nYour number is: ");

        String input = SCANNER.nextLine();

        try {

            if (input.equals("q")) {
                out();
                return 1;
            }

            int n = Integer.parseInt(input);
            LooperController.printTable(n);

            return printMenu();
        
        } catch (Exception exc) {
            System.out.println("Please, enter the valid number. (" + exc.getMessage() + ")\n");
            return printMenu();
        }


    }

    private static void out() {
        SCANNER.close();
    }
}
