package fa.documentdiff;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DocumentTest {

    Document doc;

    @Before
    public void setUp() throws Exception {
        doc = new Document("test title");
    }

    @Test
    public void testAddLineSize() throws Exception {
        doc.addLine("value", 3);
        assertEquals(1, doc.getLines().size());
    }

    @Test
    public void testAddLineValue() throws Exception {
        doc.addLine("value", 3);
        assertEquals("value", doc.getLines().get("value").getValue());
    }

    @Test
    public void testAddLineLocation() throws Exception {
        doc.addLine("value", 3);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(3);
        assertEquals(expected, doc.getLines().get("value").getLocations());
    }

    @Test
    public void testAddLineExistingValue() throws Exception {
        doc.addLine("value", 3);
        doc.addLine("value", 9);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(3);
        expected.add(9);
        assertEquals(expected, doc.getLines().get("value").getLocations());
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals("test title", doc.getTitle());
    }
}