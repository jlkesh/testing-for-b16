package uz.jl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import javax.print.attribute.standard.Chromaticity;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testForFail() {

    }

    @Test
    void testForFizz() {
        String result = fizzBuzz.fizzBuzz(12);
        Assertions.assertEquals("Fizz", result);
    }

    @Test
    void testForBuzz() {
        String result = fizzBuzz.fizzBuzz(5);
        Assertions.assertEquals("Buzz", result);
    }

    @Test
    void testForFizzBuzz() {
        String result = fizzBuzz.fizzBuzz(15);
        Assertions.assertEquals("FizzBuzz", result);
    }

    @Test
    void testForNumber() {
        String result = fizzBuzz.fizzBuzz(2);
        Assertions.assertEquals("2", result);
    }

    @ParameterizedTest()
//    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
//    @MethodSource("get")
    @CsvSource(value = {
            "1, 1",
            "3, Fizz",
            "4, 4",
            "5, Buzz",
            "30, FizzBuzz",
    })
    @CsvFileSource(files = "")
    void repeatedTest(int number, String expectedResult) {
        String result = fizzBuzz.fizzBuzz(number);
        Assertions.assertEquals(expectedResult, result);
    }


    public static Stream<FizzBuzzData> get() {
        return Stream.of(
                new FizzBuzzData(1, "1"),
                new FizzBuzzData(3, "Fizz"),
                new FizzBuzzData(5, "Buzz"),
                new FizzBuzzData(8, "8"),
                new FizzBuzzData(15, "FizzBuzz"),
                new FizzBuzzData(27, "Fizz"),
                new FizzBuzzData(30, "FizzBuzz")
        );
    }

    static class FizzBuzzData {
        int number;
        String result;

        public FizzBuzzData(int i, String n) {
            this.number = i;
            this.result = n;
        }

        @Override
        public String toString() {
            return "FizzBuzzData{" +
                    "number=" + number +
                    ", result='" + result + '\'' +
                    '}';
        }
    }


}