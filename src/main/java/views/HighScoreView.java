package views;

import entities.HighScore;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HighScoreView extends JPanel implements PropertyChangeListener {

    public HighScoreView() {
        String[][] data = {
                {"55"}
        };
        String[] headers = {"Score"};
        JTable table = new JTable(data, headers);
        this.add(table);
        this.setVisible(true);
    }

    public void update() {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
