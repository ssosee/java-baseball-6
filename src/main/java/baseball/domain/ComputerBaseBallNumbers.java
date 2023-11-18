package baseball.domain;

import java.util.List;

public class ComputerBaseBallNumbers extends BaseBallNumbers {
    private List<BaseBallNumber> baseBallNumbers;

    public ComputerBaseBallNumbers(List<Integer> baseBallNumbers) {
        validationDuplicated(baseBallNumbers);
        this.baseBallNumbers = mapBaseBallNumbers(baseBallNumbers);
    }

    public GameStatus play(BaseBallNumber userNumber) {
        return baseBallNumbers.stream()
                .map(comNumber -> GameStatus.getGameStatus(comNumber, userNumber))
                .filter(status -> !status.isNothing())
                .findFirst()
                .orElse(GameStatus.NOTHING);
    }
}
