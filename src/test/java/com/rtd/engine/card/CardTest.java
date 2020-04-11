package com.rtd.engine.card;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest{

    private Card card;

    @Before
    public void setupCard(){
        card = new Card(Card.Suit.HEART, 1);
    }

    @Test
    public void testCardConstructor(){
        assertNotNull(card);
    }

    @Test
    public void testCardGetRank(){
        assertEquals(1, card.getRank());
    }

    @Test
    public void testCardGetSuit(){
        assertEquals(Card.Suit.HEART, card.getSuit());
    }

    @Test
    public void testCardLoadImage() {
        assertNotNull(card.getImage());
    }

    @Test
    public void testGetAdjustedRank() {
        assertEquals(1.5, card.getAdjustedRank(), 0.2);
    }
}