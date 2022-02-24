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
}


