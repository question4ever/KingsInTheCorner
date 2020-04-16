package com.rtd.engine.card.views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.rtd.engine.card.models.CardModel;
import com.rtd.engine.card.models.DeckModel;
import com.rtd.engine.card.models.HandModel;

public class HandView extends JPanel {

    HandModel hand;
    private static final long serialVersionUID = 6384215034004910292L;
    
    public HandView() {
        hand = new HandModel(new DeckModel());
        setPreferredSize(new Dimension((hand.size()+1)*31, 84));
    }

    private void draw(Graphics2D g2d, int x, int y) {
        for (CardModel card : hand.cards) {
            if(card != null) {
                if(card.isPicked()) {   
                    g2d.drawImage(card.getImage(), x, y + 5, null);
                }
                else{
                    g2d.drawImage(card.getImage(), x, y, null);
                }
                x+=card.getImage().getWidth(null)/2;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        draw(g2d, 0, 0);
    }
}