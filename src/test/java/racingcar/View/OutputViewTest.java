package racingcar.View;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    OutputView outputView;
    private final ByteArrayOutputStream outPutContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        System.setOut(new PrintStream(outPutContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out); // 원복
    }

    @Test
    @DisplayName("경주할 자동차 이름 입력받기 위한 출력 확인")
    void requestCarNames() {
        outputView.requestCarNames();
        assertThat(outPutContent.toString().trim())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}
