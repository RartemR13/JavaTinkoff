package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    private final static int NUMERAL_SYSTEM = 10;

    /**
     * Возвращает количество цифр в NUMERAL_SYSTEM счисления целого числа.
     *
     * @param number число, количество цифр которого нужно посчитать
     * @return количество цифр в number
     */
    public static int countDigits(int number) {
        int curNumber = Math.abs(number);

        int ret = 0;
        do {
            curNumber /= NUMERAL_SYSTEM;
            ret++;
        } while (curNumber > 0);

        return ret;
    }
}
