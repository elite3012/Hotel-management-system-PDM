package com.code.hms.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interaction {
    public Interaction(JLabel... labels) {
        for (JLabel label : labels) {
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    label.setForeground(new Color(43, 42, 38)); // Change color on hover
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setForeground(new Color(245, 242, 233)); // Reset color when not hovering
                }
            });
        }
    }
}
