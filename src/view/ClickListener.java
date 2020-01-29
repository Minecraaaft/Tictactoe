package view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickListener implements MouseListener {
    private Point clickedLocation = new Point();

    @Override
    public void mouseClicked(MouseEvent e) {
        clickedLocation.setLocation(e.getX(), e.getY());
    }

    public Point getClickedLocation() {
        return clickedLocation;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
