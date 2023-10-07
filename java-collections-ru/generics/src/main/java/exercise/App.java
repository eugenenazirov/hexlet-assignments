package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(
            List<Map<String, String>> booksList,
            Map<String, String> search
    ) {
        if (search.isEmpty()) {
            return new ArrayList<>();
        }

        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book : booksList) {
            if (containsAllSearchedFields(book, search)) {
                result.add(book);
            }
        }

        return result;
    }

    private static boolean containsAllSearchedFields(
            Map<String, String> book,
            Map<String, String> search
    ) {
        for (Map.Entry<String, String> pair : search.entrySet()) {
            if (!book.containsKey(pair.getKey()) || !book.containsValue(pair.getValue())) {
                return false;
            }
        }
        return true;
    }
}
//END
