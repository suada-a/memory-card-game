package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class MemoryCardGame {
    public static void main(String[] args) {
        ArrayList<Card> cardSet = getCardSet();
        GameBoard gameBoard = new GameBoard(cardSet, 4, 5);
        gameBoard.setUpGUI();
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

        for (int i = 0; i < 10; i++) {
            randomCardValue = cardValues[(int) (Math.random() * cardValues.length)];
            Card card = getCard(randomCardValue);
            Card duplicateCard = getCard(randomCardValue);
            cardSet.add(i, card);
            cardSet.add(i + 1, duplicateCard);
        }

        Collections.shuffle(cardSet);
        return cardSet;
    }
}
