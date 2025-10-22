package racingcar.Service;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorServiceTest {

    ValidatorService validatorService;

    @BeforeEach
    void setUp() {
        validatorService = new ValidatorService();
    }

    @Test
    @DisplayName("자동차 이름이 5 초과일때 예외 발생 확인")
    void validateCarName_1() {
        List<String> carNamesList = new ArrayList<>(List.of("1번차", "5를넘어가는차", "3번차"));
        Assertions.assertThatThrownBy(() -> validatorService.validateCarName(carNamesList))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름이 5를 초과합니다.");

    }

    @Test
    @DisplayName("자동차 이름이 중복될 때 예외 발생 확인")
    void validateCarName_2() {
        List<String> carNamesList = new ArrayList<>(List.of("1번차", "1번차", "3번차"));
        Assertions.assertThatThrownBy(() -> validatorService.validateCarName(carNamesList))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("중복된 자동차 이름이 있습니다.");

    }
}
