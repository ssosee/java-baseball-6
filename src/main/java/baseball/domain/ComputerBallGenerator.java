package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerBallGenerator {

    private ComputerBallGenerator() {
    }

    public static List<Integer> createBaseBallNumbers() {
        List<Integer> baseBallNumbers = new ArrayList<>();
        while (baseBallNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseBallNumbers.contains(randomNumber)) {
                baseBallNumbers.add(randomNumber);
            }
        }

        return Collections.unmodifiableList(baseBallNumbers);
    }
}
