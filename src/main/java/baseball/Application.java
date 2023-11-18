package baseball;

import baseball.controller.BaseBallGameController;
import baseball.view.InputView;
import baseball.view.OutPutView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutPutView outPutView = new OutPutView();
        BaseBallGameController baseBallGameController = new BaseBallGameController(inputView, outPutView);

        baseBallGameController.start();
    }
}
