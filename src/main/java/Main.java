import entities.HighScore;
import views.DiceView;
import views.HighScoreView;
import views.Window;

import javax.swing.*;

public class Main {

    public static void main(String [] args) {
        SwingUtilities.invokeLater(() -> new Main().start());
    }
    private void start() {
        new Window();
    }

}
