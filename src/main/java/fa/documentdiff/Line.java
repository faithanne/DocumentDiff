package fa.documentdiff;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String value;
    private List<Integer> locations = new ArrayList<Integer>();

    public Line(String value, int location) {
        this.value = value;
        locations.add(location);
    }

    public String getValue() {
        return value;
    }

    public List<Integer> getLocations() {
        return locations;
    }

    public void addLocation(int location) {
        locations.add(location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (!locations.equals(line.locations)) return false;
        if (!value.equals(line.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + locations.hashCode();
        return result;
    }
}
