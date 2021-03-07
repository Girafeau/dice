package entities;

public class Dice6Factory implements DiceAbstractFactory {

	@Override
	public Dice createDice() {
		return new Dice6();
	}

}
