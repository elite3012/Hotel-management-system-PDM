package com.code.hms.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class StaffUI {
    static JLabel Tab1_background;
    static JLabel Tab2_background;
    static JLabel Tab3_background;
    static JFrame frame;
    static JPanel panel;
    static JButton main_menu;
    static JLabel available_unavailable;
    static JLabel RoomManagementTab;
    static JLabel ReservationTab;
    static JLabel CurrencyExchangeTab;
    static JButton ReservationButton;


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
        // RoomManagementTab setup
        RoomManagementTab = new JLabel("ROOMS");
        RoomManagementTab.setFont(new Font("Mulish", Font.BOLD, 23));
        RoomManagementTab.setBounds(32, 115, 235, 33);
        RoomManagementTab.setForeground(new Color(43, 42, 38));
        RoomManagementTab.setVisible(true);
        panel.add(RoomManagementTab);

        // ReservationTab setup
        ReservationTab = new JLabel("RESERVATIONS");
        ReservationTab.setFont(new Font("Mulish", Font.BOLD, 23));
        ReservationTab.setBounds(32, 162, 235, 33);
        ReservationTab.setForeground(new Color(245, 242, 233));
        ReservationTab.setOpaque(false);
        ReservationTab.setFocusable(false);
        ReservationTab.setVisible(true);
        panel.add(ReservationTab);
        new Interaction(ReservationTab);

        // ReservationButton setup
        ReservationButton = new JButton();
        ReservationButton.setBounds(32, 162, 235, 33);
        ReservationButton.setOpaque(false);  // Makes the button background transparent
        ReservationButton.setContentAreaFilled(false);  // Removes the button's content area background
        ReservationButton.setBorderPainted(false);  // Removes the button border (optional)
        ReservationButton.setVisible(true);
        panel.add(ReservationButton);

        // CurrencyExchangeTab setup
        CurrencyExchangeTab = new JLabel("CURRENCY EXCH.");
        CurrencyExchangeTab.setFont(new Font("Mulish", Font.BOLD, 23));
        CurrencyExchangeTab.setBounds(32, 209, 235, 33);
        CurrencyExchangeTab.setForeground(new Color(245, 242, 233));
        CurrencyExchangeTab.setVisible(true);
        panel.add(CurrencyExchangeTab);
        new Interaction(CurrencyExchangeTab);

        //available_unavailable labels
        available_unavailable = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Rooms_Available_Unavailable.png", 298,28));
        available_unavailable.setBounds(576, 576, 399, 35);
        available_unavailable.setVisible(true);
        panel.add(available_unavailable);

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
}