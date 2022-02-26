package org.example;

import javax.swing.*;

public class Card extends JButton {
    private String value;
    private ImageIcon back;
    private ImageIcon front;
    private JButton button;

    public Card(String value) {
        this.value = value;
        this.back = new ImageIcon("cards/back.png");
        this.front = new ImageIcon("cards/" + this.value + ".png");
        this.button = new JButton(this.back);
    }

    public String getValue() {
        return this.value;
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
        if(this.getFront().toString().equals(comparedCard.getFront().toString())) {
            return true;
        } else {
            return false;
        }
    }
}


