package com.code.hms.loginwindow;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LoadImage {
    private BufferedImage image;

    public LoadImage(String path, int width, int height) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new IllegalArgumentException("File not found: " + path);
            }

            image = ImageIO.read(file);
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.drawImage(scaledImage, 0, 0, null);
            g2d.dispose();
        } catch (IOException e) {
            System.err.println("Error loading image from path: " + path);
            e.printStackTrace();
        }
    }

    public ImageIcon getImageIcon() {
        return new ImageIcon(image);
    }
}
