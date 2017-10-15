package ru.spbau.shavkunov.lexer.tokens.words;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;
import ru.spbau.shavkunov.lexer.tokens.words.types.DelimiterType;

@Data
public class Delimiter extends Token {
    private @NotNull DelimiterType type;

    public Delimiter(int line, int column, @NotNull DelimiterType type) {
        super(line, column);
        this.type = type;
    }
}