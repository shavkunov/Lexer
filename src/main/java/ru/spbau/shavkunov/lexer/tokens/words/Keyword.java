package ru.spbau.shavkunov.lexer.tokens.words;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;
import ru.spbau.shavkunov.lexer.tokens.words.types.KeywordType;

@Data
public class Keyword extends Token {
    private @NotNull KeywordType type;

    public Keyword(int line, int column, @NotNull KeywordType type) {
        super(line, column);
        this.type = type;
    }
}