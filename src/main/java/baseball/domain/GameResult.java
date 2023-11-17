package baseball.domain;

public class GameResult {
    public static final int ALL_STRIKE = 3;
    public static final int INIT_COUNT = 0;
    private int strikeCount;
    private int ballCount;

    public void report(GameStatus status) {
        if (status.isStrike()) {
            strikeCount += 1;
        }
        if (status.isBall()) {
            ballCount += 1;
        }
    }

    public boolean hasStrikeCount() {
        return strikeCount > INIT_COUNT;
    }

    public boolean hasBallCount() {
        return ballCount > INIT_COUNT;
    }

    public boolean isAllStrike() {
        return strikeCount == ALL_STRIKE;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
