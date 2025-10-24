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

}
