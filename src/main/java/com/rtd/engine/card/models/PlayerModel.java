package com.rtd.engine.card.models;

public class PlayerModel {

    private HandModel hm;

    public PlayerModel(DeckModel deck) {
        hm = new HandModel(deck);
    }

    public void drawCard(DeckModel deck) {
        hm.addCard(deck.getRandomCard());
    }
}