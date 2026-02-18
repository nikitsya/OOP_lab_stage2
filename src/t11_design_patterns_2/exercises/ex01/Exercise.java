package t11_design_patterns_2.exercises.ex01;

interface Parser {
    int parseCount(String input);
}

class CsvParser implements Parser {
    @Override
    public int parseCount(String input) {
        if (input == null) return 0;

        String[] lines = input.split("\n");
        int count = 0;

        for (String line : lines) if (!line.trim().isEmpty()) count++;

        return count;
    }
}

class JsonParser implements Parser {
    @Override
    public int parseCount(String input) {
        if (input == null) return 0;

        int count = 0;
        for (int i = 0; i < input.length(); i++) if (input.charAt(i) == '{') count++;

        return count;
    }
}

class  XmlParser implements Parser {
    @Override
    public int parseCount(String input) {
        return 45;
    }
}

class ParserFactory {
    public Parser createFor(String extension) {
        if (extension == null || extension.isBlank()) throw new IllegalArgumentException("extension is null/blank.");

        String ext = extension.trim().toLowerCase();

        if (ext.equals("csv")) return new CsvParser();
        if (ext.equals("json")) return new JsonParser();
        if (ext.endsWith("xml")) return new XmlParser();

        throw new IllegalArgumentException("Unsupported extension: " + extension);
    }
}

public class Exercise {
    public static void run() {
        ParserFactory factory = new ParserFactory();
        Parser parser = factory.createFor("csv");

        String csvData = "a,b,c\n1,2,3\n4,5,6\n";
        System.out.println("CSV count = " + parser.parseCount(csvData));

        String jsonData = "{ \"id\": 1 }\n{ \"id\": 2 }\n";
        parser = factory.createFor("json");
        System.out.println("JSON count = " + parser.parseCount(jsonData));

        String xmlData = "{ id: 1 }\n{ id: 2 }\n";
        parser = factory.createFor("xml");
        System.out.println("XML count = " + parser.parseCount(xmlData));
    }
}
