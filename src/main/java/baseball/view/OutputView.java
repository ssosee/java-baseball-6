package baseball.view;

import baseball.domain.GameResult;
import baseball.domain.GameStatus;

public class OutputView {

    public static final String BALL_STRIKE_MESSAGE = "%d볼 %d스트라이크";
    public static final String BALL_MESSAGE = "%d볼";
    public static final String STRIKE_MESSAGE = "%d스트라이크";
    public static final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printGameResult(GameResult gameResult) {
        System.out.println(createMessage(gameResult));
        if (gameResult.isAllStrike()) {
            System.out.println(GAME_CLEAR_MESSAGE);
        }
    }

    private String createMessage(GameResult gameResult) {
        if (gameResult.hasStrikeCount() && gameResult.hasBallCount()) {
            return String.format(BALL_STRIKE_MESSAGE, gameResult.getBallCount(), gameResult.getStrikeCount());
        } else if (gameResult.hasBallCount()) {
            return String.format(BALL_MESSAGE, gameResult.getBallCount());
        } else if (gameResult.hasStrikeCount()) {
            return String.format(STRIKE_MESSAGE, gameResult.getStrikeCount());
        }
        return GameStatus.NOTHING.getMessage();
    }
}
