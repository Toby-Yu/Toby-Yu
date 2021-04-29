
public class Frog implements Critter {

	private int count;

	private int direction;

	@Override
	public char getChar() {
		// TODO Auto-generated method stub
		return 'F';
	}

	@Override
	public int getMove(CritterInfo info) {
		// TODO Auto-generated method stub

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
