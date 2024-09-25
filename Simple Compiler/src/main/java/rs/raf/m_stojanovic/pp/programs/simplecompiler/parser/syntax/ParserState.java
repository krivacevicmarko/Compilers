package rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.syntax;

import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.symbols.Symbol;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.symbols.TerminalSymbol;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParserState {

    public static final ParserState ACCEPTED
            = new ParserState(null, null, null, null);
    public static final ParserState ERROR
            = new ParserState(null, null, null, null);
    public static final ParserState START
            = new ParserState(State.START, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    private final State state;

    private final List<Symbol> readSymbols;

    private final List<State> states;

    private final List<TerminalSymbol> unreadSymbols;

    public ParserState(State state, List<Symbol> readSymbols, List<State> states, List<TerminalSymbol> unreadSymbols) {
        this.state = state;
        this.readSymbols = readSymbols;
        this.states = states;
        this.unreadSymbols = unreadSymbols;
    }

    public final Action nextAction() {
        Action a = LRSyntaxTable.LR_SYNTAX_TABLE.row(this.state).getAction(this.unreadSymbols.get(0));
        return a == null ? new Error() : a;
    }

    @Override
    public String toString() {
        return "ParserState{" +
                "state=" + state.getId() +
                ", readSymbols=" + readSymbols.stream().map(Symbol::getName).collect(Collectors.toList()) +
                ", states=" + states.stream().map(State::getId).collect(Collectors.toList()) +
                ", unreadSymbols=" + unreadSymbols.stream().map(Symbol::getName).collect(Collectors.toList()) +
                '}';
    }

    public State getState() {
        return state;
    }

    public List<Symbol> getReadSymbols() {
        return readSymbols;
    }

    public List<State> getStates() {
        return states;
    }

    public List<TerminalSymbol> getUnreadSymbols() {
        return unreadSymbols;
    }
}
