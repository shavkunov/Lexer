package ru.spbau.shavkunov.lexer.tokens;

import org.jetbrains.annotations.NotNull;

public class Comment extends Token {
    private @NotNull String comment;

    public Comment(int line, int column, int length, @NotNull String comment) {
        super(line, column, length);
        this.comment = comment;
    }

    @Override
    protected @NotNull String getName() {
        return "Comment";
    }

    @Override
    protected @NotNull String getContent() {
        return comment;
    }
}