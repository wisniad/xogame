
import java.util.Scanner;

public class Game {

    private static int player = 1;
    Sign mark = Sign.X;
    private static int place;
    private static Boolean winner = false;
    private static Boolean taken = false;
    private static Boolean draw = false;
    private static String currentPlayerName;
    public boolean isTurnX = true;

    Board board = new Board();
    Player playerOne = new Player("");
    Player playerTwo = new Player("");
    Scanner keyboard = new Scanner(System.in);

    public void startGame() {

        createPlayers();
        board.resetBoard();
        board.showBoard();
    }

    public void createPlayers() {
        System.out.println("Insert first player's name: ");
        playerOne.setName(keyboard.nextLine());
        System.out.println("Insert second player's name: ");
        playerTwo.setName(keyboard.nextLine());
    }

    public void play() {
        while(!winner) {
            board.showBoard();
            printMessages();
            place = keyboard.nextInt(); // read player input
            checkIfExit();
            if (putSignOnTheBoard()) {
                checkIfThereIsAWinner();
                if(!winner)
                    changePlayer();
            }
        }
        endGameMessage();
    }


    private void endGameMessage() {
        board.showBoard();
        if(draw) {
            System.out.println("ITS A DRAW, TRY AGAIN");

        }
        else if( place == 0) {
            System.out.println("You did exit.");
        }
        else {
            System.out.println("The winner is: " + currentPlayerName + "!");
        }
    }
    private void checkIfThereIsAWinner() {
        int takenSpots = 0;
        // po linijkach
        for (int i = 0; i < board.getLenght(); i++) {
            if (board.getBoard()[i][0] == board.getBoard()[i][1] && board.getBoard()[i][1] == board.getBoard()[i][2] && board.getBoard()[i][1] == mark)
                winner = true;
        }
        // po kolumnach
        for (int j = 0; j < board.getLenght(); j++) {
            if (board.getBoard()[0][j] == board.getBoard()[1][j] && board.getBoard()[1][j] == board.getBoard()[2][j] && board.getBoard()[2][j] == mark)
                winner = true;
        }
        // na jeden krzyz
        if (board.getBoard()[0][0] == board.getBoard()[1][1] && board.getBoard()[1][1] == board.getBoard()[2][2] && board.getBoard()[1][1] == mark)
            winner = true;
        // na drugi krzyz
        if (board.getBoard()[0][2] == board.getBoard()[1][1] && board.getBoard()[1][1] == board.getBoard()[2][0] && board.getBoard()[1][1] == mark)
            winner = true;
        for (int i = 0; i < board.getLenght(); i++) {
            for (int j = 0; j < board.getLenght(); j++) {
                if(board.getBoard()[i][j] != Sign.EMPTY)
                    takenSpots++;
            }
        }
        if (takenSpots == 9 && !winner){
            draw = true;
            winner = true;
        }
    }
    private void printMessages() {
        if(taken) {
            System.out.println("Spot that you have chosen was already taken, choose differently.");
            taken = false;
        }
        if(place > 9 ){
            System.out.println("No such place on the board.");
        }
        System.out.println("Player " + currentPlayerName );
        System.out.println("In which place to put " + mark + ": ");

    }
    private Boolean putSignOnTheBoard() {
        Boolean successful = false;
        switch (place) {
            case 1: {
                if(checkIfSpotIsEmpty(0,2)){
                    board.setField(0, 2, mark);
                    successful = true;
                }
                else {
                    taken = true;
                }
                break;
            }
            case 2: {
                if(checkIfSpotIsEmpty(1,2)){
                    board.setField(1, 2, mark);
                    successful = true;
                }
                else {
                    taken = true;
                }
                break;
            }
            case 3: {
                if(checkIfSpotIsEmpty(2,2)){
                    board.setField(2, 2, mark);
                    successful = true;
                }
                else {
                    taken = true;
                }
                break;
            }
            case 4: {
                if(checkIfSpotIsEmpty(0,1)){
                    board.setField(0, 1, mark);
                    successful = true;
                }
                else {
                    taken = true;
                }
                break;
            }
            case 5: {
                if(checkIfSpotIsEmpty(1,1)){
                    board.setField(1, 1, mark);
                    successful = true;
                }
                else {
                    taken = true;
                }
                break;
            }
            case 6: {
                if(checkIfSpotIsEmpty(2,1)){
                    board.setField(2, 1, mark);
                    successful = true;
                }
                else {
                    taken = true;
                }
                break;
            }
            case 7: {
                if(checkIfSpotIsEmpty(0,0)){
                    board.setField(0, 0, mark);
                    successful = true;
                }
                else {
                    taken = true;
                }
                break;
            }
            case 8: {
                if(checkIfSpotIsEmpty(1,0)){
                    board.setField(1, 0, mark);
                    successful = true;
                }
                else {
                    taken = true;
                }
                break;
            }
            case 9: {
                if(checkIfSpotIsEmpty(2,0)){
                    board.setField(2, 0, mark);
                    successful = true;
                }
                else {
                    taken = true;
                }
                break;
            }
        }
        return successful;
    }
    private Boolean checkIfSpotIsEmpty(int i, int j) {
        return board.isFieldEmpty(i,j);

    }
    private static void checkIfExit() {
        if( place == 0 ){
            winner = true;
        }
    }
    private void changePlayer() {
        if(player == 1){
            player = 2;
            mark = Sign.O;
            currentPlayerName = playerTwo.getName();
        }
        else {
            player = 1;
            mark = Sign.X;
            currentPlayerName = playerOne.getName();
        }
    }

}
