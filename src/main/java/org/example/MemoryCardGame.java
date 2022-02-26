package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryCardGame {
    static int rows = 4;
    static int columns = 5;
    static ArrayList<Card> flippedCards = new ArrayList<>();
    static GameBoard gameBoard;
    static ArrayList<Card> cardSet = new ArrayList<>();
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        cardSet = getCardSet();
        gameBoard = new GameBoard(cardSet, rows, columns);
        gameBoard.setUpGUI();
        instructions(gameBoard.getFrame());
    }

    public static Card getCard(String cardValue) {
        return new Card(cardValue);
    }

    public static ArrayList<Card> getCardSet() {
        ArrayList<Card> cardSet = new ArrayList<>();
        String[] cardValues = {"ace", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
        String randomCardValue;

        //Randomly select card value and add card and its duplicate to the card set.
        for (int i = 0; i < (rows * columns) / 2; i++) {
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
                    if(flippedCards.size() < 2 && !flippedCards.contains(card)) {
                        card.flipUp();
                        flippedCards.add(card);
                        card.getButton().setEnabled(false);
                        card.getButton().setDisabledIcon(card.getButton().getIcon());

                        //Add delay to keep both cards flipped up before being flipped down or removed
                        Timer timer = new Timer(500, new TimerActionListener());
                        if(flippedCards.size() == 2) {
                            timer.setRepeats(false);
                            timer.start();

                            if(flippedCards.isEmpty()) {
                                timer.stop();
                            }
                        }
                    }
                }

            }
        });
    }

    public static class TimerActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (flippedCards.get(0).isMatch(flippedCards.get(1))) {
                flippedCards.get(0).getButton().setVisible(false);
                flippedCards.get(1).getButton().setVisible(false);
                cardSet.remove(flippedCards.get(0));
                cardSet.remove(flippedCards.get(1));

                if(cardSet.isEmpty()) {
                    System.out.println("card set is empty");
                    gameOver();
                }
                
            } else {
                flippedCards.get(0).getButton().setEnabled(true);
                flippedCards.get(1).getButton().setEnabled(true);
                flippedCards.get(0).flipDown();
                flippedCards.get(1).flipDown();
            }

            flippedCards.remove(1);
            flippedCards.remove(0);
        }
    }

    public static void gameOver() {
        JLabel label = new JLabel("<html>You Won! " +
                "<br>To play again, press New Game" +
                "<br>To close the game, press exit. <html>");

        label.setFont(new Font("Arial", Font.BOLD, 20));

        Object[] options = {"New Game", "Exit"};

        int buttonPressed = JOptionPane.showOptionDialog(gameBoard.getFrame(),
                label,
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if(buttonPressed == 0) {
            startGame();
        } else if(buttonPressed == 1) {
            gameBoard.getFrame().dispatchEvent(new WindowEvent(gameBoard.getFrame(), WindowEvent.WINDOW_CLOSING));
        }
        System.out.println(buttonPressed);
    }
}
