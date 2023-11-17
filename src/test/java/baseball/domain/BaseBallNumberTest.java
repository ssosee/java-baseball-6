package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallNumberTest {

    @Test
    @DisplayName("위치와 숫자가 모두 일치하면 스트라이크(STRIKE)를 반환한다.")
    void strike() {
        // given
        BaseBallNumber com = new BaseBallNumber(1, 1);
        BaseBallNumber user = new BaseBallNumber(1, 1);

        // when
        GameStatus result = com.play(user);

        // then
        assertThat(result).isEqualTo(GameStatus.STRIKE);
    }

    @Test
    @DisplayName("위치와 숫자가 모두 일치하면 볼(BALL)을 반환한다.")
    void ball() {
        // given
        BaseBallNumber com = new BaseBallNumber(1, 1);
        BaseBallNumber user = new BaseBallNumber(1, 2);

        // when
        GameStatus result = com.play(user);

        // then
        assertThat(result).isEqualTo(GameStatus.BALL);
    }

    @Test
    @DisplayName("위치와 숫자가 모두 일치하지 않으면 낫싱(NOTHING)를 반환한다.")
    void nothing() {
        // given
        BaseBallNumber com = new BaseBallNumber(1, 1);
        BaseBallNumber user = new BaseBallNumber(2, 2);

        // when
        GameStatus result = com.play(user);

        // then
        assertThat(result).isEqualTo(GameStatus.NOTHING);
    }
}