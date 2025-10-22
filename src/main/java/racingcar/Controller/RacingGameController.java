package racingcar.Controller;

import java.util.List;
import racingcar.Service.CarNameSplitterService;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingGameController {

    InputView inputView;
    OutputView outputView;
    CarNameSplitterService carNameSplitterService;

    public RacingGameController(InputView inputView, OutputView outputView,
                                CarNameSplitterService carNameSplitterService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carNameSplitterService = carNameSplitterService;
    }

    public void runRacingGame() {
        outputView.requestCarNames();
        String carNames = inputView.readCarNames();
        List<String> carNamesList = carNameSplitterService.splitCarName(carNames);
    }
}
