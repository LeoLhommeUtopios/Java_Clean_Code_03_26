package org.example;

public class Move {
    private final int row;
    private final int col;

    public Move (String input){
        String[] coordinates = input.split(",");
        row = Integer.parseInt(coordinates[0]);
        col = Integer.parseInt(coordinates[1]);
    }

    public Move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
