package exercise;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String config) {
        return config.lines()
                .filter(line -> line.startsWith("environment="))
                .flatMap(line -> Stream.of(line
                        .replaceAll("\"", "")
                        .replaceAll("environment=", "")
                        .split(",")))
                .filter(var -> var.startsWith("X_FORWARDED_"))
                .map(var -> var.replaceFirst("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
