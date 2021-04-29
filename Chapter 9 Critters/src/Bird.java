
public class Bird implements Critter {

	private int direction;

	@Override
	public char getChar() {
		// TODO Auto-generated method stub
		return 'B';
	}

	@Override
	public int getMove(CritterInfo info) {
		// TODO Auto-generated method stub

		int direction = (int) (Math.random() * 4) + 1;

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

		System.out.print(this.direction);

		return this.direction;

	}

}
