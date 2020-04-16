package com.rtd.engine.card;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import com.rtd.engine.card.old.*;
import com.rtd.engine.card.old.Card.Suit;

import org.junit.Before;

public class PileTest {

    private ArrayList<Card> cards;

    @Before
    public void initPile() {
        Deck deck = new Deck();
        cards = new ArrayList<Card>(1);
        cards.add(deck.getRandomCard());
    }

    @Test
    public void testPileConstructor() {
        try {
            new Pile(cards);
        } catch (final Exception e) {
            fail("Construction failed.");
        }
    }

    @Test
    public void testPileDefaultConstructor() {
        try {
            new Pile(cards);
        } catch (final Exception e) {
            fail("Construction failed.");
        }
    }

    @Test 
    public void testSetPicked() {
        Pile p = new Pile();
        p.setPicked(true);
        assertTrue("boolean picked successfully set to true", p.isPicked());
    }

    @Test
    public void testMovePile() {
        cards.add(new Card(Suit.HEART, 2));
        Pile source = new Pile(cards);
        ArrayList<Card> desitnationPileCards = new ArrayList<Card>(1);
        desitnationPileCards.add(new Card(Suit.CLOVER, 1));
        Pile destination = new Pile(desitnationPileCards);
        source.movePile(destination);
        assertEquals(0, source.size());
        assertEquals(3, destination.size());
    }

    @Test
    public void testAddCard() {
        Pile p = new Pile(cards);
        try{
            p.addCard(new Card(Suit.HEART, 1));
        } catch (final Exception e) {
            fail(e.getStackTrace().toString());
        }
        assertEquals(2, p.size());
        assertEquals(Suit.HEART, p.getBottomCard().getSuit());
    }

    public void testGetBottomCard() {
        Pile p = new Pile(cards);
        assertNotNull(p.getBottomCard());
    }
}