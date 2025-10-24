package racingcar.View;

import java.util.List;

public class OutputView {

    public void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void requestAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRaceHeader() {
        System.out.println("\n실행결과");
    }

    public void printRaceState(String currentStatus) {
        System.out.println(currentStatus);
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
