package model;

public class Logic {
    private String [] players = {"x", "o"};
    private int index = 0;
    private String[][] stage = {
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
    };
    private boolean gameOver;

    public void addMarker(int row, int column, String marker) {
        if (stage[row][column].equals("")) {
            stage[row][column] = marker;
        }

        if (stage[0][0].equals(stage[1][0]) && stage[1][0].equals(stage[2][0]) && !stage[0][0].equals("")) {
            gameOver = true;
        } else if (stage[0][1].equals(stage[1][1]) && stage[1][1].equals(stage[2][1]) && !stage[0][1].equals("")) {
            gameOver = true;
        } else if (stage[0][2].equals(stage[1][2]) && stage[1][2].equals(stage[2][2]) && !stage[0][2].equals("")) {
            gameOver = true;
        }

        if (stage[0][0].equals(stage[0][1]) && stage[0][1].equals(stage[0][2]) && !stage[0][0].equals("")) {
            gameOver = true;
        } else if (stage[1][0].equals(stage[1][1]) && stage[1][1].equals(stage[1][2]) && !stage[1][0].equals("")) {
            gameOver = true;
        } else if (stage[2][0].equals(stage[2][1]) && stage[2][1].equals(stage[2][2]) && !stage[2][0].equals("")) {
            gameOver = true;
        }

        if (stage[0][0].equals(stage[1][1]) && stage[1][1].equals(stage[2][2]) && !stage[0][0].equals("")) {
            gameOver = true;
        } else if (stage[0][2].equals(stage[1][1]) && stage[1][1].equals(stage[2][0]) && !stage[0][2].equals("")) {
            gameOver=true;
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String currentPlayer() {
        return players[index];
    }

    public void nextPlayer() {
        index = ++index % players.length;
    }

}
