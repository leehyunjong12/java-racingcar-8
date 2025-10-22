package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarNames() {
        return Console.readLine();
    }

    public int readAttemptCount() {
        return Integer.parseInt(Console.readLine());
    }
}
