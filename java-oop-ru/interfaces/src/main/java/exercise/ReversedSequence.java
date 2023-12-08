package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String data;

    public ReversedSequence(String data) {
        this.data = reverse(data);
    }

    public int length() {
        return data.length();
    }

    public char charAt(int index) {
        return data.charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return data.subSequence(start, end);
    }

    public String toString() {
        return data;
    }

    private String reverse(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = tmp;
        }
        return new String(chars);
    }
}
// END
