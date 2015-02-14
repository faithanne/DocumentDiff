package fa.documentdiff;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LineTest {

    Line line;

    @Before
    public void setUp() throws Exception {
        line = new Line("lineA", 4);
    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals("lineA", line.getValue());
    }

    @Test
    public void testGetLocations() throws Exception {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        assertEquals(expected, line.getLocations());
    }

    @Test
    public void testAddLocation() throws Exception {
        line.addLocation(6);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        expected.add(6);
        assertEquals(expected, line.getLocations());
    }
}