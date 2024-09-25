package rs.raf.m_stojanovic.pp.programs.logiccompiler;

import rs.raf.m_stojanovic.pp.programs.logiccompiler.lexer.Lexer;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.lexer.Word;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.lexer.WordTypes;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.loader.FileLoader;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.Parser;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.utility.LexerToParserWordTypeUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String code = FileLoader.getFileLoader().load("program.lce");
        System.out.println(code);

        List<Word> words = Lexer.getLexer().lex(code);
        for (Word w : words)
            System.out.println(w);

        Parser.getParser().parse(LexerToParserWordTypeUtils.convert(words),
                LexerToParserWordTypeUtils.convert(WordTypes.wordTypes()));

    }
}
