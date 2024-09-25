package rs.raf.m_stojanovic.pp.programs.logiccompiler.lexer;

public class Word {

    private final String word;

    private final WordType wordType;

    public Word(String word, WordType wordType) {
        this.word = word;
        this.wordType = wordType;
    }

    @Override
    public String toString() {
        return "Word: " + word + "\nWord type: " + wordType.getWordTypeName()
                + "\nRegex: " + wordType.getRegex() + "\n\n";
    }

    public String getWord() {
        return word;
    }

    public WordType getWordType() {
        return wordType;
    }
}
