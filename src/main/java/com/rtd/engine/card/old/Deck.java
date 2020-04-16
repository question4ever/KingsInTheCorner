package com.rtd.engine.card.old;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Deck {
    /**
     *
     */
    private final boolean standard;
    private ArrayList<Card> cards;
    private final String PATH = "src\\main\\resources\\DefaultBack.png";
    private Image cardBack;

    public Deck() {
        standard = true;
        if (standard) {
            cards = new ArrayList<Card>(52);
            for (final Card.Suit suit : Card.Suit.values()) {
                for (int i = 1; i <= 13; i++) {
                    cards.add(new Card(suit, i));// Add 52 cards A->K Hearts->Spades->Diamonds->Clubs
                }
            }
        } else {
            cards = new ArrayList<Card>(60); // Magic card standard size
        }
        loadImage();
    }

    public boolean isStandard() {
        return standard;
    }

    public int getDeckSize() {
        return cards.size();
    }

    public Card getRandomCard() {
        if(cards.size() > 0){
            final Random rand = new Random();
            final int cardIndex = rand.nextInt(cards.size());
            final Card card = cards.remove(cardIndex);
            return card;
        }
        return null;
    }

    private void loadImage() {
        cardBack = new ImageIcon(PATH).getImage();
    }

    public Image getImage() {
        return cardBack;
    }
}