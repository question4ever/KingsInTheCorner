package com.rtd.engine.card.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.BasicStroke;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import com.rtd.engine.card.models.PileModel;

public class PileView extends JComponent {
    private static final long serialVersionUID = 2717047279656360295L;
    private PileModel pile; 

    private static final int iHeight = 84;
    private static final int iWidth = 62;

    private double rotation;
    private double x;
    private double y;
    private Dimension d;
     
    public PileView(PileModel pm, double rotation, double x, double y) {
        pile = pm;
        this.rotation = rotation;
        this.x = x;
        this.y = y;
        d = getPreferredSize();
        if (rotation == 0) {
            d = new Dimension(iWidth, (iHeight / 2) * (pile.size() + 1));
        } else if(rotation == Math.PI/2) { 
            //90 degrees E W
            d = new Dimension((iHeight / 2) * (pile.size() + 1), iWidth); 
        } else {
            //King NE
            int hyp = (iHeight / 2) * (pile.size() + 1);
            double leg = hyp * Math.sin(rotation);
            d = new Dimension((int)leg, (int)leg);
        }
        setPreferredSize(d);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Image image;
        if(pile.size() > 0) {
            for(int i = 0; i < pile.size(); i++) {
                AffineTransform at = new AffineTransform();
                image = pile.cards.get(i).getImage();
                // 4. translate it to the center of the component
                at.translate(x + (pile.getXOffset() * i), y + (pile.getYOffset() * i));

                // 3. do the actual rotation
                at.rotate(rotation);

                // 1. translate the object so that you rotate it around the 
                //    center (easier :))
                at.translate(-image.getWidth(null)/2, -image.getHeight(null)/2);
                g2d.drawImage(image, at, null);
            }
        } else {
            image = new ImageIcon("src\\main\\resources\\blank.png").getImage();
            AffineTransform at = new AffineTransform();
            at.translate(x, y);
            at.rotate(rotation);
            at.translate(-image.getWidth(null)/2, -image.getHeight(null)/2);
            g2d.drawImage(image, at, null);
        }
        if(pile.isPicked()) {
            g2d.setColor(Color.WHITE);
            g2d.setStroke(new BasicStroke(5));
            switch(pile.getIndex()) {
                case 0: //NORTH
                g2d.drawRect((int)(x - d.getWidth()) + iWidth/2, (int)(y - d.getHeight()) + iHeight/2, (int)d.getWidth(), (int)d.getHeight());
                break;
                case 1: //EAST
                g2d.drawRect((int)x - iWidth/2 - 8, (int)y - iHeight/2 + 10, (int)d.getWidth(), (int)d.getHeight());
                break;
                case 2: //SOUTH
                g2d.drawRect((int)x - iWidth/2, (int)y - iHeight/2, (int)d.getWidth(), (int)d.getHeight());
                break;
                case 3: //WEST
                g2d.drawRect((int)(x - d.getWidth()) + iWidth/2 + 8, (int)(y - d.getHeight()) + iHeight/2 - 10, (int)d.getWidth(), (int)d.getHeight());
                break;
                case 4:
                //TODO
                break;
                case 5:
                //TODO
                break;
                case 6:
                //TODO
                break;
                case 7:
                //TODO
                break;
                default:
                throw new IndexOutOfBoundsException();
            }
            g2d.setStroke(new BasicStroke(1));
        }
    }
}