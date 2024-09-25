package rs.raf.m_stojanovic.pp.programs.logiccompiler.parser;

import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.grammar.Grammar;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.grammar.Terminals;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.symbols.TerminalSymbol;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax.Action;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax.ParserState;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax.State;

import java.util.List;
import java.util.Map;

public class Parser {

    private static final Parser PARSER = new Parser();

    public static Parser getParser() {
        return PARSER;
    }

    public static final String[] GRAMMAR = (
                    "S' -> S #\n" +
                    "S -> main BLOCK\n" +
                    "BLOCK -> { SN }\n" +
                    "SN -> SN N ;\n" +
                    "SN -> N ;\n" +
                    "N -> DEC\n" +
                    "N -> ASS\n" +
                    "N -> CONS\n" +
                    "N -> INPUT\n" +
                    "N -> OUTPUT\n" +
                    "DEC -> TYPE name\n" +
                    "TYPE -> int\n" +
                    "TYPE -> dble\n" +
                    "TYPE -> char\n" +
                    "TYPE -> str\n" +
                    "TYPE -> arr\n" +
                    "ASS -> name := EXPR\n" +
                    "EXPR -> integer\n" +
                    "EXPR -> octal\n" +
                    "EXPR -> hexa\n" +
                    "EXPR -> double\n" +
                    "EXPR -> character\n" +
                    "EXPR -> EXPR OP1 EXPR1\n" +
                    "EXPR -> EXPR1\n" +
                    "EXPR1 -> EXPR1 OP2 EXPR2\n" +
                    "EXPR1 -> EXPR2\n" +
                    "EXPR2 -> name\n" +
                    "EXPR2 -> integer\n" +
                    "EXPR2 -> double\n" +
                    "EXPR -> EXPR3\n" +
                    "EXPR3 -> array\n" +
                    "EXPR3 -> string\n" +
                    "OP1 -> +\n" +
                    "OP1 -> -\n" +
                    "OP2 -> *\n" +
                    "OP2 -> /\n" +
                    "OP2 -> %\n" +
                    "INPUT -> scan name\n" +
                    "OUTPUT -> print OUT\n" +
                    "OUT -> name\n" +
                    "OUT -> string\n" +
                    "OUT -> arrayelement\n" +
                    "CONS -> IF\n" +
                    "CONS -> FOR\n" +
                    "CONS -> WHILE\n" +
                    "CONS -> DO\n" +
                    "CONS -> TERN\n" +
                    "IF -> if ( CONDITION ) BLOCK\n" +
                    "IF -> if ( CONDITION ) BLOCK ELIF\n" +
                    "ELIF -> elif ( CONDITION ) BLOCK ELIF\n" +
                    "ELIF -> else BLOCK\n" +
                    "FOR -> for ( INI ; CONDITION ; INC ) BLOCK\n" +
                    "INI -> name := integer\n" +
                    "INI -> int name := integer\n" +
                    "INC -> name := name + integer\n" +
                    "INC -> name := name - integer\n" +
                    "WHILE -> while ( CONDITION ) BLOCK\n" +
                    "DO -> do BLOCK while ( CONDITION )\n" +
                    "CONDITION -> CONDITION LOG COND\n" +
                    "CONDITION -> COND\n" +
                    "LOG -> &&\n" +
                    "LOG -> ||\n" +
                    "CONDITION -> ! CONDITION\n" +
                    "COND -> CND OP3 CND\n" +
                    "CND -> name\n" +
                    "CND -> integer\n" +
                    "CND -> character\n" +
                    "OP3 -> ==\n" +
                    "OP3 -> !=\n" +
                    "OP3 -> <\n" +
                    "OP3 -> >\n" +
                    "OP3 -> <=\n" +
                    "OP3 -> >=\n" +
                    "TERN -> ( CND OP3 CND ) ? POM\n" +
                    "POM -> DIT : DIT\n" +
                    "DIT -> CND\n" +
                    "DIT -> OUTPUT\n"
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
