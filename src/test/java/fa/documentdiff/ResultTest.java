package fa.documentdiff;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResultTest {

    @Test
    public void testGetValue() throws Exception {
        Result result = setUpResult("value", new Integer[]{1, 2, 3}, new Integer[]{1, 4, 5});
        assertEquals("value", result.getValue());
    }

    @Test
    public void testGetSourceLocations() throws Exception {
        Result result = setUpResult("value", new Integer[]{1, 2, 3}, new Integer[]{1, 4, 5});
        assertEquals(setUpLocations(new Integer[]{1, 2, 3}), result.getSourceLocations());
    }

    @Test
    public void testGetNullSourceLocations() throws Exception {
        Result result = setUpResult("value", null, new Integer[]{1, 4, 5});
        assertEquals(new ArrayList<Integer>(0), result.getSourceLocations());
    }

    @Test
    public void testGetTargetLocations() throws Exception {
        Result result = setUpResult("value", new Integer[]{1, 2, 3}, new Integer[]{1, 4, 5});
        assertEquals(setUpLocations(new Integer[]{1, 4, 5}), result.getTargetLocations());
    }

    @Test
    public void testGetNullTargetLocations() throws Exception {
        Result result = setUpResult("value", new Integer[]{1, 2, 3}, null);
        assertEquals(new ArrayList<Integer>(0), result.getTargetLocations());
    }

    public Result setUpResult(String value, Integer[] source, Integer[] target){
        return new Result(value, setUpLocations(source), setUpLocations(target));
    }

    public List<Integer> setUpLocations(Integer[] locations) {
        return (locations != null) ? Arrays.asList(locations) : null;
    }
}