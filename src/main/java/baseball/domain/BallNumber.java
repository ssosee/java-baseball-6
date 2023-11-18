package baseball.domain;

import java.util.Objects;

public class BallNumber {
    public static final String INVALID_NUMBER_RANGE_MESSAGE = "1~9 사이의 숫자가 아닙니다.";
    private int number;

    public BallNumber(int number) {
        validationRange(number);
        this.number = number;
    }

    private void validationRange(int number) {
        if (!isRange(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    private boolean isRange(int number) {
        return number >= 1 && number <= 9;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
