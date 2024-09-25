package rs.raf.m_stojanovic.pp.programs.regexvalidator.model;

import java.io.File;
import java.util.List;

public class UsableRegexSource implements RegexSource {

    private final String title;

    private final String comment;

    private final List<String> goods;

    private final List<String> bads;

    private final File file;

    public UsableRegexSource(String title, String comment, List<String> goods, List<String> bads, File file) {
        this.title = title;
        this.comment = comment;
        this.goods = goods;
        this.bads = bads;
        this.file = file;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TITLE\n")
                .append(this.title).append("\nCOMMENT\n");
        for (String c : this.comment.split("\n"))
            stringBuilder.append(c).append("\n");
        stringBuilder.append("TRUE\n");
        for (String g: this.goods)
            stringBuilder.append(g).append("\n");
        stringBuilder.append("FALSE\n");
        for (String b: this.bads)
            stringBuilder.append(b).append("\n");
        return stringBuilder.toString();
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public List<String> getGoods() {
        return goods;
    }

    public List<String> getBads() {
        return bads;
    }

    public File getFile() {
        return file;
    }
}
