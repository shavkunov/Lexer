package ru.spbau.shavkunov.lexer.tokens.words;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;
import ru.spbau.shavkunov.lexer.tokens.words.types.OperatorType;

@Data
public class Operator extends Token {
    private @NotNull OperatorType type;

    public Operator(int line, int column, @NotNull OperatorType type) {
        super(line, column);
        this.type = type;
    }

    @Override
    protected @NotNull String getName() {
        return type.toString();
    }

    @Override
    protected int getLength() {
        return type.toString().length();
    }
}