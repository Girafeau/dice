package persistence;

import entities.HighScore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePersistenceStrategy implements PersistenceStrategy {

    private final File file;

    public FilePersistenceStrategy(String name) {
        this.file = new File(name);
    }


    @Override
    public void persist(int score) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(score);
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
            while (reader.ready()) {
                scores.add(reader.read());
            }
            HighScore.getInstance().setScores(scores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
