package rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.grammar;

import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.symbols.NonTerminalSymbol;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.symbols.NonTerminalSymbol;

import java.util.HashMap;
import java.util.Map;

public class NonTerminals {

    static Map<String, NonTerminalSymbol> nonTerminalSymbols = new HashMap<>();

    static {
        create("S'");
        create("S");
        create("R");
        create("FUNCS");
        create("F");
        create("PARAMS");
        create("P");
    }

    private static void create(String name) {
        nonTerminalSymbols.put(name, new NonTerminalSymbol(name));
    }

    public static NonTerminalSymbol check(String name) {
        return nonTerminalSymbols.get(name);
    }

    private NonTerminals() {

    }
}
