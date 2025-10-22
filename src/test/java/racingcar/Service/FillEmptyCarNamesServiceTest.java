package racingcar.Service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FillEmptyCarNamesServiceTest {

    FillEmptyCarNamesService fillEmptyCarNamesService;

    @BeforeEach
    void setUp() {
        fillEmptyCarNamesService = new FillEmptyCarNamesService();
    }

    @Test
    @DisplayName("빈 문자열 \"Null\"+index로 채워지는지 확인")
    void fillEmptyCarNames() {
        List<String> carNamesList = new ArrayList<>(List.of("1번차", "", "3번차", "4번차", "", ""));
        assertThat(fillEmptyCarNamesService.fillEmptyCarNames(carNamesList)).isEqualTo(
                List.of("1번차", "NULL1", "3번차", "4번차", "NULL2", "NULL3"));
    }
}
