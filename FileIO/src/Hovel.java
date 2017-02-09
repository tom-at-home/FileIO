public class Hovel extends House {
	
	private int numLoosePlanks;
	private boolean isRoofSolid;
	
	public Hovel (int rooms, int windows, int doors, int floors, int numLoosePlanks, boolean isRoofSolid){
		super(rooms, windows, doors, floors);
		this.numLoosePlanks = numLoosePlanks;
		this.isRoofSolid = isRoofSolid;
	}
	
	public int getNumLoosePlanks(){
		return this.numLoosePlanks;
	}
	
	public boolean getIsRoofSolid(){
		return this.isRoofSolid;
	}
	
	public boolean equals(Object o){
		if(o instanceof Hovel){
			Hovel h = (Hovel)o;
			return (this.getNumLoosePlanks() == h.getNumLoosePlanks());
		}
		return false;
	}

}