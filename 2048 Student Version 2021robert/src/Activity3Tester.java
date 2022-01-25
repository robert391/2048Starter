
public class Activity3Tester {

	public static void main(String[] args) {
		
		//Declare a Board object
		Board b = new Board();
		//create an array with some values you want to 
		//slideRight. ie [2 0 0 0]
		int[] sample1 = {4,0,0,0};
		b.slideRight(sample1);//invoke the slideRight method on the array 
		//print out the array to see if slideRight
		//worked
		printArray(sample1);
		int[] sample2 = {2,8,0,2};
		b.slideRight(sample2);
		printArray(sample2);
		int[] sample3 = {2,0,2,0};
		b.slideRight(sample3);
		printArray(sample3);
		int[] sample4 = {0,2,2,0};
		b.slideRight(sample4);
		printArray(sample4);
		
		//testing the other slide right method
		Board g = new Board();
		System.out.println(g);
		g.slideRight();
		System.out.println(g);
		
		
	}
	public static void printArray(int[] arrays) {
		String temp = "";
		for(int i = 0; i < arrays.length; i++) {
			temp += arrays[i];
		}
		System.out.println(temp);
	}

}
