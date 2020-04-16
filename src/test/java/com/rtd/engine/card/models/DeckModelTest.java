package com.rtd.engine.card.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class DeckModelTest {

    @Test
    public void testConstructor() {
        try{
            new DeckModel();
        } catch(Exception e) {
            fail(e.toString());
        }
    }

    @Test 
    public void testSize() {
        DeckModel dm = new DeckModel();
        assertEquals(52, dm.size());
    }

    @Test
    public void testGetRandomCard() {
        DeckModel dm = new DeckModel();
        CardModel cm = dm.getRandomCard();
        assertNotNull(cm);
    }
}