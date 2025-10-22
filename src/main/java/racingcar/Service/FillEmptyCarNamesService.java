package racingcar.Service;

import java.util.List;

public class FillEmptyCarNamesService {

    private int nullIndex = 1;

    public List<String> fillEmptyCarNames(List<String> carNamesList) {
        carNamesList.replaceAll(this::fillIfEmpty);
        return carNamesList;
    }

    private String fillIfEmpty(String name) {
        return name.isEmpty() ? "NULL" + (nullIndex++) : name;
    }
}
