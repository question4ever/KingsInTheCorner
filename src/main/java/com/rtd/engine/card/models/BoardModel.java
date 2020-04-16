package com.rtd.engine.card.models;

import java.util.ArrayList;

public class BoardModel {
    private ArrayList<PileModel> piles;
    private DeckModel dm;

    private static final int kingsIndexStart = 4;
    private static final int halfCardHeight = 42;

    public static enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST,
        NE,
        SE,
        SW,
        NW
    }

    public BoardModel() {
        initBoard();
    }

    /*
    * Initalized the board wth 8 piles allocated but only the first four used
    * These are the cardinal piles 
    * The last four are the king piles and are in the order
    *   - NE SE SW NW 
    */
    private void initBoard() {
        piles = new ArrayList<PileModel>(8); //N E S W NE_King SE_King SW_King NW_King
        dm = new DeckModel();
        for(int i = 0; i < 8; i++) {
            PileModel p = new PileModel();
            p.setIndex(i);
            if(i < kingsIndexStart) {
                p.addCard(dm.getRandomCard());
            }
            piles.add(p);
        }
    }

    public PileModel getPile(Direction d) {
        return piles.get(d.ordinal());
    }

    public int getHeight() {
        int nPileSize = piles.get(0).size() + 1; //north pile size
        int sPileSize = piles.get(2).size() + 1; //south pile size
        return (nPileSize + sPileSize ) * halfCardHeight + 84; 
    }

    public int getWidth() {
        int ePileSize = piles.get(1).size() + 1; //east pile size
        int wPileSize = piles.get(3).size() + 1; //west pile size
        return (ePileSize + wPileSize) * halfCardHeight + 62; 
    }

    public void setDeck(DeckModel deck) {
        dm = deck;
    }

    public DeckModel getDeck() {
        return dm;
    }
}