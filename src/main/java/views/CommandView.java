package views;

import com.google.common.eventbus.Subscribe;
import controllers.GameController;
import entities.HighScore;
import events.ScoreEvent;
import events.ThrowEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import persistence.FilePersistenceStrategy;

public class CommandView extends HBox {

    private final GameController gameController;
    private Label nb;
    private Label score;
    private Button newGame;
    private Button throwDices;

    public CommandView(GameController gameController) {
        this.gameController = gameController;
        this.setPadding(new Insets(20));
        this.setSpacing(20);
        this.newGame = new Button("Commencer une nouvelle partie");
        this.throwDices = new Button("Lancer les dés");
        this.nb = new Label();
        this.score = new Label();
        this.throwDices.setDisable(true);

        this.newGame.setOnAction((event) -> {
            this.gameController.setNbThrow(0);
            this.gameController.setCurrentScore(0);
            this.throwDices.setDisable(false);
            this.update();
        });

        this.throwDices.setOnAction((event) -> {
            this.gameController.setNbThrow(this.gameController.getNbThrow()+1);
            this.gameController.getBus().post(new ThrowEvent(this.gameController.throwDices()));
            if(this.gameController.getNbThrow() == 10) {
                this.throwDices.setDisable(true);
                HighScore.getInstance().addScore(this.gameController.getCurrentScore());
                HighScore.getInstance().persist(new FilePersistenceStrategy("scores"), this.gameController.getCurrentScore());
                this.gameController.getBus().post(new ScoreEvent(this.gameController.getCurrentScore()));
            }
        });

        this.getChildren().add(newGame);
        this.getChildren().add(throwDices);
        this.getChildren().add(this.nb);
        this.getChildren().add(this.score);
    }

    @Subscribe
    public void event(ThrowEvent event) {
        this.update();
    }

    private void update() {
        this.nb.setText("Lancés de dés : " + Integer.toString(this.gameController.getNbThrow()));
        this.score.setText("Score de la partie : " + this.gameController.getCurrentScore());
    }
}
