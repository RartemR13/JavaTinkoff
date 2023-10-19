package edu.hw2;

record Exponent(double base, double exponent) implements Task1.Expr {
    @Override
    public double evaluate() {
        return Math.pow(base, exponent);
    }

    Exponent(Task1.Expr base, double exponent) {
        this(base.evaluate(), exponent);
    }

    Exponent(Task1.Expr base, Task1.Expr exponent) {
        this(base, exponent.evaluate());
    }
}
