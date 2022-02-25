package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryCardGame {
    static int flippedCards = 0;
    static int matchedPairs = 0;

    public static void main(String[] args) {
        ArrayList<Card> cardSet = getCardSet();
        GameBoard gameBoard = new GameBoard(cardSet, 4, 5);
        gameBoard.setUpGUI();
        instructions(gameBoard.getFrame());
    }

    public static Card getCard(String cardValue) {
        final Card card = new Card(cardValue);
        return card;
    }

    public static ArrayList<Card> getCardSet() {
        ArrayList<Card> cardSet = new ArrayList<>();
        String[] cardValues = {"ace", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
        String randomCardValue = "";

        //Randomly select card value and add card and its duplicate to the card set.
        for (int i = 0; i < 10; i++) {
            randomCardValue = cardValues[(int) (Math.random() * cardValues.length)];
            Card card = getCard(randomCardValue);
            CardListener(card);
            Card duplicateCard = getCard(randomCardValue);
            CardListener(duplicateCard);
            cardSet.add(i, card);
            cardSet.add(i + 1, duplicateCard);
        }

        Collections.shuffle(cardSet);
        return cardSet;
    }

    public static void instructions(JFrame frame) {
        JLabel label = new JLabel("<html>To play, flip over any two cards. " +
                "<br>If the cards match, " +
                "<br>they get taken off the board. " +
                "<br>if the cards don't match, " +
                "<br>he cards will flip back over. " +
                "<br>To win, you must match all 10 pairs.<html>");

        label.setFont(new Font("Arial", Font.BOLD, 20));
        JOptionPane.showMessageDialog(frame,
                label,
                "Memory Game Instructions",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void CardListener(final Card card) {
        card.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == card.getButton()) {
                    card.flipCard();
                }
            }
        });
    }
}
