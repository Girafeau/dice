package views;

import com.google.common.eventbus.Subscribe;
import entities.Dice;
import entities.Game;
import entities.HighScore;
import events.ScoreEvent;
import events.ThrowEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import persistence.FilePersistenceStrategy;

import java.util.ArrayList;
import java.util.List;

public class CommandView extends HBox {

    private final Game game;
    private Label nb;
    private Label score;
    private Button newGame;
    private Button throwDices;

    public CommandView(Game game) {
        this.game = game;
        this.setPadding(new Insets(20));
        this.setSpacing(20);
        this.newGame = new Button("Commencer une nouvelle partie");
        this.throwDices = new Button("Lancer les dés");
        this.nb = new Label();
        this.score = new Label();
        this.throwDices.setDisable(true);

        this.newGame.setOnAction((event) -> {
            this.game.setNbThrow(0);
            this.game.setCurrentScore(0);
            this.throwDices.setDisable(false);
            this.update();
        });

        this.throwDices.setOnAction((event) -> {
            this.game.setNbThrow(this.game.getNbThrow()+1);
            if(this.game.getNbThrow() == 10) {
                this.throwDices.setDisable(true);
                this.addScore();
            }
            this.game.getBus().post(new ThrowEvent(this.throwDices()));
        });

        this.getChildren().add(newGame);
        this.getChildren().add(throwDices);
        this.getChildren().add(this.nb);
        this.getChildren().add(this.score);
    }


    public List<Integer> throwDices() {
        List<Integer> scores = new ArrayList<>();
        int sum = 0;
        int score = 0;
        for(Dice dice : this.game.getDices()) {
            score = dice.throwDice();
            scores.add(score);
            sum += score;
        }
        if (sum == 7) {
            this.game.setCurrentScore(this.game.getCurrentScore() + 10);
        }
        return scores;
    }

    public void addScore() {
        this.game.getBus().post(new ScoreEvent(this.game.getCurrentScore()));
        HighScore.getInstance().addScore(this.game.getCurrentScore());
        HighScore.getInstance().persist(new FilePersistenceStrategy("scores"), this.game.getCurrentScore());
    }

    @Subscribe
    public void event(ThrowEvent event) {
        this.update();
    }

    private void update() {
        this.nb.setText("Lancés de dés : " + Integer.toString(this.game.getNbThrow()));
        this.score.setText("Score de la partie : " + this.game.getCurrentScore());
    }
}
