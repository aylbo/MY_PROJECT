package HWs;

import java.util.Scanner;

public class Battleship {
	public static void main(String[] args) {
		System.out.println("Welcome to Battleship!\n");

		Scanner input = new Scanner(System.in);

	// INPUT FOR PLAYER 1
		System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");

		char[][] grid1 = initializeGrid();
		placeShips(input, grid1);
		printBattleShip(grid1);
	
	// CLEAR SCREEN
		int skip = 0;
		do {
			System.out.println("");
			skip += 1;
		} while (skip < 100);
			
	// INPUT FOR PLAYER 2
		System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");

		char[][] grid2 = initializeGrid();
		placeShips(input, grid2);
		printBattleShip(grid2);

	// CLEAR SCREEN
		skip = 1;
		do {
			System.out.println("");
			skip += 1;
		} while (skip < 100);
	
	// Start the game
		char[][] targetBoard1 = grid2; // Tracks Player 1's attacks
		char[][] targetBoard2 = grid1; // Tracks Player 2's attacks
	
		boolean gameOn = true;
        int currentPlayer = 1;

        while (gameOn) {
            char[][] currentTargetBoard = currentPlayer == 1 ? targetBoard1 : targetBoard2;
            char[][] opponentGrid = currentPlayer == 1 ? grid2 : grid1;

            System.out.println("\nPlayer " + currentPlayer + ", enter hit row/column:");
            String attackCoordinates = input.nextLine().trim();
            String[] parts = attackCoordinates.split(" ");

            if (parts.length != 2) {
                System.out.print("Invalid coordinates. Choose different coordinates.");
                continue;
            }

            try {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);

                if (row < 0 || row >= 5 || col < 0 || col >= 5) {
                    System.out.print("Invalid coordinates. Choose different coordinates.");
                    continue;
                }

				int opponentPlayer = currentPlayer == 1 ? 2 : 1;

                if (opponentGrid[row][col] == '@') {
                    System.out.println("PLAYER " + currentPlayer + " HIT PLAYER " + opponentPlayer + "'s SHIP!");
                    currentTargetBoard[row][col] = 'X'; // Mark hit on target board
                    opponentGrid[row][col] = 'X'; // Mark hit on opponent grid
                } else if (currentTargetBoard[row][col] == '-') {
                    System.out.println("PLAYER " + currentPlayer + " MISSED!");
                    currentTargetBoard[row][col] = 'O'; // Mark miss on target board
                } else {
					System.out.print("You already fired on this spot. Choose different coordinates.");
                    continue;
				}

                printBattleShip(createMaskedBoard(currentTargetBoard));

                currentPlayer = currentPlayer == 1 ? 2 : 1;

            } catch (NumberFormatException e) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }

            if (isGameOver(grid1)) {
                System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                gameOn = false;
            } else if (isGameOver(grid2)) {
                System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                gameOn = false;
            }
        }
		System.out.println("\nFinal boards:\n");
		printBattleShip(grid1);
		System.out.println("");
		printBattleShip(grid2);
        input.close();
    }

	private static char[][] initializeGrid() {
        char[][] grid = new char[5][5];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = '-';
            }
        }
        return grid;
    }

	private static void placeShips(Scanner input, char[][] grid) {
        int placedShips = 0;

        while (placedShips < 5) {
            System.out.println("Enter ship " + (placedShips + 1) + " location:");
            String coordinates = input.nextLine().trim();
            String[] parts = coordinates.split(" ");

            if (parts.length != 2) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                continue;
            }

            try {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);

                if (row < 0 || row >= 5 || col < 0 || col >= 5) {
					System.out.print("Invalid coordinates. Choose different coordinates.");
					continue;
				}
	
				// Check if a ship is already placed at the given location
				if (grid[row][col] == '@') {
					System.out.println("You already have a ship there. Choose different coordinates.");
					continue;
				}

                grid[row][col] = '@';
                placedShips++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }
        }
	}

	private static char[][] createMaskedBoard(char[][] board) {
		char[][] maskedBoard = new char[board.length][board[0].length];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				maskedBoard[row][col] = board[row][col] == '@' ? '-' : board[row][col];
			}
		}
		return maskedBoard;
	}
	
	// Check if the game is over (all ships sunk)
    private static boolean isGameOver(char[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '@') {
                    return false; // There are still ships left
                }
            }
        }
        return true; // All ships sunk
    }

	// Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
}