package baseball.domain;

import java.util.Objects;

public class BallPosition {
    public static final String INVALID_POSITON_RANGE_MESSAGE = "0~2 사이의 위치가 아닙니다.";
    private int position;

    public BallPosition(int position) {
        validationRange(position);
        this.position = position;
    }

    private void validationRange(int position) {
        if (!isRange(position)) {
            throw new IllegalArgumentException(INVALID_POSITON_RANGE_MESSAGE);
        }
    }

    private boolean isRange(int position) {
        return position >= 0 && position <= 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallPosition that = (BallPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
