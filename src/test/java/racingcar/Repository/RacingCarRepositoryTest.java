package racingcar.Repository;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Model.RacingCar;

public class RacingCarRepositoryTest {

    RacingCarRepository racingCarRepository;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("RacingCarRepository 생성 확인")
    void getRacingCars() {
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        racingCarRepository = new RacingCarRepository(carNames);
        Assertions.assertThat(racingCarRepository.getRacingCars())
                .extracting(RacingCar::getName)   // 이름 기준으로 리스트 추출
                .containsExactly("car1", "car2");
    }

    @Test
    @DisplayName("moveAllCarsRandomly 함수 작동 확인")
    void moveAllCarsRandomly() {
        RacingCarRepository racingCarRepository = new RacingCarRepository(List.of("car1", "car2"));
        List<RacingCar> racingCars = racingCarRepository.getRacingCars();

        assertRandomNumberInRangeTest(
                () -> {
                    racingCarRepository.moveAllCarsRandomly();

                    Assertions.assertThat(racingCars.get(0).getPosition()).isEqualTo(1);
                    Assertions.assertThat(racingCars.get(1).getPosition()).isEqualTo(0);
                },
                MOVING_FORWARD, STOP
        );
    }


    @Test
    @DisplayName("getCarsStatusAsString 함수 작동 확인")
    void getCarsStatusAsString() {
        racingCarRepository = new RacingCarRepository(List.of("car1", "car2"));
        assertRandomNumberInRangeTest(
                () -> {
                    racingCarRepository.moveAllCarsRandomly();
                    String status = racingCarRepository.getCarsStatusAsString();
                    Assertions.assertThat(status).isEqualTo("car1 : -\ncar2 : \n");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("getTopPositionCarNames 함수 작동 확인")
    void getTopPositionCarNames() {
        racingCarRepository = new RacingCarRepository(List.of("car1", "car2", "car3"));
        assertRandomNumberInRangeTest(
                () -> {
                    racingCarRepository.moveAllCarsRandomly();
                    racingCarRepository.moveAllCarsRandomly();
                    List<String> topCars = racingCarRepository.getTopPositionCarNames();
                    Assertions.assertThat(topCars).containsExactlyInAnyOrder("car3");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );

    }
}
