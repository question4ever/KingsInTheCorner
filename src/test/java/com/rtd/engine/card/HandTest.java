package com.rtd.engine.card;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

import com.rtd.engine.card.old.Card;
import com.rtd.engine.card.old.Deck;
import com.rtd.engine.card.old.Hand;
import com.rtd.engine.card.old.Card.Suit;

public class HandTest{

    @Test
    public void testHandDefaultConstructor() {
        try {
            new Hand();
        } catch (final Exception e) {
            fail("Construction failed.");
        }
    }

    @Test
    public void testPlayCard() {
        Hand hand = new Hand(new Deck());
        ArrayList<Card> cards = hand.getCards();
        hand.playCard(cards.get(0));
        assertEquals(6, cards.size());
    }

    @Test
    public void testHandDefaultSizeConstructor(){
        Hand hand = new Hand(new Deck());
        assertEquals(7, hand.size());
    }

    @Test
    public void testAddCard() {
        Hand hand = new Hand(new Deck());
        hand.addCard(new Card(Suit.HEART, 1));
        assertEquals(8, hand.size());
        assertEquals(Suit.HEART, hand.getCard(7).getSuit());
        assertEquals(1, hand.getCard(7).getRank());
    }

    @Test
    public void testSortHand() {
        Hand hand = new Hand(new Deck());
        ArrayList<Card> cards = hand.getCards();
        hand.sortHand(0, cards.size() - 1);
        Card testCard = cards.get(6);
        for(int i = 1; i < cards.size(); i++) {
            assertTrue("List isn't sorted properly\n testCard: " + Double.toString(testCard.getAdjustedRank())  + "\n problem card: " + Double.toString(cards.get(i).getAdjustedRank()) + "index = " + Integer.toString(i), cards.get(i).getAdjustedRank() >= cards.get(i - 1).getAdjustedRank()); 
        }
    }

}