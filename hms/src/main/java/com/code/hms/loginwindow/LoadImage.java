package com.code.hms.loginwindow;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LoadImage {
    private BufferedImage image;

    public LoadImage(String path, int width, int height) {
        try {
            // Load and resize the image to fit the specified width and height
            image = ImageIO.read(new File(path));
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            g2d.drawImage(scaledImage, 0, 0, null);
            g2d.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get the image as an icon
    public ImageIcon getImageIcon() {
        return new ImageIcon(image);
    }
}