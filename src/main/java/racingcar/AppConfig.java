package racingcar;

import racingcar.Controller.RacingGameController;
import racingcar.Repository.RacingCarRepository;
import racingcar.Service.CarNameSplitterService;
import racingcar.Service.FillEmptyCarNamesService;
import racingcar.Service.RacingService;
import racingcar.Service.ValidatorService;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class AppConfig {

    private final RacingCarRepository racingCarRepository = new RacingCarRepository();

    public RacingGameController racingGameController() {
        return new RacingGameController(inputView(), outputView(), carNameSplitterService(),
                fillEmptyCarNamesService(), validatorService(), racingService());
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

    public ValidatorService validatorService() {
        return new ValidatorService();
    }

    public RacingService racingService() {
        return new RacingService(racingCarRepository);
    }
}
