package rs.raf.m_stojanovic.pp.programs.simplecompiler.lexer;

import java.util.LinkedHashMap;
import java.util.Map;

public class WordTypes {

    public static final Map<String, WordType> REGEXES = new LinkedHashMap<>();

    private static void putWordTypeToMap(WordType word) {
        REGEXES.put(word.getRegex(), word);
    }

    public static final WordType MAIN_WORD
            = new WordType("main", "main_body");

    public static final WordType ASSIGN_WORD
            = new WordType("assign", "\\:\\=");
    public static final WordType TERNARY_OPERATOR_WORD
            = new WordType("ternary_expression","\\?");
    public static final WordType TERNARY_OPERATION_SPLITTER
            = new WordType(":","\\:");


    public static final WordType NAME_WORD
            = new WordType("name", "[a-zA-Z_][a-zA-Z0-9_]*|[a-zA-Z]");

    public static final WordType END_OF_COMMAND
            = new WordType(";","\\;");

    public static final WordType IF_WORD
            = new WordType("if", "if");
    public static final WordType ELIF_WORD
            = new WordType("elif", "elif");
    public static final WordType ELSE_WORD
            = new WordType("else", "else");
    public static final WordType FOR_WORD
            = new WordType("for","for");
    public static final WordType WHILE_LOOP
            = new WordType("while","while");
    public static final WordType DO_WORD
            = new WordType("do","do");
    public static final WordType FOR_LOOP_STATEMENT
            = new WordType("forloopstatement","\\(.*\\;.*\\;.*\\.*\\)");
    public static final WordType CONDITIONAL_STATEMENT
            = new WordType("conditionalstatement","\\(.*\\)||\\(.*?\\&.*\\)||\\(.*?\\|\\|.*\\)");

    public static final WordType SCAN_WORD
            = new WordType("scan", "scans");
    public static final WordType PRINT_WORD
            = new WordType("print", "prints");

    public static final WordType INT_TYPE_WORD
            = new WordType("int", "num_int");
    public static final WordType CHAR_TYPE_WORD
            = new WordType("char", "char");

    public static final WordType DOUBLE_TYPE_WORD
            = new WordType("dble","num_double");

    public static final WordType STRING_TYPE_WORD
            = new WordType("str","strng");

    public static final WordType ARRAY_TYPE_WORD
            = new WordType("arr","num\\_int\\[\\]");

    private static final WordType BEGINNING_OF_AN_INT_WORD
            = new WordType("int-first-digit", "-?[1-9]");

    public static final WordType INT_WORD
            = new WordType("integer", BEGINNING_OF_AN_INT_WORD.getRegex() + "?[1-9][0-9]*|0");


    public static final WordType INT_OCTAL_WORD
            = new WordType("octal","-?[o][0-7][0-7]*");
    public static final WordType INT_HEXA_WORD
            = new WordType("hexa","-?0x[A-F0-9][A-F0-9]*");

    public static final WordType DOUBLE_WORD
            = new WordType("double","-?[0-9][0-9]*\\.[0-9][0-9]*");
    public static final WordType CHAR_WORD
            = new WordType("character", "\\'.\\'");
    public static final WordType STRING_WORD
            = new WordType("string", "\\\".*\\\"");
    public static final WordType ARRAY_WORD
            = new WordType("array","^\\{\\d+(,\\s*\\d+)*\\}$");

    public static final WordType ARRAY_ELEMENT
            = new WordType("arrayelemenet",".*\\[[0-9][1-9]*\\]|.*\\[.*\\]");

    public static final WordType PLUS_WORD
            = new WordType("+", "\\+");
    public static final WordType MINUS_WORD
            = new WordType("-", "\\-");
    public static final WordType TIMES_WORD
            = new WordType("*", "\\*");
    public static final WordType DIV_WORD
            = new WordType("/", "/");
    public static final WordType MOD_WORD
            = new WordType("%", "\\%");

    public static final WordType EQUALS_SIGN
            = new WordType("==", "\\=\\=");
    public static final WordType NOT_EQUALS_SIGN
            = new WordType("!=", "\\!\\=");
    public static final WordType LESS_THAN_SIGN
            = new WordType("<", "\\<");
    public static final WordType LESS_OR_EQUALS_SIGN
            = new WordType("<=", "\\<\\=");
    public static final WordType GREATER_THAN_SIGN
            = new WordType(">", "\\>");
    public static final WordType GREATER_OR_EQUALS_SIGN
            = new WordType(">=", "\\>\\=");

    public static final WordType LOGICAL_AND_WORD
            = new WordType("&&", "\\&\\&");
    public static final WordType LOGICAL_OR_WORD
            = new WordType("||", "\\|\\|");
    public static final WordType LOGICAL_NOT_WORD
            = new WordType("!", "\\!");

    public static final WordType OPEN_CURLY_BRACKET_WORD
            = new WordType("{", "\\{");
    public static final WordType CLOSED_CURLY_BRACKET_WORD
            = new WordType("}", "\\}");
    public static final WordType OPEN_NORMAL_BRACKET_WORD
            = new WordType("(","\\(");
    public static final WordType CLOSE_NORMAL_BRACKET_WORD
            = new WordType(")","\\)");

    static {
        putWordTypeToMap(MAIN_WORD);

        putWordTypeToMap(TERNARY_OPERATOR_WORD);
        putWordTypeToMap(TERNARY_OPERATION_SPLITTER);
        putWordTypeToMap(IF_WORD);
        putWordTypeToMap(ELIF_WORD);
        putWordTypeToMap(ELSE_WORD);
        putWordTypeToMap(FOR_WORD);
        putWordTypeToMap(FOR_LOOP_STATEMENT);
        putWordTypeToMap(WHILE_LOOP);
        putWordTypeToMap(DO_WORD);
        putWordTypeToMap(CONDITIONAL_STATEMENT);

        putWordTypeToMap(SCAN_WORD);
        putWordTypeToMap(PRINT_WORD);

        putWordTypeToMap(INT_TYPE_WORD);
        putWordTypeToMap(CHAR_TYPE_WORD);
        putWordTypeToMap(DOUBLE_TYPE_WORD);
        putWordTypeToMap(STRING_TYPE_WORD);
        putWordTypeToMap(ARRAY_TYPE_WORD);
        putWordTypeToMap(END_OF_COMMAND);

        putWordTypeToMap(OPEN_CURLY_BRACKET_WORD);
        putWordTypeToMap(CLOSED_CURLY_BRACKET_WORD);
        putWordTypeToMap(OPEN_NORMAL_BRACKET_WORD);
        putWordTypeToMap(CLOSE_NORMAL_BRACKET_WORD);

        putWordTypeToMap(PLUS_WORD);
        putWordTypeToMap(MINUS_WORD);
        putWordTypeToMap(TIMES_WORD);
        putWordTypeToMap(DIV_WORD);
        putWordTypeToMap(MOD_WORD);

        putWordTypeToMap(ASSIGN_WORD);

        putWordTypeToMap(EQUALS_SIGN);
        putWordTypeToMap(NOT_EQUALS_SIGN);
        putWordTypeToMap(LESS_THAN_SIGN);
        putWordTypeToMap(LESS_OR_EQUALS_SIGN);
        putWordTypeToMap(GREATER_THAN_SIGN);
        putWordTypeToMap(GREATER_OR_EQUALS_SIGN);

        putWordTypeToMap(LOGICAL_AND_WORD);
        putWordTypeToMap(LOGICAL_OR_WORD);
        putWordTypeToMap(LOGICAL_NOT_WORD);

        putWordTypeToMap(STRING_WORD);
        putWordTypeToMap(CHAR_WORD);
        putWordTypeToMap(INT_WORD);
        putWordTypeToMap(INT_OCTAL_WORD);
        putWordTypeToMap(INT_HEXA_WORD);
        putWordTypeToMap(DOUBLE_WORD);
        putWordTypeToMap(ARRAY_WORD);
        putWordTypeToMap(ARRAY_ELEMENT);

        putWordTypeToMap(NAME_WORD);
    }

    private WordTypes() {

    }
}
