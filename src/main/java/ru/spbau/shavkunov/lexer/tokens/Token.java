package ru.spbau.shavkunov.lexer.tokens;

public abstract class Token {
    protected final int line;
    protected final int column;

    public Token(int line, int column) {
        this.line = line;
        this.column = column;
    }
}