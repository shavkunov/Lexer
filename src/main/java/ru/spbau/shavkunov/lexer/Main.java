package ru.spbau.shavkunov.lexer;

import ru.spbau.shavkunov.lexer.tokens.Token;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Expected one argument -- path to L file");
            return;
        }

        File file = new File(args[0]);
        String content = new String(Files.readAllBytes(file.toPath()));
        try {
            List<Token> tokens = Tokenizer.tokenize(content);
            Tokenizer.printTokens(tokens);
        } catch (ParseErrorException e) {
            System.out.println("There is a problem in " +
                                "line "  + e.getLine() + ", " + "column " + e.getColumn());
        }
    }
}