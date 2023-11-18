package baseball.view;

import baseball.domain.GameResult;

public class OutPutView {

    public static final String START_GAME_AT_FIRST_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String BALL_AND_STRIKE_MESSAGE_FORMAT = "%d볼 %d스트라이크";
    public static final String STRIKE_MESSAGE_FORMAT = "%d스트라이크";
    public static final String BALL_MESSAGE_FORMAT = "%d볼";
    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printGameStartAtFirst() {
        System.out.println(START_GAME_AT_FIRST_MESSAGE);
    }

    public void printGameResult(GameResult gameResult) {
        System.out.println(getGameResultMessage(gameResult));
        if (gameResult.strikeAll()) {
            System.out.println(GAME_CLEAR_MESSAGE);
        }
    }

    private String getGameResultMessage(GameResult gameResult) {
        if (gameResult.hasStrikeAndBall()) {
            return String.format(BALL_AND_STRIKE_MESSAGE_FORMAT, gameResult.getBallCount(),
                    gameResult.getStrikeCount());
        } else if (gameResult.hasStrike()) {
            return String.format(STRIKE_MESSAGE_FORMAT, gameResult.getStrikeCount());
        } else if (gameResult.hasBall()) {
            return String.format(BALL_MESSAGE_FORMAT, gameResult.getBallCount());
        }
        return NOTHING_MESSAGE;
    }
}
