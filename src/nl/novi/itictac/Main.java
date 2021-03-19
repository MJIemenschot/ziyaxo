package nl.novi.itictac;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welkom bij het spel Boter kaas en eieren");

        //Maak een bord
        String[] board = new String[9];

        for(int i = 0; i < 9; i++) {
            board[i] = Integer.toString(i);

        }
        //Toon het bord
        printBoard(board);

        String currentPlayer = "x";
        boolean hasWon = false;

        while(hasWon == false) {

            //Geef de speler  de mogelijkheid om een symbool te zetten
            System.out.println("\n Voer een cijfer van 0 t/m 8 in om op het bord " + currentPlayer + " te zetten");

            Scanner userInput = new Scanner(System.in);
            int selectedField = userInput.nextInt();

            board[selectedField] = currentPlayer;

            //Toon het bord
            printBoard(board);

            hasWon = hasPlayerWon(board, currentPlayer);

            if (hasWon == true) {
                System.out.println("Gefeliciteerd je hebt gewonnen " + currentPlayer);
            }

            //Wissel van speler
            currentPlayer = switchPlayer(currentPlayer);
        }


    }

    public static void printBoard(String[] board) {
        for(int i = 0; i < board.length; i++) {
            System.out.print(board[i]);


            boolean isEndOfRow = (i + 1) % 3 == 0;
            boolean isLastField = i == 8;

            if(isEndOfRow == false){
                System.out.print(" | ");
            }

            if(isEndOfRow && !isLastField){

                System.out.println("\n-----------");
            }
        }
    }

    public static String switchPlayer(String currentPlayer) {
        if (currentPlayer == "x") {
            return "0";
        }
        else {
            return "x";
        }
    }

    public static boolean hasPlayerWon(String[] board, String currentPlayer) {
        //horizontale opties om te winnen
        if (board[0] == currentPlayer && board[1] == currentPlayer && board[2] == currentPlayer) {
            return true;
        }
        if (board[3] == currentPlayer && board[4] == currentPlayer && board[5] == currentPlayer) {
            return true;
        }
        if (board[6] == currentPlayer && board[7] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }

        //verticale opties om te winnen
        if (board[0] == currentPlayer && board[3] == currentPlayer && board[6] == currentPlayer) {
            return true;
        }
        if (board[1] == currentPlayer && board[4] == currentPlayer && board[7] == currentPlayer) {
            return true;
        }
        if (board[2] == currentPlayer && board[5] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }

        //diagonale opties om te winnen
        if (board[0] == currentPlayer && board[4] == currentPlayer && board[4] == currentPlayer) {
            return true;
        }
        if (board[6] == currentPlayer && board[4] == currentPlayer && board[2] == currentPlayer) {
            return true;
        }

        return false;
    }
}
