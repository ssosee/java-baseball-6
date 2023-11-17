package baseball.domain;

public class GameResult {
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

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
