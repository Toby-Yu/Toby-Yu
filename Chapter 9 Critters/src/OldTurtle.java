
public class OldTurtle implements Critter {

	private int count;

	private int direction;

	private boolean isMoving = true;

	@Override
	public char getChar() {
		// TODO Auto-generated method stub
		return 'O';
	}

	@Override
	public int getMove(CritterInfo info) {
		// TODO Auto-generated method stub

		if (isMoving) {
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
		} else {
			this.direction = Critter.CENTER;
		}
		isMoving = !isMoving;

		return this.direction;

	}

}
