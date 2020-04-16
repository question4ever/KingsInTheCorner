package com.rtd.engine.card;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.rtd.engine.card.controllers.BoardController;
import com.rtd.engine.card.helpers.Game;
import com.rtd.engine.card.models.BoardModel;
import com.rtd.engine.card.views.BoardView;
import com.rtd.engine.card.views.HandView;

/**
 * Main entry point of game engine 
 *
 */
public class App
{
    private final String message = "Hello World!";

    public App() {

    }

    public static void createAndShowGUI(){
        JFrame mainFrame = new JFrame("Card Game Engine");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel boardJPanel = new JPanel();

        BoardModel bm = new BoardModel();
        BoardView board = new BoardView(bm);
        board.addMouseListener(new BoardController(bm, board));
        board.setVisible(true);

        JButton button = new JButton("Test");
        boardJPanel.add(button);
        boardJPanel.add(board);

        mainFrame.setSize(600,300);

        mainFrame.add(boardJPanel);
        Game.setBoard(bm);

        mainFrame.setVisible(true);
    }
    public static void main( String[] args )
    {
        System.out.println( new App().getMessage());
        createAndShowGUI();
    }

    public final String getMessage(){
        return message;
    }
}