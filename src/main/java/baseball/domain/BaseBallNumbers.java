package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class BaseBallNumbers {
    public static final String INVALID_NUMBER_DUPLICATED_MESSAGE = "입력한 숫자에 중복 값이 있습니다.";
    public static final int TARGET_NUMBER_SIZE = 3;
    private List<BaseBallNumber> numbers;

    public BaseBallNumbers(List<Integer> numbers) {
        validationDuplicated(numbers);
        this.numbers = mapBaseBallNumbers(numbers);
    }

    private void validationDuplicated(List<Integer> numbers) {
        Set<Integer> answers = new HashSet<>(numbers);
        if (isSize(answers)) {
            throw new IllegalArgumentException(INVALID_NUMBER_DUPLICATED_MESSAGE);
        }
    }

    private boolean isSize(Set<Integer> answers) {
        return answers.size() != TARGET_NUMBER_SIZE;
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
