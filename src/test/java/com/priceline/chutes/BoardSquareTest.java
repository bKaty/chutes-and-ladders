package com.priceline.chutes;

import com.priceline.chutes.model.BoardSquare;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardSquareTest {

    @Test
    public void test_whenIsChuteThenNegativeNumberSquares(){
        BoardSquare square = new BoardSquare(true, false, 10);
        assertTrue(square.getNumberSquaresToSkip() < 0);
    }

    @Test
    public void test_whenItsLadderThenPositiveNumberSquares(){
        BoardSquare square = new BoardSquare(false, true, 10);
        assertTrue(square.getNumberSquaresToSkip() > 0);
    }

    @Test
    public void test_whenNoNumberSquaresToSkip(){
        BoardSquare square = new BoardSquare(false, false, 0);
        assertEquals(0, square.getNumberSquaresToSkip());
    }
}
