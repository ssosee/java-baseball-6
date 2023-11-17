package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class BaseBallNumbers {
    private List<BaseBallNumber> numbers;

    public BaseBallNumbers(List<Integer> numbers) {
        this.numbers = mapBaseBallNumbers(numbers);
    }

    public GameResult play(List<Integer> userNums) {
        BaseBallNumbers userBaseNumbers = new BaseBallNumbers(userNums);
        GameResult result = new GameResult();
        for (BaseBallNumber number : numbers) {
            GameStatus status = userBaseNumbers.play(number);
            result.report(status);
        }

        return result;
    }

    private GameStatus play(BaseBallNumber userNum) {
        return this.numbers.stream()
                .map(comNum -> comNum.play(userNum))
                .filter(status -> !status.isNothing())
                .findFirst()
                .orElse(GameStatus.NOTHING);
    }

    private List<BaseBallNumber> mapBaseBallNumbers(List<Integer> numbers) {
        int startIndexInclusive = 0;
        return IntStream.range(startIndexInclusive, numbers.size())
                .mapToObj(index -> new BaseBallNumber(numbers.get(index), index))
                .toList();
    }
}
