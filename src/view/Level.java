package view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Level {
    private BufferedImage stageLevel;
    private BufferedImage endPage;

    public Level() {
        try {
            stageLevel = ImageIO.read(new File("res/stagelevel.png"));
            endPage = ImageIO.read(new File("res/tictactoewinners.png"));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void render(Graphics graphics, int x, int y, boolean gameEnded) {
        if (gameEnded) {
            graphics.drawImage(endPage, 0, 0, x, y,0, 200, 120, 270,null);
        } else {
            graphics.drawImage(stageLevel, 0, 0, x, y,0, 0, 50, 50,null);
        }

    }
}
