package fa.documentdiff;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DocumentDiffTest {

    Document doc;

    @Before
    public void setUp() throws Exception {
        String data = "Las Vegas\nAtlanta\nOrlando\nLas Vegas\n";
        doc = DocumentDiff.makeDocument("Vacation Spots", data);
    }

    @Test
    public void testMakeDocumentSize() throws Exception {
        assertEquals(3, doc.getLines().size());
    }

    @Test
    public void testMakeDocumentLines() throws Exception {
        List<Line> expected = new ArrayList<Line>();

        Line lasVegas = new Line("Las Vegas", 1);
        lasVegas.addLocation(4);

        expected.add(lasVegas);
        expected.add(new Line("Atlanta", 2));
        expected.add(new Line("Orlando", 3));

        assertTrue(expected.equals(new ArrayList<Line>(doc.getLines().values())));
    }

    @Test
    public void testMakeDocumentTitle() throws Exception {
        assertEquals("Vacation Spots", doc.getTitle());
    }

    @Test
    public void testCompareDocuments() throws Exception {
        String data = "Singapore\nDubai\nLas Vegas\n";
        Document target = DocumentDiff.makeDocument("Places We Want to Go", data);

        assertEquals(expectedResults(), DocumentDiff.compareDocuments(doc, target));
    }

    private Map<String, List<Result>> expectedResults() {
        Map<String, List<Result>> results = new HashMap<String, List<Result>>();

        List<Result> both = new ArrayList<Result>();
        both.add(new Result("Las Vegas", Arrays.asList(1, 4), Arrays.asList(3)));

        List<Result> source = new ArrayList<Result>();
        source.add(new Result("Atlanta", Arrays.asList(2), null));
        source.add(new Result("Orlando", Arrays.asList(3), null));

        List<Result> target = new ArrayList<Result>();
        target.add(new Result("Singapore", null, Arrays.asList(1)));
        target.add(new Result("Dubai", null, Arrays.asList(2)));

        results.put("both", both);
        results.put("source", source);
        results.put("target", target);

        return results;
    }
}