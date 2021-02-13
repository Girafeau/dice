package entities;

import persistence.PersistenceStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HighScore {

    private static HighScore instance;

    public List<Integer> scores;

    private HighScore() {
        this.scores = new ArrayList<>();
    }

    public void addScore(int score) {
        this.scores.add(score);
    }

    public void sort() {
        this.scores = this.scores.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> getBestScores(int value) {
        return this.scores.stream().limit(value).collect(Collectors.toList());
    }

    public static HighScore getInstance() {
        if (instance == null) {
            instance = new HighScore();
        }
        return instance;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public void persist(PersistenceStrategy strategy, int score) {
        strategy.persist(score);
    }

    public void load(PersistenceStrategy strategy) {
        strategy.load();
    }
}
