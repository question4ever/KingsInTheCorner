package com.rtd.engine.card.helpers;

import java.util.ArrayList;

import com.rtd.engine.card.models.CardModel;

public abstract class PileOfCards {
    public ArrayList<CardModel> cards;
    private boolean picked;

    //these are all reapeated in Hand maybe an interface that they implement?
    public void setPicked(boolean p) {
        picked = p;
    }

    public boolean isPicked() {
        return picked;
    }

    public boolean addCard(CardModel c) {
        return cards.add(c);
    }

    public int size() {
        return cards.size();
    } 
    //end repeated in hand
}