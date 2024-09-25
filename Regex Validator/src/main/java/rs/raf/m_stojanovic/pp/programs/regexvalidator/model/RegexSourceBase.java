package rs.raf.m_stojanovic.pp.programs.regexvalidator.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class RegexSourceBase implements RegexSource {

    private final File file;

    public RegexSourceBase(File file) {
        this.file = file;
    }

    public final NamedRegexSource toNamedRegexSource() throws IOException {
        List<String> lines = Files.readAllLines(this.file.toPath());
        int index = lines.indexOf("TITLE");
        return new NamedRegexSource(lines.get(index + 1), lines.stream().toArray(String[]::new), this.file);
    }

    @Override
    public String toString() {
        return this.file.getName();
    }
}
