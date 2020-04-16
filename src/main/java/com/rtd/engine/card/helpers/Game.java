package com.rtd.engine.card.helpers;

import java.util.ArrayList;

import com.rtd.engine.card.models.BoardModel;
import com.rtd.engine.card.models.CardModel;
import com.rtd.engine.card.models.PileModel;
import com.rtd.engine.card.models.PlayerModel;

public class Game {

    private static ArrayList<PlayerModel> pList;
    private static BoardModel board;

    private static CardModel card;
    private static PileModel pile;

    private static PlayerModel currentPlayer;

    public static void sendCommand(int opCode, Object arg) {
        switch(opCode) {
            case 0:
            drawCard();
            System.out.println("Draw card");
            break;
            case 1:
            System.out.println("Card in hand clicked");
            cardInHandClicked((CardModel)arg);
            break;
            case 2:
            System.out.println("Pile clicked");
            pileClicked((PileModel)arg);
            break;
            default:
            System.out.println("Invalid code sent from controller");
        }
    }

    private static void cardInHandClicked(CardModel c) {

    }

    //TODO write unit tests 
    private static void pileClicked(PileModel p) {
        if(pile == null) {
            p.setPicked(true);
            pile = p;
        } else {
            pile.setPicked(false);
            p.movePile(pile);
            pile.cards.clear();
            pile = null;
        }
    }

    private static void drawCard() {
        if(currentPlayer != null) {
            currentPlayer.drawCard(board.getDeck());
            currentPlayer = nextPlayer();
        }
    }
    
    public static void setBoard(BoardModel b) {
        board = b;
    }

    public static void addPlayers(ArrayList<PlayerModel> players) {
        pList = players;
    }

    private static PlayerModel nextPlayer() {
        if(currentPlayer == null) {
            return pList.get(0);
        } else if(pList.indexOf(currentPlayer) < pList.size() - 1) {
            return pList.get(pList.indexOf(currentPlayer) + 1);
        } else {
            return pList.get(0);
        }
    }
}