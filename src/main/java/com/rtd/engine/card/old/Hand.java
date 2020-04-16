package com.rtd.engine.card.old;

import java.util.ArrayList;
import java.awt.*;

public class Hand {

    /**
	 *
	 */
	private ArrayList<Card> cards;

    public Hand() {
    }

    public Hand(Deck deck){
        cards = new ArrayList<Card>(7);
        for(int i = 0; i < 7; i++){
            cards.add(deck.getRandomCard());
        }
    }

    public Hand(Deck deck, int startingHandSize){
        cards = new ArrayList<Card>(7);
        for(int i = 0; i < startingHandSize; i++){
            cards.add(deck.getRandomCard());
        }
    }

    public Card getCard(int index) {
        Card c = cards.get(index);
        return c;
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public int size() {
        return cards.size();
    }

    public void playCard(Card c) {
        cards.remove(c);
    }

    /*
    Compares two cards
    Returns:
        0 if c1 == c2
        -1 if c1 < c2
        1 if c1 > c2
    */
    private int compareCards(Card c1, Card c2) {
        if(c1 != null && c2 != null) {
            if(c1.getAdjustedRank() > c2.getAdjustedRank()) {
                return 1;
            } else if(c1.getAdjustedRank() < c2.getAdjustedRank()) {
                return -1;
            } else {
            return 0;
            }
        }
        return -2; //error code
    }

    private void swap(int i, int j) {
        Card tmp = cards.get(i);
        if(tmp != null) {
            cards.set(i, cards.get(j));
            cards.set(j, tmp);
        }
    }

    private int partition(int low, int high) {
        Card pivot = cards.get(high);
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if(compareCards(cards.get(j), pivot) == -1) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    /*Implement quick sort
        Choose pivot -> last index
        High goes to the right lower to the left
    */
    public void sortHand(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            sortHand(low, pi-1);
            sortHand(pi+1, high);
        }
    }

    public void addCard(Card c) {
        cards.add(c);
    }

    public void draw(Graphics2D g2d, int x, int y) {
        for (Card card : cards) {
            if(card != null) {
                if(card.isPicked()) {   
                    g2d.drawImage(card.getImage(), x, y + 5, null);
                }
                else{
                    g2d.drawImage(card.getImage(), x, y, null);
                }
                x+=card.getImage().getWidth(null);
            }
        }
    }
}