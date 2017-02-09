public class Mansion extends House {
	
	private int numPools;
	
	public Mansion(int rooms, int windows, int doors, int floors, int numPools){
		super(rooms, windows, doors, floors);
		this.numPools = numPools;
	}
	
	public int getNumPools(){
		return this.numPools;
	}

}