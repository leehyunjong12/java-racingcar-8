package racingcar;


import racingcar.Controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RacingGameController racingGameController = appConfig.racingGameController();
        racingGameController.runRacingGame();
    }
}
