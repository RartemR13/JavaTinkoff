package edu.hw2;

record Constant(double value) implements Task1.Expr {
    @Override
    public double evaluate() {
        return value;
    }

    Constant(Task1.Expr expr) {
        this(expr.evaluate());
    }
}
