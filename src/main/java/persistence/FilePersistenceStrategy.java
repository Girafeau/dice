package persistence;

import entities.HighScore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilePersistenceStrategy implements PersistenceStrategy {

    private final File file;

    public FilePersistenceStrategy(String name) {
        this.file = new File(name);
    }

    @Override
    public void persist(int score) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(Integer.toString(score) +"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            FileReader reader = new FileReader(file);
            List<Integer> scores = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                scores.add(Integer.parseInt(line));
            }
            HighScore.getInstance().setScores(scores);
            HighScore.getInstance().sort();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
