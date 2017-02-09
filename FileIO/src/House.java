import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class House implements Savable {
	
	private static final long serialVersionUID = 1L;
	protected int rooms;	
	protected int windows;
	protected int doors;
	protected int floors;
	protected ArrayList<Owner> owner = new ArrayList<>();

	/* Beispiel fuer einen Init-Block */	
	// INIT BLOCK - Wird VOR dem Konstruktor ausgefuehrt
	/*{
		this.windows = 4;
		this.rooms = 2;
	}*/
	
	public House(int rooms, int windows, int doors, int floors){
		this.rooms = rooms;
		this.windows = windows;
		this.doors = doors;
		this.floors = floors;
	}
	
	public int getRooms(){
		return this.rooms;
	}
	
	public int getWindows(){
		return this.windows;
	}

	public int getDoors(){
		return this.doors;
	}

	public int getFloors(){
		return this.floors;
	}
	
	public boolean equals(Object o){
		if(this instanceof Mansion && o instanceof Mansion){
			Mansion t = (Mansion)this;
			Mansion m = (Mansion)o;
			return 
				(
					t.getRooms() == m.getRooms() && 
					t.getWindows() == m.getWindows() &&
					t.getDoors() == m.getDoors() &&
					t.getFloors() == m.getFloors() &&
					t.getNumPools() == m.getNumPools()
				);
		}
		else if(o instanceof House){
			House h = (House)o;
			return 
				(
					this.getRooms() == h.getRooms() && 
					this.getWindows() == h.getWindows() &&
					this.getDoors() == h.getDoors() &&
					this.getFloors() == h.getFloors()
				);
		}
		return false;
	}
	
	public String toString(){
		String ts = "";
		ts = "Dieses Haus ist von Typ "
				+ this.getClass().getSimpleName() + " und hat: "
				+ this.getRooms() + " Zimmer | " + 
				+ this.getWindows() + " Fenster | " + 
				+ this.getDoors() + " Tueren | " + 
				+ this.getFloors() + " Etagen.\n"
		;
		
		return ts;
		
	}
	
	public void readFile(String filename) {
		
		File f = new File(filename);
		//String str = this.toString();
		
		try (FileInputStream fis = new FileInputStream(f);) {
			
			while(fis.available()>0){
				
				byte[] b = new byte[fis.available()];
				
				if(fis.read(b) == -1){
					break;
				}
				
				System.out.println("Die eingelesenen Hauser: \n" + new String(b));
				
			}

		}
		catch(FileNotFoundException e){
			System.out.println("FileNotFoundException: " + e.getMessage());
		}
		catch(IOException e) {
			System.out.println("IOException: " + e.getMessage());
		}		
		
	}	
	
	public void writeFile(String filename) {
		
		File f = new File(filename);
		String str = this.toString();
		
		try (BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(f,true));) {
			fos.write(str.getBytes());
		}
		catch(FileNotFoundException e){
			System.out.println("FileNotFoundException: " + e.getMessage());
		}
		catch(IOException e) {
			System.out.println("IOException: " + e.getMessage());
		}		
		
	}
	
	public void save(String filename){
		
		try (ObjectOutputStream out = 
				new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(filename)));) {
			
			out.writeObject(this);
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void load(String filename){
		
		try (ObjectInputStream in = 
				new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream(filename)));) {
			
			//Object object = null;
			Object object = in.readObject();
				
			if(object != null) {
				Savable importedObj = (Savable) object;
				System.out.println("Das importierte Haus: " + importedObj);
			}
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			
	}
	
}
