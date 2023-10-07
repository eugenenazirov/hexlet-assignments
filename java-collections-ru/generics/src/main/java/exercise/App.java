package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
public class App {
    public static <K, V> List<Map<K, V>> findWhere(
            List<Map<K, V>> booksList,
            Map<K, V> search
    ) {
        if (search.isEmpty()) {
            return new ArrayList<>();
        }

        List<Map<K, V>> result = new ArrayList<>();
        for (Map<K, V> book : booksList) {
            if (App.containsAllSearchedFields(book, search)) {
                result.add(book);
            }
        }

        return result;
    }

    private static <K, V> boolean containsAllSearchedFields(
            Map<K, V> book,
            Map<K, V> search
    ) {
        for (Map.Entry<K, V> pair : search.entrySet()) {
            if (!book.containsKey(pair.getKey()) || !book.containsValue(pair.getValue())) {
                return false;
            }
        }
        return true;
    }
}
//END
