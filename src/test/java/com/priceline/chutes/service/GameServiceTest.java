package com.priceline.chutes.service;

import com.priceline.chutes.exception.GameException;
import com.priceline.chutes.model.Board;
import com.priceline.chutes.model.BoardSquare;
import com.priceline.chutes.model.Player;
import com.priceline.chutes.service.impl.BoardServiceImpl;
import com.priceline.chutes.service.impl.GameServiceImpl;
import com.priceline.chutes.service.impl.SpinnerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GameServiceTest {

    private Player player;

    GameServiceImpl gameService;
    SpinnerService mockSpinnerService;
    BoardService mockBoardService;

    Board board;

    @BeforeEach
    public void setupGame() throws GameException {
        player = new Player("Amy");
        gameService = new GameServiceImpl();
        mockSpinnerService = mock(SpinnerServiceImpl.class);
        mockBoardService = mock(BoardServiceImpl.class);
        gameService.spinnerService = mockSpinnerService;
        gameService.boardService = mockBoardService;
        board = new Board();
    }

    @Test
    public void test_whenPlayersListIsEmptyThenException(){
        List<Player> players = new ArrayList<>();
        Exception exception = assertThrows(GameException.class, () ->
                gameService.playGame(players, new Board()));
        assertEquals("Can not initiate a game", exception.getMessage());
    }

    @Test
    public void test_whenBoardIsNullThenException(){
        List<Player> players = new ArrayList<>();
        players.add(player);
        Exception exception = assertThrows(GameException.class, () ->
                gameService.playGame(players,null));
        assertEquals("Can not initiate a game", exception.getMessage());
    }

    @Test
    public void test_whenPlayerWinsTheGame() throws GameException {
        List<Player> players = new ArrayList<>();
        player.setPosition(80);
        players.add(player);
        Player p2 = new Player("Mary");
        players.add(p2);
        Mockito.doReturn(0).when(mockSpinnerService).spin();
        Mockito.doReturn(new BoardSquare(false, true, 20)).when(mockBoardService).getSquareAtPosition(board, 80);
        assertEquals(gameService.playGame(players, board).getName(),"Amy" );
    }




}
