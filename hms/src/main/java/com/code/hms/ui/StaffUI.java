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
    static JLabel Tab4_background;
    static JLabel Tab5_background;
    static JFrame frame;
    static JPanel panel;
    static JPanel roomPanel;
    static JPanel roomCleaningPanel;
    static JButton main_menu;
    static JLabel available_unavailable;
    static JLabel cleaned_uncleaned;
    static JButton RoomManagementTab;
    static JButton ReservationTab;
    static JButton CurrencyExchangeTab;
    static JButton TaskListTab;

    public StaffUI() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose: Receptionist(1)/Housekeeper(2)/ServiceStaff(3)/Admin(4)\n");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                initializeUI();
                createReceptionistUI();
                break;
            case 2:
                initializeUI();
                createHousekeeperUI();
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }
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
        createRoomTab();
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

        createReservationTab();
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

        createCurrencyExchangeTab();
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
        addRoomPanel();
        createAllBackgrounds();
    }
    private void createHousekeeperUI(){
        createRoomTab();
        RoomManagementTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tab1_background.setVisible(true);
                Tab2_background.setVisible(false);
                RoomManagementTab.setBackground(new Color(244, 242, 235));
                TaskListTab.setBackground(new Color(132, 121, 102));
                RoomManagementTab.setForeground(new Color(43, 42, 38));
                TaskListTab.setForeground(new Color(245, 242, 233));
                addRoomCleaningTabComponents();
            }
        });
        createTaskListTab();
        TaskListTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tab1_background.setVisible(false);
                Tab2_background.setVisible(true);
                RoomManagementTab.setBackground(new Color(132, 121, 102));
                TaskListTab.setBackground(new Color(244, 242, 235));
                TaskListTab.setForeground(new Color(43, 42, 38));
                RoomManagementTab.setForeground(new Color(245, 242, 233));
                removeRoomCleaningTabComponents();
            }
        });
        addRoomCleaningPanel();
        createAllBackgrounds();
    }
    private void addRoomPanel(){
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
                roomButton.setForeground(Color.decode("#000000"));
                roomButton.setOpaque(true);
                roomButton.setBorderPainted(true);
                roomButton.setFocusable(false);

                // Add action listener to change color on click
                roomButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (roomButton.getBackground().equals(Color.decode("#E3DFD5"))) {
                            roomButton.setBackground(Color.decode("#E1756E"));
                            roomButton.setForeground(Color.decode("#F5F2E9"));
                        }
                        else {
                            roomButton.setBackground(Color.decode("#E3DFD5"));
                            roomButton.setForeground(Color.decode("#000000"));
                        }
                    }
                });

                roomPanel.add(roomButton);
            }
        }
        panel.add(roomPanel);

        //available_unavailable labels
        available_unavailable = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Rooms_Available_Unavailable.png", 298,28));
        available_unavailable.setBounds(576, 576, 399, 35);
        available_unavailable.setVisible(true);
        panel.add(available_unavailable);
    }
    private void createRoomTab(){
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
    }
    private void createReservationTab(){
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
    }
    private void createCurrencyExchangeTab(){
        // CurrencyTab setup
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
    }
    private void createTaskListTab(){
        TaskListTab = new JButton();
        TaskListTab.setFocusable(false);
        TaskListTab.setBackground(new Color(132, 121, 102));
        TaskListTab.setBorderPainted(false);
        TaskListTab.setText("TASK LIST");
        TaskListTab.setFont(new Font("Mulish", Font.BOLD, 21));
        TaskListTab.setBounds(16, 162, 235, 33);
        TaskListTab.setForeground(new Color(245, 242, 233));
        TaskListTab.setHorizontalTextPosition(SwingConstants.LEFT);
        TaskListTab.setHorizontalAlignment(SwingConstants.LEFT);
        TaskListTab.setVisible(true);
        new Interaction(TaskListTab,false);
        panel.add(TaskListTab);
    }
    private void createAllBackgrounds(){
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

        //Tab4_background
        Tab4_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab4_BG.png",1280,672));
        Tab4_background.setBounds(0, 0, 1280,672);
        Tab4_background.setVisible(false);
        panel.add(Tab4_background);

        //Tab5_background
        Tab5_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab5_BG.png",1280,672));
        Tab5_background.setBounds(0, 0, 1280,672);
        Tab5_background.setVisible(false);
        panel.add(Tab5_background);
    }
    private void addRoomCleaningPanel(){
        // Create panel with grid layout
        roomCleaningPanel = new JPanel();
        roomCleaningPanel.setLayout(new GridLayout(6, 6, 27, 27)); // 6x6 grid with padding
        roomCleaningPanel.setBounds(417,40,713,530);

        // Generate buttons
        for (int floor = 1; floor <= 6; floor++) {
            for (int room = 1; room <= 6; room++) {
                int roomNumber = floor * 100 + room;
                JButton roomButton = new JButton(String.valueOf(roomNumber));
                roomButton.setPreferredSize(new Dimension(96,71));
                roomButton.setBackground(Color.decode("#B3E8F2"));
                roomButton.setFont(new Font("Mulish", Font.BOLD, 20));
                roomButton.setForeground(Color.decode("#434238"));
                roomButton.setOpaque(true);
                roomButton.setBorderPainted(true);
                roomButton.setFocusable(false);

                // Add action listener to change color on click
                roomButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (roomButton.getBackground().equals(Color.decode("#B3E8F2"))) {
                            roomButton.setBackground(Color.decode("#E1756E"));
                            roomButton.setForeground(Color.decode("#F5F2E9"));
                        }
                        else {
                            roomButton.setBackground(Color.decode("#B3E8F2"));
                            roomButton.setForeground(Color.decode("#000000"));
                        }
                    }
                });

                roomCleaningPanel.add(roomButton);
            }
        }
        panel.add(roomCleaningPanel);

        //available_unavailable labels
        cleaned_uncleaned = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Cleaned_Uncleaned.png", 298,28));
        cleaned_uncleaned.setBounds(576, 576, 399, 35);
        cleaned_uncleaned.setVisible(true);
        panel.add(cleaned_uncleaned);
    }
    private void addRoomTabComponents(){
        roomPanel.setVisible(true);
        available_unavailable.setVisible(true);
    }
    private void removeRoomTabComponents(){
        roomPanel.setVisible(false);
        available_unavailable.setVisible(false);
    }
    private void addRoomCleaningTabComponents(){
        roomCleaningPanel.setVisible(true);
        cleaned_uncleaned.setVisible(true);
    }
    private void removeRoomCleaningTabComponents(){
        roomCleaningPanel.setVisible(false);
        cleaned_uncleaned.setVisible(false);
    }
}