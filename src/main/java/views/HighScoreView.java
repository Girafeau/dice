package views;

import com.google.common.eventbus.Subscribe;
import entities.HighScore;
import events.ScoreEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.Comparator;
import java.util.stream.Collectors;

public class HighScoreView extends VBox {

    private final ObservableList<String> observable;

    public HighScoreView() {
        GridPane grid = new GridPane();
        this.observable = FXCollections.observableArrayList();
        ListView<String> list = new ListView<>(observable);
        HighScore.getInstance().getScores().forEach(score -> this.observable.add(Integer.toString(score)));
        grid.add(list, 0, 0);
        this.getChildren().add(grid);
    }

    @Subscribe
    public void event(ScoreEvent event) {
        this.update(event.getScore());
    }

    public void update(int score) {
        this.observable.add(Integer.toString(score));
    }
}
