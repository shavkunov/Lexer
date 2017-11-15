package ru.spbau.shavkunov.lexer;

import ru.spbau.shavkunov.lexer.tokens.*;

import ru.spbau.shavkunov.lexer.tokens.words.Number;
import ru.spbau.shavkunov.lexer.tokens.words.*;
import ru.spbau.shavkunov.lexer.tokens.words.types.*;

import static ru.spbau.shavkunov.lexer.tokens.words.types.DelimiterType.*;
import static ru.spbau.shavkunov.lexer.tokens.words.types.KeywordType.*;
import static ru.spbau.shavkunov.lexer.tokens.words.types.OperatorType.*;

%%

%class Lexer
%unicode
%type Token
%line
%column

%{
    // jflex itself doesn't create this variables
    private int yyline = 0;
    private int yycolumn = 0;

    public int getCurrentLine() {
        return yyline;
    }

    public int getCurrentColumn() {
        return yycolumn;
    }

    // tokens factory

    private Operator getOperator(OperatorType type) {
        return new Operator(yyline, yycolumn, yytext().length(), type);
    }

    private Keyword getKeyword(KeywordType type) {
        return new Keyword(yyline, yycolumn, yytext().length(), type);
    }

    private Delimiter getDelimiter(DelimiterType type) {
        return new Delimiter(yyline, yycolumn, yytext().length(), type);
    }

    private Comment getComment() {
        return new Comment(yyline, yycolumn, yytext().length(), yytext().toString());
    }

    private Number getIntegerNumber() {
        return new Number(yyline, yycolumn, yytext().length(), Long.parseLong(yytext().toString().replace("_", "")));
    }

    private Number getDoubleNumber() {
        return new Number(yyline, yycolumn, yytext().length(), Double.parseDouble(yytext().toString().replace("_", "")));
    }

    private Identifier getIdentifier() {
        return new Identifier(yyline, yycolumn, yytext().length(), yytext().toString());
    }
%}

EndLine = \x0D | \x0A | \x0D\x0A // CR | LF | CR LF
NotEndLine = [^\x0D\x0A]
Whitespace = {EndLine} | \x20 | \x09 | \x0C // SP | HT | FF

Letter = [a-z]
Digit = [0-9]
NonZeroDigit = [1-9]
Underscores = _+

Comment = \/\/{NotEndLine}*
Identifier = ({Letter} | _) ({Letter} | {Digit} | _)*

DigitOrUnderscore = {Digit} | _
DigitsAndUnderscores = {DigitOrUnderscore}+
Digits = {Digit} | {Digit} {DigitsAndUnderscores} ? {Digit}

Integer = "0" | {NonZeroDigit} {Digits}? | {NonZeroDigit} {Underscores} {Digits}
SignedInteger = ("+" | "-")? {Digits}

Exponent = E | e
ExponentPart = {Exponent} {SignedInteger}
Double = {Digits} "." {Digits}? {ExponentPart}? | "." {Digits} {ExponentPart}? | {Digits} {ExponentPart}

%%

({EndLine} | {Whitespace})+ {}

"+"     { return getOperator(PLUS); }
"-"     { return getOperator(MINUS); }
"*"     { return getOperator(MUL); }
"/"     { return getOperator(DIV); }
"%"     { return getOperator(MOD); }
"=="    { return getOperator(EQ); }
"!="    { return getOperator(NEQ); }
">"     { return getOperator(G); }
"<"     { return getOperator(L); }
">="    { return getOperator(GEQ); }
"<="    { return getOperator(LEQ); }
"&&"    { return getOperator(AND); }
"||"    { return getOperator(OR); }
":="    { return getOperator(ASSIGNMENT); }

"if"    { return getKeyword(IF); }
"then"  { return getKeyword(THEN); }
"else"  { return getKeyword(ELSE); }
"while" { return getKeyword(WHILE); }
"do"    { return getKeyword(DO); }
"read"  { return getKeyword(READ); }
"write" { return getKeyword(WRITE); }
"begin" { return getKeyword(BEGIN); }
"end"   { return getKeyword(END); }

";"     { return getDelimiter(SEMICOLON); }
"("     { return getDelimiter(LEFT_PARENTHESIS); }
")"     { return getDelimiter(RIGHT_PARENTHESIS); }

{Identifier}    { return getIdentifier(); }
{Comment}       { return getComment(); }
{Integer}       { return getIntegerNumber(); }
{Double}        { return getDoubleNumber(); }

[^]     { throw new ParseErrorException(yyline, yycolumn); }