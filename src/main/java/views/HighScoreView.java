package views;

import entities.HighScore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.beans.PropertyChangeEvent;

public class HighScoreView extends VBox {

    private ObservableList<String> observable;

    public HighScoreView() {
        GridPane grid = new GridPane();
        this.observable = FXCollections.observableArrayList();
        ListView<String> list = new ListView<>(observable);
        grid.add(list, 0, 0);
        this.getChildren().add(grid);
    }

    public void update() {

    }
}
