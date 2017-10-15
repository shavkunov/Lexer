package ru.spbau.shavkunov.lexer.tokens.words;

import org.jetbrains.annotations.NotNull;
import ru.spbau.shavkunov.lexer.tokens.Token;
import ru.spbau.shavkunov.lexer.tokens.words.types.OperatorType;

public class Operator extends Token {
    private @NotNull OperatorType type;

    public Operator(int line, int column, @NotNull OperatorType type) {
        super(line, column);
        this.type = type;
    }

    @Override
    protected @NotNull String getName() {
        return type.toString();
    }

    @Override
    protected int getLength() {
        switch (type) {
            case G:
            case L:
            case DIV:
            case MUL:
            case MINUS:
            case PLUS: return 1;
            case EQ:
            case NEQ:
            case GEQ:
            case AND:
            case OR:
            case LEQ: return 2;
        }

        return 1;
    }
}