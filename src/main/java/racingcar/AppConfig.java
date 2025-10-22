package racingcar;

import racingcar.Controller.RacingGameController;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class AppConfig {

    public RacingGameController racingGameController() {
        return new RacingGameController(inputView(), outputView());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
