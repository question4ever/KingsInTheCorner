package com.rtd.engine.card;

import javax.swing.JPanel;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextArea;

class Board extends JPanel {

    /**
     *
     */

    private static final long serialVersionUID = 6375957071905293254L;
    private Deck deck;
    private Hand hand;
    private Pile eastPile;
    private Pile westPile;
    private Pile northPile;
    private Pile southPile;

    private Card playedCard = null;
    private Pile pilePicked = null;

    public Board() {
        initBoard();
        JButton sortHandButton = new JButton("Sort");
        JButton getNewHandButton = new JButton("New hand");
        JTextArea output = new JTextArea();

        this.add(sortHandButton);
        this.add(getNewHandButton);

        this.add(output);
        sortHandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                hand.sortHand(0, hand.size() - 1);
                repaint();
            }
        });
        getNewHandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hand = new Hand(deck);
                repaint();
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                Point p = e.getPoint();
                int panelHeight = getHeight();
                int panelWidth = getWidth();
                int iWidth = deck.getImage().getWidth(null);
                int iHeight = deck.getImage().getHeight(null);

                if(p.getY() >= 0 && p.getY() <= iHeight) {
                    if(p.getX() <= hand.getCards().size() * iWidth) {
                        int index = (int)p.getX() / deck.getImage().getWidth(null);
                        cardClicked(index);
                    }
                } 
                else if(p.getX() >= panelWidth/2 && p.getX() <= panelWidth/2 + iWidth) {
                    if(p.getY() <= panelHeight/2  && p.getY() >= panelHeight/2 - (iHeight/2 * (northPile.size() + 1))) {
                        pileClicked(northPile);
                    } else if(p.getY() >= panelHeight/2 + iHeight && p.getY() <= panelHeight/2 + (1.25)*iHeight + (iHeight/2 * southPile.size() + 1)) {
                        pileClicked(southPile);
                    } else if(p.getY() >= panelHeight/2 && p.getY() <= panelHeight/2 + iHeight) {
                        hand.addCard(deck.getRandomCard());
                    }
                } 
                else if(p.getY() >= panelHeight/2 + iHeight/8 && p.getY() <= panelHeight/2 + iHeight/8 + iWidth) {
                    if(p.getX() >= panelWidth/2 + iWidth && p.getX() <= panelWidth/2 + (1.25)*iWidth + (iHeight/2 * eastPile.size() + 1)) {
                        pileClicked(eastPile);
                    } else if(p.getX() <= panelWidth/2 + iWidth && p.getX() >= panelWidth/2 - 1.25 * iWidth - (iHeight/2 * westPile.size() + 1)) {
                        pileClicked(westPile);
                    }
                }
                else {
                    reset();
                }
                repaint();
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }

    public Hand getHand(){return hand;}
    public Deck getDeck(){return deck;}

    private void reset() {
        if(playedCard != null) {
            playedCard.setPicked(false);
            playedCard = null;
        }
        if(pilePicked != null) {
            pilePicked.setPicked(false);
            pilePicked = null;
        }
    }

    private void cardClicked(int index) {
        if(playedCard != null) {
            playedCard.setPicked(false);
        }
        playedCard = hand.getCard(index);
        playedCard.setPicked(true);
    }

    private void pileClicked(Pile clicked) {
        if(playedCard != null) {
            clicked.addCard(playedCard);
            hand.playCard(playedCard);
            playedCard = null;
        } else {
            if(pilePicked != null) {
                pilePicked.setPicked(false); 
                pilePicked.movePile(clicked);
                pilePicked = null;
            } else {
                pilePicked = clicked;
                pilePicked.setPicked(true);
            }
        }
    }

    private void initBoard() {
        setBackground(Color.GREEN);
        deck = new Deck();
        hand = new Hand(deck, 7);

        eastPile = new Pile();
        westPile = new Pile();
        northPile = new Pile();
        southPile = new Pile();
        eastPile.addCard(deck.getRandomCard());
        westPile.addCard(deck.getRandomCard());
        northPile.addCard(deck.getRandomCard());
        southPile.addCard(deck.getRandomCard());
    }

    public void initBoard(ArrayList<Player> players) {
        initBoard();
        for (Player player : players) {
            player.setHand(new Hand(deck, 7));
        }
    }

    private void draw(Graphics g) {
        int iWidth = deck.getImage().getWidth(null);
        int iHeight = deck.getImage().getHeight(null);
        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();

        // draw the image
        Graphics2D g2d = (Graphics2D) g;
        
        double x =  getWidth() / 2 + 1.65*iWidth;
        double y = getHeight() / 2 + (0.51*iHeight);
        
        eastPile.draw(g2d, Math.PI/2, x, y, 0.5*iHeight, 0.0);
        x = getWidth() / 2 - 0.65*iWidth;
        westPile.draw(g2d, Math.PI/2, x, y, -0.5*iHeight, 0.0);

        x = panelWidth /2 + iWidth/2;
        y = panelHeight /2;

        northPile.draw(g2d, 0, x , y - iHeight/2, 0, -0.5*iHeight);
        southPile.draw(g2d, 0, x, y + (1.5)*iHeight, 0, 0.5*iHeight);
        
        if(deck.getDeckSize() > 0){
            g2d.drawImage(deck.getImage(), panelWidth/2, panelHeight/2, this);//draw deck CENTER
        }

        g2d.setPaint(Color.WHITE);
        g2d.setStroke(new BasicStroke(5));
        if(northPile.isPicked()){
            g2d.drawRect(panelWidth/2, panelHeight/2 - iHeight/2 * (northPile.size() + 1), iWidth, iHeight/2 * (northPile.size() + 1)); //NORTH pile
        }
        if(southPile.isPicked()) {
            g2d.drawRect(panelWidth/2, panelHeight/2 + iHeight, iWidth, iHeight/2 * (southPile.size() + 1)); //SOUTH pile
        }
        if(eastPile.isPicked()) {
            g2d.drawRect(panelWidth/2 + iWidth, panelHeight/2 + iHeight/8, iHeight/2 * (eastPile.size() + 1), iWidth); //EAST pile
        }
        if(westPile.isPicked()) {
            g2d.drawRect(panelWidth/2 - iHeight/2 * (westPile.size() + 1), panelHeight/2 + iHeight/8, iHeight/2 * (westPile.size() + 1), iWidth); //WEST pile
        }
        g2d.setStroke(new BasicStroke(1));

        hand.draw(g2d, 0, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
}