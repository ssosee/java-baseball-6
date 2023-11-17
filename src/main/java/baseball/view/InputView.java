package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    public static final String USER_NUMBER_REX = "^[1-9]+$";
    public static final String INVALID_USER_NUMBER_MESSAGE = "유효하지 않은 입력입니다.";
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 :";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public List<Integer> printInputNumberMessage() {
        System.out.print(INPUT_MESSAGE);
        String userNumber = Console.readLine();

        validationUserNumber(userNumber);

        return mapList(userNumber);
    }

    private List<Integer> mapList(String userNumber) {
        return userNumber.chars()
                .boxed()
                .collect(Collectors.toList());
    }

    private void validationUserNumber(String userNumber) {
        if (isNumeric(userNumber)) {
            throw new IllegalArgumentException(INVALID_USER_NUMBER_MESSAGE);
        }
    }

    private boolean isNumeric(String userNumber) {
        return Pattern.matches(USER_NUMBER_REX, userNumber);
    }
}
