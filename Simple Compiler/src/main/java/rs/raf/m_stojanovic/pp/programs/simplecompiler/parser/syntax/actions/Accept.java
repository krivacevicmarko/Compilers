package rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.syntax.actions;


import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.syntax.Action;
import rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.syntax.ParserState;

public class Accept implements Action {
    @Override
    public ParserState act(ParserState state) {
        return ParserState.ACCEPTED;
    }
}
