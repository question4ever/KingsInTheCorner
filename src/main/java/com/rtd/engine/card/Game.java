package com.rtd.engine.card;

import java.util.ArrayList;

abstract class Game {

    private static State currentState = State.INIT;
    private static State nextState = State.PLAY;
    private ArrayList<Player> players;
    private Board gameBoard;
    

    static enum State {
        INIT,
        DRAW,
        PLAY,
        UPDATE
    }

    public void executeState() {
        switch(currentState) {
            case INIT:
                nextState = State.PLAY;
            case DRAW:
                nextState = State.PLAY;
                for (Player player : players) {
                    player.play();
                }
            case PLAY:
                nextState = State.UPDATE;
            case UPDATE:
                nextState = State.DRAW;
            default:
        }
    }

    public void nextState() {
        currentState = nextState;
    }

    public State getState() {
        return currentState;
    }
}