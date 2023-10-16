package edu.hw2;

record Multiplication(double first, double second) implements Task1.Expr {
    @Override
    public double evaluate() {
        return first * second;
    }

    Multiplication(Task1.Expr first, double second) {
        this(first.evaluate(), second);
    }

    Multiplication(Task1.Expr first, Task1.Expr second) {
        this(first, second.evaluate());
    }
}
