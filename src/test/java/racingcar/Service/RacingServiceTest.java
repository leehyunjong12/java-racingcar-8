package racingcar.Service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Model.RacingCar;
import racingcar.Repository.RacingCarRepository;

public class RacingServiceTest {

    RacingService racingService;
    RacingCarRepository racingCarRepository;

    @BeforeEach
    void setUp() {
        racingCarRepository = new RacingCarRepository();
        racingService = new RacingService(racingCarRepository);
    }

    @Test
    @DisplayName("RacingCarRepository에 모델 저장 확인")
    void createRacingCars() {
        List<String> carNames = List.of("pobi", "woni", "jun");

        racingService.createRacingCars(carNames);
        List<RacingCar> racingCars = racingCarRepository.getRacingCars();

        Assertions.assertThat(racingCars).hasSize(3);
        Assertions.assertThat(racingCars)
                .extracting(RacingCar::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("라운드 10번 진행해서 전진이 있었는지 확인")
    void runSingleRound() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        racingService.createRacingCars(carNames);

        List<RacingCar> carsBefore = racingCarRepository.getRacingCars();
        List<Integer> positionsBefore = carsBefore.stream()
                .map(RacingCar::getPosition)
                .toList();

        boolean atLeastOneMoved = false;
        int attempts = 10; // 반복 횟수
        for (int j = 0; j < attempts; j++) {
            racingService.runSingleRound();

            List<RacingCar> carsAfter = racingCarRepository.getRacingCars();
            for (int i = 0; i < carsAfter.size(); i++) {
                if (carsAfter.get(i).getPosition() > positionsBefore.get(i)) {
                    atLeastOneMoved = true;
                    break;
                }
            }
            if (atLeastOneMoved) {
                break;
            }
        }

        Assertions.assertThat(atLeastOneMoved).isTrue();
    }

    @Test
    @DisplayName("한 라운드 진행 결과 출력 확인")
    void getCarsStatus() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        racingService.createRacingCars(carNames);

        String status = racingCarRepository.getCarsStatusAsString();

        // 초기 상태에서는 이동 전 position 0
        Assertions.assertThat(status).isEqualTo("pobi : \nwoni : \njun : \n");
    }

    @Test
    @DisplayName("우승자 식별 기능 확인")
    void selectWinner() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        racingService.createRacingCars(carNames);

        List<RacingCar> racingCars = racingCarRepository.getRacingCars();
        racingCars.get(0).move();
        racingCars.get(2).move();

        List<String> winners = racingService.selectWinners();
        Assertions.assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }

}
