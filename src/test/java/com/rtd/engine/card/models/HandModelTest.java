package com.rtd.engine.card.models;
import org.junit.Test;
import static org.junit.Assert.*;

public class HandModelTest {
    
    @Test 
    public void testConstructor() {
        DeckModel dm = new DeckModel();
        HandModel hm = null;
        try {
            hm = new HandModel(dm);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        if(hm != null) {
            assertEquals(7, hm.size());
        }
    }

    @Test
    public void testSetPicked() {
        PileModel p = new PileModel();
        p.setPicked(true);
        assertTrue("Failed to pick a pile", p.isPicked());
    }

    @Test
    public void testAddCard() {
        PileModel p = new PileModel();
        assertTrue("Failed to add a card", p.addCard(new CardModel()));
    }

    @Test
    public void testSize() {
        PileModel p = new PileModel();
        p.addCard(new CardModel());
        assertEquals(1, p.size());
    }
}