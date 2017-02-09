public class Program {

	public static void main(String[] args){
		
		Hovel hovel1 = new Hovel(5, 8, 6, 2, 62, false);
		Hovel hovel2 = new Hovel(1, 2, 3, 4, 62, false);

		//System.out.println("Die Anzahl der loosen Bretter im h1 und h2 ist identisch? " + hovel1.equals(hovel2));
		
		House haus1 = new House(4, 5, 6, 2);
		House haus2 = new House(4, 5, 6, 3);

		//System.out.println("Die Hauser haus1 und haus2 sind identisch? " + haus1.equals(haus2));

		//System.out.println(haus1);
		//System.out.println(hovel1);
		
		haus1.writeFile("C:\\Users\\tomaszu\\Desktop\\JAVA_CLIENT\\TAG3\\hauser.txt");
		haus1.readFile("C:\\Users\\tomaszu\\Desktop\\JAVA_CLIENT\\TAG3\\hauser.txt");
		//haus2.writeFile("C:\\Users\\tomaszu\\Desktop\\JAVA_CLIENT\\TAG3\\hauser.txt");
		//hovel1.writeFile("C:\\Users\\tomaszu\\Desktop\\JAVA_CLIENT\\TAG3\\hauser.txt");
		
		haus1.writeObject("C:\\Users\\tomaszu\\Desktop\\JAVA_CLIENT\\TAG3\\hausObj.txt");
		haus1.readObject("C:\\Users\\tomaszu\\Desktop\\JAVA_CLIENT\\TAG3\\hausObj.txt");
		

		
	}

}