package edu.hw6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HackersNewsTest {
    @Test
    @DisplayName("тест")
    void test() {
        var topicsNumbers = HackersNews.hackerNewsTopStories();

        assertThat(topicsNumbers).isNotEqualTo(null);
    }

    @Test
    @DisplayName("имя новости")
    void testName() {
        var topicTitle = HackersNews.news(37570037);
        String exp = "JDK 21 Release Note";

        assertThat(topicTitle).isEqualTo(exp);
    }
}
