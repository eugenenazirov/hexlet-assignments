package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String charset, String neededWord) {
        List<String> charsetList = getListFromString(charset);
        List<String> neededWordList = getListFromString(neededWord);

        for (String ch : neededWordList) {
            if (!containsIgnoreCase(charsetList, ch)) {
                return false;
            }

            charsetList.remove(ch);
        }

        return true;
    }

    private static List<String> getListFromString(String s) {
        return new ArrayList<>(Arrays.asList(s.split("")));
    }

    private static boolean containsIgnoreCase(List<String> stringList, String ch) {
        for (String str : stringList) {
            if (str.equalsIgnoreCase(ch)) {
                return true;
            }
        }

        return false;
    }
}
//END
