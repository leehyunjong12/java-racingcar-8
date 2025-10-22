package racingcar.View;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    InputView inputView;
    private InputStream systemInBackup;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        systemInBackup = System.in; // System.in 백업
    }

    @AfterEach
    void tearDown() {
        System.setIn(systemInBackup); // System.in 복원
    }

    @Test
    @DisplayName("경주할 자동차들 입력 확인")
    void readCarNames() {
        String simulatedInput = "pobi,woni,jun\n"; // 개행 필수
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        String result = inputView.readCarNames();
        Assertions.assertThat(result).isEqualTo("pobi,woni,jun");
    }

    @Test
    @DisplayName("시도 횟수 입력 확인")
    void readAttemptCount() {
        String simulatedInput = "5\n"; // 개행 필수
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        int result = inputView.readAttemptCount();
        Assertions.assertThat(result).isEqualTo(5);
    }
}
