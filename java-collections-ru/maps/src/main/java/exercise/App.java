package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        String[] words = sentence.split(" ");
        Map<String, Integer> wordMap = new HashMap<>();
        if (sentence.isEmpty()) {
            return wordMap;
        }

        for (String word : words) {
            if (wordMap.containsKey(word)) {
                Integer wordCount = wordMap.get(word);
                wordMap.put(word, ++wordCount);
                continue;
            }
            wordMap.put(word, 1);
        }

        return wordMap;
    }

    public static String toString(Map<String, Integer> wordsMap) {
        if (wordsMap.isEmpty()) {
            return "{}";
        }
        String result = "{\n";
        for (Map.Entry<String, Integer> pair : wordsMap.entrySet()) {
            result += "  " + pair.getKey() + ": " + pair.getValue() + "\n";
        }
        result += "}";
        return result;
    }
}
//END
