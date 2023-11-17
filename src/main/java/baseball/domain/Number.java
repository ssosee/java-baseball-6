package baseball.domain;

import java.util.Objects;

public class Number {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final String INVALID_NUMBER_RANGE_MESSAGE = "1~9 사이의 숫자가 아닙니다.";
    private int number;

    public Number(int number) {
        validation(number);
        this.number = number;
    }

    private void validation(int number) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    private boolean isValidRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
