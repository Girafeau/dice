package views;

import com.google.common.eventbus.Subscribe;
import controllers.GameController;
import events.ThrowEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class DiceView extends HBox {

    private final GameController gameController;
    private final List<Label> labels;
    private final Label sum;
    private final Label equals;

    public DiceView(GameController gameController) {
        this.setPadding(new Insets(20));
        this.setSpacing(20);
        this.sum = new Label();
        this.equals = new Label();
        this.gameController = gameController;
        this.labels = new ArrayList<>();
        this.gameController.getDices().forEach(dice -> {
            Label label = new Label();
            this.labels.add(label);
            this.getChildren().add(label);
        });
        this.getChildren().add(equals);
        this.getChildren().add(sum);

    }

    public void update(List<Integer> scores) {
        int sum = 0;
        for(int i = 0; i< scores.size(); i++) {
            this.labels.get(i).setText(Integer.toString(scores.get(i)));
            sum += scores.get(i);
        }
        this.equals.setText("=");
        this.sum.setText(Integer.toString(sum));
    }

    @Subscribe
    public void event(ThrowEvent event) {
        this.update(event.getScores());
    }
}
