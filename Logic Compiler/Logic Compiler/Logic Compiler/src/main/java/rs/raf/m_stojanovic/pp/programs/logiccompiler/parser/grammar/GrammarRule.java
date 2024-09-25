package rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.grammar;

import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.symbols.NonTerminalSymbol;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.symbols.Symbol;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.symbols.TerminalSymbol;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GrammarRule {

    static GrammarRule parseGrammarRule(String line) {
        String[] a = line.split(" -\\> ");
        NonTerminalSymbol nonTerminalSymbol = NonTerminals.check(a[0]);
        if (nonTerminalSymbol == null)
            return null;
        List<Symbol> symbols = Arrays.stream(a[1].split(" "))
                .map(s -> {
                    TerminalSymbol terminal = Terminals.check(s);
                    if (terminal != null)
                        return terminal;
                    NonTerminalSymbol nonTerminal = NonTerminals.check(s);
                    if (nonTerminal != null)
                        return nonTerminal;
                    return null;
                }).collect(Collectors.toList());
        return new GrammarRule(nonTerminalSymbol, symbols);
    }

    private final NonTerminalSymbol leftHandSide;

    private final List<Symbol> rightHandSide;

    protected GrammarRule(NonTerminalSymbol leftHandSide, List<Symbol> rightHandSide) {
        this.leftHandSide = leftHandSide;
        this.rightHandSide = rightHandSide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrammarRule that = (GrammarRule) o;
        return Objects.equals(leftHandSide, that.leftHandSide) && Objects.equals(rightHandSide, that.rightHandSide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftHandSide, rightHandSide);
    }

    public NonTerminalSymbol getLeftHandSide() {
        return leftHandSide;
    }

    public List<Symbol> getRightHandSide() {
        return rightHandSide;
    }
}
