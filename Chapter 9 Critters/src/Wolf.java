
public class Wolf implements Critter {

	@Override
	public char getChar() {
		// TODO Auto-generated method stub
		
		return 'W';
	}

	@Override
	public int getMove(CritterInfo info) {
		// TODO Auto-generated method stub
		if (info.getNeighbor(Critter.EAST) != '.' && info.getNeighbor(Critter.EAST) != 'W')
			return Critter.EAST;
		if (info.getNeighbor(Critter.SOUTH) != '.' && info.getNeighbor(Critter.SOUTH) != 'W')
			return Critter.SOUTH;
		if (info.getNeighbor(Critter.WEST) != '.' && info.getNeighbor(Critter.WEST) != 'W')
			return Critter.WEST;
	    if (info.getNeighbor(Critter.NORTH) != '.' && info.getNeighbor(Critter.NORTH) != 'W')
	    	return Critter.NORTH;
	    
	    int direction = (int) (Math.random() * 5) + 1;

		switch (direction) {

		case 1:
			return Critter.EAST;
			
		case 2:
			return Critter.SOUTH;

		case 3:
			return Critter.WEST;
		
		case 4:
			return Critter.NORTH;
			
		default:
			return Critter.CENTER;
			
		}
	}

}
