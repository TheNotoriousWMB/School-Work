public class Money {
	private double inputValue;

	private int hundreds, fifties, twenties, tens, fives, ones, quarters,
			dimes, nickels, pennies;

	public Money(double inputValue) {
		this.inputValue = inputValue;

		hundreds = fifties = twenties = tens = fives = ones = quarters = dimes = nickels = pennies = 0;
	}

	public void calculateChange() {
		int centValue = (int) (inputValue * 100);

		tens = (centValue / 1000);
		centValue = (centValue % 1000);

		fives = (centValue / 500);
		centValue = (centValue % 500);

		ones = (centValue / 100);
		centValue = (centValue % 100);

		quarters = (centValue / 25);
		centValue = (centValue % 25);

		dimes = (centValue / 10);
		centValue = (centValue % 10);

		nickels = (centValue / 5);
		centValue = (centValue % 5);

		pennies = (centValue / 1);
		centValue = (centValue % 1);
	}

	@Override
	public String toString() {
		return (tens + " ten dollar bills\n" + fives + " five dollar bills\n"
				+ ones + " one dollar bills\n" + quarters + " quarters\n"
				+ dimes + " dimes\n" + nickels + " nickels\n" + pennies + " pennies\n");
	}

	public int getHundreds() {
		return hundreds;
	}

	public void setHundreds(int hundreds) {
		this.hundreds = hundreds;
	}

	public int getFifties() {
		return fifties;
	}

	public void setFifties(int fifties) {
		this.fifties = fifties;
	}

	public int getTwenties() {
		return twenties;
	}

	public void setTwenties(int twneties) {
		this.twenties = twneties;
	}

	public double getInputValue() {
		return inputValue;
	}

	public void setInputValue(double inputValue) {
		this.inputValue = inputValue;
	}

	public int getTens() {
		return tens;
	}

	public void setTens(int tens) {
		this.tens = tens;
	}

	public int getFives() {
		return fives;
	}

	public void setFives(int fives) {
		this.fives = fives;
	}

	public int getOnes() {
		return ones;
	}

	public void setOnes(int ones) {
		this.ones = ones;
	}

	public int getQuarters() {
		return quarters;
	}

	public void setQuarters(int quarters) {
		this.quarters = quarters;
	}

	public int getDimes() {
		return dimes;
	}

	public void setDimes(int dimes) {
		this.dimes = dimes;
	}

	public int getNickels() {
		return nickels;
	}

	public void setNickels(int nickels) {
		this.nickels = nickels;
	}

	public int getPennies() {
		return pennies;
	}

	public void setPennies(int pennies) {
		this.pennies = pennies;
	}
}
