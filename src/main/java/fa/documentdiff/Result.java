package fa.documentdiff;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private String value;
    private List<Integer> sourceLocations = new ArrayList<Integer>();
    private List<Integer> targetLocations = new ArrayList<Integer>();

    public Result(String value, List<Integer> sourceLocations, List<Integer> targetLocations) {
        this.value = value;
        this.sourceLocations = initializeLocations(sourceLocations);
        this.targetLocations = initializeLocations(targetLocations);
    }

    public String getValue() {
        return value;
    }

    public List<Integer> getSourceLocations() {
        return sourceLocations;
    }

    public List<Integer> getTargetLocations() {
        return targetLocations;
    }

    private List<Integer> initializeLocations(List<Integer> locations) {
        return (locations != null) ? locations : new ArrayList<Integer>(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (!sourceLocations.equals(result.sourceLocations)) return false;
        if (!targetLocations.equals(result.targetLocations)) return false;
        if (!value.equals(result.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + sourceLocations.hashCode();
        result = 31 * result + targetLocations.hashCode();
        return result;
    }
}