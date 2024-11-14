package com.code.hms.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


public class StaffUI {
    static JLabel Tab1_background;
    static JLabel Tab2_background;
    static JLabel Tab3_background;
    static JFrame frame;
    static JPanel panel;
    static JPanel roomPanel;
    static JButton main_menu;
    static JLabel available_unavailable;
    static JButton RoomManagementTab;
    static JButton ReservationTab;
    static JButton CurrencyExchangeTab;

    public StaffUI() {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Choose: Receptionist(1)/Housekeeper(2)/ServiceStaff(3)/Admin(4)\n");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                createReceptionistUI();
                break;
            case 2:
                createHousekeeperUI();
                break;
            case 3:
                createServiceStaffUI();
                break;
            case 4:
                createAdminUI();
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }*/
        initializeUI();
        createReceptionistUI();
    }

    private void initializeUI(){
        //frame
        frame = new JFrame();
        frame.setBounds(0, 0, 1280, 672);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);

        //panel
        panel = new JPanel();
        panel.setLayout(null);
        frame.getContentPane().add(panel);
    }
    private void createReceptionistUI () {
        // ReservationTab setup
        RoomManagementTab = new JButton();
        RoomManagementTab.setFocusable(false);
        RoomManagementTab.setBackground(new Color(244, 242, 235));
        RoomManagementTab.setBorderPainted(false);
        RoomManagementTab.setText("ROOMS");
        RoomManagementTab.setFont(new Font("Mulish", Font.BOLD, 21));
        RoomManagementTab.setBounds(16, 115, 235, 33);
        RoomManagementTab.setForeground(new Color(43, 42, 38));
        RoomManagementTab.setHorizontalTextPosition(SwingConstants.LEFT);
        RoomManagementTab.setHorizontalAlignment(SwingConstants.LEFT);
        RoomManagementTab.setVisible(true);
        new Interaction(RoomManagementTab,true);
        panel.add(RoomManagementTab);
        RoomManagementTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tab1_background.setVisible(true);
                Tab2_background.setVisible(false);
                Tab3_background.setVisible(false);
                RoomManagementTab.setBackground(new Color(244, 242, 235));
                ReservationTab.setBackground(new Color(132, 121, 102));
                CurrencyExchangeTab.setBackground(new Color(132, 121, 102));
                RoomManagementTab.setForeground(new Color(43, 42, 38));
                ReservationTab.setForeground(new Color(245, 242, 233));
                CurrencyExchangeTab.setForeground(new Color(245, 242, 233));
                addRoomTabComponents();
            }
        });

        // ReservationTab setup
        ReservationTab = new JButton();
        ReservationTab.setFocusable(false);
        ReservationTab.setBackground(new Color(132, 121, 102));
        ReservationTab.setBorderPainted(false);
        ReservationTab.setText("RESERVATIONS");
        ReservationTab.setFont(new Font("Mulish", Font.BOLD, 21));
        ReservationTab.setBounds(16, 162, 235, 33);
        ReservationTab.setForeground(new Color(245, 242, 233));
        ReservationTab.setHorizontalTextPosition(SwingConstants.LEFT);
        ReservationTab.setHorizontalAlignment(SwingConstants.LEFT);
        ReservationTab.setVisible(true);
        new Interaction(ReservationTab,false);
        panel.add(ReservationTab);
        ReservationTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tab1_background.setVisible(false);
                Tab2_background.setVisible(true);
                Tab3_background.setVisible(false);
                RoomManagementTab.setBackground(new Color(132, 121, 102));
                ReservationTab.setBackground(new Color(244, 242, 235));
                CurrencyExchangeTab.setBackground(new Color(132, 121, 102));
                ReservationTab.setForeground(new Color(43, 42, 38));
                RoomManagementTab.setForeground(new Color(245, 242, 233));
                CurrencyExchangeTab.setForeground(new Color(245, 242, 233));
                removeRoomTabComponents();
            }
        });

        // ReservationTab setup
        CurrencyExchangeTab = new JButton();
        CurrencyExchangeTab.setFocusable(false);
        CurrencyExchangeTab.setBackground(new Color(132, 121, 102));
        CurrencyExchangeTab.setBorderPainted(false);
        CurrencyExchangeTab.setText("CURRENCY EXCH.");
        CurrencyExchangeTab.setFont(new Font("Mulish", Font.BOLD, 21));
        CurrencyExchangeTab.setBounds(16, 209, 235, 33);
        CurrencyExchangeTab.setForeground(new Color(245, 242, 233));
        CurrencyExchangeTab.setHorizontalTextPosition(SwingConstants.LEFT);
        CurrencyExchangeTab.setHorizontalAlignment(SwingConstants.LEFT);
        CurrencyExchangeTab.setVisible(true);
        new Interaction(CurrencyExchangeTab,false);
        panel.add(CurrencyExchangeTab);
        CurrencyExchangeTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tab1_background.setVisible(false);
                Tab2_background.setVisible(false);
                Tab3_background.setVisible(true);
                RoomManagementTab.setBackground(new Color(132, 121, 102));
                ReservationTab.setBackground(new Color(132, 121, 102));
                CurrencyExchangeTab.setBackground(new Color(244, 242, 235));
                CurrencyExchangeTab.setForeground(new Color(43, 42, 38));
                RoomManagementTab.setForeground(new Color(245, 242, 233));
                ReservationTab.setForeground(new Color(245, 242, 233));
                removeRoomTabComponents();
            }
        });

        //available_unavailable labels
        available_unavailable = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Rooms_Available_Unavailable.png", 298,28));
        available_unavailable.setBounds(576, 576, 399, 35);
        available_unavailable.setVisible(true);
        panel.add(available_unavailable);

        // Create panel with grid layout
        roomPanel = new JPanel();
        roomPanel.setLayout(new GridLayout(6, 6, 27, 27)); // 6x6 grid with padding
        roomPanel.setBounds(417,40,713,530);

        // Generate buttons
        for (int floor = 1; floor <= 6; floor++) {
            for (int room = 1; room <= 6; room++) {
                int roomNumber = floor * 100 + room;
                JButton roomButton = new JButton(String.valueOf(roomNumber));
                roomButton.setPreferredSize(new Dimension(96,71));
                roomButton.setBackground(Color.decode("#E3DFD5"));
                roomButton.setFont(new Font("Mulish", Font.BOLD, 20));
                roomButton.setOpaque(true);
                roomButton.setBorderPainted(true);
                roomButton.setFocusable(false);

                // Add action listener to change color on click
                roomButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (roomButton.getBackground().equals(Color.decode("#E3DFD5"))) {
                            roomButton.setBackground(Color.decode("#E1756E"));
                        }
                        else {
                            roomButton.setBackground(Color.decode("#E3DFD5"));
                        }
                    }
                });

                roomPanel.add(roomButton);
            }
        }
        panel.add(roomPanel);

        //Tab1_background
        Tab1_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab1_BG.png",1280,672));
        Tab1_background.setBounds(0, 0, 1280,672);
        Tab1_background.setVisible(true);
        panel.add(Tab1_background);

        //Tab2_background
        Tab2_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab2_BG.png",1280,672));
        Tab2_background.setBounds(0, 0, 1280,672);
        Tab2_background.setVisible(false);
        panel.add(Tab2_background);

        //Tab3_background
        Tab3_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab3_BG.png",1280,672));
        Tab3_background.setBounds(0, 0, 1280,672);
        Tab3_background.setVisible(false);
        panel.add(Tab3_background);
    }
    private void addRoomTabComponents(){
        roomPanel.setVisible(true);
        available_unavailable.setVisible(true);
    }
    private void removeRoomTabComponents(){
        roomPanel.setVisible(false);
        available_unavailable.setVisible(false);
    }
}