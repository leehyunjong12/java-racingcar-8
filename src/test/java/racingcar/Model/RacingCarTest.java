package racingcar.Model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    @DisplayName("RacingCar 모델 출력 확인")
    void checkRacingCaModelStringr() {
        RacingCar car1 = new RacingCar("Car1");
        car1.move();
        Assertions.assertThat(car1.getCarStatusAsString()).isEqualTo("Car1 : -");
    }

    @Test
    @DisplayName("getName 함수 작동 확인")
    void getName() {
        RacingCar car1 = new RacingCar("Car1");
        Assertions.assertThat(car1.getName()).isEqualTo("Car1");
    }

    @Test
    @DisplayName("getPosition 함수 작동 확인")
    void getPosition() {
        RacingCar car1 = new RacingCar("Car1");
        Assertions.assertThat(car1.getPosition()).isEqualTo(0);
        car1.move();
        car1.move();
        Assertions.assertThat(car1.getPosition()).isEqualTo(2);
    }
}
