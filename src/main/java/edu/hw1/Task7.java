package edu.hw1;

public final class Task7 {
    private Task7() {
    }

    /**
     * Циклический битовый сдвиг влево
     *
     * @param number число, которое нужно сдвинуть
     * @param shift на сколько сдвинуть
     * @return число после сдвига
     */
    public static int rotateLeft(int number, int shift) {
        String binaryString = Integer.toBinaryString(number);

        int absShift = Math.abs(shift);
        absShift %= binaryString.length();

        if (shift > 0) {
            return Integer.parseInt(
                binaryString.substring(absShift) + binaryString.substring(0, absShift),
                2
            );
        }

        return Integer.parseInt(
            binaryString.substring(binaryString.length() - absShift)
                + binaryString.substring(0, binaryString.length() - absShift),
            2
        );
    }

    /**
     * Циклический битовый сдвиг вправо
     *
     * @param number число, которое надо сдвинуть
     * @param shift на сколько сдвинуть
     * @return число после сдвига
     */
    public static int rotateRight(int number, int shift) {
        return rotateLeft(number, -shift);
    }
}
