package racingcar.Repository;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Model.RacingCar;

public class RacingCarRepositoryTest {

    RacingCarRepository racingCarRepository;

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
    @DisplayName("moveAllCarsRandomly 함수 작동 확인(최소 한 번 전진하면 성공)")
    void moveAllCarsRandomly() {
        RacingCarRepository racingCarRepository = new RacingCarRepository(List.of("car1", "car2"));
        List<RacingCar> racingCars = racingCarRepository.getRacingCars();

        List<Integer> before = new ArrayList<>();
        for (RacingCar car : racingCars) {
            before.add(car.getPosition());
        }

        boolean anyMoved = false;
        // 확률을 높이기 위해 50회 moveAllCarsRandomly
        for (int k = 0; k < 50; k++) {
            racingCarRepository.moveAllCarsRandomly();
            for (int i = 0; i < racingCars.size(); i++) {
                int afterPos = racingCars.get(i).getPosition();
                if (afterPos > before.get(i)) {
                    anyMoved = true;
                    break;
                }
            }
            if (anyMoved) {
                break;
            }
        }
        Assertions.assertThat(anyMoved).isTrue();
    }

    @Test
    @DisplayName("getCarsStatusAsString 함수 작동 확인")
    void getCarsStatusAsString() {
        racingCarRepository = new RacingCarRepository(List.of("car1", "car2"));

        String status = racingCarRepository.getCarsStatusAsString();

        // 초기 상태에서는 이동 전 position 0
        Assertions.assertThat(status).isEqualTo("car1 : \ncar2 : \n");
    }

    @Test
    @DisplayName("getTopPositionCarNames 함수 작동 확인")
    void getTopPositionCarNames() {
        racingCarRepository = new RacingCarRepository(List.of("car1", "car2", "car3"));
        List<RacingCar> racingCars = racingCarRepository.getRacingCars();

        racingCars.get(0).move();
        racingCars.get(2).move();

        List<String> topCars = racingCarRepository.getTopPositionCarNames();
        Assertions.assertThat(topCars).containsExactlyInAnyOrder("car1", "car3");
    }
}
