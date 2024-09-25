package rs.raf.m_stojanovic.pp.programs.logiccompiler.parser.grammar;

import java.util.ArrayList;
import java.util.List;

public class Grammar {

    public static Grammar GRAMMAR;

    public static Grammar parseGrammar(String[] lines) {
        Grammar grammar = new Grammar();
        for (String line : lines) {
            GrammarRule grammarRule = GrammarRule.parseGrammarRule(line);
            grammar.grammarRules.add(grammarRule);
        }
        return grammar;
    }

    private final List<GrammarRule> grammarRules = new ArrayList<>();

    private Grammar() {

    }

    public List<GrammarRule> getGrammarRules() {
        return grammarRules;
    }
}
