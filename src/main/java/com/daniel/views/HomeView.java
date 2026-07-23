package com.daniel.views;

import com.daniel.controllers.LooperController;

public class HomeView extends View {
    public static void printMenu() {

        String text = """
                === Welcome to LOOPS program! ===

                Enter the number to get a table of multiply. 
                ('q' to exit)

                Your number is: 
                """;
        
        System.out.println(text);

        String input = SCANNER.nextLine();

        try {
            if (input == "q") out();

            int n = Integer.parseInt(input);
            LooperController.printTable(n);
        
        } catch (Exception exc) {
            System.out.println("Please, enter the valid number." + exc.getMessage() + "\n");
            printMenu();
        }
    }

    private static void out() {
        SCANNER.close();
    }
}
