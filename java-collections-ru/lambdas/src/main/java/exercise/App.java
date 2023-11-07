package exercise;

import java.util.Arrays;
import java.util.stream.IntStream;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .flatMap(row -> IntStream.range(0, 2).mapToObj(i -> row)) // Duplicate each row
                .map(row -> Arrays.stream(row)
                        .flatMap(pixel -> IntStream.range(0, 2).mapToObj(i -> pixel)) // Duplicate each pixel
                        .toArray(String[]::new)) // Collect to array
                .toArray(String[][]::new); // Collect rows to array
    }
}
// END
