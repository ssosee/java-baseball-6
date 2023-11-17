package baseball.domain;

import java.util.Objects;

public class BaseBallNumber {
    private Number number;
    private Position position;

    public BaseBallNumber(int number, int position) {
        this.number = new Number(number);
        this.position = new Position(position);
    }

    public GameStatus play(BaseBallNumber userNumber) {
        return GameStatus.getGameResult(this, userNumber);
    }

    public boolean isStrike(BaseBallNumber userNumber) {
        return this.equals(userNumber);
    }

    public boolean isNothing(BaseBallNumber userNumber) {
        return !this.isStrike(userNumber) && this.isBall(userNumber);
    }

    public boolean isBall(BaseBallNumber userNumber) {
        return number.equals(userNumber.number);
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
