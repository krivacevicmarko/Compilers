package rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.grammar;

import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.symbols.NonTerminalSymbol;

import java.util.HashMap;
import java.util.Map;

public class NonTerminals {

    static Map<String, NonTerminalSymbol> nonTerminalSymbols = new HashMap<>();

    static {
        create("S'");
        create("S");
        create("BLOCK");
        create("SN");
        create("N");
        create("DEC");
        create("ASS");
        create("CONS'");
        create("INPUT");
        create("OUTPUT");
        create("TYPE");
        create("EXPR");
        create("EXPR1");
        create("EXPR2");
        create("EXPR3");
        create("OP1");
        create("OP2");
        create("OUT");
        create("CONS");
        create("IF");
        create("CONDITION");
        create("COND");
        create("CND");
        create("LOG");
        create("OP3");
        create("ELIF");
        create("FOR");
        create("WHILE");
        create("DO");
        create("INI");
        create("INC");
        create("TERN");
        create("POM");
        create("DIT");
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
