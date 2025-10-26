package racingcar.Service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

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
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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
    @DisplayName("한 라운드 진행시 변화값 확인")
    void runSingleRound() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        racingService.createRacingCars(carNames);

        assertRandomNumberInRangeTest(
                () -> {
                    racingService.runSingleRound();
                    List<RacingCar> racingCars = racingCarRepository.getRacingCars();
                    Assertions.assertThat(racingCars.get(0).getPosition()).isEqualTo(1);
                    Assertions.assertThat(racingCars.get(1).getPosition()).isEqualTo(0);
                    Assertions.assertThat(racingCars.get(2).getPosition()).isEqualTo(1);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("현재 자동차들 진행 상태 확인")
    void getCarsStatus() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        racingService.createRacingCars(carNames);
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.runSingleRound();
                    String status = racingService.getCarsStatus();
                    Assertions.assertThat(status).isEqualTo("pobi : -\nwoni : \njun : -\n");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("우승자 식별 기능 확인")
    void selectWinner() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        racingService.createRacingCars(carNames);
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.runSingleRound();
                    racingService.runSingleRound();
                    List<String> winners = racingService.selectWinners();
                    Assertions.assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );


    }

}
