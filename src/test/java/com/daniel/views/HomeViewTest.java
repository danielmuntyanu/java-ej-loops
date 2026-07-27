package com.daniel.views;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HomeViewTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    
    @Test
    void testHomeView_printMenu() {
        String commands = String.format("%s\n%s\n", "5", "q");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(commands.getBytes());
        View.setScanner(new Scanner(inputStream));

        String numberRequest = "Your number is:";
        String result = "5 x 1 = 5";

        HomeView.printMenu();

        assertThat(outputStreamCaptor.toString().trim(), containsString(numberRequest));
        assertThat(outputStreamCaptor.toString().trim(), containsString(result));
    }

    @Test
    void testPrintMenu_shouldExitOnQ() {
        Scanner fakeScanner = new Scanner(new ByteArrayInputStream("q\n".getBytes()));
        View.setScanner(fakeScanner);

        int result = HomeView.printMenu();

        assertThat(result, is(1));
    }

    @Test
    void testHomeView_printMenuIncorrectInput() {
        String commands = String.format("%s\n%s\n%s\n", "plumbus", "6", "q");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(commands.getBytes());
        View.setScanner(new Scanner(inputStream));

        String numberRequest = "Please, enter the valid number";
        String result = "6 x 6 = 36";

        HomeView.printMenu();

        assertThat(outputStreamCaptor.toString().trim(), containsString(numberRequest));
        assertThat(outputStreamCaptor.toString().trim(), containsString(result));
    }

    @Test
    void testHomeView_welcomeMessage() {

        HomeView.printGreeting();

        String output = outputStreamCaptor.toString().trim();

        String expected = "Welcome to LOOPS program!";

        assertThat(output, containsString(expected));

    }

    @Test
    void testHomeView_printFarewell() {
        
        HomeView.printFarewell();

        String output = outputStreamCaptor.toString().trim();
        String expected = "Goodbye";

        assertThat(output, containsString(expected));

    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        View.resetScanner();
    }

}
