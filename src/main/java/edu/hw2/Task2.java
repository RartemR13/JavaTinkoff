package edu.hw2;

public final class Task2 {
    private Task2() {
    }

    public static class Rectangle {
        protected final int width;
        protected final int height;

        public Rectangle() {
            width = 0;
            height = 0;
        }

        public Rectangle(int height, int width) {
            this.height = height;
            this.width = width;
        }

        Rectangle setWidth(int width) {
            return new Rectangle(this.height, width);
        }

        Rectangle setHeight(int height) {
            return new Rectangle(height, this.width);
        }

        double area() {
            return width * height;
        }
    }

    public static final class Square extends Rectangle {
        @Override
        Rectangle setWidth(int width) {
            if (width != this.width) {
                return super.setWidth(width);
            } else {
                return new Square(width);
            }
        }

        public Square() {
        }

        public Square(int width) {
            super(width, width);
        }

        @Override
        Rectangle setHeight(int height) {
            if (height != this.height) {
                return super.setHeight(height);
            } else {
                return new Square(height);
            }
        }
    }
}
