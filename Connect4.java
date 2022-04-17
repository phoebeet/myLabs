import java.util.Scanner;

public class Connect4 {

	static Scanner in =  new Scanner(System.in);

	public static void main(String args[]) {
		System.out.println("Please enter board size:");
		System.out.println("Width (columns): ");
		int w = in.nextInt();
		System.out.println("Height (rows): ");
		int h = in.nextInt();
		char[][] board = makeBoard(w, h);
		printBoard(board);
		Checker.setBoard(board);
		Checker.setWinNum(4);
		boolean player1 = true;
		do {
			if (player1)
				System.out.println("It's player1's turn:");
			else
				System.out.println("It's player2's turn:");
			System.out.println("Place your next checker at (column x row)");
			System.out.println("Column: ");
			int c = in.nextInt();
			System.out.println("Row: ");
			int r = in.nextInt();
			if (board[r][c] != '.' || c >= w || r >= h) {
				System.out.println("Illegal input");
				continue;
			}
			if (player1) {
				board[r][c] = 'x';
				player1 = false;
			} else {
				board[r][c] = 'o';
				player1 = true;
			}
			printBoard(board);
		} while (!checkBoard(4, w, h));
		if (player1)
			System.out.println("Player2 won !!! ");
		else
			System.out.println("Player1 won !!! ");
	}

	public static char[][] makeBoard(int width, int height) {
		char[][] board = new char[width][height];
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				board[i][j] = '.';
			}
		}
		return board;
	}

	public static boolean checkBoard(int winNum, int width, int height) {
		CheckerFactory checkMaker = new CheckerFactory();
		Checker activeChecker;
		// check columns
		for (int i=0; i<width; i++) {
			for (int j=0; j<(height - winNum); j++) {
				activeChecker = checkMaker.posX(i).posY(j).delX(0).delY(1).makeChecker();
				if (activeChecker.checkArray(0))
					return true;
			}
 		}
		// check rows
		for (int i=0; i<height; i++) {
			for (int j=0; j<(width - winNum); j++) {
				activeChecker = checkMaker.posX(j).posY(i).delX(1).delY(0).makeChecker();
				if (activeChecker.checkArray(0))
					return true;
			}
		}
		// check diags
		for (int i=0; i<width - winNum; i++) {
			for (int j=0; j<=height - winNum; j++) {
				activeChecker = new Checker(i, j, 1, 1);
				if (activeChecker.checkArray(0))
					return true;
				activeChecker = new Checker(width - i - 1, j, -1, 1);
				if (activeChecker.checkArray(0))
					return true;
			}
		}

		return false;
	}

	public static void printBoard(char[][] inBoard) {
		// assumes inner arrays have consistent length
		for (int i=0; i<inBoard.length; i++) {
			for (int j=0; j<inBoard[0].length; j++) {
				System.out.print(inBoard[i][j]);
			}
			System.out.println();
		}
	}
}

class Checker {

	// main board
	static char[][] board;
	// the number of matches needed to win
	static int winningNum;

	// these change when we create a new checker
	final int startX;
	final int startY;
	final int deltaX;
	final int deltaY;
	int positionX;
	int positionY;

	// found type we're checking against
	final char tokenType;

	public Checker(int posX, int posY, int delX, int delY) {
		positionX = posX;
		positionY = posY;
		startX = posX;
		startY = posY;
		deltaX = delX;
		deltaY = delY;
		tokenType = getToken();
	}

	private char getToken() {
		return board[positionY][positionX];
	}

	public static void setBoard(char[][] inBoard) {
		board = inBoard;
	}

	public static void setWinNum(int inWinningNum) {
		winningNum = inWinningNum;
	}

	private void incrementPos() {
		positionX += deltaX;
		positionY += deltaY;
	}
	public void printStatus() {
		System.out.println(
			String.format(
				"start x: %d\n" +
				"start y: %d\n" +
				"change x: %d\n" +
				"change y: %d\n",
				startX, startY, deltaX, deltaY
			)
		);
	}

	public boolean checkArray(int depth) {
		if (tokenType == '.')
			return false;
		else if (depth >= (winningNum - 1)) {
			printStatus();
			return true;
		} else {
			incrementPos();
			if (getToken() != tokenType)
				return false;
			else
				return checkArray(depth + 1);
		}
	}

}

class CheckerFactory {
	int positionX;
	int positionY;
	int deltaX;
	int deltaY;

	public CheckerFactory posX(int inX) {
		positionX = inX;
		return this;
	}
	public CheckerFactory posY(int inY) {
		positionY = inY;
		return this;
	}
	public CheckerFactory delX(int inX) {
		deltaX = inX;
		return this;
	}
	public CheckerFactory delY(int inY) {
		deltaY = inY;
		return this;
	}
	public Checker makeChecker() {
		return new Checker(positionX, positionY, deltaX, deltaY);
	}
}

