package com.priceline.chutes.service;

import com.priceline.chutes.exception.GameException;
import com.priceline.chutes.model.Board;
import com.priceline.chutes.model.Player;

import java.util.List;

public interface GameService {
    Player playGame(List<Player> players, Board board) throws GameException;
}
