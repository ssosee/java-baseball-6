package baseball.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum GameStatus {
    STRIKE("스트라이크", BaseBallNumber::isStrike),
    BALL("볼", BaseBallNumber::isBall),
    NOTHING("낫싱", BaseBallNumber::isNothing);

    private final String message;
    private final BiPredicate<BaseBallNumber, BaseBallNumber> isMatch;

    GameStatus(String message, BiPredicate<BaseBallNumber, BaseBallNumber> isMatch) {
        this.message = message;
        this.isMatch = isMatch;
    }

    public static GameStatus getGameResult(final BaseBallNumber com, final BaseBallNumber user) {
        return Arrays.stream(GameStatus.values())
                .filter(gameStatus -> gameStatus.isMatch.test(com, user))
                .findFirst()
                .orElse(NOTHING);
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isNothing() {
        return this == NOTHING;
    }
}
