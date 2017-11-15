package ru.spbau.shavkunov.lexer.tokens.words;

import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;
import ru.spbau.shavkunov.lexer.tokens.words.types.KeywordType;

public class Keyword extends Token {
    private @NotNull KeywordType type;

    public Keyword(int line, int column, int length, @NotNull KeywordType type) {
        super(line, column, length);
        this.type = type;
    }

    @Override
    protected @NotNull String getName() {
        return type.toString();
    }
}