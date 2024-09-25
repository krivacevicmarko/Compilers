package rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax;

import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.grammar.Grammar;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.grammar.NonTerminals;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.grammar.Terminals;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.symbols.NonTerminalSymbol;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.symbols.TerminalSymbol;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax.actions.Accept;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax.actions.Reduce;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax.actions.Shift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRSyntaxTable {

    public static final LRSyntaxTable LR_SYNTAX_TABLE;

    static {
        List<LRSyntaxTableRow> lrSyntaxTableRows = new ArrayList<>();
        lrSyntaxTableRows.add(new LRSyntaxTableRow(State.START, new HashMap<>(), new HashMap<>()));
        for (int i = 1; i <= 21; ++i)
            lrSyntaxTableRows.add(new LRSyntaxTableRow(new State(), new HashMap<>(), new HashMap<>()));

        lrSyntaxTableRows.get(0).actions.put(Terminals.check("id"),
                new Shift(lrSyntaxTableRows.get(4).state));
        lrSyntaxTableRows.get(2).actions.put(Terminals.check("."),
                new Shift(lrSyntaxTableRows.get(2).state));
        lrSyntaxTableRows.get(3).actions.put(Terminals.check(":-"),
                new Shift(lrSyntaxTableRows.get(5).state));
        lrSyntaxTableRows.get(4).actions.put(Terminals.check("("),
                new Shift(lrSyntaxTableRows.get(6).state));
        lrSyntaxTableRows.get(5).actions.put(Terminals.check("id"),
                new Shift(lrSyntaxTableRows.get(9).state));
        lrSyntaxTableRows.get(6).actions.put(Terminals.check("atom"),
                new Shift(lrSyntaxTableRows.get(12).state));
        lrSyntaxTableRows.get(6).actions.put(Terminals.check("id"),
                new Shift(lrSyntaxTableRows.get(13).state));
        lrSyntaxTableRows.get(8).actions.put(Terminals.check(","),
                new Shift(lrSyntaxTableRows.get(14).state));
        lrSyntaxTableRows.get(9).actions.put(Terminals.check("("),
                new Shift(lrSyntaxTableRows.get(15).state));
        lrSyntaxTableRows.get(10).actions.put(Terminals.check(")"),
                new Shift(lrSyntaxTableRows.get(16).state));
        lrSyntaxTableRows.get(11).actions.put(Terminals.check(","),
                new Shift(lrSyntaxTableRows.get(17).state));
        lrSyntaxTableRows.get(14).actions.put(Terminals.check("id"),
                new Shift(lrSyntaxTableRows.get(9).state));
        lrSyntaxTableRows.get(15).actions.put(Terminals.check("atom"),
                new Shift(lrSyntaxTableRows.get(12).state));
        lrSyntaxTableRows.get(15).actions.put(Terminals.check("id"),
                new Shift(lrSyntaxTableRows.get(13).state));
        lrSyntaxTableRows.get(17).actions.put(Terminals.check("atom"),
                new Shift(lrSyntaxTableRows.get(12).state));
        lrSyntaxTableRows.get(17).actions.put(Terminals.check("id"),
                new Shift(lrSyntaxTableRows.get(13).state));
        lrSyntaxTableRows.get(19).actions.put(Terminals.check(")"),
                new Shift(lrSyntaxTableRows.get(21).state));

        lrSyntaxTableRows.get(2).actions.put(Terminals.check("#"),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(2)));
        lrSyntaxTableRows.get(3).actions.put(Terminals.check("."),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(3)));
        lrSyntaxTableRows.get(4).actions.put(Terminals.check("."),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(8)));
        lrSyntaxTableRows.get(4).actions.put(Terminals.check(":-"),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(8)));
        lrSyntaxTableRows.get(7).actions.put(Terminals.check("."),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(4)));
        lrSyntaxTableRows.get(8).actions.put(Terminals.check("."),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(6)));
        lrSyntaxTableRows.get(9).actions.put(Terminals.check(","),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(8)));
        lrSyntaxTableRows.get(9).actions.put(Terminals.check("."),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(8)));
        lrSyntaxTableRows.get(11).actions.put(Terminals.check(")"),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(10)));
        lrSyntaxTableRows.get(12).actions.put(Terminals.check(")"),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(11)));
        lrSyntaxTableRows.get(12).actions.put(Terminals.check(","),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(11)));
        lrSyntaxTableRows.get(13).actions.put(Terminals.check(")"),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(12)));
        lrSyntaxTableRows.get(13).actions.put(Terminals.check(","),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(12)));
        lrSyntaxTableRows.get(16).actions.put(Terminals.check("."),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(7)));
        lrSyntaxTableRows.get(16).actions.put(Terminals.check(":-"),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(7)));
        lrSyntaxTableRows.get(18).actions.put(Terminals.check("."),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(5)));
        lrSyntaxTableRows.get(20).actions.put(Terminals.check(")"),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(9)));
        lrSyntaxTableRows.get(21).actions.put(Terminals.check(","),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(7)));
        lrSyntaxTableRows.get(21).actions.put(Terminals.check("."),
                new Reduce(Grammar.GRAMMAR.getGrammarRules().get(7)));

        lrSyntaxTableRows.get(1).actions.put(Terminals.check("#"),
                new Accept());

        lrSyntaxTableRows.get(0).gotos.put(NonTerminals.check("S"),
                new Goto(lrSyntaxTableRows.get(1).state));
        lrSyntaxTableRows.get(0).gotos.put(NonTerminals.check("R"),
                new Goto(lrSyntaxTableRows.get(2).state));
        lrSyntaxTableRows.get(0).gotos.put(NonTerminals.check("F"),
                new Goto(lrSyntaxTableRows.get(3).state));
        lrSyntaxTableRows.get(5).gotos.put(NonTerminals.check("FUNCS"),
                new Goto(lrSyntaxTableRows.get(7).state));
        lrSyntaxTableRows.get(5).gotos.put(NonTerminals.check("F"),
                new Goto(lrSyntaxTableRows.get(8).state));
        lrSyntaxTableRows.get(6).gotos.put(NonTerminals.check("PARAMS"),
                new Goto(lrSyntaxTableRows.get(10).state));
        lrSyntaxTableRows.get(6).gotos.put(NonTerminals.check("P"),
                new Goto(lrSyntaxTableRows.get(11).state));
        lrSyntaxTableRows.get(14).gotos.put(NonTerminals.check("FUNCS"),
                new Goto(lrSyntaxTableRows.get(18).state));
        lrSyntaxTableRows.get(14).gotos.put(NonTerminals.check("F"),
                new Goto(lrSyntaxTableRows.get(8).state));
        lrSyntaxTableRows.get(15).gotos.put(NonTerminals.check("PARAMS"),
                new Goto(lrSyntaxTableRows.get(19).state));
        lrSyntaxTableRows.get(15).gotos.put(NonTerminals.check("P"),
                new Goto(lrSyntaxTableRows.get(11).state));
        lrSyntaxTableRows.get(17).gotos.put(NonTerminals.check("PARAMS"),
                new Goto(lrSyntaxTableRows.get(20).state));
        lrSyntaxTableRows.get(17).gotos.put(NonTerminals.check("P"),
                new Goto(lrSyntaxTableRows.get(11).state));

        LR_SYNTAX_TABLE = new LRSyntaxTable(lrSyntaxTableRows);
    }

    private final Map<State, LRSyntaxTableRow> lrSyntaxTableRows;

    public LRSyntaxTable(List<LRSyntaxTableRow> lrSyntaxTableRows) {
        this.lrSyntaxTableRows = new HashMap<>();
        for (LRSyntaxTableRow lrstr : lrSyntaxTableRows)
            this.lrSyntaxTableRows.put(lrstr.state, lrstr);
    }

    public LRSyntaxTableRow row(State state) {
        return this.lrSyntaxTableRows.get(state);
    }

    public static class LRSyntaxTableRow {

        private final State state;

        private final Map<TerminalSymbol, Action> actions;

        private final Map<NonTerminalSymbol, Goto> gotos;

        public LRSyntaxTableRow(State state, Map<TerminalSymbol, Action> actions,
                                Map<NonTerminalSymbol, Goto> gotos) {
            this.state = state;
            this.actions = actions;
            this.gotos = gotos;
        }

        public final Action getAction(TerminalSymbol terminal) {
            return this.actions.get(terminal);
        }

        public final Goto getGoto(NonTerminalSymbol nonTerminal) {
            return this.gotos.get(nonTerminal);
        }
    }

}
