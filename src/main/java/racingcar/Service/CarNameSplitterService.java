package racingcar.Service;

import java.util.List;

public class CarNameSplitterService {

    public List<String> splitCarName(String carNames) {
        return List.of(carNames.split(",", -1));
    }
}
