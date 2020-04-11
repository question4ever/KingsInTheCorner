package com.rtd.engine.card;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testBoardConstructor() {
        try {
            new Board();
        } catch (final Exception e) {
            fail("Construction failed.");
        }
    }

    @Test
    public void testGetHand() {
        Board board = new Board();
        assertEquals(7, board.getHand().getCards().size());
    }

    @Test
    public void testGetDeck() {
        Board board = new Board();
        assertEquals(41, board.getDeck().getDeckSize());   
    }
}