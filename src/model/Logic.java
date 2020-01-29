package model;

public class Logic {
    private String [] players = {"x", "o"};
    private int index = 0;

    public String currentPlayer() {
        return players[index];
    }

    public void nextPlayer() {
        index = ++index % players.length;
    }

    public boolean checkWin(String[][] board) {
        boolean hasWon = false;
        if (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) && !board[0][0].equals("")) {
            hasWon = true;
        } else if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]) && !board[0][1].equals("")) {
            hasWon = true;
        } else if (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]) && !board[0][2].equals("")) {
            hasWon = true;
        }

        if (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]) && !board[0][0].equals("")) {
            hasWon = true;
        } else if (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2]) && !board[1][0].equals("")) {
            hasWon = true;
        } else if (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2]) && !board[2][0].equals("")) {
            hasWon = true;
        }

        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("")) {
            hasWon = true;
        } else if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals("")) {
            hasWon=true;
        }

        return hasWon;
    }
}
