package entities;

public class DiceFactory {

	public static Dice getDice(DiceAbstractFactory factory) {
		return factory.createDice();
	}

}
