import java.util.Scanner;

public class Puzzle {

    /**
     * Generates a random move for the computer in the game of Rock-Paper-Scissors.
     * @return A string representing the computer's move ("rock", "paper", or "scissors").
     */
    public static String randomMove() {
        String move;
        int randomNum = (int) (Math.random() * 3) + 1;
        if (randomNum == 1) {
            move = "rock";
        } else if (randomNum == 2) {
            move = "paper";
        } else {
            move = "scissors";
        }
        return move;
    }

    /**
     * Plays a game of Rock-Paper-Scissors until either the player or the computer scores 3 points.
     * @return A string indicating if the player wins or loses the game.
     */
    public static String rockPaperScissors() {
        int computerScore = 0;
        int playerScore = 0;
        Scanner keyboard = new Scanner(System.in);
        while (computerScore < 3 && playerScore < 3) {
            System.out.print("|Rock, Paper, or Scissors| -> ");
            String computerMove = randomMove();
            String playerMove = keyboard.nextLine().toLowerCase();
            while (!playerMove.equals("rock") && !playerMove.equals("scissors") && !playerMove.equals("paper")) {
                System.out.print("Invalid move. Try again: ");
                playerMove = keyboard.nextLine().toLowerCase();
            }
            if ((computerMove.equals("rock") && playerMove.equals("paper"))
                    || (computerMove.equals("paper") && playerMove.equals("scissors"))
                    || (computerMove.equals("scissors") && playerMove.equals("rock"))) {
                playerScore++;
                System.out.println();
                System.out.println("\"You played " + playerMove + ", and I played " + computerMove + ".\"");
                System.out.println();
                System.out.println("\"You won this round! The score is " + playerScore + " to " + computerScore + ".\"");
            } else if ((computerMove.equals("rock") && playerMove.equals("scissors"))
                    || (computerMove.equals("paper") && playerMove.equals("rock"))
                    || (computerMove.equals("scissors") && (playerMove.equals("paper")))) {
                computerScore++;
                System.out.println();
                System.out.println("\"You played " + playerMove + ", and I played " + computerMove + ".\"");
                System.out.println();
                System.out.println("\"You lost this round! The score is " + playerScore + " to " + computerScore + ".\"");
            } else {
                System.out.println();
                System.out.println("\"You played " + playerMove + ", and I played " + computerMove + ".\"");
                System.out.println();
                System.out.println("\"We tied! The score is " + playerScore + " to " + computerScore + ".\"");
            }
        }
        if (computerScore > playerScore) {
            return "You lose!";
        }
        return "You win!";
    }

    /**
     * Plays a game of Guess the Number where the player has up to 11 attempts to guess a randomly generated number between 1 and 1000.
     * @return A string indicating if the player wins or loses the game.
     */
    public static String guessTheNumber() {
        int randomNum = (int) (Math.random() * 1000) + 1;
        Scanner keyboard = new Scanner(System.in);
        int guess = -1;
        int turns = 1;
        while (guess != randomNum && turns <= 11) {
            System.out.print("Enter your numerical guess: ");
            guess = keyboard.nextInt();
            if (guess == randomNum) {
                break;
            } else if (guess > randomNum) {
                System.out.println("\"Your guess is too high.\"");
                System.out.println("\"You have " + (11 - turns) + " guesses left.\"");
                System.out.println();
            } else {
                System.out.println("\"Your guess is too low.\"");
                System.out.println("\"You have " + (11 - turns) + " guesses left.\"");
                System.out.println();
            }
            turns++;
        }
        System.out.println();
        System.out.println("\"My number was " + randomNum + "!\"");
        if (guess == randomNum) {
            return "You win!";
        }
        return "You lose!";
    }

    /**
     * Runs a series of Tic-Tac-Toe games until the player wins 3 times or runs out of attempts (5 tries).
     * @return A string indicating if the player wins or loses the game series.
     */
    public static String runTicTacToe() {
        int numWins = 0;
        int tries = 5;
        while (numWins < 3 && tries > 0) {
            int win = TicTacToe();
            if (win == 0 || win == 2) {
                numWins++;
            }
            tries--;
            System.out.println("\"You have " + tries + " tries left. You have won " + numWins + " rounds.\"");
        }
        if (numWins == 3) {
            return "You win!";
        } else {
            return "You lose!";
        }
    }

    /**
     * Plays a single game of Tic-Tac-Toe between the player and the AI.
     * @return An integer indicating the game result (0 for player win, 1 for AI win, 2 for draw, 3 for ongoing game).
     */
    public static int TicTacToe() {
        char[][] board = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };
        Scanner scanner = new Scanner(System.in);
        while (true) {
            playerMove(board, scanner);
            if (isGameOver(board) != 3) {
                break;
            }
            aiMove(board);
            if (isGameOver(board) != 3) {
                break;
            }
        }
        return isGameOver(board);
    }

    /**
     * Prompts the player to make a move in Tic-Tac-Toe by entering row and column indices.
     * @param board The current state of the Tic-Tac-Toe board.
     * @param scanner The Scanner object for reading player input.
     */
    private static void playerMove(char[][] board, Scanner scanner) {
        int row, col;
        while (true) {
            printBoard(board);
            System.out.print("Enter your move (row [1-3] and column [1-3]): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (row < 0 || col < 0 || row >= 3 || col >= 3 || board[row][col] != ' ') {
                System.out.println("This move is not valid.");
            } else {
                break;
            }
        }
        board[row][col] = 'X';
    }

    /**
     * Makes the best possible move for the AI in Tic-Tac-Toe.
     * @param board The current state of the Tic-Tac-Toe board.
     */
    private static void aiMove(char[][] board) {
        int[] bestMove = findBestMove(board);
        board[bestMove[0]][bestMove[1]] = 'O';
    }

    /**
     * Checks if the game of Tic-Tac-Toe is over and determines the result.
     * @param board The current state of the Tic-Tac-Toe board.
     * @return An integer indicating the game result (0 for player win, 1 for AI win, 2 for draw, 3 for ongoing game).
     */
    private static int isGameOver(char[][] board) {
        if (hasWon(board, 'X')) {
            printBoard(board);
            return 0;
        }
        if (hasWon(board, 'O')) {
            printBoard(board);
            return 1;
        }
        if (isBoardFull(board)) {
            printBoard(board);
            return 2;
        }
        return 3;
    }

    /**
     * Prints the current state of the Tic-Tac-Toe board.
     * @param board The current state of the Tic-Tac-Toe board.
     */
    private static void printBoard(char[][] board) {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2)
                    System.out.print("|");
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
    }

    /**
     * Checks if the specified player has won the game of Tic-Tac-Toe.
     * @param board The current state of the Tic-Tac-Toe board.
     * @param player The player character to check for a win ('X' or 'O').
     * @return A boolean indicating if the player has won.
     */
    public static boolean hasWon(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the Tic-Tac-Toe board is full.
     * @param board The current state of the Tic-Tac-Toe board.
     * @return A boolean indicating if the board is full.
     */
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Finds the best possible move for the AI in Tic-Tac-Toe using the minimax algorithm.
     * @param board The current state of the Tic-Tac-Toe board.
     * @return An array containing the row and column indices of the best move for the AI.
     */
    private static int[] findBestMove(char[][] board) {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    int score = minimax(board, 0, false);
                    board[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        return bestMove;
    }

    /**
     * Implements the minimax algorithm to find the best move for the AI in Tic-Tac-Toe.
     * @param board The current state of the Tic-Tac-Toe board.
     * @param depth The current depth of the minimax tree.
     * @param isMaximizing A boolean indicating if the current turn is the maximizing player's turn.
     * @return An integer representing the score of the board state.
     */
    private static int minimax(char[][] board, int depth, boolean isMaximizing) {
        if (hasWon(board, 'O')) {
            return 10 - depth;
        }
        if (hasWon(board, 'X')) {
            return depth - 10;
        }
        if (isBoardFull(board)) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'O';
                        int score = minimax(board, depth + 1, false);
                        board[i][j] = ' ';
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';
                        int score = minimax(board, depth + 1, true);
                        board[i][j] = ' ';
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    /**
     * Prompts the player to solve a series of riddles. The player must solve 3 out of 5 riddles to win.
     */
    public static void solveRiddles() {
        Scanner scanner = new Scanner(System.in);
        int wins = 0;
        String[][] riddles = {
            {"Riddle 1: I am not alive, but I grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I? ", "fire"},
            {"Riddle 2: I am taken from a mine, and shut up in a wooden case, from which I am never released. What am I? ", "pencil"},
            {"Riddle 3: You measure my life in hours, and I serve you by expiring. I’m quick when I’m thin and slow when I’m fat. The wind is my enemy. What am I? ", "candle"},
            {"Riddle 4: I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I? ", "echo"},
            {"Riddle 5: I have keys, but no locks and space, and no rooms. You can enter, but you can’t go outside. What am I? ", "keyboard"}
        };
        System.out.println("You must solve " + (riddles.length - 2) + " of the " + riddles.length + " riddles to move on. You have 1 try for each riddle.");
        for (int i = 0; i < riddles.length; i++) {
            System.out.print(riddles[i][0]);
            String answer = scanner.nextLine().toLowerCase();
            if (answer.indexOf(riddles[i][1]) != -1) {
                wins++;
                System.out.println("Correct! The answer was " + riddles[i][1] + ". You only need to solve " + (3 - wins) + " more riddles. You have " + (riddles.length - i - 1) + " tries left.");
            } else {
                System.out.println("Incorrect! The answer was " + riddles[i][1] + ". You only need to solve " + (3 - wins) + " more riddles. You have " + (riddles.length - i - 1) + " tries left.");
            }
            if (wins == 3) {
                break;
            }
        }
        if (wins == 3) {
            System.out.println("You have solved enough! You may move on!");
        } else {
            System.out.println("You have failed. The door remains shut forever.");
        }
    }
}
