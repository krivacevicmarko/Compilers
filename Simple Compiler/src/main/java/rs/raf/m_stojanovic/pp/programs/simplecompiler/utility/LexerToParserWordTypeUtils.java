package rs.raf.m_stojanovic.pp.programs.simplecompiler.utility;

import rs.raf.m_stojanovic.pp.programs.simplecompiler.lexer.Word;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.lexer.WordType;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.symbols.TerminalSymbol;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.lexer.Word;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.lexer.WordType;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.symbols.TerminalSymbol;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LexerToParserWordTypeUtils {

    private static TerminalSymbol convert(Word word) {
        return convert(word.getWordType());
    }

    public static List<TerminalSymbol> convert(List<Word> words) {
        return words.stream()
                .map(LexerToParserWordTypeUtils::convert)
                .collect(Collectors.toList());
    }

    private static TerminalSymbol convert(WordType wordType) {
        return new TerminalSymbol(wordType.getWordTypeName());
    }

    public static Map<String, TerminalSymbol> convert(Collection<WordType> wordTypes) {
        Map<String, TerminalSymbol> terminalSymbolMap = new HashMap<>();
        for (WordType wt : wordTypes) {
            String name = wt.getWordTypeName();
            TerminalSymbol symbol = convert(wt);
            terminalSymbolMap.put(name, symbol);
        }
        return terminalSymbolMap;
    }

    private LexerToParserWordTypeUtils() {

    }

}
