package rs.raf.m_stojanovic.pp.programs.simplecompiler.parser.syntax;

public class Goto {

    private final State nextState;

    public Goto(State nextState) {
        this.nextState = nextState;
    }

    public State getNextState() {
        return nextState;
    }
}
