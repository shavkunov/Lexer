package ru.spbau.shavkunov.lexer.tokens.words;

import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;
import ru.spbau.shavkunov.lexer.tokens.words.types.OperatorType;

public class Operator extends Token {
    private @NotNull OperatorType type;

    public Operator(int line, int column, int length, @NotNull OperatorType type) {
        super(line, column, length);
        this.type = type;
    }

    @Override
    protected @NotNull String getName() {
        return type.toString();
    }
}