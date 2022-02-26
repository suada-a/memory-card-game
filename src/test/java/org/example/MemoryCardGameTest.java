package org.example;

import org.junit.Test;
import javax.swing.*;
import static org.junit.Assert.*;

public class MemoryCardGameTest {

    @Test
    public void flipCardUp() {
        Card card = new Card("ace");
        card.flipUp();
        ImageIcon ace = new ImageIcon("cards/ace.png");
        assertEquals(ace.toString(), card.getButton().getIcon().toString());
    }

    @Test
    public void flipCardDown() {
        Card card = new Card("ace");
        ImageIcon back = new ImageIcon("cards/back.png");
        assertEquals(back.toString(), card.getButton().getIcon().toString());
    }

    @Test
    public void match() {
        Card card = new Card("two");
        Card card2 = new Card("two");
        assertEquals(true, card.isMatch(card2));
    }

    @Test
    public void notAMatch() {
        Card card = new Card("ace");
        Card card2 = new Card("two");
        assertEquals(false, card.isMatch(card2));
    }
}
