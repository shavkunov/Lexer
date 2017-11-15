package ru.spbau.shavkunov.lexer.tokens.words;

import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;

public class Number extends Token {
    private double number;

    public Number(int line, int column, int length, double number) {
        super(line, column, length);
        this.number = number;
    }

    @Override
    protected @NotNull String getName() {
        return "Number";
    }

    @Override
    protected @NotNull String getContent() {
        return String.valueOf(number);
    }
}