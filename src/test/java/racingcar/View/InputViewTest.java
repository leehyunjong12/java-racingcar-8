package racingcar.View;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    @DisplayName("경주할 자동차들 입력이 잘 들어오는지 확인")
    void readCarNames() {
        String simulatedInput = "pobi,woni,jun\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);
        Assertions.assertThat(inputView.readCarNames()).isEqualTo("pobi,woni,jun");
    }
}
