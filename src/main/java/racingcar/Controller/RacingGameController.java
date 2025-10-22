package racingcar.Controller;

import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingGameController {

    InputView inputView;
    OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runRacingGame() {
        outputView.requestCarNames();
        String carNames = inputView.readCarNames();
    }
}
