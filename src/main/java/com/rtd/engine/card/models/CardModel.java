package com.rtd.engine.card.models;

import java.awt.Image;

import javax.swing.ImageIcon;

public class CardModel {
    private boolean picked;
    private int rank;
    private Suit suit;
    private Image image;

    public static enum Suit 
    {
        HEART,
        SPADE,
        DIAMOND,
        CLOVER
    }

    public CardModel() {

    }

    public CardModel(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public void setPicked(boolean p) {
        picked = p;
    }

    public boolean isPicked() {
        return picked;
    }

    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Image getImage() {
        if(image == null) {
            loadImage();
        }
        return image;
    }

    private void loadImage() {
        String path = "src\\main\\resources\\card_"+Integer.toString(rank)+"_"+suit.name().toLowerCase()+".png";
        image = new ImageIcon(path).getImage();
    }
}