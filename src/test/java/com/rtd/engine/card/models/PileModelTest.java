package com.rtd.engine.card.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class PileModelTest {

    @Test
    public void testPileModelConstructor() {
        try {
            new PileModel();
        } catch (final Exception e) {
            fail("Construction failed.");
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

    @Test 
    public void testMovePile() {
        PileModel pSource = new PileModel();
        pSource.addCard(new CardModel());
        pSource.addCard(new CardModel());
        PileModel pDest = new PileModel();
        pDest.addCard(new CardModel());
        pDest.movePile(pSource);
        assertEquals(3, pDest.size());
    }

    @Test
    public void testSetIndex() {
        PileModel pm = new PileModel();
        pm.setIndex(0);
        assertEquals(0, pm.getIndex());
        assertEquals(0, pm.getXOffset());
        assertEquals(-42, pm.getYOffset());
    }
}