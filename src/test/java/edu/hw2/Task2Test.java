package edu.hw2;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import edu.hw2.Task2.*;
import org.junit.jupiter.params.provider.MethodSource;

class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
}

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        var newRect = rect.setWidth(20).setHeight(10);

        assertThat(newRect.area()).isEqualTo(200.0);
    }

}
