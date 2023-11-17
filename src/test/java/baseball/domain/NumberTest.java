package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("1~9 사이의 숫자이면 예외가 발생하지 않는다.")
    void createNumber(int input) {
        // given // when // then
        assertThatCode(() -> new Number(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100})
    @DisplayName("1~9 사이의 숫자가 아니면 예외가 발생한다.")
    void createNumberException(int input) {
        // given // when // then
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}