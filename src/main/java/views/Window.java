package views;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window() {
        this.setTitle("Jeu de dés");
        this.getRootPane().setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(new HighScoreView(), BorderLayout.NORTH);
        this.add(new DiceView(), BorderLayout.CENTER);
        this.add(new CommandView(), BorderLayout.SOUTH);
        this.pack();
        this.setSize(1000, 1000);
        this.setLocation(200, 200);
        this.setVisible(true);
    }
}
