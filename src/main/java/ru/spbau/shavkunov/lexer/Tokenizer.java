package ru.spbau.shavkunov.lexer;

import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class Tokenizer {
    public static @NotNull List<Token> tokenize(@NotNull String content) throws IOException {
        Lexer lexer = new Lexer(null);
        lexer.reset(content, 0, content.length(), 0);

        List<Token> tokens = new LinkedList<>();

        Token token = lexer.yylex();
        while (token != null) {
            tokens.add(token);
            token = lexer.yylex();
        }

        return tokens;
    }

    public static void printTokens(@NotNull List<Token> tokens) {
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}