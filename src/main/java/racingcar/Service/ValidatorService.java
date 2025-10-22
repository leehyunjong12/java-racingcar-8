package racingcar.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidatorService {

    public void validateCarName(List<String> carNames) {
        for (String carName : carNames) {
            checkCarNameLength(carName);
        }
        checkDuplicateCarNames(carNames);

    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5를 초과합니다.");
        }
    }

    private void checkDuplicateCarNames(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if (carNamesSet.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    public void validateAttemptCount(int attemptCount) {
        validateAttemptCountIsPositive(attemptCount);
    }


    private void validateAttemptCountIsPositive(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("시도할 횟수가 양수가 아닙니다.");
        }
    }

}
