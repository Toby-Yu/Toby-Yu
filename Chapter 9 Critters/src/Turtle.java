
public class Turtle implements Critter {

	private int count;

	private int direction;

	@Override
	public char getChar() {
		//returns 'T' when getChar() method is called
		return 'T';
	}

	@Override
	public int getMove(CritterInfo info) {
		//Makes turtle move 5 spaces in each direction counterclockwise

		int step = count % 20;

		if (step <= 4) {
			this.direction = Critter.SOUTH;
		} else if (step <= 9) {
			this.direction = Critter.WEST;
		} else if (step <= 14) {
			this.direction = Critter.NORTH;
		} else {
			this.direction = Critter.EAST;
		}

		count++;

		return this.direction;

	}

}
