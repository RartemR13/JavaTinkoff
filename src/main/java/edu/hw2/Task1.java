package edu.hw2;

public final class Task1 {
    private Task1() {
    }

    public sealed interface Expr permits Constant, Negate, Exponent, Addition, Multiplication {
        double evaluate();
    }
}
