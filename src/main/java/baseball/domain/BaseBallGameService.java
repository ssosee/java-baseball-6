package baseball.domain;

import java.util.List;

public class BaseBallGameService {
    private final ComputerBaseBallNumbers computerBaseBallNumbers;
    private UserBaseBallNumbers userBaseBallNumbers;

    public BaseBallGameService(ComputerBaseBallNumbers computerBaseBallNumbers) {
        this.computerBaseBallNumbers = computerBaseBallNumbers;
    }

    public void changeUserBaseBallNumbers(UserBaseBallNumbers userBaseBallNumbers) {
        this.userBaseBallNumbers = userBaseBallNumbers;
    }

    public GameResult play() {
        List<BaseBallNumber> baseBallNumbers = userBaseBallNumbers.getBaseBallNumbers();
        GameResult gameResult = new GameResult();
        for (BaseBallNumber userNumber : baseBallNumbers) {
            GameStatus gameStatus = computerBaseBallNumbers.play(userNumber);
            gameResult.report(gameStatus);
        }

        return gameResult;
    }
}
