package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.Service.CarNameSplitterService;
import racingcar.Service.FillEmptyCarNamesService;
import racingcar.Service.RacingService;
import racingcar.Service.ValidatorService;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingGameController {

    InputView inputView;
    OutputView outputView;
    CarNameSplitterService carNameSplitterService;
    FillEmptyCarNamesService fillEmptyCarNamesService;
    ValidatorService validatorService;
    RacingService racingService;

    public RacingGameController(InputView inputView, OutputView outputView,
                                CarNameSplitterService carNameSplitterService,
                                FillEmptyCarNamesService fillEmptyCarNamesService, ValidatorService validatorService,
                                RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carNameSplitterService = carNameSplitterService;
        this.fillEmptyCarNamesService = fillEmptyCarNamesService;
        this.validatorService = validatorService;
        this.racingService = racingService;
    }

    public void runRacingGame() {
        String carNamesInput = inputCarNames();
        List<String> carNamesList = convertToCarNameList(carNamesInput);
        validatorService.validateCarName(carNamesList);
        int attemptCountInput = inputAttemptCount();
        validatorService.validateAttemptCount(attemptCountInput);
        runRace(carNamesList, attemptCountInput);
    }

    private String inputCarNames() {
        outputView.requestCarNames();
        return inputView.readCarNames();
    }

    private List<String> convertToCarNameList(String carNames) {
        List<String> carNamesList = new ArrayList<>(carNameSplitterService.splitCarName(carNames));
        return fillEmptyCarNamesService.fillEmptyCarNames(carNamesList);
    }

    private int inputAttemptCount() {
        outputView.requestAttemptCount();
        return inputView.readAttemptCount();
    }

    private void runRace(List<String> carNamesList, int attemptCount) {
        racingService.createRacingCars(carNamesList);
        outputView.printRaceHeader();
        for (int i = 0; i < attemptCount; i++) {
            racingService.runSingleRound();
            String currentStatus = racingService.getCarsStatus();
            outputView.printRaceState(currentStatus);
        }
        List<String> winners = racingService.selectWinners();
        outputView.printWinners(winners);
    }
}
