package baseball.domain;

import java.util.Objects;

public class Position {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 2;
    public static final String INVALID_POSITION_RANGE_MESSAGE = "숫자의 위치는 0~2 사이의 숫자여야 합니다.";
    private int position;

    public Position(int position) {
        validation(position);
        this.position = position;
    }

    private void validation(int position) {
        if (!isValidRange(position)) {
            throw new IllegalArgumentException(INVALID_POSITION_RANGE_MESSAGE);
        }
    }

    private boolean isValidRange(int position) {
        return position >= MIN_POSITION && position <= MAX_POSITION;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
