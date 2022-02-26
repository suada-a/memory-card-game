package org.example;

import javax.swing.*;

public class Card extends JButton {
    private final ImageIcon back;
    private final ImageIcon front;
    private final JButton button;

    public Card(String value) {
        this.back = new ImageIcon("cards/back.png");
        this.front = new ImageIcon("cards/" + value + ".png");
        this.button = new JButton(this.back);
    }

    public ImageIcon getBack() {
        return back;
    }

    public ImageIcon getFront() {
        return front;
    }

    public JButton getButton() {
        return button;
    }

    public void flipUp() {
        if (this.getButton().getIcon() == this.getBack()) {
            this.getButton().setIcon(this.getFront());
        }
    }

    public void flipDown() {
        if (this.getButton().getIcon() == this.getFront()) {
            this.getButton().setIcon(this.getBack());
        }
    }

    public boolean isMatch(Card comparedCard) {
        return this.getFront().toString().equals(comparedCard.getFront().toString());
    }
}


