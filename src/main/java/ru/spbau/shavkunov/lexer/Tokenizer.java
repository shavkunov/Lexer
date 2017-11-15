package ru.spbau.shavkunov.lexer;

import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;
import ru.spbau.shavkunov.lexer.tokens.words.Identifier;
import ru.spbau.shavkunov.lexer.tokens.words.Keyword;
import ru.spbau.shavkunov.lexer.tokens.words.Number;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Tokenizer {
    public static @NotNull List<Token> tokenize(@NotNull String content) throws IOException, ParseErrorException {
        Lexer lexer = new Lexer(null);

        lexer.reset(content, 0, content.length(), 0);

        List<Token> tokens = new LinkedList<>();

        Token token = lexer.yylex();
        while (token != null) {
            tokens.add(token);
            token = lexer.yylex();
        }

        verifyTokens(tokens);

        return tokens;
    }

    /**
        Method throws exception, if there is a problem: after number token
        there is a keyword or identifier token without any delimiters.
     */
    private static void verifyTokens(List<Token> tokens) throws ParseErrorException {
        if (tokens.size() <= 1) {
            return;
        }

        Iterator<Token> iterator = tokens.iterator();

        Token left = null;
        Token right = iterator.next();
        while (iterator.hasNext()) {
            left = right;
            right = iterator.next();

            if (left instanceof Number && (right instanceof Keyword || right instanceof Identifier)) {
                if (left.getColumn() + left.getLength() == right.getColumn()) {
                    throw new ParseErrorException(left.getLine(), right.getColumn());
                }
            }
        }
    }

    public static void printTokens(@NotNull List<Token> tokens) {
        System.out.println(tokensToString(tokens));
    }

    public static @NotNull String tokensToString(@NotNull List<Token> tokens) {
        StringBuilder builder = new StringBuilder();
        for (Token token : tokens) {
            builder.append(token.toString()).append("; ");
        }

        if (builder.length() > 0) {
            builder.setLength(builder.length() - 1);
        }
        return builder.toString();
    }
}