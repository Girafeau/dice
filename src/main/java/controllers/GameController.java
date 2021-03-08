package controllers;

import com.google.common.eventbus.EventBus;
import entities.Dice;
import entities.Dice6Factory;
import entities.DiceFactory;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private EventBus bus;
    private final List<Dice> dices;
    private int nbThrow;
    private int currentScore;

    public GameController(int nb) {
        this.currentScore = 0;
        this.dices = new ArrayList<>();
        this.nbThrow = 0;
        for(int i = 0; i< nb; i++) {
            this.dices.add(DiceFactory.getDice(new Dice6Factory()));
        }
        this.bus = new EventBus();
    }

    public List<Integer> throwDices() {
        List<Integer> scores = new ArrayList<>();
        int sum = 0;
        int score = 0;
        for(Dice dice : this.dices) {
            score = dice.throwDice();
            scores.add(score);
            sum += score;
        }
        if (sum == 7) {
            this.currentScore += 10;
        }
        return scores;
    }

    public void addListener(Object object) {
        this.bus.register(object);
    }

    public EventBus getBus() {
        return bus;
    }

    public void setBus(EventBus bus) {
        this.bus = bus;
    }

    public List<Dice> getDices() {
        return dices;
    }

    public int getNbThrow() {
        return nbThrow;
    }

    public void setNbThrow(int nbThrow) {
        this.nbThrow = nbThrow;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }
}
