package rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax.actions;

import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax.Action;
import rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax.ParserState;

public class Accept implements Action {
    @Override
    public ParserState act(ParserState state) {
        return ParserState.ACCEPTED;
    }
}
