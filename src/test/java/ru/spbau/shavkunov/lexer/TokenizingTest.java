package ru.spbau.shavkunov.lexer;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import ru.spbau.shavkunov.lexer.Tokenizer;
import ru.spbau.shavkunov.lexer.tokens.Token;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TokenizingTest {
    private @NotNull ClassLoader classLoader = getClass().getClassLoader();
    private @NotNull File tests = new File(classLoader.getResource("tests").getFile());
    private @NotNull File answers = new File(classLoader.getResource("answers").getFile());

    @Test
    public void test() throws Exception {

        System.out.println(tests);
        //System.out.println(answers);

        for (String filename : tests.list()) {
            File test = tests.toPath().resolve(filename).toFile();
            getTokens(test);
        }
    }

    private void check(String test) throws IOException {
    }

    private List<Token> getTokens(File test) throws IOException {
        String content = new String(Files.readAllBytes(test.toPath().toAbsolutePath()));
        List<Token> tokens = Tokenizer.tokenize(content);
        Tokenizer.printTokens(tokens);

        return tokens;
    }
}