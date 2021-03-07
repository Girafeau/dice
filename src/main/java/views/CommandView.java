package views;

import com.google.common.eventbus.EventBus;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CommandView extends HBox {

    public CommandView(EventBus eventBus) {
        this.setPadding(new Insets(20));
        this.setSpacing(20);
        Button b = new Button("Commencer une nouvelle partie");
        Button u = new Button("Lancer les dés");
        b.setOnAction((event) -> {

        });
        u.setOnAction((event) -> {
            eventBus.post(new ThrowEvent());
        });
        this.getChildren().add(b);
        this.getChildren().add(u);
    }
}
