package ru.spbau.shavkunov.lexer.tokens.words;

import lombok.Data;
import ru.spbau.shavkunov.lexer.tokens.Token;

@Data
public class Number extends Token {
    private double number;

    public Number(int line, int column, double number) {
        super(line, column);
        this.number = number;
    }
}