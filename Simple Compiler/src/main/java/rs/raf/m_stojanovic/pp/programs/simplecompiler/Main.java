package rs.raf.m_stojanovic.pp.programs.simplecompiler;

import rs.raf.m_stojanovic.pp.programs.simplecompiler.lexer.Lexer;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.lexer.Word;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.loader.FileLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String code = FileLoader.getFileLoader().load("program01.sce");
        System.out.println(code);

        List<Word> words = Lexer.getLexer().lex(code);
        for (Word w : words)
            System.out.println(w);

    }
}
