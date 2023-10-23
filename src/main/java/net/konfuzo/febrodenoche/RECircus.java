package net.konfuzo.febrodenoche;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class RECircus implements RenderEngine {
    @Override
    public BufferedImage drawImage(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.magenta);
        g2.fillRect(0, 0, width, height);
        g2.setPaint(Color.red);
        int cx = width/2;
        int cy = height/2;
        int dia = width*3/4;
        Ellipse2D e = new Ellipse2D.Double(cx - dia/2, cy - dia/2, dia, dia);
        g2.fill(e);
        g2.draw(e);
        g2.setColor(Color.black);
        g2.fillOval(0, 0, width/3, height/4);
        g2.dispose();
        return image;
    }
}
