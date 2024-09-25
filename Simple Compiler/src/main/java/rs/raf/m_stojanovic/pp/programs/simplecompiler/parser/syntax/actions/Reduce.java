package rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.syntax.actions;


import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.grammar.GrammarRule;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.symbols.NonTerminalSymbol;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.symbols.Symbol;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.symbols.TerminalSymbol;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.syntax.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce implements Action {

    private final GrammarRule grammarRule;

    public Reduce(GrammarRule grammarRule) {
        this.grammarRule = grammarRule;
    }

    @Override
    public ParserState act(ParserState state) {
        System.out.println(state);
        System.out.println(this.grammarRule.getLeftHandSide().getName());
        System.out.println(this.grammarRule.getRightHandSide().stream().map(Symbol::getName).collect(Collectors.toList()));
        System.out.println();
        final List<TerminalSymbol> nextUnreadSymbols = new ArrayList<>(state.getUnreadSymbols());
        int toRemove = this.grammarRule.getRightHandSide().size();
        final List<Symbol> nextReadSymbols
                = state.getReadSymbols().subList(0, state.getReadSymbols().size() - toRemove);
        final List<State> nextStates
                = state.getStates().subList(0, state.getStates().size() - toRemove);
        NonTerminalSymbol evalSymbol = this.grammarRule.getLeftHandSide();
        State evalState = nextStates.get(nextStates.size() - 1);
        Goto gt = LRSyntaxTable.LR_SYNTAX_TABLE.row(evalState).getGoto(evalSymbol);
        nextReadSymbols.add(evalSymbol);
        nextStates.add(gt.getNextState());
        return new ParserState(gt.getNextState(), nextReadSymbols, nextStates, nextUnreadSymbols);
    }
}
