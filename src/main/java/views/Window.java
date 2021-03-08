package views;


import controllers.GameController;
import entities.HighScore;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import persistence.FilePersistenceStrategy;

public class Window extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GameController gameController = new GameController(2);
        HighScore.getInstance().load(new FilePersistenceStrategy("scores"));
        stage.setTitle("Jeu de dés");
        BorderPane pane = new BorderPane();
        DiceView diceView = new DiceView(gameController);
        CommandView commandView = new CommandView(gameController);
        HighScoreView highScoreView = new HighScoreView();
        gameController.addListener(diceView);
        gameController.addListener(commandView);
        gameController.addListener(highScoreView);
        pane.setTop(highScoreView);
        pane.setCenter(diceView);
        pane.setBottom(commandView);
        Scene scene = new Scene(pane, 1000, 1000);
        stage.setScene(scene);
        stage.show();

    }
}
