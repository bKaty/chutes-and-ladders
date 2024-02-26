package com.priceline.chutes.service;

import com.priceline.chutes.model.Board;
import com.priceline.chutes.model.BoardSquare;

public interface BoardService {
    BoardSquare getSquareAtPosition(Board board, int currPosition);

}
