package views;


import entities.Game;
import entities.HighScore;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import persistence.FilePersistenceStrategy;

public class Window extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Game game = new Game(2);
        HighScore.getInstance().load(new FilePersistenceStrategy("scores"));
        stage.setTitle("Jeu de dés");
        BorderPane pane = new BorderPane();
        DiceView diceView = new DiceView(game);
        CommandView commandView = new CommandView(game);
        HighScoreView highScoreView = new HighScoreView();
        game.addListener(diceView);
        game.addListener(commandView);
        game.addListener(highScoreView);
        pane.setTop(highScoreView);
        pane.setCenter(diceView);
        pane.setBottom(commandView);
        Scene scene = new Scene(pane, 1000, 1000);
        stage.setScene(scene);
        stage.show();

    }
}
