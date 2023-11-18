package baseball.controller;

import baseball.domain.BaseBallGameService;
import baseball.domain.ComputerBallGenerator;
import baseball.domain.ComputerBaseBallNumbers;
import baseball.domain.GameResult;
import baseball.domain.UserBaseBallNumbers;
import baseball.view.InputView;
import baseball.view.OutPutView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseBallGameController {

    public static final int EXIT = 2;
    public static final int RESTART = 1;
    private final InputView inputView;
    private final OutPutView outPutView;

    public BaseBallGameController(InputView inputView, OutPutView outPutView) {
        this.inputView = inputView;
        this.outPutView = outPutView;
    }

    public void start() {
        outPutView.printGameStartAtFirst();

        while (true) {
            List<Integer> computerBaseBallNums = ComputerBallGenerator.createBaseBallNumbers();

            ComputerBaseBallNumbers computerBaseBallNumbers = new ComputerBaseBallNumbers(computerBaseBallNums);
            BaseBallGameService baseBallGameService = new BaseBallGameService(computerBaseBallNumbers);

            if (simulateBaseBallGame(baseBallGameService)) {
                break;
            }
        }

        Console.close();
    }

    private boolean simulateBaseBallGame(BaseBallGameService baseBallGameService) {
        while (true) {
            readUserNumber(baseBallGameService);

            GameResult gameResult = play(baseBallGameService);

            if (gameResult.strikeAll()) {
                int userQuery = inputView.readGameRestartQuery();
                if (isExit(userQuery)) {
                    return true;
                } else if (isReStart(userQuery)) {
                    return false;
                }
            }
        }
    }

    private static boolean isReStart(int userQuery) {
        return userQuery == RESTART;
    }

    private static boolean isExit(int userQuery) {
        return userQuery == EXIT;
    }

    private GameResult play(BaseBallGameService baseBallGameService) {
        GameResult gameResult = baseBallGameService.play();
        outPutView.printGameResult(gameResult);

        return gameResult;
    }

    private void readUserNumber(BaseBallGameService baseBallGameService) {
        UserBaseBallNumbers userNumbers = inputView.readUserNumbers();
        baseBallGameService.changeUserBaseBallNumbers(userNumbers);
    }
}
