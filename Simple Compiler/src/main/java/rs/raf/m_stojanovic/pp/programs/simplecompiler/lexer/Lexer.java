package rs.raf.m_stojanovic.pp.programs.simplecompiler.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lexer {

    private static Lexer lexer;

    public static Lexer getLexer() {
        if (lexer == null) {
            synchronized (Lexer.class) {
                if (lexer == null)
                    lexer = new Lexer();
            }
        }
        return lexer;
    }

    private Lexer() {

    }

    public List<Word> lex(String code) {
        List<Word> words = new ArrayList<>();
        String[] codeSplitted = code.split(" ");
        for (String word: codeSplitted) {
            WordType wordType = null;
            for (Map.Entry<String, WordType> wt : WordTypes.REGEXES.entrySet()) {
                if (word.matches(wt.getKey())) {
                    wordType = wt.getValue();
                    break;
                }
            }
            if (wordType == null)
                throw new LexerException(word);
            Word w = new Word(word, wordType);
            words.add(w);
        }
        return words;
    }

}
