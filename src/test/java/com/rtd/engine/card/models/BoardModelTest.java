package com.rtd.engine.card.models;

import org.junit.Test;
import static org.junit.Assert.*;

import com.rtd.engine.card.models.BoardModel.Direction;

public class BoardModelTest {

    @Test
    public void testConstructor() {
        try{
            new BoardModel();
        } catch (Exception e) {
            fail(e.getStackTrace().toString());
        }
    }

    @Test
    public void testGetPile() {
        BoardModel bm = new BoardModel(); //lol
        assertEquals(1, bm.getPile(Direction.NORTH).size());
    }

    @Test
    public void testInitBoard() {
        BoardModel bm = new BoardModel(); //lol
        assertEquals(1, bm.getPile(Direction.NORTH).size());
        assertEquals(1, bm.getPile(Direction.SOUTH).size());
        assertEquals(1, bm.getPile(Direction.EAST).size());
        assertEquals(1, bm.getPile(Direction.WEST).size());
    }

    @Test 
    public void testGetWidth() {
        BoardModel bm = new BoardModel(); //lol
        assertEquals(168 + 62, bm.getWidth());
    }

    @Test
    public void testGetHeight() {
        BoardModel bm = new BoardModel();
        assertEquals(168 + 84, bm.getHeight());
    }

    public void testSetGetDeck() {
        BoardModel bm = new BoardModel();
        DeckModel deck = bm.getDeck();
        deck.getRandomCard();
        assertEquals(51, deck.size());
    }
}