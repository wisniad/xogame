
public class Board {

    Sign[][] board = new Sign[3][3];

    public void showBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print("\n----------------------\n");
            for (int j = 0; j < board[i].length; j++){
                if(j == 0) {
                    System.out.print(" ");
                }
                if (board[i][j] != Sign.EMPTY) {
                    System.out.print("|  "+board[i][j]+"  |");
                }
                else {
                    System.out.print("|     |");

                }
            }
        }
        System.out.print("\n----------------------\n");


    }
    public int getLenght() {
        return board.length;
    }
    public void resetBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = Sign.EMPTY;
        }
    }

    public void setField(int x, int y, Sign fieldState) {
        board[y][x] = fieldState;
    }

    public void setBoard(Sign[][] board) {
        this.board = board;
    }

    public boolean isFieldEmpty(int x, int y){
        if(board[y][x].equals(Sign.EMPTY))
            return true;
        return false;
    }

    public Sign[][] getBoard() {
        return board;
    }
}