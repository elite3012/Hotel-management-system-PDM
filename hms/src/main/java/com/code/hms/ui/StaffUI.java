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
        frame.setVisible(true);
        frame.setSize(1440, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        //panel
        panel = new JPanel();
        panel.setLayout(null);
        frame.getContentPane().add(panel);
    }
    private void createReceptionistUI () {
        //background
        background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Rooms_BG.png",1440,900));
        background.setBounds(0, 0, 1440, 900);
        background.setVisible(true);
        panel.add(background);

        // RoomManagementTab setup
        RoomManagementTab = new JLabel("ROOMS");
        RoomManagementTab.setFont(new Font("Mulish", Font.BOLD, 25));
        RoomManagementTab.setBounds(35, 145, 250, 60);
        panel.add(RoomManagementTab);

        //main menu button
        main_menu = new JButton(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Main_menu_Button.png",197,38));
        main_menu.setBounds(21, 23, 197, 38);
        main_menu.setBorderPainted(false);       // Remove border
        main_menu.setBackground(null);
        main_menu.setHorizontalAlignment(SwingConstants.CENTER);
        main_menu.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(main_menu);

        //available_unavailable labels
        available_unavailable = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Rooms_Available_Unavailable.png", 447, 47));
        available_unavailable.setBounds(647,800,447,47);
        available_unavailable.setVisible(true);
        panel.add(available_unavailable);
    }
}