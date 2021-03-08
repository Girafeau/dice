package events;

import java.util.List;

public class ThrowEvent {

    private List<Integer> scores;

    public ThrowEvent(List<Integer> scores) {
        this.scores = scores;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }
}
