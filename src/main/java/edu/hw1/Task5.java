package edu.hw1;

public final class Task5 {
    private Task5() {
    }

    /**
     * Проверяет, является ли число палиндромом
     *
     * @param number проверяемое число
     * @return true, если число палидром или false иначе
     */
    private static boolean isPalindrome(int number) {
        return Integer.toString(number).contentEquals(
            new StringBuilder(Integer.toString(number)).reverse()
        );
    }

    /**
     * Возвращает потомка числа
     * Если потомка нет возвращает сам число
     *
     * @param number число, потомок которого нужно вернуть
     * @return потомок числа, если он есть или самое число если его нет
     */
    private static int getDescendant(int number) {
        String numberStr = Integer.toString(number);

        if (numberStr.length() % 2 != 0) {
            return number;
        }

        int descendant = 0;
        for (int i = 0; i < numberStr.length(); i += 2) {
            int leftDigit = Integer.parseInt(numberStr.substring(i, i + 1));
            int rightDigit = Integer.parseInt(numberStr.substring(i + 1, i + 2));

            descendant *= Integer.toString(leftDigit + rightDigit).length();
            descendant += leftDigit + rightDigit;
        }

        return descendant;
    }

    /**
     * Проверяет, является ли число или какой-то его потомок палиндромом
     * Потомок числа в данном случае это склеенные суммы пар соседних чисел
     * Если число нечетной длины то потомка нет
     *
     * @param number число для проверки
     * @return true, если число либо какой-то его потомок палиндром, false иначе
     */
    public static boolean isPalindromeDescendant(int number) {
        int curNumber = number;

        while (!isPalindrome(curNumber)) {
            int nextNumber = getDescendant(number);
            if (curNumber == nextNumber) {
                break;
            }

            curNumber = nextNumber;
        }

        return isPalindrome(curNumber);
    }
}
