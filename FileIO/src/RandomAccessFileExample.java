import java.io.RandomAccessFile;

public class RandomAccessFileExample {

/*

KONSTRUKTOREN
RandomAccessFile (File, String -> siehe Modis)
RandomAccessFile (String -> Dateiname, String -> Modi)

METHODEN
readInt()			:int
readShort()			:
readChar()			:
readByte()			:
readLong()			:
readUnsignedByte()	:int
readUnsignedShort()	:int
readLine()			:String \n (newline) gilt als Trennzeichen
read(byte[])		:		-> byte[] b = new byte[1024] ; raf.read(b);
readFully(byte[])	:		-> 

length()			:long	-> gibt die Groesse der einzulesenden Datei zurueck
seek(long)			:		-> spring an die Position long in der Datei
setLength(long)		:		-> 

writeInt(int)		:void


MODIS
"r"
"w"
"rw"
 
 
 */
	
	public static void main(String[] args){
		
		RandomAccessFileExample ra = new RandomAccessFileExample();
		ra.write("datei.dat");
		ra.read("datei.dat");
		
	}
	
	
	
	public void write(String filename){
		
		int i = 11;
		int ii = 22;
		int iii = 33;
		
		double d = 44.4444;
		
		String str = "Hallo Welt";
		
		float f = 55.55f;
		float ff = 66.66f;
		
		short s = 77;
		short ss = 88;
		
		//byte b = (byte)0x10;  // 00010000
		//byte unsignedByte = (byte)0xF7; // 11110111
		
		//System.out.println("0x10: " + b);
		//System.out.println("0xF7: " + unsignedByte);
		
		RandomAccessFile rf = null;
		
		try{
			rf = new RandomAccessFile(filename, "rw");
			
			// SCHREIBEN
			rf.writeInt(i);
			rf.writeInt(ii);
			rf.writeInt(iii);			
			
			rf.writeDouble(d);
			
			rf.writeUTF(str);
			
			rf.writeFloat(f);
			rf.writeFloat(ff);
			
			rf.writeShort(s);
			rf.writeShort(ss);
			
			//rf.writeByte(b);
			//rf.writeByte(unsignedByte);
			
			rf.seek(0);
				
		}
		catch(Exception e){
			System.out.println("Write Exeption found");
		}
		
	}
	
	public void read(String filename){
		
		RandomAccessFile rf = null;
		
		try{
			rf = new RandomAccessFile(filename, "rw");
			
			// Nach dem Schreiben an die Anfangsposition der Datei zum Lesen springen
			rf.seek(0);
			
			// LESEN
			int i = rf.readInt();
			int ii = rf.readInt();
			int iii = rf.readInt();		
			
			double d = rf.readDouble();
			
			String str = rf.readUTF();
			
			float f = rf.readFloat();
			float ff = rf.readFloat();
			
			short s = rf.readShort();
			short ss = rf.readShort();
			
			System.out.println("Der Wert von i: " + i);
			System.out.println("Der Wert von ii: " + ii);			
			System.out.println("Der Wert von iii: " + iii);
			System.out.println("Der Wert von d: " + d);
			System.out.println("Der Wert von str: " + str);
			System.out.println("Der Wert von f: " + f);
			System.out.println("Der Wert von ff: " + ff);
			System.out.println("Der Wert von s: " + s);
			System.out.println("Der Wert von ss: " + ss);
			
			
			/*
			int newI = rf.readInt();
			byte newB = rf.readByte();			
			//ALTERNATIVE int newUnsignedByte = rf.readUnsignedByte();
			byte newUnsignedByte = rf.readByte();
			
			System.out.println("newI: " + newI);
			System.out.println("newB: " + newB);
			System.out.println("newUnsignedByte: " + newUnsignedByte);
			*/
		}
		catch(Exception e){
			System.out.println("Read Exeption found");
		}
		
	}
	
	
}
