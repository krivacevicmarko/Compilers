package rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.symbols;

public class TerminalSymbol extends Symbol {

    public static final TerminalSymbol END = new TerminalSymbol("#");

    public TerminalSymbol(String name) {
        super(name);
    }
}
