package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class BaseBallNumbers {

    public static final String INVALID_NUMBER_DUPLICATED_MESSAGE = "입력 값에 중복된 숫자가 있습니다.";
    public static final int VALID_NUMBER_SIZE = 3;

    protected void validationDuplicated(List<Integer> userNumbers) {
        Set<Integer> answer = new HashSet<>(userNumbers);
        if (!isSize(answer)) {
            throw new IllegalArgumentException(INVALID_NUMBER_DUPLICATED_MESSAGE);
        }
    }

    private static boolean isSize(Set<Integer> answer) {
        return answer.size() == VALID_NUMBER_SIZE;
    }

    protected List<BaseBallNumber> mapBaseBallNumbers(List<Integer> userNumbers) {
        List<BaseBallNumber> baseBallNumbers = new ArrayList<>();
        for (int index = 0; index < userNumbers.size(); index++) {
            baseBallNumbers.add(new BaseBallNumber(userNumbers.get(index), index));
        }

        return baseBallNumbers;
    }
}
