package com.code.hms.ui;

import com.code.hms.entities.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class CustomerUI {
        static JFrame frame;
        static JPanel panel;
        static JButton OurHotelTab;
        static JButton RoomTab;
        static JButton ServiceTab;
        static JButton ReviewTab;
        static JLabel Tab1_background;
        static JLabel Tab2_background;
        static JLabel Tab3_background;
        static JLabel Tab4_background;

        public CustomerUI() {
            createMainGUI();
        }

        private void createMainGUI() {
            // Frame setup
            frame = new JFrame();
            frame.setSize(1280, 672);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setResizable(true);

            // Panel setup
            panel = new JPanel();
            panel.setLayout(null);
            frame.getContentPane().add(panel);

            // HotelInfoTab setup
            HotelInfoTab = new JLabel("OUR HOTEL");
            HotelInfoTab.setFont(new Font("Mulish", Font.BOLD, 23));
            HotelInfoTab.setBounds(32, 115, 235, 33);
            panel.add(HotelInfoTab);

            //RoomTab setup
            RoomTab = new JLabel("ROOM BOOKING");
            RoomTab.setFont(new Font("Mulish", Font.BOLD, 23));
            RoomTab.setBounds(32, 162, 235, 33);
            RoomTab.setForeground(new Color(245, 242, 233));
            panel.add(RoomTab);

            // ServiceTab setup
            ServiceTab = new JLabel("SERVICE BOOKING");
            ServiceTab.setFont(new Font("Mulish", Font.BOLD, 23));
            ServiceTab.setBounds(32, 209, 235, 33);
            ServiceTab.setForeground(new Color(245, 242, 233));
            panel.add(ServiceTab);

            // ReviewTab setup
            ReviewTab = new JLabel("REVIEW");
            ReviewTab.setFont(new Font("Mulish", Font.BOLD, 23));
            ReviewTab.setBounds(32, 256, 235, 33);
            ReviewTab.setForeground(new Color(245, 242, 233));
            panel.add(ReviewTab);

            new Interaction(RoomTab, ServiceTab, ReviewTab);

            // Tab1_background
            Tab1_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab1_BG.png", 1280, 672));
            Tab1_background.setBounds(0, 0, 1280, 672);
            panel.add(Tab1_background);

            Tab2_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab2_BG.png", 1280, 672));
            Tab2_background.setBounds(0, 0, 1280, 672);
            panel.add(Tab2_background);

            Tab3_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab3_BG.png", 1280, 672));
            Tab3_background.setBounds(0, 0, 1280, 672);
            panel.add(Tab3_background);

            Tab4_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab4_BG.png", 1280, 672));
            Tab4_background.setBounds(0, 0, 1280, 672);
            panel.add(Tab4_background);

            // Make frame visible
            frame.setVisible(true);

        }
    }
