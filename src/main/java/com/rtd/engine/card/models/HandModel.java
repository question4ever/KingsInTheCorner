package com.rtd.engine.card.models;
import java.util.ArrayList;

import com.rtd.engine.card.helpers.PileOfCards;

public class HandModel extends PileOfCards{
    
    public HandModel() {
        cards = new ArrayList<CardModel>(7);
    }

    public HandModel(DeckModel deck) {
        cards = new ArrayList<CardModel>(7);
        for(int i = 0; i < 7; i++) {
            cards.add(deck.getRandomCard());
        }
    } 
}