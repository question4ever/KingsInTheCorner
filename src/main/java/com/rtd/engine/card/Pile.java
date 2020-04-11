package com.rtd.engine.card;

import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.AffineTransform;

class Pile {
    private ArrayList<Card> cards;
    private Point p;
    private boolean picked; 

    public Pile() {
        cards = new ArrayList<Card>(1);
    }

    public Pile(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
    }

    public boolean isPicked() {
        return picked;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Point getLocation() {
        return p;
    }

    public int size() {
        return cards.size();
    }

    public Card getBottomCard() {
        return cards.get(cards.size() - 1);
    }

    public Card getTopCard() {
        return cards.get(0);
    }

    public void movePile(Pile destination) {
        for (int i = 0; i < cards.size(); i++) {
            destination.addCard(cards.get(i));
        }
        cards = new ArrayList<Card>(1);
    }

    public void draw(Graphics2D g2d, double radRotation, double x, double y, double xOffset, double yOffset) {
        double _x; 
        double _y;
        Image image;
        p = new Point();
        for(int i = 0; i < cards.size(); i++) {
            AffineTransform at = new AffineTransform();
            _x = x;
            _y = y;
            p.setLocation(x, y);
            image = cards.get(i).getImage();
            // 4. translate it to the center of the component
            at.translate(_x + (xOffset * i), _y + (yOffset * i));

            // 3. do the actual rotation
            at.rotate(radRotation);

            // 1. translate the object so that you rotate it around the 
            //    center (easier :))
            at.translate(-image.getWidth(null)/2, -image.getHeight(null)/2);
            g2d.drawImage(image, at, null);
        }
    }
}