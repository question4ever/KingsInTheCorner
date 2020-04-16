package com.rtd.engine.card.models;

import java.util.ArrayList;
import com.rtd.engine.card.helpers.PileOfCards;

public class PileModel extends PileOfCards {
    //Maybe add x, y, rotation, width and height 
    //this would aid the view to be able to update the Pile

    //Also need to understand propertyChanged middleware a bit better
    private int xOffset;
    private int yOffset;
    private int index;

    private static final int iHeight = 84;

    public PileModel() {
        cards = new ArrayList<CardModel>(1);
    }

    public void setIndex(int i) {
        index = i;
        switch(i) {
            case 0: 
                xOffset = 0; 
                yOffset = -iHeight/2;
                break;
            case 1: 
                xOffset = iHeight/2; 
                yOffset = 0;
                break;
            case 2: 
                xOffset = 0; 
                yOffset = iHeight/2;
                break;
            case 3: 
                xOffset = -iHeight/2;
                yOffset = 0;
                break;
            case 4: 
                xOffset = iHeight/2; 
                yOffset = -iHeight/2;
                break;
            case 5: 
                xOffset = iHeight/2; 
                yOffset = iHeight/2;
                break;
            case 6: 
                xOffset = -iHeight/2; 
                yOffset = iHeight/2;
                break;
            case 7: 
                xOffset = -iHeight/2; 
                yOffset = -iHeight/2;
                break;
        }
    }

    public int getIndex() {
                      //0 1 2 3 4  5  6  7
        return index; //N E S W NE SE SW NW 
    }

    public int getXOffset() {
        return xOffset;
    }

    public int getYOffset() {
        return yOffset;
    }

    //This pile is destination and parameter is source.
    public void movePile(PileModel source) {
        ArrayList<CardModel> tmp = new ArrayList<CardModel>(source.size() + this.size());
        tmp.addAll(this.cards);
        tmp.addAll(source.cards);
        this.cards = tmp;
    }
}