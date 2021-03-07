package entities;

public class Dice20Factory implements DiceAbstractFactory {

	@Override
	public Dice createDice() {
		return new Dice20();
	}

}
