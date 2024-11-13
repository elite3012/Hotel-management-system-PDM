package com.code.hms.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interaction {public Interaction(JLabel roomTab, JLabel serviceTab, JLabel reviewTab) {
    // Add mouse listener to RoomTab
    roomTab.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            roomTab.setForeground(new Color(245, 242, 233)); // Change color on hover
        }

        @Override
        public void mouseExited(MouseEvent e) {
            roomTab.setForeground(new Color(43, 42, 38)); // Reset color when not hovering
        }
    });
    serviceTab.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            serviceTab.setForeground(new Color(245, 242, 233)); // Change color on hover
        }

        @Override
        public void mouseExited(MouseEvent e) {
            serviceTab.setForeground(new Color(43, 42, 38)); // Reset color when not hovering
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // Optionally handle click events here
        }
    });
    reviewTab.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            reviewTab.setForeground(new Color(245, 242, 233)); // Change color on hover
        }

        @Override
        public void mouseExited(MouseEvent e) {
            reviewTab.setForeground(new Color(43, 42, 38)); // Reset color when not hovering
        }
    });
    }
}
