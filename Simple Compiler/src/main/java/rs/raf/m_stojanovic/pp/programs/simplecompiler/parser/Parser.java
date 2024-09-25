package rs.raf.m_stojanovic.pp.programs.simplecompiler.parser;


import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.grammar.Grammar;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.grammar.Terminals;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.symbols.TerminalSymbol;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.syntax.Action;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.syntax.ParserState;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.syntax.State;

import java.util.List;
import java.util.Map;

public class Parser {

    private static final Parser PARSER = new Parser();

    public static Parser getParser() {
        return PARSER;
    }

    public static final String[] GRAMMAR = (
            "S' -> S #\n" +
            "S -> R . S\n" +
            "S -> R .\n" +
            "R -> F\n" +
            "R -> F :- FUNCS\n" +
            "FUNCS -> F , FUNCS\n" +
            "FUNCS -> F\n" +
            "F -> id ( PARAMS )\n" +
            "F -> id\n" +
            "PARAMS -> P , PARAMS\n" +
            "PARAMS -> P\n" +
            "P -> atom\n" +
            "P -> id"
    ).split("\\n");

    private Parser() {

    }

    public void parse(List<TerminalSymbol> symbols, Map<String, TerminalSymbol> terminalSymbols) {
        Terminals.receiveTerminals(terminalSymbols);
        Grammar.GRAMMAR = Grammar.parseGrammar(GRAMMAR);
        ParserState parserState = ParserState.START;
        parserState.getUnreadSymbols().addAll(symbols);
        parserState.getStates().add(State.START);
        while (parserState != ParserState.ACCEPTED && parserState != ParserState.ERROR
                && !parserState.getUnreadSymbols().isEmpty()) {
            Action action = parserState.nextAction();
            parserState = action.act(parserState);
        }
        System.out.println(parserState == ParserState.ACCEPTED);
    }
}
