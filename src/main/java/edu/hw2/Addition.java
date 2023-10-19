package edu.hw2;

record Addition(double first, double second) implements Task1.Expr {
    @Override
    public double evaluate() {
        return first + second;
    }

    Addition(Task1.Expr first, double second) {
        this(first.evaluate(), second);
    }

    Addition(Task1.Expr first, Task1.Expr second) {
        this(first, second.evaluate());
    }
}
