package baseball.domain;

public class GameResult {
    public static final int GAME_END_COUNT = 3;
    public static final int INIT_COUNT = 0;
    private int strikeCount;
    private int ballCount;

    public void report(GameStatus status) {
        if (status.isStrike()) {
            strikeCount++;
        }
        if (status.isBall()) {
            ballCount++;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean hasStrikeAndBall() {
        return hasStrike() && hasBall();
    }

    public boolean hasStrike() {
        return strikeCount > INIT_COUNT;
    }

    public boolean hasBall() {
        return ballCount > INIT_COUNT;
    }

    public boolean strikeAll() {
        return strikeCount == GAME_END_COUNT;
    }
}
