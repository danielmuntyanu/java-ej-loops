package com.daniel.looper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

// import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

public class LooperTest {

    @Test
    void testLooperGetTable_shouldReturnTable() {
        ILooper looper = new Looper(5);
        
        String[] list = {
            "5 x 1 = 5",
            "5 x 2 = 10",
            "5 x 3 = 15",
            "5 x 4 = 20",
            "5 x 5 = 25",
            "5 x 6 = 30",
            "5 x 7 = 35",
            "5 x 8 = 40",
            "5 x 9 = 45",
            "5 x 10 = 50"
        };

        List<String> excepted = new LinkedList<String>(Arrays.asList(list));
        
        assertThat(looper.getTable(), is(excepted));
    }


    // getLine()
    
    @Test
    void testLooperGetLine_shouldReturnCorrectLine() {
        int input = 25;
        int factor = 5;

        ILooper looper = new Looper(input);

        assertThat(looper.getLine(input, factor), is("25 x 5 = 125"));
    }

    // multiply()

    @ParameterizedTest(name = "{0}, {1} is expected to output {2}")
    @MethodSource("multiplyTestCases")
    public static void testMultiply(int input, int factor, int expected) {
        ILooper looper = new Looper(input);
        int result = looper.multiply(input, factor);
        assertThat(result, is(expected));
    }

    private static Stream<Arguments> multiplyTestCases() {
        return Stream.of(
            Arguments.of(1, 1, 1),
            Arguments.of(5, 5, 25),
            Arguments.of(3, 3, 9),
            Arguments.of(250, 4, 1000),
            Arguments.of(47, 10, 470),
            Arguments.of(25, 3, 75),
            Arguments.of(4, 3, 12),
            Arguments.of(99, 9, 891),
            Arguments.of(23, 4, 92),
            Arguments.of(55, 6, 330),
            Arguments.of(14285, 8, 114280),
            Arguments.of(0, 5, 0)
            );
    }
}
