package rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax.actions;

import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.symbols.Symbol;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.symbols.TerminalSymbol;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax.Action;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax.ParserState;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax.State;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shift implements Action {

    private final State state;

    public Shift(State state) {
        this.state = state;
    }

    @Override
    public ParserState act(ParserState state) {
        System.out.println(state);
        System.out.println(this.state.getId());
        TerminalSymbol terminalSymbol = state.getUnreadSymbols().get(0);
        final State nextState = this.state;
        final List<Symbol> nextReadSymbols = new ArrayList<>(state.getReadSymbols());
        nextReadSymbols.add(terminalSymbol);
        final List<State> nextStates = new ArrayList<>(state.getStates());
        nextStates.add(this.state);
        final List<TerminalSymbol> nextUnreadSymbols = new ArrayList<>(state.getUnreadSymbols());
        nextUnreadSymbols.remove(0);
        System.out.println();
        return new ParserState(nextState, nextReadSymbols, nextStates, nextUnreadSymbols);
    }
}
