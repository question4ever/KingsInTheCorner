package com.rtd.engine.card;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import com.rtd.engine.card.Card.Suit;

public class DeckTest{

    private Deck deck;

    @Before
    public void createDeck(){
        deck = new Deck();
    }

    @Test
    public void testDeckConstructor() {
        try {
            new Deck();
        } catch (final Exception e) {
            fail("Construction failed.");
        }
    }

    @Test
    public void testDeckIsStandard() {
        assertTrue("Deck constructor failed to assign standard a value of true", deck.isStandard() == true);
    }

    @Test
    public void testStandardDeckSize() {
        assertEquals(52, deck.getDeckSize());
    }

    @Test
    public void testGetRandomCardShrinkDeck() {
        final Card card = deck.getRandomCard();
        assertEquals(51, deck.getDeckSize());
        assertNotNull(card);
    }

    @Test
    public void testGetRandomCardRandomness() {
        final Card card1 = deck.getRandomCard();
        deck = new Deck();
        final Card card2 = deck.getRandomCard();
        assertNotEquals(card1, card2);
        assertEquals(51, deck.getDeckSize());
    }
}