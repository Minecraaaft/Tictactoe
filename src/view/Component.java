package view;

import model.Logic;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

public class Component extends Applet implements Runnable {
    private static final long serialVersionUID = 1L;
    private int pixelSize = 2;
    private boolean gameEnded = false;

    // dimension holds two integers, width and height
    private Dimension size = new Dimension(700, 560);
    private Dimension pixel = new Dimension(size.width / pixelSize, size.height / pixelSize);
    private Image screen;
    private Graphics graphics;

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

        if (listener.getClickedLocation().x > 14 && listener.getClickedLocation().x < 223 && listener.getClickedLocation().y > 12 && listener.getClickedLocation().y < 176) {
            marker.addMarker(0, 0, logic.currentPlayer());
        } else if (listener.getClickedLocation().x > 238 && listener.getClickedLocation().x < 460 && listener.getClickedLocation().y > 12 && listener.getClickedLocation().y < 176) {
            marker.addMarker(0, 1, logic.currentPlayer());
        } else if (listener.getClickedLocation().x > 477 && listener.getClickedLocation().x < 684 && listener.getClickedLocation().y > 12 && listener.getClickedLocation().y < 176) {
            marker.addMarker(0, 2, logic.currentPlayer());
        }

        if (listener.getClickedLocation().x > 14 && listener.getClickedLocation().x < 223 && listener.getClickedLocation().y > 193 && listener.getClickedLocation().y < 364) {
            marker.addMarker(1, 0, logic.currentPlayer());
        } else if (listener.getClickedLocation().x > 238 && listener.getClickedLocation().x < 460 && listener.getClickedLocation().y > 193 && listener.getClickedLocation().y < 364) {
            marker.addMarker(1, 1, logic.currentPlayer());
        } else if (listener.getClickedLocation().x > 477 && listener.getClickedLocation().x < 684 && listener.getClickedLocation().y > 193 && listener.getClickedLocation().y < 364) {
            marker.addMarker(1, 2, logic.currentPlayer());
        }

        if (listener.getClickedLocation().x > 14 && listener.getClickedLocation().x < 223 && listener.getClickedLocation().y > 382 && listener.getClickedLocation().y < 542) {
            marker.addMarker(2, 0, logic.currentPlayer());
        } else if (listener.getClickedLocation().x > 238 && listener.getClickedLocation().x < 460 && listener.getClickedLocation().y > 382 && listener.getClickedLocation().y < 542) {
            marker.addMarker(2, 1, logic.currentPlayer());
        } else if (listener.getClickedLocation().x > 477 && listener.getClickedLocation().x < 684 && listener.getClickedLocation().y > 382 && listener.getClickedLocation().y < 542) {
            marker.addMarker(2, 2, logic.currentPlayer());
        }

        if (marker.isNewlyAddedMarker()) {
             if (logic.checkWin(marker.getStage())) {
                 gameEnded = true;
                 System.out.println(logic.currentPlayer() + " has won");
             } else {
                 logic.nextPlayer();
             }
        }
    }

    public void render() {
        graphics = screen.getGraphics();

        graphics.setColor(new Color(76, 180, 255));
        graphics.fillRect(0,0, pixel.width, pixel.height);
        level.render(graphics,size.width / pixelSize,size.height/ pixelSize, gameEnded);
        marker.render(graphics, gameEnded);

        graphics = getGraphics();

        graphics.drawImage(screen, 0,0, 1000, 1400, 0, 0, 500, 700, null);
        graphics.dispose();

    }

    @Override
    public void run() {
        screen = createVolatileImage(pixel.width, pixel.height);
        while (true) {

            tick();
            render();

            try {

                Thread.sleep(5);
            } catch (Exception e) { }

        }


    }
}
