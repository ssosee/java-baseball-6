package baseball.domain;

import java.util.Objects;

public class BaseBallNumber {
    private BallNumber number;
    private BallPosition position;

    public BaseBallNumber(int number, int position) {
        this.number = new BallNumber(number);
        this.position = new BallPosition(position);
    }

    public boolean isBall(BaseBallNumber userNumber) {
        return this.number.equals(userNumber.number);
    }

    public boolean isStrike(BaseBallNumber userNumber) {
        return this.equals(userNumber);
    }

    public boolean isNothing(BaseBallNumber userNumber) {
        return !isStrike(userNumber) && !isBall(userNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseBallNumber that = (BaseBallNumber) o;
        return Objects.equals(number, that.number) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
