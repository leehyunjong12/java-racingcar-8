package racingcar;

import racingcar.Controller.RacingGameController;
import racingcar.Service.CarNameSplitterService;
import racingcar.Service.FillEmptyCarNamesService;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class AppConfig {

    public RacingGameController racingGameController() {
        return new RacingGameController(inputView(), outputView(), carNameSplitterService(),
                fillEmptyCarNamesService());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public CarNameSplitterService carNameSplitterService() {
        return new CarNameSplitterService();
    }

    public FillEmptyCarNamesService fillEmptyCarNamesService() {
        return new FillEmptyCarNamesService();
    }
}
