package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private final String body;
    private final List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    public String getBody() {
        return body;
    }

    public String toString() {
        String attrs = getAttributes().entrySet().stream()
                .map(e -> String.format(" %s=\"%s\"", e.getKey(), e.getValue()))
                .collect(Collectors.joining());
        String childrenStr = children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());
        return String.format("<%s%s>%s%s</%s>", getName(), attrs, getBody(), childrenStr, getName());
    }
}
// END
