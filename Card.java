// File   : GUI-lowlevel/cards1/cards/Card.java
// Purpose: Represents one card.
// Author : Fred Swartz - February 19, 2007 - Placed in public domain.
//
// Enhancements:
//          * Needs to have Suit and Face value.

package cards;

import java.awt.*;
import javax.swing.*;

/////////////////////////////////////////////////////////////////////////// Card
class Card {
    //=================================================================== fields
    private ImageIcon _image;
    private int       _x;
    private int       _y;

    //============================================================== constructor
    public Card(ImageIcon image, int x, int y) {
        _image = image;
    }

    //=================================================================== moveTo


    //================================================================= contains
    public boolean contains(int x, int y) {
        return (x > _x && x < (_x + getWidth()) &&
                y > _y && y < (_y + getHeight()));
    }

    //================================================================= getWidth
    public int getWidth() {
        return _image.getIconWidth();
    }

    //================================================================ getHeight
    public int getHeight() {
        return _image.getIconHeight();
    }

    //===================================================================== getX
    public int getX() {
        return _x;
    }

    //===================================================================== getY
    public int getY() {
        return _x;
    }

    //===================================================================== draw
    public void draw(Graphics g, Component c, int x, int y) {
        _image.paintIcon(c, g, x, y);
    }
}
