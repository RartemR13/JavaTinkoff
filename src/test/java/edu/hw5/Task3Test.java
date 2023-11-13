package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

class Task3Test {
    @Test
    @DisplayName("Слеши")
    void slashesTest() {
        String date = "1/3/1976";

        var ans = Task3.parseDate(date);

        assertThat(ans).isNotEmpty();
        assertThat(ans.get()).isEqualTo(LocalDate.of(1976, 3, 1));
    }

    @Test
    @DisplayName("Деши")
    void dashesTest() {
        String date = "2020-10-10";

        var ans = Task3.parseDate(date);

        assertThat(ans).isNotEmpty();
        assertThat(ans.get()).isEqualTo(LocalDate.of(2020, 10, 10));
    }

    @Test
    @DisplayName("Завтра")
    void tomorrowTest() {
        String date = "TOMORROW";
        var correctAns = LocalDate.now().plusDays(1);

        var ans = Task3.parseDate(date);

        assertThat(ans).isNotEmpty();
        assertThat(ans.get()).isEqualTo(correctAns);
    }

    @Test
    @DisplayName("Сегодня")
    void todayTest() {
        String date = "ToDaY";
        var correctAns = LocalDate.now();

        var ans = Task3.parseDate(date);

        assertThat(ans).isNotEmpty();
        assertThat(ans.get()).isEqualTo(correctAns);
    }

    @Test
    @DisplayName("Вчера")
    void yesterdayTest() {
        String date = "Yesterday";
        var correctAns = LocalDate.now().minusDays(1);

        var ans = Task3.parseDate(date);

        assertThat(ans).isNotEmpty();
        assertThat(ans.get()).isEqualTo(correctAns);
    }

    @Test
    @DisplayName("Дни назад")
    void daysAgoTest() {
        String date = "6 days ago";
        var correctAns = LocalDate.now().minusDays(6);

        var ans = Task3.parseDate(date);

        assertThat(ans).isNotEmpty();
        assertThat(ans.get()).isEqualTo(correctAns);
    }
}
