package com.code.hms.ui;

import javax.swing.*;
import java.awt.*;

public class CustomerUI {
    public static class HotelInfoGUI {
        static JFrame frame;
        static JPanel panel;
        static JLabel HotelInfoTab;
        static JLabel RoomTab;
        static JLabel ServiceTab;
        static JLabel ReviewTab;

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

            // ServiceTab setup
            ServiceTab = new JLabel("SERVICE BOOKING");
            ServiceTab.setFont(new Font("Mulish", Font.BOLD, 25));
            ServiceTab.setBounds(35, 245, 239, 60);
            ServiceTab.setForeground(new Color(43, 42, 38));
            panel.add(ServiceTab);

            // ReviewTab setup
            ReviewTab = new JLabel("REVIEW");
            ReviewTab.setFont(new Font("Mulish", Font.BOLD, 25));
            ReviewTab.setBounds(35, 295, 100, 60);
            ReviewTab.setForeground(new Color(43, 42, 38));
            panel.add(ReviewTab);
        }
    }
}
