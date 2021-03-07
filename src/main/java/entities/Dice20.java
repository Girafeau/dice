package entities;

public class Dice20 extends Dice {

	private int nbSides;

	public Dice20() {
		this.nbSides = 20;
	}

	@Override
	public int throwDice() {
		return (int) (Math.random() * this.nbSides) + 1;
	}

	@Override
	public int getNbSides() {
		return this.nbSides;
	}

}
