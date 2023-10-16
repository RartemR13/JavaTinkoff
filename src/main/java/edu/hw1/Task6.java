package edu.hw1;

import java.util.Arrays;

public final class Task6 {
    private Task6() {
    }

    static final int CAPRECAR_CONST = 6174;

    /**
     * Рекурсивная функция, считающая, сколько шагов необходимо сделать до числа Капрекара
     *
     * @param number число, для которого нужно посчитать количество шагов
     * @return количество шагов до числа Капрекара
     */
    private static int countKRec(int number) {
        if (number == CAPRECAR_CONST) {
            return 0;
        }

        char[] low = Integer.toString(number).toCharArray();
        Arrays.sort(low);


        char[] big = new char[low.length];
        for (int i = 0; i < low.length; ++i) {
            big[i] = low[low.length - 1 - i];
        }

        String lowStr = new String(low);
        String bigStr = new String(big);

        int curNumber = Integer.parseInt(bigStr) - Integer.parseInt(lowStr);
        return countKRec(curNumber) + 1;
    }

    /**
     * Если число удовлетворяет требованиям для подсчета числа шагов, то считает колво шагов
     *  иначе бросает исключение
     *
     * @param number число, для которого нужно посчитать количество шагов
     * @return количество шагов
     * @throws IncorrectInputNumber выбрасывается, если число number некорректно
     */
    public static int countK(int number) {
        if (!isCorrectInputNumber(number)) {
            throw new IncorrectInputNumber();
        }

        return countKRec(number);
    }

    static final int FOUR_DIGIT_NUMBER_LENGTH = 4;

    /**
     * Проверяет, удовлетворяет ли number требованиям для подсчета количества шагов
     * Число должно быть четырехзнаычным и не должно состоять из одинаковых цифр
     *
     * @param number число, которое нужно проверить
     * @return true, если удовлетворяет, false иначе
     */
    private static boolean isCorrectInputNumber(int number) {
        String numberStr = Integer.toString(number);

        if (numberStr.length() != FOUR_DIGIT_NUMBER_LENGTH || "1000".equals(numberStr)) {
            return false;
        }

        boolean hasUnique = false;
        for (int i = 1; i < numberStr.length(); ++i) {
            if (numberStr.charAt(i - 1) != numberStr.charAt(i)) {
                hasUnique = true;
                break;
            }
        }

        return hasUnique;
    }

    public static final class IncorrectInputNumber extends RuntimeException {
    }
}
