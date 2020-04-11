package com.rtd.engine.card;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
        JPanel boardJPanel = new Board();
        mainFrame.setSize(400,400);
        mainFrame.add(boardJPanel);
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
