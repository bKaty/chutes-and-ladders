package com.priceline.chutes.service.impl;

import com.priceline.chutes.model.Board;
import com.priceline.chutes.model.BoardSquare;
import com.priceline.chutes.service.BoardService;

public class BoardServiceImpl implements BoardService {

    public BoardSquare getSquareAtPosition(Board board, int currPosition){
        return board.squares.get(currPosition - 1);
    }

}
