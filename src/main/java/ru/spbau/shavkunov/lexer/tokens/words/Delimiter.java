package ru.spbau.shavkunov.lexer.tokens.words;

import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;
import ru.spbau.shavkunov.lexer.tokens.words.types.DelimiterType;

public class Delimiter extends Token {
    private @NotNull DelimiterType type;

    public Delimiter(int line, int column, @NotNull DelimiterType type) {
        super(line, column);
        this.type = type;
    }

    @Override
    protected @NotNull String getName() {
        return type.toString();
    }

    @Override
    protected int getLength() {
        return 1;
    }
}