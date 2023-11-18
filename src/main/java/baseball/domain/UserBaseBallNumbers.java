package baseball.domain;

import java.util.Collections;
import java.util.List;

public class UserBaseBallNumbers extends BaseBallNumbers {
    private final List<BaseBallNumber> baseBallNumbers;

    public UserBaseBallNumbers(List<Integer> userNumbers) {
        validationDuplicated(userNumbers);
        this.baseBallNumbers = mapBaseBallNumbers(userNumbers);
    }


    public List<BaseBallNumber> getBaseBallNumbers() {
        return Collections.unmodifiableList(baseBallNumbers);
    }
}
