package lab;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.swing.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * todo Document type MainTest
 */

public class MainTest {

    public static final String LONGEST_STRING = "longest string";
    public static final String OTHER_LONGEST_STRING = "longest strinf";
    public static final String SHORTEST_STRING = "shortest";
    public static final String EMPTY = "";
    private final Main main = new Main();


    @Test
    public void givenArrayWhenContainsEmptyStringThenCorrectBooleanReturned() {
        assertThat(Main.containsEmptyString(new String[] {"", "", "hello world"})).isTrue();
        assertThat(Main.containsEmptyString(new String[] {"hello world", "bye world"})).isFalse();
    }

    @Test
    public void givenNullWhenContainsEmptyStringThenIllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> Main.containsEmptyString(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void givenValidInputWhenGetLongestStringThenCorrectStringReturned(String[] input, String output) {
        System.out.println(main);
        assertThat(main.getLongestString(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @MethodSource("provideIllegalArguments")
    void givenInvalidInputWhenGetLongestStringThenIllegalArgumentExceptionThrown(String[] input, Class exceptionClass) {
        assertThatThrownBy(() -> main.getLongestString(input)).isInstanceOf(exceptionClass);
    }

    public static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new String[]{SHORTEST_STRING, LONGEST_STRING}, LONGEST_STRING),
            Arguments.of(new String[]{LONGEST_STRING, OTHER_LONGEST_STRING, OTHER_LONGEST_STRING}, LONGEST_STRING),
            Arguments.of(new String[]{LONGEST_STRING}, LONGEST_STRING),
            Arguments.of(new String[]{SHORTEST_STRING, LONGEST_STRING, EMPTY}, LONGEST_STRING),
            Arguments.of(new String[]{SHORTEST_STRING, LONGEST_STRING, OTHER_LONGEST_STRING, EMPTY}, LONGEST_STRING)
        );
    }

    public static Stream<Arguments> provideIllegalArguments() {
        return Stream.of(
            Arguments.of(new String[]{LONGEST_STRING, null}, IllegalArgumentException.class),
            Arguments.of(new String[]{}, IllegalArgumentException.class)
        );
    }
}