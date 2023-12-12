package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public final class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    public String toString() {
        String attrs = getAttributes().entrySet().stream()
                .map((e) -> String.format(" %s=\"%s\"", e.getKey(), e.getValue()))
                .collect(Collectors.joining());
        return String.format("<%s%s>", getName(), attrs);
    }
}
// END
