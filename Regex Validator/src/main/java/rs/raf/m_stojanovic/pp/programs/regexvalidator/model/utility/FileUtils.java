package rs.raf.m_stojanovic.pp.programs.regexvalidator.model.utility;

import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.RegexSourceBase;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.UsableRegexSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

    public static List<RegexSourceBase> listAll() {
        try {
            return Files.list(Paths.get("regex/src/"))
                    .map(Path::toFile)
                    .map(RegexSourceBase::new)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(UsableRegexSource regexSource) {
        try {
            Files.writeString(regexSource.getFile().toPath(), regexSource.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private FileUtils() {

    }
}
