package fa.documentdiff;

import java.util.LinkedHashMap;
import java.util.Map;

public class Document {

    private Map<String, Line> lines = new LinkedHashMap<String, Line>();
    private String title;

    public Document(String title) {
        this.title = title;
    }

    public void addLine(String value, int location) {
        if (lines.containsKey(value)) {
            lines.get(value).addLocation(location);
        }
        else {
            lines.put(value, new Line(value, location));
        }
    }

    public String getTitle() {
        return title;
    }

    public Map<String, Line> getLines() {
        return lines;
    }
}
