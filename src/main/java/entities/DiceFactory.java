package entities;

public class DiceFactory {

	public static Dice getComputer(DiceAbstractFactory factory) {
		return factory.createDice();
	}

}
