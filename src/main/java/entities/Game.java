package entities;

import com.google.common.eventbus.EventBus;
import entities.Dice;
import entities.Dice6Factory;
import entities.DiceFactory;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private EventBus bus;
    private final List<Dice> dices;
    private int nbThrow;
    private int currentScore;

    public Game(int nb) {
        this.currentScore = 0;
        this.dices = new ArrayList<>();
        this.nbThrow = 0;
        for(int i = 0; i< nb; i++) {
            this.dices.add(DiceFactory.getDice(new Dice6Factory()));
        }
        this.bus = new EventBus();
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
