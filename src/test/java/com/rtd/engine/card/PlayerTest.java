package com.rtd.engine.card;
import org.junit.Before;
import org.junit.Test;
import com.rtd.engine.card.old.*;
import static org.junit.Assert.*;

public class PlayerTest {
    private Hand hand;
    private boolean human;

    @Before
    public void initPlayer() {
        Deck deck = new Deck();
        human = false;
        hand = new Hand(deck, 7);
    }

    @Test
    public void testPlayerConstructor() {
        try {
            new Player(human);
        } catch (final Exception e) {
            fail("Construction failed.");
        }
    }

    @Test
    public void testSetGetHand() {
        Player player = new Player(human);
        player.setHand(hand);
        assertEquals(hand, player.getHand());
    }

    @Test
    public void testIsHuman() {
        Player player = new Player(human);
        assertFalse("The player is not human", player.isHuman());
    }
}