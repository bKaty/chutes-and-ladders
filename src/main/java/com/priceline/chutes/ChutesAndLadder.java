package com.priceline.chutes;

import com.priceline.chutes.exception.GameException;
import com.priceline.chutes.model.Board;
import com.priceline.chutes.model.Player;
import com.priceline.chutes.service.GameService;
import com.priceline.chutes.service.impl.GameServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ChutesAndLadder {

    private final static Logger LOGGER = Logger.getLogger(ChutesAndLadder.class.getName());

    /**
     * This is the entry point of the game chutes and ladders.
     * @param args
     */
    public static void main(String[] args) {
        try {
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter number of players: ");
            int numOfPlayers= sc.nextInt();

            if(numOfPlayers < 2 || numOfPlayers > 4){
                throw new GameException("Invalid number of players, Chutes and Ladders is for 2 to 4 players");
            }

            List<Player> playerList = new ArrayList<>(numOfPlayers);
            for(int i=0; i< numOfPlayers; i++){
                System.out.print("Enter name of the %d player: "+ (i+1));
                String name= sc.next();
                Player p= new Player(name);
                playerList.add(p);
            }

            LOGGER.info("Initialized the players for the game....");
            LOGGER.info("Loading the board.....");
            Board board = new Board();
            GameService gameService =new GameServiceImpl();

            LOGGER.info("Starting the game....");
            Player winner = gameService.playGame(playerList, board);
            System.out.println("The winner is: " + winner.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
