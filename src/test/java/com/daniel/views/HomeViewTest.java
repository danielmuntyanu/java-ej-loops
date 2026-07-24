package com.daniel.views;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
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

}
