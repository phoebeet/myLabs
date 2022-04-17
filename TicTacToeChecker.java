import java.util.Random;

public class TicTacToeChecker {
	public static void main(String args[]) {
		char[][] board = makeBoard(4);
		printBoard(board);
		int winNum = 3;
		Checker.setBoard(board);
		Checker.setWinNum(3);
		CheckerFactory checkMaker = new CheckerFactory();
		Checker activeChecker;
		// check columns
		for (int i=0; i<board[0].length; i++) {
			for (int j=0; j<=(board[0].length - winNum); j++) {
				activeChecker = checkMaker.posX(i).posY(j).delX(0).delY(1).makeChecker();
				activeChecker.checkArray();
			}
 		}
		// check rows
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<=(board.length - winNum); j++) {
				activeChecker = checkMaker.posX(j).posY(i).delX(1).delY(0).makeChecker();
				activeChecker.checkArray();
			}
		}
		// check diags
		for (int i=0; i<=board[0].length - winNum; i++) {
			for (int j=0; j<=board.length - winNum; j++) {
				activeChecker = new Checker(i, j, 1, 1);
				activeChecker.checkArray();
				activeChecker = new Checker(board[0].length - i - 1, j, -1, 1);
				activeChecker.checkArray();
			}
		}
	}

	public static char[][] makeBoard(int boardSize) {
		Random activeRand = new Random();
		char[][] board = new char[boardSize][boardSize];
		for (int i=0; i<boardSize; i++) {
			for (int j=0; j<boardSize; j++) {
				board[i][j] = activeRand.nextBoolean() ? 'x' : 'o';
			}
		}
		return board;
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

	public boolean checkArray() {
		boolean foundWinPart = true;
		for (int i=1; i<winningNum; i++) {
			incrementPos();
			if (getToken() != tokenType) {
				foundWinPart = false;
				break;
			}
		}
		if (foundWinPart) {
			printStatus();
		}
		return foundWinPart;
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

