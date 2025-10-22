package racingcar.Service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameSplitterServiceTest {

    CarNameSplitterService carNameSplitterServiceTest;

    @BeforeEach
    void setUp() {
        carNameSplitterServiceTest = new CarNameSplitterService();
    }

    @Test
    @DisplayName("자동차 입력 문자열을 구분자로 나누기 확인")
    void splitCarName() {
        String carNames = "1번차,2번차,3번차,";
        assertThat(carNameSplitterServiceTest.splitCarName(carNames)).isEqualTo(List.of("1번차", "2번차", "3번차", ""));
    }
}
