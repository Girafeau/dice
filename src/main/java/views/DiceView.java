package views;

import com.google.common.eventbus.Subscribe;
import entities.Dice;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class DiceView extends HBox {

    private final List<Dice> dices;
    private final List<Label> labels;

    public DiceView(int nb) {
        this.dices = new ArrayList<>();
        this.labels = new ArrayList<>();
        for(int i = 0; i< nb; i++) {
            this.dices.add(new Dice());
            this.labels.add(new Label());
        }
    }

    @Subscribe
    public void event(ThrowEvent event) {
        this.update();
    }

    public void update() {
        for(int i = 0; i< this.dices.size(); i++) {
            this.labels.get(i).setText(this.dices.get(i).toString());
        }
    }


}
