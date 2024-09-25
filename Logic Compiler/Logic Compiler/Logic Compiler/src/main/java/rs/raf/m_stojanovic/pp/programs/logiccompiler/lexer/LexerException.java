package rs.raf.m_stojanovic.pp.programs.logiccompiler.lexer;

public class LexerException extends RuntimeException {
    public LexerException(String word) {
        super("The word '" + word + "' doesn't belong to any type");
    }
}
