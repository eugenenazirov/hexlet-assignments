package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private final String labelText;
    private final TagInterface tag;

    public LabelTag(String labelText, TagInterface tag) {
        this.labelText = labelText;
        this.tag = tag;
    }

    public String render() {
        return String.format("<label>%s%s</label>", labelText, tag.render());
    }
}
// END
