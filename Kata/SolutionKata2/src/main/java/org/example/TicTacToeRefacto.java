package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToeRefacto {
    
    private static final int BOARD_SIZE = 3;
    private static final int EMPTY_CELL = 0;
    private static final int PLAYER_MARK = 1;
    private static final int COMPUTER_MARK = 2;
    private static final int MAX_COMPUTER_ATTEMPTS = 100;

    private final int[][] board;
    private final BufferedReader inputReader;
    private boolean playerTurn = true;

    public TicTacToeRefacto() {
        this.board = createEmptyBoard();
        this.inputReader = new BufferedReader(new InputStreamReader(System.in));
    }
    

    
    public void play() {
        while (!isGameOver()) {
            playPlayerTurn();
            if (isGameOver()) {
                announcePlayerWin();
                break;
            }
            
            playComputerTurn();
            if (isGameOver()) {
                announceComputerWin();
                break;
            }
        }
    }
    
    private void playPlayerTurn() {
        displayBoard();
        Move playerMove = getPlayerMove();
        makeMove(playerMove, PLAYER_MARK);
        displayBoard();
    }
    
    private void playComputerTurn() {
        Move computerMove = generateComputerMove();
        makeMove(computerMove, COMPUTER_MARK);
    }
    
    private int[][] createEmptyBoard() {
        int[][] newBoard = new int[BOARD_SIZE][BOARD_SIZE];
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                newBoard[row][col] = EMPTY_CELL;
            }
        }
        return newBoard;
    }
    
    private Move getPlayerMove() {
        System.out.print("\nEnter move r,c (0-2,0-2): ");
        String input = readUserInput();
        return new Move(input);
    }
    
    private String readUserInput() {
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read user input", e);
        }
    }

    
    private Move generateComputerMove() {
        for (int attempt = 0; attempt < MAX_COMPUTER_ATTEMPTS; attempt++) {
            int row = (int) (Math.random() * BOARD_SIZE);
            int col = (int) (Math.random() * BOARD_SIZE);
            Move move = new Move(row, col);
            
            if (isCellEmpty(move)) {
                return move;
            }
        }
        throw new IllegalStateException("Unable to generate computer move");
    }
    
    private void makeMove(Move move, int playerMark) {
        board[move.getRow()][move.getCol()] = playerMark;
    }
    
    private boolean isCellEmpty(Move move) {
        return board[move.getRow()][move.getCol()] == EMPTY_CELL;
    }
    
    private boolean isGameOver() {
        return hasWinningRow() || hasWinningColumn() || hasWinningDiagonal();
    }
    
    private boolean hasWinningRow() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (isWinningLine(board[row][0], board[row][1], board[row][2])) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasWinningColumn() {
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isWinningLine(board[0][col], board[1][col], board[2][col])) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasWinningDiagonal() {
        return isWinningLine(board[0][0], board[1][1], board[2][2]) ||
               isWinningLine(board[2][0], board[1][1], board[0][2]);
    }
    
    private boolean isWinningLine(int first, int second, int third) {
        return first == second && second == third && first != EMPTY_CELL;
    }
    
    private void displayBoard() {
        System.out.println("\n\nGame after move:");
        for (int row = 0; row < BOARD_SIZE; row++) {
            System.out.println();
            for (int col = 0; col < BOARD_SIZE; col++) {
                System.out.print(" " + getCellSymbol(board[row][col]));
            }
        }
    }
    
    private String getCellSymbol(int cellValue) {
        return switch (cellValue) {
            case EMPTY_CELL -> ".";
            case PLAYER_MARK -> "x";
            case COMPUTER_MARK -> "o";
            default -> throw new IllegalArgumentException("Invalid cell value: " + cellValue);
        };
    }
    
    private void announcePlayerWin() {
        System.out.println("\n\nYou are the winner");
    }
    
    private void announceComputerWin() {
        System.out.println("\n\nBetter Luck next time");
    }

}