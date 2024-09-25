package rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.syntax;

public interface Action {
    ParserState act(ParserState state);
}
