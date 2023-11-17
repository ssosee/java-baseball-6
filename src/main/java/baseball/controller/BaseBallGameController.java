package baseball.controller;

import baseball.domain.BaseBallNumbers;
import baseball.domain.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseBallGameController {

    public static final int GAME_EXIT = 2;
    public static final int GAME_RESTART = 1;
    public static final String INVALID_GAME_RESTART_MESSAGE = "유효한 값이 아닙니다.";
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private final InputView inputView;
    private final OutputView outputView;

    public BaseBallGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        inputView.printGameStart();
        
        while (true) {
            List<Integer> gameNumbers = createBaseBallNumbers();
            BaseBallNumbers baseBallNumbers = new BaseBallNumbers(gameNumbers);

            while (true) {
                List<Integer> readUserNumbers = inputView.printInputNumber();

                GameResult gameResult = baseBallNumbers.play(readUserNumbers);
                outputView.printGameResult(gameResult);

                if (gameResult.isAllStrike()) {
                    int response = inputView.printNewGame();
                    if (isExit(response)) {
                        Console.close();
                        return;
                    } else if (isRestart(response)) {
                        break;
                    }
                }
            }
        }
    }

    private boolean isRestart(int response) {
        return response == GAME_RESTART;
    }

    private boolean isExit(int response) {
        return response == GAME_EXIT;
    }

    private List<Integer> createBaseBallNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        int maxSize = 3;
        while (computerNumbers.size() < maxSize) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computerNumbers.contains(number)) {
                computerNumbers.add(number);
            }
        }

        return Collections.unmodifiableList(computerNumbers);
    }
}
