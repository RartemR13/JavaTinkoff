package edu.hw1;

public final class Task3 {
    private Task3() {
    }

    /**
     * Возвращает минимум непустого массива
     * @param array массив, минимум которого нужно найти
     * @return минимум массива array
     */
    private static int getMin(int[] array) {
        int currentMin = array[0];
        for (int number : array) {
            currentMin = Math.min(number, currentMin);
        }

        return currentMin;
    }

    /**
     * Возвращает максимум непустого массива
     * @param array массив, максимум которого нужно найти
     * @return максимум массива array
     */
    private static int getMax(int[] array) {
        int currentMax = array[0];
        for (int number : array) {
            currentMax = Math.max(number, currentMax);
        }

        return currentMax;
    }

    /**
     * Проверяет, вложен ли первый массив во второй.
     * Первый массив вложен во второй когда минимум второго больше минимума первого
     *  и максимум первого меньше максимума второго
     * Также если первый массив пуст, то он вложен в любой другой
     * Если второй массив пуст, в него может быть вложен только пустой
     *
     * @param array1 первый массив
     * @param array2 второй массив
     * @return true, если первый массив лежит во втором, false иначе
     */
    public static boolean isNestable(int[] array1, int[] array2) {
        if (array1.length == 0) {
            return true;
        }

        if (array2.length == 0) {
            return false;
        }

        return getMin(array1) > getMin(array2)
            && getMax(array1) < getMax(array2);
    }
}
