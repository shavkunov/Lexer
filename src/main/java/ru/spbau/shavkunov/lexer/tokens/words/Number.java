package ru.spbau.shavkunov.lexer.tokens.words;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;

@Data
public class Number extends Token {
    private double number;

    public Number(int line, int column, double number) {
        super(line, column);
        this.number = number;
    }

    @Override
    protected @NotNull String getName() {
        return "Number";
    }

    @Override
    protected int getLength() {
        return String.valueOf(number).length();
    }

    @Override
    protected @NotNull String getContent() {
        return String.valueOf(number);
    }
}