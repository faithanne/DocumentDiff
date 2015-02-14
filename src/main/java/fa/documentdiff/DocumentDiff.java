package fa.documentdiff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentDiff {

    public static Map<String, List<Result>> compareDocuments(Document source, Document target) {
        Map<String, List<Result>> results = initializeResults();
        Map<String, Line> sourceLines = source.getLines();
        Map<String, Line> targetLines = target.getLines();

        for (Map.Entry<String, Line> targetEntry : targetLines.entrySet()) {
            String key = targetEntry.getKey();

            if (sourceLines.containsKey(key)) {
                List<Integer> sourceLocations = sourceLines.get(key).getLocations();
                List<Integer> targetLocations = targetEntry.getValue().getLocations();

                results.get("both").add(new Result(key, sourceLocations, targetLocations));

                sourceLines.remove(key);
                targetLines.remove(key);
            }
            results.put("source", createResults("source", sourceLines));
            results.put("target", createResults("target", targetLines));
        }
        return results;
    }

    private static List<Result> createResults(String type, Map<String, Line> lines) {
        List<Result> results = new ArrayList<Result>();
        for (Map.Entry<String, Line> line : lines.entrySet()) {
            if (type.equals("source")) {
                results.add(new Result(line.getKey(), line.getValue().getLocations(), null));
            }
            else if (type.equals("target")) {
                results.add(new Result(line.getKey(), null, line.getValue().getLocations()));
            }
            else {
                throw new IllegalArgumentException("Must be source or target.");
            }
        }
        return results;
    }

    private static Map<String, List<Result>> initializeResults() {
        Map<String, List<Result>> results = new HashMap<String, List<Result>>();
        results.put("source", new ArrayList<Result>());
        results.put("target", new ArrayList<Result>());
        results.put("both", new ArrayList<Result>());
        return results;
    }


    public static Document makeDocument(String title, String data) {
        Document doc = new Document(title);
        String[] values = data.split("\n");
        for (int i = 0; i < values.length; i++) {
            doc.addLine(values[i], i + 1);
        }
        return doc;
    }
}