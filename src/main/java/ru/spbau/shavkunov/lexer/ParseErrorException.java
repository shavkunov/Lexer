package ru.spbau.shavkunov.lexer;

public class ParseErrorException extends Exception {
    private int line;
    private int column;

    public ParseErrorException(int line, int column) {
        super();
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}