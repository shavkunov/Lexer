package ru.spbau.shavkunov.lexer.tokens.words;

import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;

public class Identifier extends Token {
    private @NotNull String name;

    public Identifier(int line, int column, @NotNull String name) {
        super(line, column);
        this.name = name;
    }

    @Override
    protected int getLength() {
        return name.length();
    }

    @Override
    protected @NotNull String getName() {
        return "Identifier";
    }

    @Override
    protected @NotNull String getContent() {
        return name;
    }
}