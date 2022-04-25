import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class TestCalculator {

    private final Calculator calculator = new Calculator();


   /* @BeforeAll
    static void initBeforeAll() {
        System.out.println("Before all called");
    }

    @BeforeEach
    void init() {
        System.out.println("before each called");
        calculator = new Calculator();
    }*/
    @Test
    @DisplayName("test for sum")
    void testSum() {
        //GIVEN
        int first = 4;
        int second = 5;
        String operation = "+";
        String expectedResult = "9.00";

        //WHEN
        String actualResult = calculator.calculate(first, second, operation);
        //THEN
        assertEquals(expectedResult, actualResult);

    }
    @Test
    @DisplayName("test for sub")
    void testSubtraction() {
        //GIVEN
        int first = 8;
        int second = 3;
        String operation = "-";
        String expectedResult = "5,00";

        //WHEN
        String actualResult = calculator.calculate(first, second, operation);
        //THEN
        assertEquals(expectedResult, actualResult);

    }
    @Test
    @DisplayName("test for division")
    void testDivision() {
        //GIVEN
        int first = 4;
        int second = 3;
        String operation = "/";
        String expectedResult = "1,33";

        //WHEN
        String actualResult = calculator.calculate(first, second, operation);
        //THEN
        assertEquals(expectedResult, actualResult);

    }
    @ParameterizedTest
    @MethodSource("allOperations")
    void testSum_paramMethod(int first, int second, String operation, String expectedResult) {
        //WHEN
        String actualResult = calculator.calculate(first, second, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> allOperations() { //provideValidData()
        return Stream.of(
                Arguments.of(2,2, "*", "4,00"),
                Arguments.of(2,2,"/","1,00"),
                Arguments.of(2,4,"+","6,00"),
                Arguments.of(2,3,"-","-1,00")
        );
    }
}
