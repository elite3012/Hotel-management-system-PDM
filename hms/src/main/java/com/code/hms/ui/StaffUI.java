package com.code.hms.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import com.code.hms.daoimpl.ReservationDaoImpl;
import com.code.hms.entities.Reservation;
import java.util.List;


public class StaffUI {
    static JLabel Tab1_background;
    static JLabel Tab2_background;
    static JLabel Tab3_background;
    static JLabel Tab4_background;
    static JLabel Tab5_background;
    static JFrame frame;
    static JPanel panel;
    static JPanel roomPanel;
    static JPanel reservationPanel;
    static JPanel serviceOrderPanel;
    static JPanel roomCleaningPanel;
    static JPanel taskListPanel;
    static JPanel ManageUserPanel;
    static JButton main_menu;
    static JLabel available_unavailable;
    static JLabel cleaned_uncleaned;
    static JComboBox adminRoomMenu;
    static JButton RoomManagementTab;
    static JButton ReservationTab;
    static JButton CurrencyExchangeTab;
    static JButton TaskListTab;
    static JButton ServiceOrderTab;
    static JButton FinancialTab;
    static JButton UsersTab;
    static JTable serviceOrderTable;
    static JTable taskListTable;
    static JTable ManageUserTable;
    static JScrollPane serviceOrderScrollPane;
    static JScrollPane taskListScrollPane;
    static JScrollPane ManageUserScrollPane;
    static ReservationDaoImpl reservationDaoImpl;

    public StaffUI() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose: Receptionist(1)/Housekeeper(2)/Admin(3)\n");
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
            case 3:
                initializeUI();
                createAdminUI();
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }
        reservationDaoImpl = new ReservationDaoImpl();
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
                removeReservationTabComponents();
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
                addReservationTabComponents();
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
                removeReservationTabComponents();
            }
        });
        addReservationPanel();
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
                removeTaskListComponents();
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
                addTaskListComponents();
            }
        });
        addRoomCleaningPanel();
        createAllBackgrounds();
        createTaskListPanel();
    }
    private void createAdminUI(){
        createRoomTab();

        RoomManagementTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tab1_background.setVisible(true);
                Tab2_background.setVisible(false);
                Tab3_background.setVisible(false);
                Tab4_background.setVisible(false);
                Tab5_background.setVisible(false);

                RoomManagementTab.setBackground(new Color(244, 242, 235));
                ReservationTab.setBackground(new Color(132, 121, 102));
                ServiceOrderTab.setBackground(new Color(132, 121, 102));
                FinancialTab.setBackground(new Color(132, 121, 102));
                UsersTab.setBackground(new Color(132, 121, 102));

                RoomManagementTab.setForeground(new Color(43, 42, 38));
                ReservationTab.setForeground(new Color(245, 242, 233));
                ServiceOrderTab.setForeground(new Color(245, 242, 233));
                FinancialTab.setForeground(new Color(245, 242, 233));
                UsersTab.setForeground(new Color(245, 242, 233));

                adminRoomMenu.setSelectedItem("Availability");
                addRoomTabComponents();
                addAdminRoomMenu();

                removeServiceOrderComponents();
            }
        });

        createReservationTab();
        ReservationTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tab1_background.setVisible(false);
                Tab2_background.setVisible(true);
                Tab3_background.setVisible(false);
                Tab4_background.setVisible(false);
                Tab5_background.setVisible(false);

                RoomManagementTab.setBackground(new Color(132, 121, 102));
                ReservationTab.setBackground(new Color(244, 242, 235));
                ServiceOrderTab.setBackground(new Color(132, 121, 102));
                FinancialTab.setBackground(new Color(132, 121, 102));
                UsersTab.setBackground(new Color(132, 121, 102));

                RoomManagementTab.setForeground(new Color(245, 242, 233));
                ReservationTab.setForeground(new Color(43, 42, 38));
                ServiceOrderTab.setForeground(new Color(245, 242, 233));
                FinancialTab.setForeground(new Color(245, 242, 233));
                UsersTab.setForeground(new Color(245, 242, 233));

                removeRoomTabComponents();
                removeAdminRoomMenu();
                removeRoomCleaningTabComponents();
                removeServiceOrderComponents();
                removeManageUserComponents();
            }
        });

        createServiceOrderTab();
        ServiceOrderTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tab1_background.setVisible(false);
                Tab2_background.setVisible(false);
                Tab3_background.setVisible(true);
                Tab4_background.setVisible(false);
                Tab5_background.setVisible(false);

                RoomManagementTab.setBackground(new Color(132, 121, 102));
                ReservationTab.setBackground(new Color(132, 121, 102));
                ServiceOrderTab.setBackground(new Color(244, 242, 235));
                FinancialTab.setBackground(new Color(132, 121, 102));
                UsersTab.setBackground(new Color(132, 121, 102));

                RoomManagementTab.setForeground(new Color(245, 242, 233));
                ReservationTab.setForeground(new Color(245, 242, 233));
                ServiceOrderTab.setForeground(new Color(43, 42, 38));
                FinancialTab.setForeground(new Color(245, 242, 233));
                UsersTab.setForeground(new Color(245, 242, 233));

                addServiceOrderComponents();
                removeRoomTabComponents();
                removeAdminRoomMenu();
                removeRoomCleaningTabComponents();
                removeManageUserComponents();
            }
        });

        createFinancialTab();
        FinancialTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tab1_background.setVisible(false);
                Tab2_background.setVisible(false);
                Tab3_background.setVisible(false);
                Tab4_background.setVisible(true);
                Tab5_background.setVisible(false);

                RoomManagementTab.setBackground(new Color(132, 121, 102));
                ReservationTab.setBackground(new Color(132, 121, 102));
                ServiceOrderTab.setBackground(new Color(132, 121, 102));
                FinancialTab.setBackground(new Color(244, 242, 235));
                UsersTab.setBackground(new Color(132, 121, 102));

                RoomManagementTab.setForeground(new Color(245, 242, 233));
                ReservationTab.setForeground(new Color(245, 242, 233));
                ServiceOrderTab.setForeground(new Color(245, 242, 233));
                FinancialTab.setForeground(new Color(43, 42, 38));
                UsersTab.setForeground(new Color(245, 242, 233));

                removeRoomTabComponents();
                removeAdminRoomMenu();
                removeRoomCleaningTabComponents();
                removeServiceOrderComponents();
                removeManageUserComponents();
            }
        });

        createUsersTab();
        UsersTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tab1_background.setVisible(false);
                Tab2_background.setVisible(false);
                Tab3_background.setVisible(false);
                Tab4_background.setVisible(false);
                Tab5_background.setVisible(true);

                RoomManagementTab.setBackground(new Color(132, 121, 102));
                ReservationTab.setBackground(new Color(132, 121, 102));
                ServiceOrderTab.setBackground(new Color(132, 121, 102));
                FinancialTab.setBackground(new Color(132, 121, 102));
                UsersTab.setBackground(new Color(244, 242, 235));

                RoomManagementTab.setForeground(new Color(245, 242, 233));
                ReservationTab.setForeground(new Color(245, 242, 233));
                ServiceOrderTab.setForeground(new Color(245, 242, 233));
                FinancialTab.setForeground(new Color(245, 242, 233));
                UsersTab.setForeground(new Color(43, 42, 38));

                addManageUserComponents();
                removeRoomTabComponents();
                removeAdminRoomMenu();
                removeRoomCleaningTabComponents();
                removeServiceOrderComponents();
            }
        });
        addRoomPanel();
        addRoomCleaningPanel();
        removeRoomCleaningTabComponents();
        createAdminRoomMenu();
        createAllBackgrounds();
        createServiceOrderPanel();
        createManageUserPanel();

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

    private void addReservationPanel() {
        if (reservationPanel == null) {
            reservationPanel = new JPanel();
            reservationPanel.setLayout(new GridLayout(3, 2, 10, 10)); 
            reservationPanel.setBounds(417, 40, 713, 530); // 
    
            // Define buttons for various reservation actions
            JButton viewAllButton = new JButton("View All Reservations");
            viewAllButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List<Object[]> reservations = reservationDaoImpl.getAllReservations(); 
                    if (reservations != null && !reservations.isEmpty()) {
                        String[] columnNames = {"Reservation ID", "User ID", "First Name", "Last Name",
                                                "Check-in Date", "Check-out Date", "Total Days", "Num of Guests"};

                        Object[][] data = new Object[reservations.size()][8];
                        for (int i = 0; i < reservations.size(); i++) {
                            Object[] row = reservations.get(i);
                            data[i][0] = row[0]; // Reservation ID
                            data[i][1] = row[1]; // User ID
                            data[i][2] = row[2]; // First Name
                            data[i][3] = row[3]; // Last Name
                            data[i][4] = row[4]; // Check-in Date
                            data[i][5] = row[5]; // Check-out Date
                            data[i][6] = row[6]; // Total Days
                            data[i][7] = row[7]; // Num of Guests
                        }

                        JTable table = new JTable(data, columnNames);
                        JScrollPane scrollPane = new JScrollPane(table);

                        JOptionPane.showMessageDialog(null, scrollPane, "All Reservations", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No reservations found.", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });


            JButton createNewButton = new JButton("Create New Reservation");
            createNewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String userIdInput = JOptionPane.showInputDialog("Enter User ID:");
                        if (userIdInput == null || userIdInput.isEmpty()) throw new IllegalArgumentException("User ID cannot be empty.");
                        int userId = Integer.parseInt(userIdInput);

                        String checkinDateInput = JOptionPane.showInputDialog("Enter Check-in Date (YYYY-MM-DD):");
                        if (checkinDateInput == null || checkinDateInput.isEmpty()) throw new IllegalArgumentException("Check-in date cannot be empty.");
                        java.sql.Date checkinDate = java.sql.Date.valueOf(checkinDateInput);

                        String checkoutDateInput = JOptionPane.showInputDialog("Enter Check-out Date (YYYY-MM-DD):");
                        if (checkoutDateInput == null || checkoutDateInput.isEmpty()) throw new IllegalArgumentException("Check-out date cannot be empty.");
                        java.sql.Date checkoutDate = java.sql.Date.valueOf(checkoutDateInput);

                        long difference = checkoutDate.getTime() - checkinDate.getTime();
                        int totalDays = (int) (difference / (1000 * 60 * 60 * 24));
                        if (totalDays <= 0) throw new IllegalArgumentException("Check-out date must be after check-in date.");

                        String numGuestsInput = JOptionPane.showInputDialog("Enter Number of Guests:");
                        if (numGuestsInput == null || numGuestsInput.isEmpty()) throw new IllegalArgumentException("Number of guests cannot be empty.");
                        int numOfGuests = Integer.parseInt(numGuestsInput);

                        Reservation newReservation = new Reservation();
                        newReservation.setUserId(userId);
                        newReservation.setCheckinDate(checkinDate);
                        newReservation.setCheckoutDate(checkoutDate);
                        newReservation.setTotalDays(totalDays);
                        newReservation.setNumOfGuests(numOfGuests);

                        reservationDaoImpl.saveReservation(newReservation);
                        
                        JOptionPane.showMessageDialog(panel, "Reservation created successfully!");

                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel, "Failed to create reservation", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            
            JButton updateButton = new JButton("Update Reservation");
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String reservationIdInput = JOptionPane.showInputDialog("Enter Reservation ID to Update:");
                        if (reservationIdInput == null || reservationIdInput.isEmpty()) throw new IllegalArgumentException("Reservation ID cannot be empty.");
                        int reservationId = Integer.parseInt(reservationIdInput);
            
                        Reservation existingReservation = reservationDaoImpl.getReservationByID(reservationId);
                        if (existingReservation == null) {
                            JOptionPane.showMessageDialog(panel, "Reservation not found.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
            
                        String[] options = {"Check-in Date", "Check-out Date", "Number of Guests", "Cancel"};
                        int choice = JOptionPane.showOptionDialog(
                            panel,
                            "What would you like to update?",
                            "Update Reservation",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]
                        );
            
                        switch (choice) {
                            case 0: 
                                String newCheckinDate = JOptionPane.showInputDialog("Enter new Check-in Date (YYYY-MM-DD):", existingReservation.getCheckinDate());
                                if (newCheckinDate != null && !newCheckinDate.isEmpty()) {
                                    existingReservation.setCheckinDate(java.sql.Date.valueOf(newCheckinDate));
                                }
                                break;
            
                            case 1: 
                                String newCheckoutDate = JOptionPane.showInputDialog("Enter new Check-out Date (YYYY-MM-DD):", existingReservation.getCheckoutDate());
                                if (newCheckoutDate != null && !newCheckoutDate.isEmpty()) {
                                    existingReservation.setCheckoutDate(java.sql.Date.valueOf(newCheckoutDate));
                                    long diff = existingReservation.getCheckoutDate().getTime() - existingReservation.getCheckinDate().getTime();
                                    existingReservation.setTotalDays((int) (diff / (1000 * 60 * 60 * 24)));
                                }
                                break;
            
                            case 2: 
                                String newNumOfGuests = JOptionPane.showInputDialog("Enter new Number of Guests:", existingReservation.getNumOfGuests());
                                if (newNumOfGuests != null && !newNumOfGuests.isEmpty()) {
                                    existingReservation.setNumOfGuests(Integer.parseInt(newNumOfGuests));
                                }
                                break;
            
                            case 3: // Cancel (do nothing)
                                JOptionPane.showMessageDialog(panel, "Update canceled.");
                                return;
            
                            default:
                                JOptionPane.showMessageDialog(panel, "Invalid selection.");
                                return;
                        }

                        reservationDaoImpl.updateReservation(existingReservation);
                        JOptionPane.showMessageDialog(panel, "Reservation updated successfully!");
            
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel, "Failed to update reservation" , "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });            
            
            JButton cancelButton = new JButton("Cancel Reservation");
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idInput = JOptionPane.showInputDialog("Enter Reservation ID to Cancel:");
                    try {
                        int reservationId = Integer.parseInt(idInput);
                        Reservation reservation = reservationDaoImpl.getReservationByID(reservationId);
                        if (reservation != null) {
                            int confirmation = JOptionPane.showConfirmDialog(panel, "Are you sure you want to cancel this reservation?");
                            if (confirmation == JOptionPane.YES_OPTION) {
                                reservationDaoImpl.deleteReservation(reservationId); 
                                JOptionPane.showMessageDialog(panel, "Reservation canceled successfully!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(panel, "Reservation not found.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panel, "Invalid ID format.");
                    }
                }
            });
            
            JButton searchButton = new JButton("Search Reservations");
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idInput = JOptionPane.showInputDialog("Enter Reservation ID to Search: ");
                    try {
                        int reservationId = Integer.parseInt(idInput);
                        Reservation reservation = reservationDaoImpl.getReservationByID(reservationId);
                        if (reservation != null) {
                            JOptionPane.showMessageDialog(panel, "Reservation Found:\nID: " + reservation.getReservationId() +
                                    "\nCustomer Id: " + reservation.getUserId());
                        } else {
                            JOptionPane.showMessageDialog(panel, "No reservation found with ID: " + reservationId);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panel, "Invalid ID format.");
                    }
                }
            });
    
            // Customize the appearance of the buttons
            Font buttonFont = new Font("Mulish", Font.BOLD, 16);
            Color buttonColor = Color.decode("#E3DFD5");
            Color textColor = Color.decode("#000000");
    
            // Array of buttons for easier customization
            JButton[] buttons = {viewAllButton, createNewButton, updateButton, cancelButton, searchButton};
    
            for (JButton button : buttons) {
                button.setPreferredSize(new Dimension(160, 40));
                button.setFont(buttonFont);
                button.setBackground(buttonColor);
                button.setForeground(textColor);
                button.setFocusable(false);
                button.setVisible(true);
                reservationPanel.add(button); // Add button to the panel
            }
        }
    
        // Add the reservationPanel to the main panel directly
        panel.add(reservationPanel);
        reservationPanel.setVisible(false);
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
    private void createServiceOrderTab(){
        // ServiceOrderTab setup
        ServiceOrderTab = new JButton();
        ServiceOrderTab.setFocusable(false);
        ServiceOrderTab.setBackground(new Color(132, 121, 102));
        ServiceOrderTab.setBorderPainted(false);
        ServiceOrderTab.setText("SERVICE ORDERS");
        ServiceOrderTab.setFont(new Font("Mulish", Font.BOLD, 21));
        ServiceOrderTab.setBounds(16, 209, 235, 33);
        ServiceOrderTab.setForeground(new Color(245, 242, 233));
        ServiceOrderTab.setHorizontalTextPosition(SwingConstants.LEFT);
        ServiceOrderTab.setHorizontalAlignment(SwingConstants.LEFT);
        ServiceOrderTab.setVisible(true);
        new Interaction(ServiceOrderTab,false);
        panel.add(ServiceOrderTab);
    }
    private void createFinancialTab(){
        // FinancialTab setup
        FinancialTab = new JButton();
        FinancialTab.setFocusable(false);
        FinancialTab.setBackground(new Color(132, 121, 102));
        FinancialTab.setBorderPainted(false);
        FinancialTab.setText("FINANCIAL DATA");
        FinancialTab.setFont(new Font("Mulish", Font.BOLD, 21));
        FinancialTab.setBounds(16, 253, 235, 33);
        FinancialTab.setForeground(new Color(245, 242, 233));
        FinancialTab.setHorizontalTextPosition(SwingConstants.LEFT);
        FinancialTab.setHorizontalAlignment(SwingConstants.LEFT);
        FinancialTab.setVisible(true);
        new Interaction(FinancialTab,false);
        panel.add(FinancialTab);
    }
    private void createUsersTab(){
        // UsersTab setup
        UsersTab = new JButton();
        UsersTab.setFocusable(false);
        UsersTab.setBackground(new Color(132, 121, 102));
        UsersTab.setBorderPainted(false);
        UsersTab.setText("USERS");
        UsersTab.setFont(new Font("Mulish", Font.BOLD, 21));
        UsersTab.setBounds(16, 300, 235, 33);
        UsersTab.setForeground(new Color(245, 242, 233));
        UsersTab.setHorizontalTextPosition(SwingConstants.LEFT);
        UsersTab.setHorizontalAlignment(SwingConstants.LEFT);
        UsersTab.setVisible(true);
        new Interaction(UsersTab,false);
        panel.add(UsersTab);
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
    private void createAdminRoomMenu(){
        String adminRoomMenuOption[] = {"Availability","Cleaning"};
        adminRoomMenu = new JComboBox(adminRoomMenuOption);
        adminRoomMenu.setBounds(277, 6, 135, 36);
        adminRoomMenu.setFont(new Font("Mulish", Font.BOLD, 16));
        adminRoomMenu.setBackground(new Color(244, 242, 235));
        adminRoomMenu.setFocusable(false);
        adminRoomMenu.setVisible(true);
        panel.add(adminRoomMenu);
        // Add ActionListener to handle selection changes
        adminRoomMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected option
                String selectedOption = (String) adminRoomMenu.getSelectedItem();

                // Show the appropriate panel based on the selection
                if ("Availability".equals(selectedOption)) {
                    addRoomTabComponents();
                    removeRoomCleaningTabComponents();
                } else if ("Cleaning".equals(selectedOption)) {
                    addRoomCleaningTabComponents();
                    removeRoomTabComponents();
                }
            }
        });
    }
    private void createServiceOrderPanel(){
        String[][] serviceOrderBaseData = {{" "," "," "," "," "}};
        String[] serviceOrderColumnNames = {"CustomerID","ServiceType","Date","Time","Assigned to"};
        serviceOrderTable = new JTable(serviceOrderBaseData,serviceOrderColumnNames);
        serviceOrderTable.setBounds(374,40,800,530);
        serviceOrderTable.getTableHeader().setFont(new Font("Mulish", Font.BOLD, 13));
        serviceOrderTable.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
        serviceOrderTable.setVisible(false);

        serviceOrderScrollPane = new JScrollPane(serviceOrderTable);
        serviceOrderScrollPane.setBounds(374, 40, 800, 530); // Set bounds for JScrollPane
        serviceOrderScrollPane.setVisible(false);
        panel.add(serviceOrderScrollPane);

        serviceOrderPanel = new JPanel();
        serviceOrderPanel.setBounds(374,40,800,530);
        serviceOrderPanel.setOpaque(false);
        serviceOrderPanel.setVisible(false);
        panel.add(serviceOrderPanel);
    }

    private void createManageUserPanel(){
        String[][] ManageUserBaseData = {{" "," "}};
        String[] ManageUserColumnNames = {"UserID","Role"};
        ManageUserTable = new JTable(ManageUserBaseData,ManageUserColumnNames);
        ManageUserTable.setBounds(374,40,800,530);
        ManageUserTable.getTableHeader().setFont(new Font("Mulish", Font.BOLD, 13));
        ManageUserTable.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
        ManageUserTable.setVisible(false);

        ManageUserScrollPane = new JScrollPane(ManageUserScrollPane);
        ManageUserScrollPane.setBounds(374, 40, 800, 530); // Set bounds for JScrollPane
        ManageUserScrollPane.setVisible(false);
        panel.add(ManageUserScrollPane);

        ManageUserPanel = new JPanel();
        ManageUserPanel.setBounds(374,40,800,530);
        ManageUserPanel.setOpaque(false);
        ManageUserPanel.setVisible(false);
        panel.add(ManageUserPanel);
    }

    private void createTaskListPanel(){
        String[][] taskListBaseData = {{" "," "}};
        String[] taskListColumnNames = {"Assigned Room","Cleaning Status"};
        taskListTable = new JTable(taskListBaseData,taskListColumnNames);
        taskListTable.setBounds(374,40,800,530);
        taskListTable.getTableHeader().setFont(new Font("Mulish", Font.BOLD, 13));
        taskListTable.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
        taskListTable.setVisible(false);

        taskListScrollPane = new JScrollPane(taskListTable);
        taskListScrollPane.setBounds(374, 40, 800, 530); // Set bounds for JScrollPane
        taskListScrollPane.setVisible(false);
        panel.add(taskListScrollPane);

        taskListPanel = new JPanel();
        taskListPanel.setBounds(374,40,800,530);
        taskListPanel.setOpaque(false);
        taskListPanel.setVisible(false);
        panel.add(taskListPanel);
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
    private void addAdminRoomMenu(){
        adminRoomMenu.setVisible(true);
    }
    private void removeAdminRoomMenu(){
        adminRoomMenu.setVisible(false);
    }
    private void addServiceOrderComponents(){
        serviceOrderPanel.setVisible(true);
        serviceOrderTable.setVisible(true);
        serviceOrderScrollPane.setVisible(true);
    }
    private void removeServiceOrderComponents(){
        serviceOrderPanel.setVisible(false);
        serviceOrderTable.setVisible(false);
        serviceOrderScrollPane.setVisible(false);
    }
    private void addTaskListComponents(){
        taskListPanel.setVisible(true);
        taskListTable.setVisible(true);
        taskListScrollPane.setVisible(true);
    }
    private void removeTaskListComponents(){
        taskListPanel.setVisible(false);
        taskListTable.setVisible(false);
        taskListScrollPane.setVisible(false);
    }
    private void addReservationTabComponents(){
        reservationPanel.setVisible(true);
    }
    private void removeReservationTabComponents(){
        reservationPanel.setVisible(false);
    }
    private void addManageUserComponents(){
        ManageUserTable.setVisible(true);
        ManageUserPanel.setVisible(true);
        ManageUserScrollPane.setVisible(true);
    }
    private void removeManageUserComponents(){
        ManageUserTable.setVisible(false);
        ManageUserPanel.setVisible(false);
        ManageUserScrollPane.setVisible(false);
    }
}
//debug commit command