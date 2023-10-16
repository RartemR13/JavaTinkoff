package edu.hw2;

public final class Task1 {
    private Task1() {
    }

    public sealed interface Expr {
        double evaluate();

        record Constant(double value) implements Expr {
            @Override
            public double evaluate() {
                return value;
            }

            public Constant(Expr expr) {
                this(expr.evaluate());
            }
        }

        record Negate(double value) implements Expr {
            @Override
            public double evaluate() {
                return -value;
            }

            public Negate(Expr expr) {
                this(expr.evaluate());
            }
        }

        record Exponent(double base, double exponent) implements Expr {
            @Override
            public double evaluate() {
                return Math.pow(base, exponent);
            }

            public Exponent(Expr base, double exponent) {
                this(base.evaluate(), exponent);
            }

            public Exponent(Expr base, Expr exponent) {
                this(base, exponent.evaluate());
            }
        }

        record Addition(double first, double second) implements Expr {
            @Override
            public double evaluate() {
                return first + second;
            }

            public Addition(Expr first, double second) {
                this(first.evaluate(), second);
            }

            public Addition(Expr first, Expr second) {
                this(first, second.evaluate());
            }
        }

        record Multiplication(double first, double second) implements Expr {
            @Override
            public double evaluate() {
                return first * second;
            }

            public Multiplication(Expr first, double second) {
                this(first.evaluate(), second);
            }

            public Multiplication(Expr first, Expr second) {
                this(first, second.evaluate());
            }
        }
    }
}
