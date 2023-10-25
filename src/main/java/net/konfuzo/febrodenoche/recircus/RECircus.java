package net.konfuzo.febrodenoche.recircus;

import net.konfuzo.febrodenoche.RenderEngine;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RECircus implements RenderEngine {
    final private Graphics2D g2;
    final private int imgWidth;
    final private int imgHeight;

    public RECircus(Graphics2D g2, int width, int height) {
        this.g2 = g2;
        this.imgWidth = width;
        this.imgHeight = height;
    }

    @Override
    public void drawImage() {
        g2.setPaint(Color.black);
        g2.fillRect(0, 0, imgWidth, imgHeight);

        this.drawSpiral();

        for (float fi = 0.0f; fi <= 1.01f; fi += 1.0f/100f) {
            float bright = (1.0f - fi)/2.0f;
            g2.setPaint(Color.getHSBColor(0.4f, 1.0f, bright));
            int cx = (int)(fi*imgWidth);
            int cy = 0;
            int dia = (int)(fi*imgWidth/2.0);
            Ellipse2D e = new Ellipse2D.Double(cx - dia/2.0, cy - dia/2.0, dia, dia);
            g2.fill(e);
            g2.draw(e);
            g2.setPaint(Color.getHSBColor(0.24f, 1.0f, bright));
            cx = imgWidth;
            cy = (int)(fi*imgWidth);
            e = new Ellipse2D.Double(cx - dia/2.0, cy - dia/2.0, dia, dia);
            g2.fill(e);
            g2.draw(e);
            g2.setPaint(Color.getHSBColor(0.2f, 1.0f, bright));
            cx = (int)((1.0 - fi)*imgWidth);
            cy = imgHeight;
            e = new Ellipse2D.Double(cx - dia/2.0, cy - dia/2.0, dia, dia);
            g2.fill(e);
            g2.draw(e);
            g2.setPaint(Color.getHSBColor(0.17f, 1.0f, bright));
            cx = 0;
            cy = (int)((1.0-fi)*imgWidth);
            e = new Ellipse2D.Double(cx - dia/2.0, cy - dia/2.0, dia, dia);
            g2.fill(e);
            g2.draw(e);
            //g2.setColor(Color.black);
            //g2.fillOval(0, 0, width/3, height/4);
        }
    }

    private void drawSpiral() {

        for (double iD = 0.0; iD < Math.PI*12.0; iD += 0.1) {
            double cx = imgWidth/2.0;
            double cy = imgHeight/2.0;
            double r = iD*10.0;
            double x = cx + r*Math.cos(iD);
            double y = cy + r*Math.sin(iD);
            Ellipse2D e = new Ellipse2D.Double(x,y,iD,iD);
            g2.setPaint(Color.getHSBColor(0.83f, 1.0f, 0.5f));
            g2.fill(e);
            g2.draw(e);
        }
    }
}
