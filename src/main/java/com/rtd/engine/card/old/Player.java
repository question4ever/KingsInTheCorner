package com.rtd.engine.card.old;


public class Player {
    private Hand hand;
    private boolean human;
    public boolean playedFlag;

    public Player(boolean isHuman) {
        human = isHuman;
    }
    
    public void setHand(Hand pHand) { hand = pHand; }
    public Hand getHand() { return hand; }
    public boolean isHuman() { return human; }

    public void play() {
        if(isHuman()){
            //wait for human to play
            //set playedFlag
        } else {
            hand.sortHand(0, hand.getCards().size() - 1); //sort hand RED BLACK ascending order
        }
    }

    
}
