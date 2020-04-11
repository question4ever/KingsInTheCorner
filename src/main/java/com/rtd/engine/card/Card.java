package com.rtd.engine.card;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

class Card extends JComponent
{
    /**
     *
     */
    private static final long serialVersionUID = 2895964857243180324L;
    private boolean picked;

    public static enum Suit 
    {
        HEART,
        SPADE,
        DIAMOND,
        CLOVER
    }
    private int rank;
    private Suit suit;
    private Image image = null;
    private double adjustedRank;

    public Card(Suit suit, int rank)
    {
        this.rank = rank;
        this.suit = suit;
        if(suit == Suit.HEART || suit == Suit.DIAMOND) { adjustedRank = rank + 0.5;}
        else { adjustedRank = rank;}
        loadImage();
    }

    public Suit getSuit() 
    {
        return suit;
    }

    public void setPicked(boolean isPicked) {
        picked = isPicked;
    }

    public boolean isPicked() {
        return picked;
    }

    public double getAdjustedRank() { return adjustedRank; }

    public int getRank() { return rank; }

    private void loadImage() {
        String path = "src\\main\\resources\\card_"+Integer.toString(rank)+"_"+suit.name().toLowerCase()+".png";
        image = new ImageIcon(path).getImage();
    }

    public Image getImage(){ return image; }
}