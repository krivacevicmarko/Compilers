package rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.grammar;

import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.symbols.TerminalSymbol;

import java.util.Map;

public class Terminals {

    private static Map<String, TerminalSymbol> terminalSymbols;

    public static void receiveTerminals(Map<String, TerminalSymbol> terminalSymbolMap) {
        if (terminalSymbols == null)
            terminalSymbols = terminalSymbolMap;
        else
            throw new RuntimeException();
        terminalSymbols.put(TerminalSymbol.END.getName(), TerminalSymbol.END);
    }

    public static TerminalSymbol check(String name) {
        return terminalSymbols.get(name);
    }

    private Terminals() {

    }
}
