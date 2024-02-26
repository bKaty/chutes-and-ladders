package com.priceline.chutes.service.impl;

import com.priceline.chutes.exception.GameException;
import com.priceline.chutes.model.Board;
import com.priceline.chutes.model.BoardSquare;
import com.priceline.chutes.model.Player;
import com.priceline.chutes.service.BoardService;
import com.priceline.chutes.service.GameService;
import com.priceline.chutes.service.SpinnerService;

import java.util.List;
import java.util.logging.Logger;

public class GameServiceImpl implements GameService {

    private final static Logger LOGGER = Logger.getLogger(GameServiceImpl.class.getName());
    public SpinnerService spinnerService;
    public BoardService boardService;

    public GameServiceImpl() {
        this.spinnerService = new SpinnerServiceImpl();
        this.boardService = new BoardServiceImpl();
    }

    /**
     * This method initiates the game and declares the winner.
     * @param players
     * @param board
     * @return Player
     */
    @Override
    public Player playGame(List<Player> players, Board board) throws GameException {
        int turn = 0;
        if(players.isEmpty() || board == null){
            throw new GameException("Can not initiate a game");
        }

        while(true){
            turn = turn +1;
            LOGGER.info("{} Turn: "+ turn );

            for (Player currentPlayer : players) {
                int spinResult = spinnerService.spin();
                LOGGER.info("Spin result: " + spinResult);
                int nextPosition = currentPlayer.getPosition() + spinResult;

                if (nextPosition > 100){
                    LOGGER.info("{} has to skip the turn! better luck in next turn!"+  currentPlayer.getName() );
                    break;
                }

                BoardSquare nextSquare = boardService.getSquareAtPosition(board, nextPosition);
                nextPosition = nextPosition + nextSquare.getNumberSquaresToSkip();

                LOGGER.info(currentPlayer.getName() + " has moved from "+ currentPlayer.getPosition() + " to "+ nextPosition);
                if (nextPosition < 100) {
                    currentPlayer.setPosition(nextPosition);
                } else if (nextPosition == 100) {
                    return currentPlayer;
                }
            }
        }
    }
}
