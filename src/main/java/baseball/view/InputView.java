package baseball.view;

import baseball.domain.UserBaseBallNumbers;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String INVALID_NUMBER_MESSAGE = "입력값이 숫자가 아닙니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public UserBaseBallNumbers readUserNumbers() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String userNumbers = Console.readLine();

        validationUserNumber(userNumbers);

        return new UserBaseBallNumbers(mapList(userNumbers));
    }

    private void validationUserNumber(String userNumbers) {
        if (!isNumeric(userNumbers)) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    private boolean isNumeric(String userNumbers) {
        return userNumbers.chars().allMatch(Character::isDigit);
    }

    private List<Integer> mapList(String userNumbers) {
        return userNumbers.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public int readGameRestartQuery() {
        System.out.println(GAME_RESTART_MESSAGE);
        String response = Console.readLine();

        validationUserNumber(response);

        return Integer.parseInt(response);
    }
}
