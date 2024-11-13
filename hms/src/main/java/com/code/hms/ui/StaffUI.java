package com.code.hms.ui;

import javax.swing.*;
import java.util.Scanner;


public class StaffUI {
    static JLabel background;
    static JFrame frame;
    static JPanel panel;
    static JButton main_menu;


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
        createReceptionistUI();
    }

    private void createReceptionistUI () {
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
}