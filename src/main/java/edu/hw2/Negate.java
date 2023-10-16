package edu.hw2;

record Negate(double value) implements Task1.Expr {
    @Override
    public double evaluate() {
        return -value;
    }

    Negate(Task1.Expr expr) {
        this(expr.evaluate());
    }
}
