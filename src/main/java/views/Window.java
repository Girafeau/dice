package views;


import com.google.common.eventbus.EventBus;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Window extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        EventBus eventBus = new EventBus();
        stage.setTitle("Jeu de dés");
        BorderPane pane = new BorderPane();
        DiceView diceView = new DiceView(2);
        CommandView commandView = new CommandView(eventBus);
        pane.setCenter(diceView);
        pane.setBottom(commandView);
        Scene scene = new Scene(pane, 1000, 1000);
        stage.setScene(scene);
        stage.show();

        eventBus.register(diceView);
    }
}
