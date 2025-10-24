package racingcar.Service;

import java.util.List;
import racingcar.Repository.RacingCarRepository;

public class RacingService {

    RacingCarRepository racingCarRepository;

    public RacingService(RacingCarRepository racingCarRepository) {
        this.racingCarRepository = racingCarRepository;
    }

    public void createRacingCars(List<String> carNamesList) {
        racingCarRepository.setCars(carNamesList);
    }

    public void runSingleRound() {
        racingCarRepository.moveAllCarsRandomly();
    }

    public String getCarsStatus() {
        return racingCarRepository.getCarsStatusAsString();
    }

    public List<String> selectWinners() {
        return racingCarRepository.getTopPositionCarNames();
    }
}
