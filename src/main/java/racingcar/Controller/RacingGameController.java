package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.Service.CarNameSplitterService;
import racingcar.Service.FillEmptyCarNamesService;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingGameController {

    InputView inputView;
    OutputView outputView;
    CarNameSplitterService carNameSplitterService;
    FillEmptyCarNamesService fillEmptyCarNamesService;

    public RacingGameController(InputView inputView, OutputView outputView,
                                CarNameSplitterService carNameSplitterService,
                                FillEmptyCarNamesService fillEmptyCarNamesService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carNameSplitterService = carNameSplitterService;
        this.fillEmptyCarNamesService = fillEmptyCarNamesService;
    }

    public void runRacingGame() {
        outputView.requestCarNames();
        String carNames = inputView.readCarNames();
        List<String> carNamesList = new ArrayList<>(carNameSplitterService.splitCarName(carNames));
        carNamesList = fillEmptyCarNamesService.fillEmptyCarNames(carNamesList);
    }
}
