import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* Methoden der File Klasse

exists()			:boolean
isFile()			:boolean
isDirectory()		:boolean
listFiles()			:File[]
length()			:long
deleteOnExit()		:void  // bei temporaer angelegten Dateien
canRead()			:boolean
canWrite()			:boolean
canExecute()		:boolean
getName()			:String // gibt den relativen Pfad zurueck (inkl. den Dateinamen)
getAsolutePath()	:String // gibt den absoluten Pfad zurueck (inkl. den Dateinamen)
isHidden()			:boolean

*/

public class FileExample {
	
	public static void main(String[] args){
		
		FileExample fe = new FileExample();
		fe.scanDirectory("C:\\Users\\tomaszu\\Desktop\\JAVA_CLIENT");
		
	}

	// NUR EIN BEISPIEL
	public void run(){
		File f = new File("c:\\Programme");
		if(f.exists()){
			if(f.isDirectory()){
				
			}
			else if(f.isFile()){
				
			}
		}
		else{
			f.mkdir();
		}
	}
	
	public void readFile(String filename) {
		
		File f = new File(filename);
		FileInputStream fis = null;
		
		try{
			fis = new FileInputStream(f);
		}
		catch(FileNotFoundException e){
			System.out.println("Fehler");
		}
		
		try {
			while(fis.available()>0){
				byte[] b = new byte[fis.available()];	
				if(fis.read(b) == -1){
					break;
				}		
			}
		}
		catch(IOException e) {
		}
		
	}
	
	public void scanDirectory(String dirName){
		File f = null;
		
		try{
			f = new File(dirName);
		}
		catch(NullPointerException e){
			System.out.println("Exception gefunden.");
			return;
		}
		
		if(f.exists()){
			if(f.isDirectory()){
				File[] files = f.listFiles();
				for (File file : files){
					if(file.exists()){
						if(file.isDirectory()){
							scanDirectory(file.getAbsolutePath());
						}
						else if(file.isFile()){
							System.out.println("Datei gefunden: " + file.getAbsolutePath());
						}
					}
				}
			}
		}
	}

}