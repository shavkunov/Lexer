package ru.spbau.shavkunov.lexer.tokens;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class Token {
    protected final int line;
    protected final int column;

    public Token(int line, int column) {
        this.line = line;
        this.column = column;
    }

    protected @NotNull abstract String getName();
    protected abstract int getLength();
    protected @Nullable String getContent() {
        return null;
    }

    @Override
    public @NotNull String toString() {
        String coordinates = line + "";

        if (getLength() > 1) {
            int rightBorder = column + getLength() - 1;
            coordinates += ", [" + column + ":" + rightBorder + "]";
        } else {
            coordinates += column;
        }

        if (getContent() != null) {
            return getName() + "(" + coordinates + ", '" + getContent() + "')";
        }

        return getName() + "(" + coordinates + ")";
    }
}