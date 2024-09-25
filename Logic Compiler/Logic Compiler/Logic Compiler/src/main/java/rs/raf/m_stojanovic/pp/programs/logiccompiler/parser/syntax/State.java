package rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.syntax;

public class State {

    private static int nextId = 0;

    public static final State START = new State();

    private final int id;

    public State() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }
}
