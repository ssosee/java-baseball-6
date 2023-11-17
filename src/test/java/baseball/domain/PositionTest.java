package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("위치가 0~2 사이의 숫자이면 예외가 발생하지 않는다.")
    void createPosition(int input) {
        // given // when // then
        assertThatCode(() -> new Position(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 4})
    @DisplayName("위치가 0~2 사이의 숫자가 아니면 예외가 발생한다.")
    void createPositionException(int input) {
        // given // when // then
        assertThatThrownBy(() -> new Position(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}