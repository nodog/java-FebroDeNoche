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
        g2.setPaint(Color.black);
        g2.fillRect(0, 0, width, height);

        for (float fi = 0.0f; fi <= 1.01f; fi += 1.0f/100f) {
            float bright = (1.0f - fi)/2.0f;
            g2.setPaint(Color.getHSBColor(0.4f, 1.0f, bright));
            int cx = (int)(fi*width);
            int cy = 0;
            int dia = (int)(fi*width/2.0);
            Ellipse2D e = new Ellipse2D.Double(cx - dia/2, cy - dia/2, dia, dia);
            g2.fill(e);
            g2.draw(e);
            g2.setPaint(Color.getHSBColor(0.24f, 1.0f, bright));
            cx = width;
            cy = (int)(fi*width);
            e = new Ellipse2D.Double(cx - dia/2, cy - dia/2, dia, dia);
            g2.fill(e);
            g2.draw(e);
            g2.setPaint(Color.getHSBColor(0.2f, 1.0f, bright));
            cx = (int)((1.0 - fi)*width);
            cy = height;
            e = new Ellipse2D.Double(cx - dia/2, cy - dia/2, dia, dia);
            g2.fill(e);
            g2.draw(e);
            g2.setPaint(Color.getHSBColor(0.17f, 1.0f, bright));
            cx = 0;
            cy = (int)((1.0-fi)*width);
            e = new Ellipse2D.Double(cx - dia/2, cy - dia/2, dia, dia);
            g2.fill(e);
            g2.draw(e);
            //g2.setColor(Color.black);
            //g2.fillOval(0, 0, width/3, height/4);
        }
        g2.dispose();
        return image;
    }
}
