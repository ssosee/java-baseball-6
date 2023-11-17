package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallNumbersTest {
    @Test
    @DisplayName("3스트라이크")
    void strike3() {
        // given
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers(List.of(1, 2, 3));

        // when
        GameResult result = baseBallNumbers.play(List.of(1, 2, 3));

        // then
        assertAll(
                () -> assertThat(result.getStrikeCount()).isEqualTo(3),
                () -> assertThat(result.getBallCount()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("3볼")
    void ball3() {
        // given
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers(List.of(1, 2, 3));

        // when
        GameResult result = baseBallNumbers.play(List.of(3, 1, 2));

        // then
        assertAll(
                () -> assertThat(result.getStrikeCount()).isEqualTo(0),
                () -> assertThat(result.getBallCount()).isEqualTo(3)
        );
    }

    @Test
    @DisplayName("1볼 1스트라이크")
    void ball1Strike1() {
        // given
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers(List.of(1, 2, 3));

        // when
        GameResult result = baseBallNumbers.play(List.of(1, 5, 2));

        // then
        assertAll(
                () -> assertThat(result.getStrikeCount()).isEqualTo(1),
                () -> assertThat(result.getBallCount()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("낫싱")
    void nothing() {
        // given
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers(List.of(1, 2, 3));

        // when
        GameResult result = baseBallNumbers.play(List.of(7, 8, 9));

        // then
        assertAll(
                () -> assertThat(result.getStrikeCount()).isEqualTo(0),
                () -> assertThat(result.getBallCount()).isEqualTo(0)
        );
    }
}