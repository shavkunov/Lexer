package ru.spbau.shavkunov.lexer.tokens.words;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;

@Data
public class Identifier extends Token {
    private @NotNull String name;

    public Identifier(int line, int column, @NotNull String name) {
        super(line, column);
        this.name = name;
    }
}