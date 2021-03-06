package view;

import model.Logic;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

public class Component extends Applet implements Runnable {
    private static final long serialVersionUID = 1L;
    private boolean gameEnded = false;

    // dimension holds two integers, width and height
    private Dimension size = new Dimension(700, 560);
    private Image screen;

    private Level level = new Level();
    private Marker marker = new Marker();
    private ClickListener listener = new ClickListener();

    private Logic logic;

    public Component(Logic logic) {
        this.logic = logic;
        setPreferredSize(size);
        addMouseListener(listener);
    }

    @Override
    public void start() {
        JFrame jFrame = new JFrame();

        // adds component to the screen
        jFrame.add(this);
        // Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
        jFrame.pack();
        jFrame.setTitle("Tic Tac Toe");
        // shows the page
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        // sets the screen in the middle
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // calls run method on Component
        new Thread(this).start();
    }

    public void tick() {

        // puts a marker on the square that the use clicks on
        if (listener.getClickedLocation().x > 14 && listener.getClickedLocation().x < 223 && listener.getClickedLocation().y > 12 && listener.getClickedLocation().y < 176) {
            logic.addMarker(0, 0, logic.currentPlayer());
            marker.addMarker(0, 0, logic.currentPlayer());
        } else if (listener.getClickedLocation().x > 238 && listener.getClickedLocation().x < 460 && listener.getClickedLocation().y > 12 && listener.getClickedLocation().y < 176) {
            logic.addMarker(0, 1, logic.currentPlayer());
            marker.addMarker(0, 1, logic.currentPlayer());
        } else if (listener.getClickedLocation().x > 477 && listener.getClickedLocation().x < 684 && listener.getClickedLocation().y > 12 && listener.getClickedLocation().y < 176) {
            logic.addMarker(0, 2, logic.currentPlayer());
            marker.addMarker(0, 2, logic.currentPlayer());
        }

        if (listener.getClickedLocation().x > 14 && listener.getClickedLocation().x < 223 && listener.getClickedLocation().y > 193 && listener.getClickedLocation().y < 364) {
            logic.addMarker(1, 0, logic.currentPlayer());
            marker.addMarker(1, 0, logic.currentPlayer());
        } else if (listener.getClickedLocation().x > 238 && listener.getClickedLocation().x < 460 && listener.getClickedLocation().y > 193 && listener.getClickedLocation().y < 364) {
            logic.addMarker(1, 1, logic.currentPlayer());
            marker.addMarker(1, 1, logic.currentPlayer());
        } else if (listener.getClickedLocation().x > 477 && listener.getClickedLocation().x < 684 && listener.getClickedLocation().y > 193 && listener.getClickedLocation().y < 364) {
            logic.addMarker(1, 2, logic.currentPlayer());
            marker.addMarker(1, 2, logic.currentPlayer());
        }

        if (listener.getClickedLocation().x > 14 && listener.getClickedLocation().x < 223 && listener.getClickedLocation().y > 382 && listener.getClickedLocation().y < 542) {
            logic.addMarker(2, 0, logic.currentPlayer());
            marker.addMarker(2, 0, logic.currentPlayer());
        } else if (listener.getClickedLocation().x > 238 && listener.getClickedLocation().x < 460 && listener.getClickedLocation().y > 382 && listener.getClickedLocation().y < 542) {
            logic.addMarker(2, 1, logic.currentPlayer());
            marker.addMarker(2, 1, logic.currentPlayer());
        } else if (listener.getClickedLocation().x > 477 && listener.getClickedLocation().x < 684 && listener.getClickedLocation().y > 382 && listener.getClickedLocation().y < 542) {
            logic.addMarker(2, 2, logic.currentPlayer());
            marker.addMarker(2, 2, logic.currentPlayer());
        }

        if (marker.isNewlyAddedMarker()) {
             if (logic.isGameOver()) {
                 gameEnded = true;
             } else {
                 logic.nextPlayer();
             }
        }
    }

    public void render() {
        Graphics graphics = screen.getGraphics();

        level.render(graphics, 355, 285, gameEnded);
        marker.render(graphics, gameEnded);

        graphics = getGraphics();

        graphics.drawImage(screen, 0,0, 1000, 1400, 0, 0, 500, 700, null);
        graphics.dispose();
    }

    @Override
    public void run() {
        screen = createVolatileImage(355, 285);
        while (true) {
            tick();
            render();

            try {
                Thread.sleep(5);
            } catch (Exception e) { }
        }
    }
}
