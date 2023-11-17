package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    @DisplayName("스트라이크 갯수를 1개 증가시킨다.")
    void reportStrike() {
        // given
        GameResult result = new GameResult();

        // when
        result.report(GameStatus.STRIKE);

        // then
        assertThat(result.getStrikeCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 갯수를 1개 증가시킨다.")
    void reportBall() {
        // given
        GameResult result = new GameResult();

        // when
        result.report(GameStatus.BALL);

        // then
        assertThat(result.getBallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크가 1개 이상 존재하면 true를 반환한다.")
    void hasStrikeCount() {
        // given
        GameResult result = new GameResult();

        // when
        result.report(GameStatus.STRIKE);

        // then
        assertAll(
                () -> assertThat(result.hasStrikeCount()).isTrue(),
                () -> assertThat(result.hasBallCount()).isFalse()
        );
    }

    @Test
    @DisplayName("볼이 1개 이상 존재하면 true를 반환한다.")
    void hasBallCount() {
        // given
        GameResult result = new GameResult();

        // when
        result.report(GameStatus.BALL);

        // then
        assertAll(
                () -> assertThat(result.hasStrikeCount()).isFalse(),
                () -> assertThat(result.hasBallCount()).isTrue()
        );
    }
}