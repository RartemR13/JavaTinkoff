package edu.hw1;

public final class Task4 {
    private Task4() {
    }

    /**
     * Меняет соседние символы местами
     * Если длина строки нечетная, последний символ остается на своем месте
     *
     * @param toFix строка, в которой нужно поменять символы местами
     * @return измененная строка
     */
    public static String fixString(String toFix) {
        char[] even = new char[toFix.length() / 2 + ((toFix.length() % 2 > 0) ? 1 : 0)];
        char[] odd = new char[toFix.length() / 2];

        for (int i = 0; i < toFix.length(); ++i) {
            if (i % 2 == 0) {
                even[i / 2] = toFix.charAt(i);
            } else {
                odd[i / 2] = toFix.charAt(i);
            }
        }

        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (i < even.length || i < odd.length) {
            if (i < odd.length) {
                ret.append(odd[i]);
            }

            if (i < even.length) {
                ret.append(even[i]);
            }

            i++;
        }

        return ret.toString();
    }
}
