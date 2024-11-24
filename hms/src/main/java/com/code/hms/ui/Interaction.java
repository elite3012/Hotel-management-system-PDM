package com.code.hms.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interaction {
    private static JButton selectedButton = null; // Tracks the currently selected button
    private final JButton button;
    private final Color colorA = new Color(43, 42, 38); // Active color
    private final Color colorB = new Color(245, 242, 233); // Inactive color

    public Interaction(JButton button, boolean isInitiallySelected) {
        this.button = button;

        // Set initial selected button if specified
        if (isInitiallySelected) {
            selectedButton = button;
            button.setForeground(colorA);
        }

        // Add mouse listener for hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (selectedButton != button) { // Only apply hover if not selected
                    button.setForeground(colorA);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (selectedButton != button) { // Only reset color if not selected
                    button.setForeground(colorB);
                }
            }
        });

        // Add action listener to manage selection state
        button.addActionListener(e -> selectButton());
    }

    private void selectButton() {
        // Only change selection if another button is clicked
        if (selectedButton != button) {
            if (selectedButton != null) {
                selectedButton.setForeground(colorB); // Reset previous button color
            }
            button.setForeground(colorA); // Set current button as selected
            selectedButton = button;
        }
    }
}
