package view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Marker {
    private boolean newlyAddedMarker;
    private BufferedImage markers;
    private String[][] stage = {
                    {"", "", ""},
                    {"", "", ""},
                    {"", "", ""},
    };
    private String lastMarker;

    public Marker() {
        try {
            markers = ImageIO.read(new File("res/minecraftMarkers.png"));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void addMarker(int row, int column, String marker) {
        if (stage[row][column].equals("")) {
            stage[row][column] = marker;
            lastMarker = marker;
            newlyAddedMarker = true;
        } else {
            newlyAddedMarker = false;
        }
    }

    public String[][] getStage() {
        return stage;
    }

    public boolean isNewlyAddedMarker() {
        return newlyAddedMarker;
    }

    public void render(Graphics graphics, boolean gameEnded) {
        if (gameEnded) {
            if (lastMarker.equals("x")) {
                graphics.drawImage(markers, 12 + 115, 15 + 95, 100 + 115, 80 + 95,0, 384, 16, 400,null);
            } else {
                graphics.drawImage(markers, 12 + 115, 15 + 95, 100 + 115, 80 + 95,18, 384, 36, 400,null);
            }

        } else {
            for (int i = 0; i < stage.length; i++) {
                for (int j = 0; j < stage[0].length; j++) {
                    if (stage[i][j] == "x") {
                        graphics.drawImage(markers, 12 + j * 115, 15 + i * 95, 100 + j * 115, 80 + i * 95,0, 384, 16, 400,null);
                    } else if (stage[i][j] == "o") {
                        graphics.drawImage(markers, 12 + j * 115, 15 + i * 95, 100 + j * 115, 80 + i * 95,18, 384, 36, 400,null);
                    }
                }
            }
        }

    }
}
