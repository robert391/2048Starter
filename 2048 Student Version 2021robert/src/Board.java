import java.util.Random;

public class Board {
 
	private int[][] board; // holds state of game
	private Random rnd = new Random(0); // setup random # generator
	private int size; // size or the number of tiles occupied
	
	/* default constructor for board */
	// constructors must match exactly the name
	// of the class.
	public Board() {
		
		// instantiate the board
		board = new int[4][4];
		populateOne();
		populateOne();
	}

	/*
	 * return a String representation of the 2D array board
	 * each row should be in its own line
	 * 
	 * Example:
	 * 
	 * { {1, 2, 3}, {4, 5, 6}} -> 
	 * 1 2 3
	 * 4 5 6
	 */

	
	// overriding a method is when a "child"
	// class implement the exact same method
	// that its parent class has
	public String toString() {
		String str = "";
		/*
		 * Use the String formatter to pad the numbers with leading 0s
		 * so that the print out does not become jagged
		 * An example is shown below. 
		 * String str = String.format("%04d", 9);  // 0009  
		 * int x = 30;
		 * System.out.println(String.format("%04d",x));
		 *     
		 */
		
		//setup loops to visit
		//every spot possible
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[0].length; col++) {
				str = str + String.format("%04d", board[row][col]) + " ";
			}
			str = str + "\n";
		}
		
		return str;
	}

	/*
	 * set one of the empty spaces (at random)
	 * to a 2 or 4 (90/10 chance). an empty spot is defined to be a 0 element
	 * Must use the Random class object rnd.
	 * Example Use of rnd object.
	 * 
	 * int randomNum = rnd.nextInt(10); //returns a number in range [0 10) (not
	 * inclusive on the 10)
	 */

	public void populateOne() {
		int maxSize = board.length*board[0].length;
		if(size < maxSize) {// is there an empty spot?
			// for randomness, generate a row and column
			int row = rnd.nextInt(board.length);
			int col = rnd.nextInt(board[0].length);
			
			// check if that tile is empty, if it is NOT empty,
		    // generate another set of row and column
			while(board[row][col] != 0) {
				row = rnd.nextInt(board.length);
				col = rnd.nextInt(board[0].length);
			}
			
			//checks whether to put a 2 or a 4
			int val = rnd.nextInt(10);
			System.out.println("val = " + val);
			if(val == 8) {
				board[row][col] = 4;
			}else {
				board[row][col] = 2;
			}
			
			size++;
		}
		
		// what happens if the entire board is full??! 
	}

	/*
	 * 
	 * Given an array of integers, slide all non-zero elements to the right.
	 * zero elements are considered open spots.
	 * example:
	 * 
	 * [0 2 0 2]->[0 0 2 2]
	 * [2 8 0 2]->[0 2 8 2]
	 * [4 0 0 0]->[0 0 0 4]
	 */

	public void slideRight(int[] row) {
		for(int i = row.length-1; i >= 0; i--) {
			if(row[i] != 0) {
				for(int j = i; j < row.length; j++) {
				if(j < row.length-1 && row[j+1] == 0) {
						int temp = row[j];
						row[j] = row[j+1];
						row[j+1] = temp;
					}
				}
			}
		}

	
	}

	/*
	 * 
	 * Move the numbers as far to the right as they can go
	 * aka the numbers are trying to move to the right-most
	 * empty spaces. This method must utilize the slideRight(int[] row) method
	 * must utilize the helper method above for full credit.
	 * param: a valid row of 2048 where 0s are "empty" spots
	 * effect: row is modified so all numbers are to the right side
	 * return: none
	 */

	public void slideRight() {
		for(int row = 0; row < board.length; row++) {
			slideRight(board[row]);
		}
		// go through 2D array, move all digits as far right as possible
		//setup a loop to grab ONE row at a time from 2d array board
	}

	/**
	 * Given an array of integers, slide all non-zero elements to the left.
	 * zero elements are considered open spots.
	 * example:
	 * 
	 * [0 2 0 2] -> [2 2 0 0]
	 * [2 0 0 2] -> [2 2 0 0]
	 */

	public void slideLeft(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				for(int j = i; j >= 0; j--) {
					if(j > 0 && arr[j-1] == 0) {
						int temp = arr[j];
						arr[j] = arr[j-1];
						arr[j-1] = temp;
					}
				}
			}
		}
			
	}

	/*
	 * Slide all the numbers to the left so that
	 * 
	 * all of the empty spaces are on the right side
	 */

	public void slideLeft() {
		
		// grabbing a row from a 2D array
		// if it's called arr then arr[i] grabs ONE row!
	
		//visit every single row in the 2D array
		//call the slideLeft method that takes in one argument
		for(int i = 0; i < board.length; i++) {
			slideLeft(board[i]);
		}
	}

	/**
	 * Given a 2D array and a column number, return a 1D array representing the
	 * elements in the given column number.
	 */
	public int[] getCol(int[][] data, int c) {
		int[] temp = new int[data.length];
		//you can also add print out statements here
		for(int i = 0; i < data.length; i++) {
			temp[i] = data[i][c];
		}
		return temp;
		
	}

	/**
	 * Given an array of integers, slide all non-zero elements to the top.
	 * 
	 * zero elements are considered open spots.
	 */

	public void slideUp(int[] arr) {
		/* calls a helper method */
		// do not rewrite logic you already have!
		slideLeft(arr);
	}

	/*
	 * 
	 * Slide all elements in the board towards the top.
	 * 
	 * You must use slideUp and getCol for full credit.
	 */
	public void slideUp() {
		int[] temp;
		//visit every column index
		for(int i = 0; i < board[0].length; i++) {
			//grab each column as an array using getCol -> keep track of it in a 1d array
		// variable/reference1
			temp = getCol(board,i);
			//have slideUp perform manipulation on the array
			slideUp(temp);
			// copy over the 1D array representation of the column
		    // back to the 2D board array
			for(int j = 0; j < board.length; j++) {
				board[j][i] = temp[j];
			}
		}
			
	}

	public void slideDown(int[] arr) {
		slideRight(arr);
		
	}

	/*
	 * slide all the numbers down so that any
	 * empty space is at the top
	 * You must use slideDown and getCol for full credit.
	 */

	public void slideDown() {
		int[] temp;
		for(int i = 0; i < board[0].length; i++) {
			temp = getCol(board,i);
			slideDown(temp);
			
			for(int j = 0; j < board.length; j++) {
				board[j][i] = temp[j];
			}
		}
	}

	/*
	 * Given the 2D array, board, combineRight will take adjacent numbers that
	 * are the same and combine them (add them).
	 * After adding them together, one of the numbers is zeroed out. For example, 
	 * if row 0 contained [0 0 4 4], a call to combineRight will produce [0 0 0 8]. 
	 * If row 1 contained [2 2 2,2], a call to combineRight will produce [0 4 0 4].
	 * 
	 * Notice that the left element is zeroed out.
	 */

	public void combineRight() {
		for(int i = 0; i < board.length; i++) {
			combineRight(board[i]);
		}
	}
	
	public void combineRight(int[] arr) {
		for(int j = arr.length-1; j >= 1; j--) {
			if(arr[j] != 0 && arr[j] == arr[j-1]) {
				arr[j] = arr[j]+ arr[j-1];
				arr[j-1] = 0;
				size--;
			}
		}
	}
	

	/*
	 * same behavior as combineRight but the right element is zeroed out when
	 * two elements are combined
	 */

	public void combineLeft() {
		for(int i = 0; i < board.length; i++) {
			combineLeft(board[i]);
		}
	}
	
	public void combineLeft(int[] arr) {
		for(int j = 0; j < arr.length-1; j++) {
			if(arr[j] != 0 && arr[j] == arr[j+1]) {
				arr[j] = arr[j] + arr[j+1];
				arr[j+1] = 0;
				size--;
			}
		}
	}
	/*
	 * same behavior as combineRight but the bottom element is zeroed out when
	 * two elements are combined
	 */

	public void combineUp() {
		int[] temp;
		for(int i = 0; i < board[0].length; i++) {
			temp = getCol(board,i);
			combineLeft(temp);
			
			for(int j = 0; j < board.length; j++) {
				board[j][i] = temp[j];
			}
		}
	}

	/*
	 * same behavior as combineRight but the top element is zeroed out when two
	 * elements are combined
	 */

	public void combineDown() {
		int[] temp;
		for(int i = 0; i < board[0].length; i++) {
			temp = getCol(board,i);
			combineRight(temp);
			
			for(int j = 0; j < board.length; j++) {
				board[j][i] = temp[j];
			}
		}
	}

	
	
	/* reminder: these are the methods that will ultimately invoke
	 * a series of methods
	 * 
	 * the combine and slide methods should not worry about each other's methods
	 */
	public void left() {
		//1) numbers slide to the left
		slideLeft();
		//2) combine
		combineLeft();
		//3) slide
		slideLeft();
	}

	public void right() {
		slideRight();
		combineRight();
		slideRight();
	}

	public void up() {
		slideUp();
		combineUp();
		slideUp();
	}

	public void down() {
		slideDown();
		combineDown();
		slideDown();
	}
	
	

	public boolean gameOver() {
		if(size >= board.length * board.length) {
			return true;
		}else {
			return false;
		}
	}

	public int[][] getBoard() {
		return board;
	}

	// populate with a given 2d array
	public void populate(int[][] arr) {
		size = 0;
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				board[r][c] = arr[r][c];
				//calculate size
				if (board[r][c] != 0) {
					size++;
				}
			}
		}
	}
	
	public void eraseBoard() {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[0].length; col++) {
				board[row][col] = 0;
			}
		}
		size = 0;
	}
}
