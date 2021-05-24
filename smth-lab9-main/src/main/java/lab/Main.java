package lab;

import java.util.Comparator;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Comparator.comparingInt;

/**
 * todo Document type Main
 */
public class Main {

    public static final String EMPTY = "";

    public static boolean containsEmptyString(String[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Provided null instead of array");
        }
        return asList(array).contains(EMPTY);
    }

    /**
     *
     * @param array
     * @return the longest string or the first
     */
    public String getLongestString(String[] array) {
        if (array == null || array.length == 0 || asList(array).contains(null)) {
            throw new IllegalArgumentException();
        }
        return stream(array).max(comparingInt(String::length)).orElseThrow(() -> new IllegalArgumentException("Array should contain at least one element"));
    }
}
