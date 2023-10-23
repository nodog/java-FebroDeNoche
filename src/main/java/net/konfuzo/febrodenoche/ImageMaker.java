package net.konfuzo.febrodenoche;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import static javax.swing.text.StyleConstants.setBackground;

public class ImageMaker extends JPanel
{
    int width, height;
    BufferedImage image;

    public ImageMaker()
    {
        width = 120;
        height = 120;
        createImage();
        setBackground(Color.black);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        int x = (w - width)/2;
        int y = (h - height)/2;
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);
        g2.drawRenderedImage(image, at);
    }

    /**
     * Here's how you make an image
     */
    private void createImage()
    {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
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
        g2.dispose();
    }
}
