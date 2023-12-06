package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> srcList, int outputQuantity) {
        return srcList.stream()
                .sorted(Home::compareTo)
                .limit(outputQuantity)
                .map(Home::toString)
                .collect(Collectors.toList());
    }
}
// END
