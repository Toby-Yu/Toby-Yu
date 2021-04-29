
public class Frog implements Critter {

	private int count;

	private int direction;

	@Override
	public char getChar() {
		//returns 'F' when getChar() method is called
		return 'F';
	}

	@Override
	public int getMove(CritterInfo info) {
		//Makes frog means in a random direction 3 spaces

		if (count == 0 || count == 3) {
			direction = (int) (Math.random() * 4 + 1);

			switch (direction) {

			case 1:
				this.direction = Critter.EAST;
				break;
			case 2:
				this.direction = Critter.SOUTH;
				break;
			case 3:
				this.direction = Critter.WEST;
				break;
			case 4:
				this.direction = Critter.NORTH;
				break;
			}

			count = 0;
		}

		count++;



		return this.direction;

	}

}
