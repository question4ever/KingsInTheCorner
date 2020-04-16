package com.rtd.engine.card.models;
import java.util.ArrayList;
import java.util.Random;

public class DeckModel {
    private ArrayList<CardModel> cards;

    public DeckModel() {
        cards = new ArrayList<CardModel>(52);
        for (CardModel.Suit suit : CardModel.Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new CardModel(suit, i));// Add 52 cards A->K Hearts->Spades->Diamonds->Clubs
            }
        }
    }

    public CardModel getRandomCard() {
        if(cards.size() > 0){
            final Random rand = new Random();
            final int cardIndex = rand.nextInt(cards.size());
            final CardModel card = cards.remove(cardIndex);
            return card;
        }
        return null;
    }

    public int size() {
        return cards.size();
    }
}