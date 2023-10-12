package edu.hw1;

public final class Task1 {
    private Task1() {
    }

    private static final int MINUTES_MAX_LEN = 5;
    private static final int SECONDS_IN_MINUTE_MAX_COUNT = 59;
    private static final int SECONDS_PER_MINUTE = 60;

    /**
     *  Возвращает количество секунд из формата записи minutes:seconds.
     *  Для того, чтобы избежать возможного переполнения, длина minutes
     * ограничивается в MINUTES_MAX_LEN символов.
     *
     * @param time строка в формате minutes:seconds
     * @return количество секунд или -1 если time не соответсвует требованиям
     */
    public static int minutesToSeconds(String time) {
        String[] timePartition = time.split(":");
        if (timePartition.length != 2
            || (timePartition[0].isEmpty() || timePartition[1].length() != 2)
            || (timePartition[0].length() > MINUTES_MAX_LEN)
            || (timePartition[0].startsWith("0") && !(time.equals("0:00")))) {
            return -1;
        }

        int minutes;
        int seconds;
        try {
            minutes = Integer.parseInt(timePartition[0]);
            seconds = Integer.parseInt(timePartition[1]);
        } catch (Exception any) {
            return -1;
        }

        if (minutes < 0 || seconds < 0 || seconds > SECONDS_IN_MINUTE_MAX_COUNT) {
            return -1;
        }

        return minutes * SECONDS_PER_MINUTE + seconds;
    }
}
