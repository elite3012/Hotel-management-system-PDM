package com.code.hms.ui;

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

    static JLabel SpaEnterBoxFName;
    static JLabel SpaEnterBoxLName;
    static JLabel SpaEnterBoxPNumber;
    static JLabel SpaEnterBoxEmail;

    static JTextField SpaFirstName;
    static JTextField SpaLastName;
    static JTextField SpaPhoneNumber;
    static JTextField SpaEmail;

    static JLabel RestaurantEnterBoxFName;
    static JLabel RestaurantEnterBoxLName;
    static JLabel RestaurantEnterBoxPNumber;
    static JLabel RestaurantEnterBoxEmail;

    static JTextField RestaurantFirstName;
    static JTextField RestaurantLastName;
    static JTextField RestaurantPhoneNumber;
    static JTextField RestaurantEmail;

    static JLabel ServiceMenu;
    static JLabel SpaCenter;
    static JLabel CustomerInfo;

    static JButton Spa;
    static JButton Restaurant;
    static JButton RoomCleaning;
    static JButton MusicLounge;

    static JLabel FNamePosition;
    static JLabel LNamePosition;
    static JLabel PNumberPosition;
    static JLabel EmailPosition;

    public CustomerUI() {
        createMainGUI();
        CreateSpaInfoBox();
        CreateRestaurantInfoBox();
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

        //show customer box to enter correct information
        FNamePosition = new JLabel();
        FNamePosition.setText("First name");
        FNamePosition.setFont(new Font("Mulish", Font.BOLD, 20));
        FNamePosition.setBounds(350, 170, 500, 30);
        FNamePosition.setForeground(new Color(136, 120, 81));
        FNamePosition.setVisible(false);
        panel.add(FNamePosition);

        LNamePosition = new JLabel();
        LNamePosition.setText("Last name");
        LNamePosition.setFont(new Font("Mulish", Font.BOLD, 20));
        LNamePosition.setBounds(750, 170, 500, 30);
        LNamePosition.setForeground(new Color(136, 120, 81));
        LNamePosition.setVisible(false);
        panel.add(LNamePosition);

        PNumberPosition = new JLabel();
        PNumberPosition.setText("Phone Number");
        PNumberPosition.setFont(new Font("Mulish", Font.BOLD, 20));
        PNumberPosition.setBounds(350, 250, 500, 30);
        PNumberPosition.setForeground(new Color(136, 120, 81));
        PNumberPosition.setVisible(false);
        panel.add(PNumberPosition);

        EmailPosition = new JLabel();
        EmailPosition.setText("Email");
        EmailPosition.setFont(new Font("Mulish", Font.BOLD, 20));
        EmailPosition.setBounds(750, 250, 500, 30);
        EmailPosition.setForeground(new Color(136, 120, 81));
        EmailPosition.setVisible(false);
        panel.add(EmailPosition);

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
        new Interaction(OurHotelTab, true);
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
                MusicLounge.setVisible(false);
                OurHotelTab.setBackground(new Color(244, 242, 235));
                RoomTab.setBackground(new Color(132, 121, 102));
                ServiceTab.setBackground(new Color(132, 121, 102));
                ReviewTab.setBackground(new Color(132, 121, 102));
                OurHotelTab.setForeground(new Color(43, 42, 38));
                RoomTab.setForeground(new Color(245, 242, 233));
                ServiceTab.setForeground(new Color(245, 242, 233));
                ReviewTab.setForeground(new Color(245, 242, 233));

                SpaCenter.setVisible(false);
                CustomerInfo.setVisible(false);

                SpaFirstName.setVisible(false);
                SpaLastName.setVisible(false);
                SpaPhoneNumber.setVisible(false);
                SpaEmail.setVisible(false);

                SpaEnterBoxFName.setVisible(false);
                SpaEnterBoxLName.setVisible(false);
                SpaEnterBoxPNumber.setVisible(false);
                SpaEnterBoxEmail.setVisible(false);

                RestaurantFirstName.setVisible(false);
                RestaurantLastName.setVisible(false);
                RestaurantPhoneNumber.setVisible(false);
                RestaurantEmail.setVisible(false);

                RestaurantEnterBoxFName.setVisible(false);
                RestaurantEnterBoxLName.setVisible(false);
                RestaurantEnterBoxPNumber.setVisible(false);
                RestaurantEnterBoxEmail.setVisible(false);

                FNamePosition.setVisible(false);
                LNamePosition.setVisible (false);
                PNumberPosition.setVisible(false);
                EmailPosition.setVisible(false);
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
        new Interaction(RoomTab, false);
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
                MusicLounge.setVisible(false);
                OurHotelTab.setBackground(new Color(132, 121, 102));
                RoomTab.setBackground(new Color(244, 242, 235));
                ServiceTab.setBackground(new Color(132, 121, 102));
                ReviewTab.setBackground(new Color(132, 121, 102));
                RoomTab.setForeground(new Color(43, 42, 38));
                OurHotelTab.setForeground(new Color(245, 242, 233));
                ServiceTab.setForeground(new Color(245, 242, 233));
                ReviewTab.setForeground(new Color(245, 242, 233));

                SpaCenter.setVisible(false);
                CustomerInfo.setVisible(false);

                SpaFirstName.setVisible(false);
                SpaLastName.setVisible(false);
                SpaPhoneNumber.setVisible(false);
                SpaEmail.setVisible(false);

                SpaEnterBoxFName.setVisible(false);
                SpaEnterBoxLName.setVisible(false);
                SpaEnterBoxPNumber.setVisible(false);
                SpaEnterBoxEmail.setVisible(false);

                RestaurantFirstName.setVisible(false);
                RestaurantLastName.setVisible(false);
                RestaurantPhoneNumber.setVisible(false);
                RestaurantEmail.setVisible(false);

                RestaurantEnterBoxFName.setVisible(false);
                RestaurantEnterBoxLName.setVisible(false);
                RestaurantEnterBoxPNumber.setVisible(false);
                RestaurantEnterBoxEmail.setVisible(false);

                FNamePosition.setVisible(false);
                LNamePosition.setVisible (false);
                PNumberPosition.setVisible(false);
                EmailPosition.setVisible(false);
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

        SpaCenter = new JLabel();
        SpaCenter.setText("SPA CENTER");
        SpaCenter.setFont(new Font("Mulish", Font.BOLD, 33));
        SpaCenter.setBounds(310, 20, 300, 33);
        SpaCenter.setForeground(new Color(212, 158, 24));
        SpaCenter.setVisible(false);
        panel.add(SpaCenter);

        CustomerInfo = new JLabel();
        CustomerInfo.setText("I. CUSTOMER INFORMATION");
        CustomerInfo.setFont(new Font("Mulish", Font.BOLD, 33));
        CustomerInfo.setBounds(310, 115, 500, 33);
        CustomerInfo.setForeground(new Color(136, 120, 81));
        CustomerInfo.setVisible(false);
        panel.add(CustomerInfo);

        Spa = new JButton();
        Spa.setFocusable(false);
        Spa.setBackground(new Color(217, 217, 217));
        Spa.setBounds(400, 150, 350, 200);
        Spa.setVisible(false);
        panel.add(Spa);
        Spa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FNamePosition.setVisible(true);
                LNamePosition.setVisible (true);
                PNumberPosition.setVisible(true);
                EmailPosition.setVisible(true);

                Tab1_background.setVisible(false);
                Tab2_background.setVisible(false);
                Tab3_background.setVisible(true);
                Tab4_background.setVisible(false);

                Restaurant.setVisible(false);
                Spa.setVisible(false);
                RoomCleaning.setVisible(false);
                MusicLounge.setVisible((false));

                ServiceMenu.setVisible(false);
                SpaCenter.setVisible(true);
                CustomerInfo.setVisible(true);

                SpaEnterBoxFName.setVisible(true);
                SpaEnterBoxLName.setVisible(true);
                SpaEnterBoxPNumber.setVisible(true);
                SpaEnterBoxEmail.setVisible(true);

                SpaFirstName.setVisible(true);
                SpaLastName.setVisible(true);
                SpaPhoneNumber.setVisible(true);
                SpaEmail.setVisible(true);

                RestaurantFirstName.setVisible(false);
                RestaurantLastName.setVisible(false);
                RestaurantPhoneNumber.setVisible(false);
                RestaurantEmail.setVisible(false);

                RestaurantEnterBoxFName.setVisible(false);
                RestaurantEnterBoxLName.setVisible(false);
                RestaurantEnterBoxPNumber.setVisible(false);
                RestaurantEnterBoxEmail.setVisible(false);
            }
        });

        Restaurant = new JButton();
        Restaurant.setFocusable(false);
        Restaurant.setBackground(new Color(217, 217, 217));
        Restaurant.setBounds(800, 150, 350, 200);
        Restaurant.setVisible(false);
        panel.add(Restaurant);
        Restaurant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tab1_background.setVisible(false);
                Tab2_background.setVisible(false);
                Tab3_background.setVisible(true);
                Tab4_background.setVisible(false);
                Restaurant.setVisible(false);
                Spa.setVisible(false);
                RoomCleaning.setVisible(false);
                MusicLounge.setVisible((false));

                CustomerInfo.setVisible(true);

                SpaFirstName.setVisible(false);
                SpaLastName.setVisible(false);
                SpaPhoneNumber.setVisible(false);
                SpaEmail.setVisible(false);

                RestaurantFirstName.setVisible(true);
                RestaurantLastName.setVisible(true);
                RestaurantPhoneNumber.setVisible(true);
                RestaurantEmail.setVisible(true);

                RestaurantEnterBoxFName.setVisible(true);
                RestaurantEnterBoxLName.setVisible(true);
                RestaurantEnterBoxPNumber.setVisible(true);
                RestaurantEnterBoxEmail.setVisible(true);

                FNamePosition.setVisible(true);
                LNamePosition.setVisible (true);
                PNumberPosition.setVisible(true);
                EmailPosition.setVisible(true);
            }
        });

        RoomCleaning = new JButton();
        RoomCleaning.setFocusable(false);
        RoomCleaning.setBackground(new Color(217, 217, 217));
        RoomCleaning.setBounds(400, 380, 350, 200);
        RoomCleaning.setVisible(false);
        panel.add(RoomCleaning);
        RoomCleaning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tab1_background.setVisible(false);
                Tab2_background.setVisible(false);
                Tab3_background.setVisible(true);
                Tab4_background.setVisible(false);
                Restaurant.setVisible(false);
                Spa.setVisible(false);
                RoomCleaning.setVisible(false);
                MusicLounge.setVisible((false));

                CustomerInfo.setVisible(true);

                SpaFirstName.setVisible(false);
                SpaLastName.setVisible(false);
                SpaPhoneNumber.setVisible(false);
                SpaEmail.setVisible(false);

                RestaurantFirstName.setVisible(false);
                RestaurantLastName.setVisible(false);
                RestaurantPhoneNumber.setVisible(false);
                RestaurantEmail.setVisible(false);

                RestaurantEnterBoxFName.setVisible(false);
                RestaurantEnterBoxLName.setVisible(false);
                RestaurantEnterBoxPNumber.setVisible(false);
                RestaurantEnterBoxEmail.setVisible(false);

                FNamePosition.setVisible(true);
                LNamePosition.setVisible (true);
                PNumberPosition.setVisible(true);
                EmailPosition.setVisible(true);
            }
        });

        MusicLounge = new JButton();
        MusicLounge.setFocusable(false);
        MusicLounge.setBackground(new Color(217, 217, 217));
        MusicLounge.setBounds(800, 380, 350, 200);
        MusicLounge.setVisible(false);
        panel.add(MusicLounge);
        MusicLounge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tab1_background.setVisible(false);
                Tab2_background.setVisible(false);
                Tab3_background.setVisible(true);
                Tab4_background.setVisible(false);
                Restaurant.setVisible(false);
                Spa.setVisible(false);
                RoomCleaning.setVisible(false);
                MusicLounge.setVisible((false));

                CustomerInfo.setVisible(true);

                SpaFirstName.setVisible(false);
                SpaLastName.setVisible(false);
                SpaPhoneNumber.setVisible(false);
                SpaEmail.setVisible(false);

                RestaurantFirstName.setVisible(false);
                RestaurantLastName.setVisible(false);
                RestaurantPhoneNumber.setVisible(false);
                RestaurantEmail.setVisible(false);

                RestaurantEnterBoxFName.setVisible(false);
                RestaurantEnterBoxLName.setVisible(false);
                RestaurantEnterBoxPNumber.setVisible(false);
                RestaurantEnterBoxEmail.setVisible(false);

                FNamePosition.setVisible(true);
                LNamePosition.setVisible (true);
                PNumberPosition.setVisible(true);
                EmailPosition.setVisible(true);
            }
        });

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
        new Interaction(ServiceTab, false);
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
                MusicLounge.setVisible(true);
                OurHotelTab.setBackground(new Color(132, 121, 102));
                RoomTab.setBackground(new Color(132, 121, 102));
                ServiceTab.setBackground(new Color(244, 242, 235));
                ReviewTab.setBackground(new Color(132, 121, 102));
                ServiceTab.setForeground(new Color(43, 42, 38));
                OurHotelTab.setForeground(new Color(245, 242, 233));
                RoomTab.setForeground(new Color(245, 242, 233));
                ReviewTab.setForeground(new Color(245, 242, 233));

                SpaCenter.setVisible(false);
                CustomerInfo.setVisible(false);

                SpaFirstName.setVisible(false);
                SpaLastName.setVisible(false);
                SpaPhoneNumber.setVisible(false);
                SpaEmail.setVisible(false);

                SpaEnterBoxFName.setVisible(false);
                SpaEnterBoxLName.setVisible(false);
                SpaEnterBoxPNumber.setVisible(false);
                SpaEnterBoxEmail.setVisible(false);

                RestaurantFirstName.setVisible(false);
                RestaurantLastName.setVisible(false);
                RestaurantPhoneNumber.setVisible(false);
                RestaurantEmail.setVisible(false);

                RestaurantEnterBoxFName.setVisible(false);
                RestaurantEnterBoxLName.setVisible(false);
                RestaurantEnterBoxPNumber.setVisible(false);
                RestaurantEnterBoxEmail.setVisible(false);

                FNamePosition.setVisible(false);
                LNamePosition.setVisible (false);
                PNumberPosition.setVisible(false);
                EmailPosition.setVisible(false);
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
        new Interaction(ReviewTab, false);
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
                MusicLounge.setVisible(false);
                OurHotelTab.setBackground(new Color(132, 121, 102));
                RoomTab.setBackground(new Color(132, 121, 102));
                ServiceTab.setBackground(new Color(132, 121, 102));
                ReviewTab.setBackground(new Color(244, 242, 235));
                OurHotelTab.setForeground(new Color(245, 242, 233));
                RoomTab.setForeground(new Color(245, 242, 233));
                ServiceTab.setForeground(new Color(245, 242, 233));
                ReviewTab.setForeground(new Color(43, 42, 38));

                SpaCenter.setVisible(false);
                CustomerInfo.setVisible(false);

                SpaFirstName.setVisible(false);
                SpaLastName.setVisible(false);
                SpaPhoneNumber.setVisible(false);
                SpaEmail.setVisible(false);

                SpaEnterBoxFName.setVisible(false);
                SpaEnterBoxLName.setVisible(false);
                SpaEnterBoxPNumber.setVisible(false);
                SpaEnterBoxEmail.setVisible(false);

                RestaurantFirstName.setVisible(false);
                RestaurantLastName.setVisible(false);
                RestaurantPhoneNumber.setVisible(false);
                RestaurantEmail.setVisible(false);

                RestaurantEnterBoxFName.setVisible(false);
                RestaurantEnterBoxLName.setVisible(false);
                RestaurantEnterBoxPNumber.setVisible(false);
                RestaurantEnterBoxEmail.setVisible(false);

                FNamePosition.setVisible(false);
                LNamePosition.setVisible (false);
                PNumberPosition.setVisible(false);
                EmailPosition.setVisible(false);
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

    public void CreateSpaInfoBox() {
        //box for first name
        SpaEnterBoxFName = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        SpaEnterBoxFName.setBounds(350, 200, 300, 30);
        panel.add(SpaEnterBoxFName);
        panel.setComponentZOrder(SpaEnterBoxFName, 0); // Brings it to the top of the component stack
        SpaEnterBoxFName.setVisible(false);

        SpaFirstName = new JTextField();
        panel.add(SpaFirstName);
        SpaFirstName.setBounds(352, 201, 295, 28);
        SpaFirstName.setBackground(new Color(244, 242, 235));
        SpaFirstName.setVisible(false);
        SpaFirstName.setBorder(null);

        //box for last name
        SpaEnterBoxLName = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        SpaEnterBoxLName.setBounds(750, 200, 300, 30);
        panel.add(SpaEnterBoxLName);
        panel.setComponentZOrder(SpaEnterBoxLName, 0); // Brings it to the top of the component stack
        SpaEnterBoxLName.setVisible(false);

        SpaLastName = new JTextField();
        panel.add(SpaLastName);
        SpaLastName.setBounds(752, 201, 295, 28);
        SpaLastName.setBackground(new Color(244, 242, 235));
        SpaLastName.setVisible(false);
        SpaLastName.setBorder(null);

        //box for phone number
        SpaEnterBoxPNumber = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        SpaEnterBoxPNumber.setBounds(350, 280, 300, 30);
        panel.add(SpaEnterBoxPNumber);
        panel.setComponentZOrder(SpaEnterBoxPNumber, 0); // Brings it to the top of the component stack
        SpaEnterBoxPNumber.setVisible(false);

        SpaPhoneNumber = new JTextField();
        panel.add(SpaPhoneNumber);
        SpaPhoneNumber.setBounds(352, 281, 295, 28);
        SpaPhoneNumber.setBackground(new Color(244, 242, 235));
        SpaPhoneNumber.setVisible(false);
        SpaPhoneNumber.setBorder(null);

        //box for email
        SpaEnterBoxEmail = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        SpaEnterBoxEmail.setBounds(750, 280, 300, 30);
        panel.add(SpaEnterBoxEmail);
        panel.setComponentZOrder(SpaEnterBoxEmail, 0); // Brings it to the top of the component stack
        SpaEnterBoxEmail.setVisible(false);

        SpaEmail = new JTextField();
        panel.add(SpaEmail);
        SpaEmail.setBounds(752, 281, 295, 28);
        SpaEmail.setBackground(new Color(244, 242, 235));
        SpaEmail.setVisible(false);
        SpaEmail.setBorder(null);
    }

    public void CreateRestaurantInfoBox() {
        //box for first name
        RestaurantEnterBoxFName = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        RestaurantEnterBoxFName.setBounds(350, 200, 300, 30);
        panel.add(RestaurantEnterBoxFName);
        panel.setComponentZOrder(RestaurantEnterBoxFName, 0); // Brings it to the top of the component stack
        RestaurantEnterBoxFName.setVisible(false);

        RestaurantFirstName = new JTextField();
        panel.add(RestaurantFirstName);
        RestaurantFirstName.setBounds(352, 201, 295, 28);
        RestaurantFirstName.setBackground(new Color(244, 242, 235));
        RestaurantFirstName.setVisible(false);
        RestaurantFirstName.setBorder(null);

        //box for last name
        RestaurantEnterBoxLName = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        RestaurantEnterBoxLName.setBounds(750, 200, 300, 30);
        panel.add(RestaurantEnterBoxLName);
        panel.setComponentZOrder(RestaurantEnterBoxLName, 0); // Brings it to the top of the component stack
        RestaurantEnterBoxLName.setVisible(false);

        RestaurantLastName = new JTextField();
        panel.add(RestaurantLastName);
        RestaurantLastName.setBounds(752, 201, 295, 28);
        RestaurantLastName.setBackground(new Color(244, 242, 235));
        RestaurantLastName.setVisible(false);
        RestaurantLastName.setBorder(null);

        //box for phone number
        RestaurantEnterBoxPNumber = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        RestaurantEnterBoxPNumber.setBounds(350, 280, 300, 30);
        panel.add(RestaurantEnterBoxPNumber);
        panel.setComponentZOrder(RestaurantEnterBoxPNumber, 0); // Brings it to the top of the component stack
        RestaurantEnterBoxPNumber.setVisible(false);

        RestaurantPhoneNumber = new JTextField();
        panel.add(RestaurantPhoneNumber);
        RestaurantPhoneNumber.setBounds(352, 281, 295, 28);
        RestaurantPhoneNumber.setBackground(new Color(244, 242, 235));
        RestaurantPhoneNumber.setVisible(false);
        RestaurantPhoneNumber.setBorder(null);

        //box for email
        RestaurantEnterBoxEmail = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        RestaurantEnterBoxEmail.setBounds(750, 280, 300, 30);
        panel.add(RestaurantEnterBoxEmail);
        panel.setComponentZOrder(RestaurantEnterBoxEmail, 0); // Brings it to the top of the component stack
        RestaurantEnterBoxEmail.setVisible(false);

        RestaurantEmail = new JTextField();
        panel.add(RestaurantEmail);
        RestaurantEmail.setBounds(752, 281, 295, 28);
        RestaurantEmail.setBackground(new Color(244, 242, 235));
        RestaurantEmail.setVisible(false);
        RestaurantEmail.setBorder(null);
    }
}
