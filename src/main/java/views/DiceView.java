package views;

import com.google.common.eventbus.Subscribe;
import entities.*;
import events.ThrowEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class DiceView extends HBox {

    private final Game game;
    private final List<Label> labels;

    public DiceView(Game game) {
        this.game = game;
        this.labels = new ArrayList<>();
        this.game.getDices().forEach(dice -> {
            Label label = new Label();
            this.labels.add(label);
            this.getChildren().add(label);
        });
    }

    public void update(List<Integer> scores) {
        for(int i = 0; i< scores.size(); i++) {
            this.labels.get(i).setText(Integer.toString(scores.get(i)) + " - ");
        }
    }

    @Subscribe
    public void event(ThrowEvent event) {
        this.update(event.getScores());
    }
}
