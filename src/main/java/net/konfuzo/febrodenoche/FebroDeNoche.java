package net.konfuzo.febrodenoche;

import net.konfuzo.febrodenoche.recircus.RECircus;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FebroDeNoche {
    public static void main(String[] args) throws IOException {
        int height = 1000;
        int width = 1000;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        RenderEngine renderEngine = new RECircus(g2, width, height);
        renderEngine.drawImage();
        g2.dispose();
        // Save as JPEG
        File file = new File("myimage.jpg");
        ImageIO.write(image, "jpg", file);
    }
}