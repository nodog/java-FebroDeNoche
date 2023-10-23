package net.konfuzo.febrodenoche;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FebroDeNoche {
    public static void main(String[] args) throws IOException {
        int height = 1000;
        int width = 1000;
        RenderEngine renderEngine = new RECircus();
        BufferedImage image = renderEngine.drawImage(width, height);
        // Save as JPEG
        File file = new File("myimage.jpg");
        ImageIO.write(image, "jpg", file);
    }
}