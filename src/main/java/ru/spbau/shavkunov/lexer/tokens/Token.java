package ru.spbau.shavkunov.lexer.tokens;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class Token {
    protected final int line;
    protected final int column;
    protected final int length;

    public Token(int line, int column, int length) {
        this.line = line;
        this.column = column;
        this.length = length;
    }

    protected @NotNull abstract String getName();
    protected @Nullable String getContent() {
        return null;
    }

    @Override
    public @NotNull String toString() {
        String coordinates = line + "";

        if (length > 1) {
            int rightBorder = column + length - 1;
            coordinates += ", [" + column + ":" + rightBorder + "]";
        } else {
            coordinates += ", " + column;
        }

        if (getContent() != null) {
            return getName() + "(" + coordinates + ", '" + getContent() + "')";
        }

        return getName() + "(" + coordinates + ")";
    }

    public int getColumn() {
        return column;
    }

    public int getLength() {
        return length;
    }

    public int getLine() {
        return line;
    }
}