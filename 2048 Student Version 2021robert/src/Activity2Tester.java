public class Activity2Tester {

	public static void main(String[] args) {
		//Create a Board object
		
		//Random rnd = new Random(1); 
		//for(int i = 0; i < 30; i++) {
		//	System.out.print(rnd.nextInt(16) + ", ");
		//}
		
		Board b = new Board();
		for(int i = 0; i < 16; i++) {
			b.populateOne();
			System.out.println(b);
		}
		
		//call the populateOne method and print out the board each time
		//does it fill a random location? How about if the board is almost
		//full? Does it still work?
		
		
	}

}