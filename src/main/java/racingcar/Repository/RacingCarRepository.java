package racingcar.Repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.Model.RacingCar;

public class RacingCarRepository {

    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingCarRepository() {
    }

    public RacingCarRepository(List<String> carNames) {
        setCars(carNames);
    }

    public void setCars(List<String> carNames) {
        racingCars.clear();
        for (String name : carNames) {
            racingCars.add(new RacingCar(name));
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void moveAllCarsRandomly() {
        for (RacingCar racingCar : racingCars) {
            moveCarRandomly(racingCar);
        }
    }

    private void moveCarRandomly(RacingCar racingCar) {
        Boolean isMovable = canMove();
        if (isMovable) {
            racingCar.move();
        }
    }

    private Boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }


    public String getCarsStatusAsString() {
        StringBuilder carsStatus = new StringBuilder();
        for (RacingCar racingCar : racingCars) {
            carsStatus.append(racingCar.getCarStatusAsString());
            carsStatus.append("\n");
        }
        return carsStatus.toString();
    }


    public List<String> getTopPositionCarNames() {
        List<RacingCar> topPositionCars = new ArrayList<>();
        topPositionCars.add(racingCars.getFirst());
        for (int i = 1; i < racingCars.size(); i++) {
            updateTopPositionCars(i, topPositionCars);
        }
        return extractCarNames(topPositionCars);
    }

    private void updateTopPositionCars(int i, List<RacingCar> topPositionCars) {
        if (racingCars.get(i).getPosition() > topPositionCars.getFirst().getPosition()) {
            topPositionCars.clear();
            topPositionCars.add(racingCars.get(i));
        }
        if (racingCars.get(i).getPosition() == topPositionCars.getFirst().getPosition()) {
            topPositionCars.add(racingCars.get(i));
        }
    }

    private List<String> extractCarNames(List<RacingCar> topPositionCars) {
        List<String> topPositionCarNames = new ArrayList<>();
        for (RacingCar car : topPositionCars) {
            topPositionCarNames.add(car.getName());
        }
        return topPositionCarNames;
    }


}
