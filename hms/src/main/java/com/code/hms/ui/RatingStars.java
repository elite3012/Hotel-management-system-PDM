package com.code.hms.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;

class RatingStars extends JPanel {
    private final int starCount = 5; // Number of stars
    private final int starSize = 50; // Size of each star
    private int selectedRating = 0;  // Current selected rating
    private int hoveredRating = -1;  // Current hovered rating

    public RatingStars() {
        setPreferredSize(new Dimension((starSize + 10) * starCount, starSize + 20));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int clickedStar = e.getX() / (starSize + 30);
                if (clickedStar < starCount) {
                    selectedRating = clickedStar + 1;
                    repaint();
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                hoveredRating = e.getX() / (starSize + 30);
                if (hoveredRating >= starCount) hoveredRating = -1;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoveredRating = -1; // Reset hover when mouse leaves
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 0; i < starCount; i++) {
            int x = i * (starSize + 30); // Position each star
            int y = 10; // Fixed vertical position

            // Determine the color for each star
            if (i < selectedRating) {
                g2d.setColor(Color.YELLOW); // Selected stars
            } else {
                g2d.setColor(Color.GRAY); // Unselected stars
            }

            // Draw the star
            g2d.fill(createStarShape(x + starSize / 2, y + starSize / 2, starSize / 2, starSize / 4));
        }
    }

    // Helper method to create a star shape
    private Shape createStarShape(double centerX, double centerY, double outerRadius, double innerRadius) {
        GeneralPath star = new GeneralPath();
        int points = 5;
        double angleStep = Math.PI / points;

        for (int i = 0; i < points * 2; i++) {
            double angle = i * angleStep - Math.PI / 2; // Start at top
            double radius = (i % 2 == 0) ? outerRadius : innerRadius;
            double x = centerX + Math.cos(angle) * radius;
            double y = centerY + Math.sin(angle) * radius;
            if (i == 0) {
                star.moveTo(x, y);
            } else {
                star.lineTo(x, y);
            }
        }
        star.closePath();
        return star;
    }

    public void resetRating() {
        selectedRating = 0; // Reset selected rating to 0
        repaint(); // Repaint to update the visual representation
    }

    public int getSelectedRating() {
        return selectedRating;
    }
}
