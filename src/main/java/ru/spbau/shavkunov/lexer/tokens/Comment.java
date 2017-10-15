package ru.spbau.shavkunov.lexer.tokens;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class Comment extends Token {
    private @NotNull String comment;

    public Comment(int line, int column, @NotNull String comment) {
        super(line, column);
        this.comment = comment;
    }

    @Override
    protected @NotNull String getName() {
        return "Comment";
    }

    @Override
    protected int getLength() {
        return comment.length();
    }

    @Override
    protected @NotNull String getContent() {
        return comment;
    }
}