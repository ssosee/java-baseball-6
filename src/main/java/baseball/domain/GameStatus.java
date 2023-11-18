package baseball.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum GameStatus {
    STRIKE(BaseBallNumber::isStrike),
    BALL(BaseBallNumber::isBall),
    NOTHING(BaseBallNumber::isNothing);

    private final BiPredicate<BaseBallNumber, BaseBallNumber> isMatch;

    GameStatus(BiPredicate<BaseBallNumber, BaseBallNumber> isMatch) {
        this.isMatch = isMatch;
    }

    public static GameStatus getGameStatus(BaseBallNumber com, BaseBallNumber user) {
        return Arrays.stream(GameStatus.values())
                .filter(status -> status.isMatch.test(com, user))
                .findFirst()
                .orElse(NOTHING);
    }

    public boolean isNothing() {
        return this == NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
