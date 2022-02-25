package org.example;

import org.junit.Test;
import javax.swing.*;
import static org.junit.Assert.*;

public class MemoryCardGameTest {

    @Test
    public void flipCardUp() {
        Card card = new Card("ace");
        card.flipCard();
        ImageIcon ace = new ImageIcon("cards/ace.png");
        assertEquals(ace.toString(), card.getButton().getIcon().toString());
    }

    @Test
    public void flipCardDown() {
        Card card = new Card("ace");
        ImageIcon back = new ImageIcon("cards/back.png");
        assertEquals(back.toString(), card.getButton().getIcon().toString());
    }
}
