package rs.raf.m_stojanovic.pp.programs.regexvalidator.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NamedRegexSource implements RegexSource {

    private final String title;

    private final String[] lines;

    private final File file;

    public NamedRegexSource(String title, String[] lines, File file) {
        this.title = title;
        this.lines = lines;
        this.file = file;
    }

    public final UsableRegexSource toUsableRegexSource() {
        Map<String, List<String>> parsedLines = new HashMap<>();
        for (String kw: new String[] {"TITLE", "COMMENT", "TRUE", "FALSE"})
            parsedLines.put(kw, new ArrayList<>());
        String part = "";
        for (String l : this.lines) {
            if (parsedLines.containsKey(l))
                part = l;
            else
                parsedLines.get(part).add(l);
        }
        String title = parsedLines.get("TITLE").get(0);
        StringBuilder commentBuilder = new StringBuilder();
        for (String c : parsedLines.get("COMMENT"))
            commentBuilder.append(c).append("\n");
        String comment = commentBuilder.toString().trim();
        List<String> goods = parsedLines.get("TRUE");
        List<String> bads = parsedLines.get("FALSE");
        return new UsableRegexSource(title, comment, goods, bads, this.file);
    }

    @Override
    public String toString() {
        return this.file.getName();
    }

    public String getTitle() {
        return title;
    }
}
