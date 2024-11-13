package com.code.hms.ui;

import javax.swing.*;
import java.awt.*;

public class CustomerUI {
    public static class HotelInfoGUI {
        static JFrame frame;
        static JPanel panel;
        static JLabel HotelInfoTab;
        static JLabel RoomTab;

        public HotelInfoGUI() {
            createMainGUI();
        }

        private void createMainGUI() {
            // Frame setup
            frame = new JFrame();
            frame.setSize(1440, 900);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setResizable(true);

            // Panel setup
            panel = new JPanel();
            panel.setLayout(null);
            frame.getContentPane().add(panel);

            // HotelInfoTab setup
            HotelInfoTab = new JLabel("OUR HOTEL");
            HotelInfoTab.setFont(new Font("Mulish", Font.BOLD, 25));
            HotelInfoTab.setBounds(35, 145, 250, 60);
            panel.add(HotelInfoTab);

            //RoomTab setup
            RoomTab = new JLabel("ROOM BOOKING");
            RoomTab.setFont(new Font("Mulish", Font.BOLD, 25));
            RoomTab.setBounds(35, 195, 210, 60);
            RoomTab.setForeground(new Color(43, 42, 38));
            panel.add(RoomTab);
        }
    }
}
