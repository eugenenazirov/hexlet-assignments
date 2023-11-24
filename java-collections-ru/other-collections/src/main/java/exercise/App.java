package exercise;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.Objects;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        NavigableSet<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        Map<String, String> diff = new LinkedHashMap<>();

        for (String key : keys) {
            if (!map1.containsKey(key)) {
                diff.put(key, "added");
            } else if (!map2.containsKey(key)) {
                diff.put(key, "deleted");
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                diff.put(key, "changed");
            } else {
                diff.put(key, "unchanged");
            }
        }

        return diff;
    }
}
//END
