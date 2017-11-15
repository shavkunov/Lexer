package ru.spbau.shavkunov.lexer;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import ru.spbau.shavkunov.lexer.tokens.Token;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TokenizingTest {
    private @NotNull ClassLoader classLoader = getClass().getClassLoader();
    private @NotNull File tests = new File(classLoader.getResource("tests").getFile());
    private @NotNull File answers = new File(classLoader.getResource("answers").getFile());

    @Test
    public void test() throws Exception {
        for (String filename : tests.list()) {
            File test = tests.toPath().resolve(filename).toFile();
            String testContent = new String(Files.readAllBytes(test.toPath()));

            File answer = answers.toPath().resolve(filename.replace(".L", "")).toFile();
            String answerContent = new String(Files.readAllBytes(answer.toPath()));

            List<Token> tokens = Tokenizer.tokenize(testContent);
            String result = Tokenizer.tokensToString(tokens);

            assertEquals(answerContent, result);
        }
    }
}