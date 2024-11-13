package com.code.hms.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class StaffUI {
    static JLabel background;
    static JFrame frame;
    static JPanel panel;
    static JButton main_menu;
    static JLabel available_unavailable;
    static JLabel RoomManagementTab;
    static JLabel ReservationTab;


    public StaffUI() {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Choose: Receptionist(1)/Housekeeper(2)/Admin(3)\n");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                createReceptionistUI();
                break;
            case 2:
                createHousekeeperUI();
                break;
            case 3:
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
        RoomManagementTab.setVisible(true);
        panel.add(RoomManagementTab);

        // ReservationTab setup
        ReservationTab = new JLabel("RESERVATIONS");
        ReservationTab.setFont(new Font("Mulish", Font.BOLD, 23));
        ReservationTab.setBounds(32, 162, 235, 33);
        ReservationTab.setVisible(true);
        panel.add(ReservationTab);

        //main menu button
        main_menu = new JButton(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Main_menu_Button.png",175,28));
        main_menu.setBounds(19,17,175,28);
        main_menu.setBorderPainted(false);       // Remove border
        main_menu.setBackground(null);
        main_menu.setHorizontalAlignment(SwingConstants.CENTER);
        main_menu.setVerticalAlignment(SwingConstants.CENTER);
        main_menu.setVisible(true);
        panel.add(main_menu);

        //available_unavailable labels
        available_unavailable = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Rooms_Available_Unavailable.png", 298,28));
        available_unavailable.setBounds(576, 576, 399, 35);
        available_unavailable.setVisible(true);
        panel.add(available_unavailable);

        //background
        background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Rooms_BG.png",1280,672));
        background.setBounds(0, 0, 1280,672);
        background.setVisible(true);
        panel.add(background);
    }
}