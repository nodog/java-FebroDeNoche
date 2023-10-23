package net.konfuzo;

import javax.swing.*;

public class FebroDeNoche {
    public static void main(String[] args) {
        ImageMaker imageMaker = new ImageMaker();
        ImageSaver imageSaver = new ImageSaver(imageMaker);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(imageSaver.getUIPanel(), "North");
        f.getContentPane().add(imageMaker);
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}