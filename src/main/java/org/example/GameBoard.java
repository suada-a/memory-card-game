package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameBoard extends JFrame {
    private JFrame frame;
    private ArrayList<Card> cardSet;
    private int rows;
    private int columns;

    public GameBoard(ArrayList<Card> cardSet, int rows, int columns) {
        this.frame = new JFrame("Memory Game");
        this.cardSet = cardSet;
        this.rows = rows;
        this.columns = columns;
    }

    public void setUpGUI() {
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setVisible(true);
        this.populateBoard();
        this.frame.setLayout(new GridLayout(this.rows, this.columns));
        this.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void populateBoard() {
        for(Card card : cardSet) {
            this.frame.add(card.getButton());
        }
    }
}
