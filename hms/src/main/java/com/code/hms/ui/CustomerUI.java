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
        static JLabel ServiceMenu;
        static JButton Spa;
        static JButton Restaurant;
        static JButton RoomCleaning;
        static JButton MusicLounge;

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
            OurHotelTab = new JButton();
            OurHotelTab.setFocusable(false);
            OurHotelTab.setBackground(new Color(244, 242, 235));
            OurHotelTab.setBorderPainted(false);
            OurHotelTab.setText("OUR HOTEL");
            OurHotelTab.setFont(new Font("Mulish", Font.BOLD, 21));
            OurHotelTab.setBounds(16, 115, 235, 33);
            OurHotelTab.setForeground(new Color(43, 42, 38));
            OurHotelTab.setHorizontalTextPosition(SwingConstants.LEFT);
            OurHotelTab.setHorizontalAlignment(SwingConstants.LEFT);
            OurHotelTab.setVisible(true);
            new Interaction(OurHotelTab,true);
            panel.add(OurHotelTab);
            OurHotelTab.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Tab1_background.setVisible(true);
                    Tab2_background.setVisible(false);
                    Tab3_background.setVisible(false);
                    Tab4_background.setVisible(false);
                    ServiceMenu.setVisible(false);
                    Spa.setVisible(false);
                    Restaurant.setVisible(false);
                    RoomCleaning.setVisible(false);
                    OurHotelTab.setBackground(new Color(244, 242, 235));
                    RoomTab.setBackground(new Color(132, 121, 102));
                    ServiceTab.setBackground(new Color(132, 121, 102));
                    ReviewTab.setBackground(new Color(132,121, 102));
                    OurHotelTab.setForeground(new Color(43, 42, 38));
                    RoomTab.setForeground(new Color(245, 242, 233));
                    ServiceTab.setForeground(new Color(245, 242, 233));
                    ReviewTab.setForeground(new Color(245, 242,233));
                }
            });

            // ReservationTab setup
            RoomTab = new JButton();
            RoomTab.setFocusable(false);
            RoomTab.setBackground(new Color(132, 121, 102));
            RoomTab.setBorderPainted(false);
            RoomTab.setText("ROOM BOOKING");
            RoomTab.setFont(new Font("Mulish", Font.BOLD, 21));
            RoomTab.setBounds(16, 162, 235, 33);
            RoomTab.setForeground(new Color(245, 242, 233));
            RoomTab.setHorizontalTextPosition(SwingConstants.LEFT);
            RoomTab.setHorizontalAlignment(SwingConstants.LEFT);
            RoomTab.setVisible(true);
            new Interaction(RoomTab,false);
            panel.add(RoomTab);
            RoomTab.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Tab1_background.setVisible(false);
                    Tab2_background.setVisible(true);
                    Tab3_background.setVisible(false);
                    Tab4_background.setVisible(false);
                    ServiceMenu.setVisible(false);
                    Spa.setVisible(false);
                    Restaurant.setVisible(false);
                    RoomCleaning.setVisible(false);
                    OurHotelTab.setBackground(new Color(132, 121, 102));
                    RoomTab.setBackground(new Color(244, 242, 235));
                    ServiceTab.setBackground(new Color(132, 121, 102));
                    ReviewTab.setBackground(new Color(132, 121,102));
                    RoomTab.setForeground(new Color(43, 42, 38));
                    OurHotelTab.setForeground(new Color(245, 242, 233));
                    ServiceTab.setForeground(new Color(245, 242, 233));
                    ReviewTab.setForeground(new Color(245,242,233));
                }
            });

            // ReservationTab setup
            ServiceMenu = new JLabel();
            ServiceMenu.setText("SERVICE MENU");
            ServiceMenu.setFont(new Font("Mulish", Font.BOLD, 33));
            ServiceMenu.setBounds(310, 20, 300, 33);
            ServiceMenu.setForeground(new Color(212, 158, 24));
            ServiceMenu.setVisible(false);
            panel.add(ServiceMenu);

            Spa = new JButton();
            Spa.setFocusable(false);
            Spa.setBackground(new Color(217, 217, 217));
            Spa.setBounds(400, 150, 350, 200);
            Spa.setVisible(false);
            panel.add(Spa);

            Restaurant = new JButton();
            Restaurant.setFocusable(false);
            Restaurant.setBackground(new Color(217, 217, 217));
            Restaurant.setBounds(800, 150, 350, 200);
            Restaurant.setVisible(false);
            panel.add(Restaurant);

            RoomCleaning = new JButton();
            RoomCleaning.setFocusable(false);
            RoomCleaning.setBackground(new Color(217, 217, 217));
            RoomCleaning.setBounds(400, 380, 350, 200);
            RoomCleaning.setVisible(false);
            panel.add(RoomCleaning);

            ServiceTab = new JButton();
            ServiceTab.setFocusable(false);
            ServiceTab.setBackground(new Color(132, 121, 102));
            ServiceTab.setBorderPainted(false);
            ServiceTab.setText("SERVICE BOOKING");
            ServiceTab.setFont(new Font("Mulish", Font.BOLD, 21));
            ServiceTab.setBounds(16, 209, 235, 33);
            ServiceTab.setForeground(new Color(245, 242, 233));
            ServiceTab.setHorizontalTextPosition(SwingConstants.LEFT);
            ServiceTab.setHorizontalAlignment(SwingConstants.LEFT);
            ServiceTab.setVisible(true);
            new Interaction(ServiceTab,false);
            panel.add(ServiceTab);
            ServiceTab.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Tab1_background.setVisible(false);
                    Tab2_background.setVisible(false);
                    Tab3_background.setVisible(true);
                    Tab4_background.setVisible(false);
                    ServiceMenu.setVisible(true);
                    Spa.setVisible(true);
                    Restaurant.setVisible(true);
                    RoomCleaning.setVisible(true);
                    OurHotelTab.setBackground(new Color(132, 121, 102));
                    RoomTab.setBackground(new Color(132, 121, 102));
                    ServiceTab.setBackground(new Color(244, 242, 235));
                    ReviewTab.setBackground(new Color(132,121,102));
                    ServiceTab.setForeground(new Color(43, 42, 38));
                    OurHotelTab.setForeground(new Color(245, 242, 233));
                    RoomTab.setForeground(new Color(245, 242, 233));
                    ReviewTab.setForeground(new Color(245, 242,233));
                }
            });
            ReviewTab = new JButton();
            ReviewTab.setFocusable(false);
            ReviewTab.setBackground(new Color(132, 121, 102));
            ReviewTab.setBorderPainted(false);
            ReviewTab.setText("REVIEW");
            ReviewTab.setFont(new Font("Mulish", Font.BOLD, 21));
            ReviewTab.setBounds(16, 256, 235, 33);
            ReviewTab.setForeground(new Color(245, 242, 233));
            ReviewTab.setHorizontalTextPosition(SwingConstants.LEFT);
            ReviewTab.setHorizontalAlignment(SwingConstants.LEFT);
            ReviewTab.setVisible(true);
            new Interaction(ReviewTab,false);
            panel.add(ReviewTab);
            ReviewTab.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Tab1_background.setVisible(false);
                    Tab2_background.setVisible(false);
                    Tab3_background.setVisible(false);
                    Tab4_background.setVisible(true);
                    ServiceMenu.setVisible(false);
                    Spa.setVisible(false);
                    Restaurant.setVisible(false);
                    RoomCleaning.setVisible(false);
                    OurHotelTab.setBackground(new Color(132, 121, 102));
                    RoomTab.setBackground(new Color(132, 121, 102));
                    ServiceTab.setBackground(new Color(132, 121, 102));
                    ReviewTab.setBackground(new Color(244, 242, 235));
                    OurHotelTab.setForeground(new Color(245, 242, 233));
                    RoomTab.setForeground(new Color(245, 242, 233));
                    ServiceTab.setForeground(new Color(245, 242, 233));
                    ReviewTab.setForeground(new Color(43, 42, 38));
                }
            });

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
