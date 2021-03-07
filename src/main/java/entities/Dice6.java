package entities;

public class Dice6 extends Dice {

	private int nbSides;

	public Dice6() {
		this.nbSides = 6;
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
