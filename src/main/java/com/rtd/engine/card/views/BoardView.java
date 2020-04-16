package com.rtd.engine.card.views;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.rtd.engine.card.models.BoardModel;
import com.rtd.engine.card.models.BoardModel.Direction;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class BoardView extends JPanel {

    private static final long serialVersionUID = 2214357393949826637L;
    private BoardModel board;
    private static final String cardBack = "src\\main\\resources\\\\DefaultBack.png";

    public BoardView(BoardModel bm) {
        board = bm;
        setPreferredSize(new Dimension(board.getWidth(), board.getHeight()));
        setBackground(Color.GREEN);
    }

    private void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Image iBack = new ImageIcon(cardBack).getImage();
        g2d.drawImage(iBack, this.getWidth() / 2 - 31, this.getHeight() / 2 - 42, Color.BLUE, null);
        PileView northView = new PileView(board.getPile(Direction.NORTH), 0, this.getWidth() / 2,
                this.getHeight() / 2 - 84);
        northView.draw(g);
        PileView eastView = new PileView(board.getPile(Direction.EAST), Math.PI / 2, this.getWidth() / 2 + 74,
                this.getHeight() / 2);
        eastView.draw(g);
        PileView westView = new PileView(board.getPile(Direction.WEST), Math.PI / 2, this.getWidth() / 2 - 73,
                this.getHeight() / 2);
        westView.draw(g);
        PileView southView = new PileView(board.getPile(Direction.SOUTH), 0, this.getWidth() / 2,
                this.getHeight() / 2 + 84);
        southView.draw(g);

        PileView neKingView = new PileView(board.getPile(Direction.NE), Math.PI / 4, this.getWidth() / 2 + 72,
                this.getHeight() / 2 - 80);
        neKingView.draw(g);
        PileView seKingView = new PileView(board.getPile(Direction.SE), -Math.PI / 4, this.getWidth() / 2 + 72,
                this.getHeight() / 2 + 80);
        seKingView.draw(g);
        PileView swKingView = new PileView(board.getPile(Direction.SW), Math.PI * 0.75, this.getWidth() / 2 - 72,
                this.getHeight() / 2 - 80);
        swKingView.draw(g);
        PileView nwKingView = new PileView(board.getPile(Direction.NW), -Math.PI * 0.75, this.getWidth() / 2 - 72,
                this.getHeight() / 2 + 80);
        nwKingView.draw(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //TODO fix the resize issue
        setSize(new Dimension(board.getWidth(), board.getHeight()));
        draw(g);
    }
}