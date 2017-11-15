package ru.spbau.shavkunov.lexer.tokens.words;

import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;
import ru.spbau.shavkunov.lexer.tokens.words.types.DelimiterType;

public class Delimiter extends Token {
    private @NotNull DelimiterType type;

    public Delimiter(int line, int column, int length, @NotNull DelimiterType type) {
        super(line, column, length);
        this.type = type;
    }

    @Override
    protected @NotNull String getName() {
        return type.toString();
    }
}