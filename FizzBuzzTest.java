import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    @ParameterizedTest
    @CsvSource({
            "1,  1",
            "2,  2",
            "3,  Fizz",
            "4,  4",
            "5,  Buzz",
            "6,  Fizz",
            "9,  Fizz",
            "10, Buzz",
            "15, FizzBuzz",
            "30, FizzBuzz"
    })
    void test_fizzBuzz_1(int input, String output) {
        String result = FizzBuzz.execute(input);
        assertEquals(output, result);
    }

}