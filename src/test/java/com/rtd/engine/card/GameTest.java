package com.rtd.engine.card;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    public class MockGame extends Game {}

    @Test
    public void testNextState() {
        MockGame mock = new MockGame();
        mock.nextState();
        assertEquals(Game.State.PLAY.name(), mock.getState().name());
    }
}