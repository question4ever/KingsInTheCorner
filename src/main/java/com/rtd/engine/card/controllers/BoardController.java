package com.rtd.engine.card.controllers;

import java.awt.Dimension;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import com.rtd.engine.card.helpers.Game;
import com.rtd.engine.card.models.BoardModel;
import com.rtd.engine.card.models.PileModel;
import com.rtd.engine.card.models.BoardModel.Direction;
import com.rtd.engine.card.views.BoardView;

public class BoardController implements MouseInputListener {

    private BoardModel bm;
    private BoardView bv;

    public BoardController(BoardModel bm, BoardView bv) {
        this.bm = bm;
        this.bv = bv;
    }

    private void drawCard() {
        Game.sendCommand(0, null);
        System.out.println("Draw pile clicked");
    }

    private void pileClicked(PileModel clicked) {
        Game.sendCommand(2, clicked);
        System.out.println(clicked.getIndex());
        bv.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) { 
        int x = e.getX();
        int y = e.getY();
        int panelWidth = bv.getWidth();
        int panelHeight = bv.getHeight();
        int iHeight = 84;
        int iWidth = 62;

        if(x >= panelWidth/2 - iWidth/2 && x <= panelWidth/2 + iWidth/2) {
            if(y >= panelHeight/2 - iHeight/2 && y <= panelHeight/2 + iHeight/2) {
                drawCard();
            } else if(y >= panelHeight/2 + iHeight/2 && y <= panelHeight/2 + iHeight/2 * (bm.getPile(Direction.SOUTH).size() + 2)) {
                pileClicked(bm.getPile(Direction.SOUTH));
            } else {
                pileClicked(bm.getPile(Direction.NORTH));
            }
        } else if(y >= panelHeight/2 - iWidth/2 && y <= panelHeight/2 + iWidth/2) {
            if(x >= panelWidth/2 + iWidth/2 && x <= panelWidth/2 + iHeight/2 * (bm.getPile(Direction.EAST).size() + 2)) {
                pileClicked(bm.getPile(Direction.EAST));
            }
            else {
                pileClicked(bm.getPile(Direction.WEST));
            }
        } else if(x <= panelWidth/2- iWidth/2) {
            if(y >= panelHeight/2 + iWidth/2) {
                pileClicked(bm.getPile(Direction.SW));
            } else {
                pileClicked(bm.getPile(Direction.NW));
            }
        } else {
            if(y >= panelHeight/2 + iWidth/2) {
                pileClicked(bm.getPile(Direction.SE));
            } else {
                pileClicked(bm.getPile(Direction.NE));
            }
        }
        //System.out.printf("Mouse clicked at (%d, %d)\n", e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.printf("Mouse pressed at (%d, %d)\n", e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.printf("Mouse released at (%d, %d)\n", e.getX(), e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.printf("Mouse entered at (%d, %d)\n", e.getX(), e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.printf("Mouse exited at (%d, %d)\n", e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.printf("Mouse drageed to (%d, %d)\n", e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.printf("Mouse moved to (%d, %d)\n", e.getX(), e.getY());
    }
    
}