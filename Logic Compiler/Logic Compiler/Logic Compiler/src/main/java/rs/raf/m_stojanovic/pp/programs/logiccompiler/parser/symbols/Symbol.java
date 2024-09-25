package rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.symbols;

import java.util.Objects;

public abstract class Symbol {

    private final String name;

    protected Symbol(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return Objects.equals(name, symbol.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
