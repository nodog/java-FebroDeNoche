package net.konfuzo.febrodenoche;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

class ImageSaver
{
    ImageMaker imageMaker;

    public ImageSaver(ImageMaker im)
    {
        imageMaker = im;
    }

    public JPanel getUIPanel()
    {
        JButton save = new JButton("save");
        save.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    ImageIO.write(imageMaker.image, "png", new File("example.png"));
                }
                catch(IOException ioe)
                {
                    System.out.println("write: " + ioe.getMessage());
                }
            }
        });
        JPanel panel = new JPanel();
        panel.add(save);
        return panel;
    }
}