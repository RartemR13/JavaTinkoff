package edu.hw1;

public final class Task1 {
    private Task1() {
    }

    private static final int MINUTES_MAX_LEN = 5;
    private static final int SECONDS_IN_MINUTE_MAX_COUNT = 59;
    private static final int SECONDS_PER_MINUTE = 60;

    private static boolean isCorrectPartitionPartsLen(String[] partition) {
        return (!partition[0].isEmpty() && partition.length <= MINUTES_MAX_LEN)
            && partition[1].length() == 2;
    }

    private static boolean isWithoutLeadZero(String time) {
        return !time.startsWith("0") || "0:00".equals(time);
    }

    /**
     * Возвращает количество секунд из формата записи minutes:seconds.
     * Для того, чтобы избежать возможного переполнения, длина minutes
     * ограничивается в MINUTES_MAX_LEN символов.
     *
     * @param time строка в формате minutes:seconds
     * @return количество секунд или -1 если time не соответсвует требованиям
     */
    public static int minutesToSeconds(String time) {
        String[] timePartition = time.split(":");
        if (timePartition.length != 2
            || !isCorrectPartitionPartsLen(timePartition)
            || !isWithoutLeadZero(time)) {
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
