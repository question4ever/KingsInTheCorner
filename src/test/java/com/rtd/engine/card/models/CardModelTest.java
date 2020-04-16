package com.rtd.engine.card.models;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class CardModelTest {

    private CardModel card;

    @Before
    public void setupCard(){
        card = new CardModel(CardModel.Suit.HEART, 1);
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
        assertEquals(CardModel.Suit.HEART, card.getSuit());
    }

    @Test
    public void testCardLoadImage() {
        assertNotNull(card.getImage());
    }
}