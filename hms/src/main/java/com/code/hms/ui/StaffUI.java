package com.code.hms.ui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

import com.code.hms.daoimpl.*;
import com.code.hms.entities.Billing;
import com.code.hms.entities.Reservation;
import com.code.hms.entities.Room;
import com.code.hms.entities.User;

import java.util.List;

import com.code.hms.entities.Room;
import com.code.hms.entities.Room_Reservation;
import com.code.hms.entities.Room_Reservation_Pk;


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
    static JPanel financialPanel;
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
    static JTable billingTable;
    static JScrollPane serviceOrderScrollPane;
    static JScrollPane taskListScrollPane;
    static JScrollPane ManageUserScrollPane;
    static JScrollPane billingScrollPane;
    static ReservationDaoImpl reservationDaoImpl;
    static RoomDaoImpl roomDaoImpl;
    static Room_ReservationDaoImpl room_ReservationDaoImpl; 
    static UserDaoImpl userDaoImpl;
    static BillingDaoImpl billingDaoImpl;
    static Service_OrderDAOImpl serviceOrderDaoImpl;

    static List<Object[]> serviceOrders;
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
    }

    public StaffUI(String role) {
        serviceOrderDaoImpl = new Service_OrderDAOImpl();
        serviceOrders = serviceOrderDaoImpl.getAllServiceOrders();

        reservationDaoImpl = new ReservationDaoImpl();
        room_ReservationDaoImpl = new Room_ReservationDaoImpl();
        roomDaoImpl = new RoomDaoImpl();
        billingDaoImpl = new BillingDaoImpl();
        reservationDaoImpl = new ReservationDaoImpl();
        userDaoImpl = new UserDaoImpl();
        switch (role) {
            case "Receptionist":
                initializeUI();
                createReceptionistUI();
                break;
            case "Housekeeper":
                initializeUI();
                createHousekeeperUI();
                break;
            case "Admin":
                initializeUI();
                createAdminUI();
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }

    }

    private void initializeUI() {
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

    private void createReceptionistUI() {
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

    private void createHousekeeperUI() {
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

    private void createAdminUI() {
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
                removeManageUserComponents();
                removeServiceOrderComponents();
                removeReservationTabComponents();
                removeFinancialComponents();
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
                removeFinancialComponents();
                addReservationTabComponents();
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

                
                if (serviceOrders != null && !serviceOrders.isEmpty()) {
                    addServiceOrderComponents();
                } else {
                    JOptionPane.showMessageDialog(null, "No service orders found.", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
                removeRoomTabComponents();
                removeAdminRoomMenu();
                removeRoomCleaningTabComponents();
                removeManageUserComponents();
                removeReservationTabComponents();
                removeFinancialComponents();
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
                removeManageUserComponents();
                removeReservationTabComponents();
                removeServiceOrderComponents();
                addFinancialComponents();
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

                removeRoomTabComponents();
                removeAdminRoomMenu();
                removeRoomCleaningTabComponents();
                removeServiceOrderComponents();
                removeFinancialComponents();
                addManageUserComponents();
            }
        });
        createServiceOrderPanel();
        
        addFinancialPanel();
        addAdminReservationPanel();
        addManageUserPanel();
        addAdminReservationPanel();
        addRoomPanel();
        addRoomCleaningPanel();
        
        createAdminRoomMenu();
        createAllBackgrounds();
        
        removeRoomCleaningTabComponents();
        removeReservationTabComponents();

    }

    private void addRoomPanel() {
        // Create panel with grid layout
        roomPanel = new JPanel();
        roomPanel.setLayout(new GridLayout(6, 6, 27, 27)); // 6x6 grid with padding
        roomPanel.setBounds(417, 40, 713, 530);

        // Generate buttons
        for (int floor = 1; floor <= 6; floor++) {
            for (int room = 1; room <= 6; room++) {
                int roomNumber = floor * 100 + room;

                JButton roomButton = new JButton(String.valueOf(roomNumber));
                roomButton.setPreferredSize(new Dimension(96, 71));
                roomButton.setFont(new Font("Mulish", Font.BOLD, 20));
                roomButton.setOpaque(true);
                roomButton.setBorderPainted(true);
                roomButton.setFocusable(false);

                // Initialize button color based on room status in the database
                initializeRoomButtonColor(roomButton, roomNumber);

                // Add action listener to toggle room status
                roomButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            // Fetch current status from the database
                            String currentStatus = roomDaoImpl.getRoomStatus(roomNumber);

                            if ("Available".equals(currentStatus)) {
                                // Change to 'Unavailable' and update the database
                                roomButton.setBackground(Color.decode("#E1756E")); // Unavailable color
                                roomButton.setForeground(Color.decode("#F5F2E9"));
                                roomDaoImpl.setRoomCheckedIn(roomNumber);
                            } else {
                                // Change to 'Available' and update the database
                                roomButton.setBackground(Color.decode("#E3DFD5")); // Available color
                                roomButton.setForeground(Color.decode("#000000"));
                                roomDaoImpl.setRoomCheckedOut(roomNumber);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                roomPanel.add(roomButton);
            }
        }
        panel.add(roomPanel);

    //available_unavailable labels
        available_unavailable = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Rooms_Available_Unavailable.png", 298, 28));
        available_unavailable.setBounds(576, 576, 399, 35);
        available_unavailable.setVisible(true);
        panel.add(available_unavailable);
    }
    private void initializeRoomButtonColor(JButton roomButton, int roomNumber) {
        try {
            String status = roomDaoImpl.getRoomStatus(roomNumber); // Query the room's status
            if ("Available".equals(status)) {
                roomButton.setBackground(Color.decode("#E3DFD5")); // Available color
                roomButton.setForeground(Color.decode("#000000"));
            } else if ("Cleaning".equals(status)) {
                roomButton.setBackground(Color.decode("#FFD700")); // Cleaning color
                roomButton.setForeground(Color.decode("#000000"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void addReservationPanel() {
        if (reservationPanel == null) {
            reservationPanel = new JPanel();
            reservationPanel.setLayout(new BorderLayout(20, 20));
            JPanel gridPanel = new JPanel(new GridLayout(2, 2, 10, 10));
            reservationPanel.setBounds(417, 40, 713, 530); // 
            // Define buttons for various reservation actions
            JButton viewAllButton = createRoundedButton("View All Reservations");
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

                        for (int i = 0; i < table.getColumnCount(); i++) {
                            int maxWidth = 0;

                            for (int j = 0; j < table.getRowCount(); j++) {
                                Object value = table.getValueAt(j, i);
                                if (value != null) {
                                    int width = value.toString().length();
                                    maxWidth = Math.max(maxWidth, width);
                                }
                            }

                            TableColumn column = table.getColumnModel().getColumn(i);
                            column.setPreferredWidth(maxWidth * 10);
                        }

                        JScrollPane scrollPane = new JScrollPane(table);

                        JPanel panel = new JPanel(new BorderLayout());
                        panel.add(scrollPane, BorderLayout.CENTER);


                        JFrame frame = new JFrame("All Reservations");
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.add(panel);
                        frame.setSize(800, 600);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "No reservations found.", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

            
            JButton createNewButton = createRoundedButton("Create New Reservation");
            createNewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String checkinDateInput = JOptionPane.showInputDialog("Enter Check-in Date (YYYY-MM-DD):");
                        if (checkinDateInput == null || checkinDateInput.isEmpty())
                            throw new IllegalArgumentException("Check-in date cannot be empty.");
                        java.sql.Date checkinDate = java.sql.Date.valueOf(checkinDateInput);

                        String checkoutDateInput = JOptionPane.showInputDialog("Enter Check-out Date (YYYY-MM-DD):");
                        if (checkoutDateInput == null || checkoutDateInput.isEmpty())
                            throw new IllegalArgumentException("Check-out date cannot be empty.");
                        java.sql.Date checkoutDate = java.sql.Date.valueOf(checkoutDateInput);

                        long difference = checkoutDate.getTime() - checkinDate.getTime();
                        int totalDays = (int) (difference / (1000 * 60 * 60 * 24));
                        if (totalDays <= 0)
                            throw new IllegalArgumentException("Check-out date must be after check-in date.");

                        String numGuestsInput = JOptionPane.showInputDialog("Enter Number of Guests:");
                        if (numGuestsInput == null || numGuestsInput.isEmpty())
                            throw new IllegalArgumentException("Number of guests cannot be empty.");
                        int numOfGuests = Integer.parseInt(numGuestsInput);

                        List<Room> availableRooms = roomDaoImpl.getAllAvailableRooms(); 
                        if (availableRooms.isEmpty())
                            throw new IllegalArgumentException("No rooms available for the selected dates!");

                        DefaultListModel<String> roomListModel = new DefaultListModel<>();
                        for (Room room : availableRooms) {
                            roomListModel.addElement("Room ID: " + room.getRoomId() + ", Type: " + room.getRoomType());
                        }

                        JList<String> roomList = new JList<>(roomListModel);
                        roomList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                        JScrollPane scrollPane = new JScrollPane(roomList);
                        scrollPane.setPreferredSize(new Dimension(300, 200));

                        int result = JOptionPane.showConfirmDialog(
                            panel,
                            scrollPane,
                            "Select Room(s)",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE
                        );

                        if (result != JOptionPane.OK_OPTION || roomList.getSelectedValuesList().isEmpty()) {
                            throw new IllegalArgumentException("You must select at least one room.");
                        }

                        Reservation newReservation = new Reservation();
                        newReservation.setCheckinDate(checkinDate);
                        newReservation.setCheckoutDate(checkoutDate);
                        newReservation.setTotalDays(totalDays);
                        newReservation.setNumOfGuests(numOfGuests);
                        reservationDaoImpl.saveReservation(newReservation);

                        for (String selectedRoom : roomList.getSelectedValuesList()) { 
                            int roomId = Integer.parseInt(selectedRoom.split(" ")[2].replace(",", ""));
                            Room_Reservation room_Reservation = new Room_Reservation();
                            Room_Reservation_Pk pk = new Room_Reservation_Pk(roomId,newReservation.getReservationId());
                            room_Reservation.setPk(pk);
                            Room room = roomDaoImpl.getRoomByRoomID(roomId);
                            room_Reservation.setRoom(room);
                            room_Reservation.setReservation(newReservation);
                            room_Reservation.setDate(checkinDate);
                            room_Reservation.setTime(new java.sql.Time(System.currentTimeMillis()));
                            room_ReservationDaoImpl.saveRoomReservation(room_Reservation);
                            room.setRoomStatus("Unavailable");
                            roomDaoImpl.updateRoom(room);
                        }
                        JOptionPane.showMessageDialog(panel, "Reservation created successfully!");

                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(panel, "Failed to create reservation", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });


            JButton updateButton = createRoundedButton("Update Reservation");
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String reservationIdInput = JOptionPane.showInputDialog("Enter Reservation ID to Update:");
                        if (reservationIdInput == null || reservationIdInput.isEmpty())
                            throw new IllegalArgumentException("Reservation ID cannot be empty.");
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
                        JOptionPane.showMessageDialog(panel, "Failed to update reservation", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            JButton cancelButton = createRoundedButton("Cancel Reservation");
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

            JButton searchButton = createRoundedButton("Search Reservations");
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idInput = JOptionPane.showInputDialog("Enter Reservation ID to Search: ");
                    try {
                        int reservationId = Integer.parseInt(idInput);
                        Reservation reservation = reservationDaoImpl.getReservationByID(reservationId);

                        if (reservation != null) {
                            String[] columnNames = {
                                    "Reservation ID", "User ID", "Check-in Date",
                                    "Check-out Date", "Total Days", "Number of Guests"
                            };
                            Object[][] data = {
                                    {
                                            reservation.getReservationId(),
                                            reservation.getUserId(),
                                            reservation.getCheckinDate(),
                                            reservation.getCheckoutDate(),
                                            reservation.getTotalDays(),
                                            reservation.getNumOfGuests()
                                    }
                            };
                            JTable table = new JTable(data, columnNames);

                            for (int i = 0; i < table.getColumnCount(); i++) {
                                int maxWidth = 0;

                                for (int j = 0; j < table.getRowCount(); j++) {
                                    Object value = table.getValueAt(j, i);
                                    if (value != null) {
                                        int width = value.toString().length();
                                        maxWidth = Math.max(maxWidth, width);
                                    }
                                }

                                TableColumn column = table.getColumnModel().getColumn(i);
                                column.setPreferredWidth(maxWidth * 10);
                            }

                            JScrollPane scrollPane = new JScrollPane(table);

                            JPanel panel = new JPanel(new BorderLayout());
                            panel.add(scrollPane, BorderLayout.CENTER);


                            JFrame frame = new JFrame("Reservation found");
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.add(panel);
                            frame.setSize(800, 600);
                            frame.setLocationRelativeTo(null);
                            frame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(panel, "No reservation found with ID: " + reservationId, "Information", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panel, "Invalid ID format. Please enter a numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel, "An error occurred while fetching the reservation.", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            });


            // Customize the appearance of the buttons
            Font buttonFont = new Font("Mulish", Font.BOLD, 16);
            Color buttonColor = Color.decode("#E3DFD5");
            Color textColor = Color.decode("#000000");

            gridPanel.add(viewAllButton);
            gridPanel.add(updateButton);
            gridPanel.add(cancelButton);
            gridPanel.add(searchButton);
            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            topPanel.add(createNewButton);
            reservationPanel.add(topPanel, BorderLayout.NORTH);
            reservationPanel.add(gridPanel, BorderLayout.CENTER);

            JButton[] buttons = {viewAllButton, createNewButton, updateButton, cancelButton, searchButton};

            for (JButton button : buttons) {
                button.setPreferredSize(new Dimension(220, 40));
                button.setFont(buttonFont);
                button.setBackground(buttonColor);
                button.setForeground(textColor);
                button.setFocusable(false);
                button.setVisible(true);
            }
            JLabel dateLabel = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/clock.png", 20, 20));
            dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
            dateLabel.setForeground(Color.DARK_GRAY);
            dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
            String currentDate = dateFormat.format(new Date());
            dateLabel.setText(" " + currentDate);
            reservationPanel.add(dateLabel, BorderLayout.SOUTH);
        }

        panel.add(reservationPanel);
        reservationPanel.setVisible(false);
    }

    private void addAdminReservationPanel() {
        if (reservationPanel == null) {
            reservationPanel = new JPanel();
            reservationPanel.setLayout(new BorderLayout(20, 20));
            JPanel gridPanel = new JPanel(new GridLayout(2, 2, 10, 10));
            reservationPanel.setBounds(417, 40, 713, 530); // 
            // Define buttons for various reservation actions
            JButton viewAllButton = createRoundedButton("View All Reservations");
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

                        for (int i = 0; i < table.getColumnCount(); i++) {
                            int maxWidth = 0;

                            for (int j = 0; j < table.getRowCount(); j++) {
                                Object value = table.getValueAt(j, i);
                                if (value != null) {
                                    int width = value.toString().length();
                                    maxWidth = Math.max(maxWidth, width);
                                }
                            }

                            TableColumn column = table.getColumnModel().getColumn(i);
                            column.setPreferredWidth(maxWidth * 10);
                        }

                        JScrollPane scrollPane = new JScrollPane(table);

                        JPanel panel = new JPanel(new BorderLayout());
                        panel.add(scrollPane, BorderLayout.CENTER);


                        JFrame frame = new JFrame("All Reservations");
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.add(panel);
                        frame.setSize(800, 600);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "No reservations found.", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

            JButton updateButton = createRoundedButton("Update Reservation");
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String reservationIdInput = JOptionPane.showInputDialog("Enter Reservation ID to Update:");
                        if (reservationIdInput == null || reservationIdInput.isEmpty())
                            throw new IllegalArgumentException("Reservation ID cannot be empty.");
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
                        JOptionPane.showMessageDialog(panel, "Failed to update reservation", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            JButton cancelButton = createRoundedButton("Cancel Reservation");
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

            JButton searchButton = createRoundedButton("Search Reservations");
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idInput = JOptionPane.showInputDialog("Enter Reservation ID to Search: ");
                    try {
                        int reservationId = Integer.parseInt(idInput);
                        Reservation reservation = reservationDaoImpl.getReservationByID(reservationId);

                        if (reservation != null) {
                            String[] columnNames = {
                                    "Reservation ID", "User ID", "Check-in Date",
                                    "Check-out Date", "Total Days", "Number of Guests"
                            };
                            Object[][] data = {
                                    {
                                            reservation.getReservationId(),
                                            reservation.getUserId(),
                                            reservation.getCheckinDate(),
                                            reservation.getCheckoutDate(),
                                            reservation.getTotalDays(),
                                            reservation.getNumOfGuests()
                                    }
                            };
                            JTable table = new JTable(data, columnNames);

                            for (int i = 0; i < table.getColumnCount(); i++) {
                                int maxWidth = 0;

                                for (int j = 0; j < table.getRowCount(); j++) {
                                    Object value = table.getValueAt(j, i);
                                    if (value != null) {
                                        int width = value.toString().length();
                                        maxWidth = Math.max(maxWidth, width);
                                    }
                                }

                                TableColumn column = table.getColumnModel().getColumn(i);
                                column.setPreferredWidth(maxWidth * 10);
                            }

                            JScrollPane scrollPane = new JScrollPane(table);

                            JPanel panel = new JPanel(new BorderLayout());
                            panel.add(scrollPane, BorderLayout.CENTER);


                            JFrame frame = new JFrame("Reservation found");
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.add(panel);
                            frame.setSize(800, 600);
                            frame.setLocationRelativeTo(null);
                            frame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(panel, "No reservation found with ID: " + reservationId, "Information", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panel, "Invalid ID format. Please enter a numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel, "An error occurred while fetching the reservation.", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            });


            // Customize the appearance of the buttons
            Font buttonFont = new Font("Mulish", Font.BOLD, 16);
            Color buttonColor = Color.decode("#E3DFD5");
            Color textColor = Color.decode("#000000");

            gridPanel.add(viewAllButton);
            gridPanel.add(updateButton);
            gridPanel.add(cancelButton);
            gridPanel.add(searchButton);
            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            reservationPanel.add(topPanel, BorderLayout.NORTH);
            reservationPanel.add(gridPanel, BorderLayout.CENTER);

            JButton[] buttons = {viewAllButton, updateButton, cancelButton, searchButton};

            for (JButton button : buttons) {
                button.setPreferredSize(new Dimension(220, 40));
                button.setFont(buttonFont);
                button.setBackground(buttonColor);
                button.setForeground(textColor);
                button.setFocusable(false);
                button.setVisible(true);
            }
            JLabel dateLabel = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/clock.png", 20, 20));
            dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
            dateLabel.setForeground(Color.DARK_GRAY);
            dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
            String currentDate = dateFormat.format(new Date());
            dateLabel.setText(" " + currentDate);
            reservationPanel.add(dateLabel, BorderLayout.SOUTH);
        }

        panel.add(reservationPanel);
        reservationPanel.setVisible(false);
    }

    private void addFinancialPanel() {
        if (financialPanel == null) {
            financialPanel = new JPanel();
            financialPanel.setLayout(new BorderLayout(20, 20));
            financialPanel.setBounds(417, 40, 713, 530);
    
            JPanel gridPanel = new JPanel(new GridLayout(2, 2, 10, 10));
            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
            JButton viewAllButton = createRoundedButton("View All Billings");
            JButton createNewButton = createRoundedButton("Create New Billing");
            JButton findBillingsButton = createRoundedButton("Find Billings");
            JButton deleteButton = createRoundedButton("Delete Billing");

            Font buttonFont = new Font("Mulish", Font.BOLD, 16);
            Color buttonColor = Color.decode("#E3DFD5");
            Color textColor = Color.decode("#000000");
    
            viewAllButton.addActionListener(e -> {
                List<Object[]> billings = billingDaoImpl.getAllBillings();
                if (billings != null && !billings.isEmpty()) {
                    String[] columnNames = {"Billing ID", "Reservation ID", "User ID", "Amount", "Payment Method", "Date"};
                    Object[][] data = new Object[billings.size()][6];
                    for (int i = 0; i < billings.size(); i++) {
                        Object[] row = billings.get(i);
                        data[i][0] = row[0]; // Billing ID
                        data[i][1] = row[4]; // Reservation ID
                        data[i][2] = row[5]; // User ID
                        data[i][3] = row[1]; // Amount
                        data[i][4] = row[2]; // Payment Method
                        data[i][5] = row[3]; // Date
                    }
                    JTable table = new JTable(data, columnNames);
                    JScrollPane scrollPane = new JScrollPane(table);
    
                    JFrame frame = new JFrame("All Billings");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.add(scrollPane);
                    frame.setSize(800, 600);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No billings found.", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            });
    
            createNewButton.addActionListener(e -> {
                try {
                    String reservationIdInput = JOptionPane.showInputDialog("Enter Reservation ID:");
                    int reservationId = Integer.parseInt(reservationIdInput);
                    Reservation reservation = reservationDaoImpl.getReservationByID(reservationId);
    
                    if (reservation == null) {
                        JOptionPane.showMessageDialog(null, "Reservation not found.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
    
                    String amountInput = JOptionPane.showInputDialog("Enter Amount:");
                    double amount = Double.parseDouble(amountInput);
    
                    // Get payment method
                    String paymentMethod = getPaymentMethodSelection();
                    if (paymentMethod == null) {
                        JOptionPane.showMessageDialog(null, "No payment method selected.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
    
                    Billing billing = new Billing();
                    billing.setReservation(reservation);
                    billing.setAmount(amount);
                    billing.setPaymentMethod(paymentMethod);
                    billing.setDate(new java.sql.Date(System.currentTimeMillis()));
    
                    billingDaoImpl.saveBilling(billing);
                    JOptionPane.showMessageDialog(null, "Billing created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error creating billing: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
    
            findBillingsButton.addActionListener(e -> {
                String[] options = {"Find by Reservation ID", "Find by User ID"};
                int choice = JOptionPane.showOptionDialog(
                        null,
                        "Select the search criteria:",
                        "Find Billings",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]
                );
            
                if (choice == 0) { // Search by Reservation ID
                    String reservationIdInput = JOptionPane.showInputDialog("Enter Reservation ID:");
                    try {
                        int reservationId = Integer.parseInt(reservationIdInput);
            
                        // Fetch billing for the Reservation ID
                        Object[] billing = billingDaoImpl.getBillingByReservationID(reservationId);
                        if (billing == null) {
                            JOptionPane.showMessageDialog(null, "No billing found for Reservation ID: " + reservationId, "Information", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            // Create table and display the result
                            String[] columnNames = {"Billing ID", "Reservation ID", "User ID", "Amount", "Payment Method", "Date"};
            
                            Object[][] data = new Object[1][6];
                            data[0][0] = billing[0]; // Billing ID
                            data[0][1] = billing[1]; // Reservation ID
                            data[0][2] = billing[2]; // User ID
                            data[0][3] = billing[3]; // Amount
                            data[0][4] = billing[4]; // Payment Method
                            data[0][5] = billing[5]; // Date
            
                            JTable table = new JTable(data, columnNames);
                            JScrollPane scrollPane = new JScrollPane(table);
            
                            JPanel panel = new JPanel(new BorderLayout());
                            panel.add(scrollPane, BorderLayout.CENTER);
            
                            JFrame frame = new JFrame("Billing Details");
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.add(panel);
                            frame.setSize(800, 200);
                            frame.setLocationRelativeTo(null);
                            frame.setVisible(true);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error finding billing: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (choice == 1) { // Search by User ID
                    String userIdInput = JOptionPane.showInputDialog("Enter User ID:");
                    try {
                        int userId = Integer.parseInt(userIdInput);
            
                        // Fetch all billings for the User ID
                        List<Object[]> billings = billingDaoImpl.getBillingsByUserId(userId);
                        if (billings.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No billings found for User ID: " + userId, "Information", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            // Create table and display the result
                            String[] columnNames = {"Billing ID", "Reservation ID", "User ID", "Amount", "Payment Method", "Date"};
            
                            Object[][] data = new Object[billings.size()][6];
                            for (int i = 0; i < billings.size(); i++) {
                                Object[] row = billings.get(i);
                                data[i][0] = row[0]; // Billing ID
                                data[i][1] = row[1]; // Reservation ID
                                data[i][2] = row[2]; // User ID
                                data[i][3] = row[3]; // Amount
                                data[i][4] = row[4]; // Payment Method
                                data[i][5] = row[5]; // Date
                            }
            
                            JTable table = new JTable(data, columnNames);
                            JScrollPane scrollPane = new JScrollPane(table);
            
                            JPanel panel = new JPanel(new BorderLayout());
                            panel.add(scrollPane, BorderLayout.CENTER);
            
                            JFrame frame = new JFrame("Billing Details");
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.add(panel);
                            frame.setSize(800, 400);
                            frame.setLocationRelativeTo(null);
                            frame.setVisible(true);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error finding billings: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });            
    
            deleteButton.addActionListener(e -> {
                try {
                    String billingIdInput = JOptionPane.showInputDialog("Enter Billing ID to Delete:");
                    int billingId = Integer.parseInt(billingIdInput);
                    Billing billing = billingDaoImpl.getBillingByID(billingId);
                    if (billing == null) {
                        JOptionPane.showMessageDialog(null, "Billing not found.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
    
                    int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this billing?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        billingDaoImpl.deleteBilling(billingId);
                        JOptionPane.showMessageDialog(null, "Billing deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error deleting billing: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
    
            gridPanel.add(viewAllButton);
            gridPanel.add(createNewButton);
            gridPanel.add(findBillingsButton);
            gridPanel.add(deleteButton);
    
            JButton[] buttons = {viewAllButton, createNewButton, findBillingsButton, deleteButton};
            for (JButton button : buttons) {
                button.setPreferredSize(new Dimension(220, 40));
                button.setFont(buttonFont);
                button.setBackground(buttonColor);
                button.setForeground(textColor);
                button.setFocusable(false);
            }
    
            JLabel dateLabel = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/clock.png", 20, 20));
            dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
            dateLabel.setForeground(Color.DARK_GRAY);
            dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
            dateLabel.setText(" " + dateFormat.format(new Date()));
    
            financialPanel.add(topPanel, BorderLayout.NORTH);
            financialPanel.add(gridPanel, BorderLayout.CENTER);
            financialPanel.add(dateLabel, BorderLayout.SOUTH);
        }
    
        panel.add(financialPanel);
        financialPanel.setVisible(false);
    }
     
    private void createRoomTab() {
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
        new Interaction(RoomManagementTab, true);
        panel.add(RoomManagementTab);
    }

    private void createReservationTab() {
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
        new Interaction(ReservationTab, false);
        panel.add(ReservationTab);
    }

    private void createCurrencyExchangeTab() {
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
        new Interaction(CurrencyExchangeTab, false);
        panel.add(CurrencyExchangeTab);
    }

    private void createTaskListTab() {
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
        new Interaction(TaskListTab, false);
        panel.add(TaskListTab);
    }

    private void createServiceOrderTab() {
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
        new Interaction(ServiceOrderTab, false);
        panel.add(ServiceOrderTab);
    }

    private void createFinancialTab() {
        // FinancialTab setup
        FinancialTab = new JButton();
        FinancialTab.setFocusable(false);
        FinancialTab.setBackground(new Color(132, 121, 102));
        FinancialTab.setBorderPainted(false);
        FinancialTab.setText("BILLING");
        FinancialTab.setFont(new Font("Mulish", Font.BOLD, 21));
        FinancialTab.setBounds(16, 253, 235, 33);
        FinancialTab.setForeground(new Color(245, 242, 233));
        FinancialTab.setHorizontalTextPosition(SwingConstants.LEFT);
        FinancialTab.setHorizontalAlignment(SwingConstants.LEFT);
        FinancialTab.setVisible(true);
        new Interaction(FinancialTab, false);
        panel.add(FinancialTab);

    }

    private void createUsersTab() {
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
        new Interaction(UsersTab, false);
        panel.add(UsersTab);
    }

    private void createAllBackgrounds() {
        //Tab1_background
        Tab1_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab1_BG.png", 1280, 672));
        Tab1_background.setBounds(0, 0, 1280, 672);
        Tab1_background.setVisible(true);
        panel.add(Tab1_background);

        //Tab2_background
        Tab2_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab2_BG.png", 1280, 672));
        Tab2_background.setBounds(0, 0, 1280, 672);
        Tab2_background.setVisible(false);
        panel.add(Tab2_background);

        //Tab3_background
        Tab3_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab3_BG.png", 1280, 672));
        Tab3_background.setBounds(0, 0, 1280, 672);
        Tab3_background.setVisible(false);
        panel.add(Tab3_background);

        //Tab4_background
        Tab4_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab4_BG.png", 1280, 672));
        Tab4_background.setBounds(0, 0, 1280, 672);
        Tab4_background.setVisible(false);
        panel.add(Tab4_background);

        //Tab5_background
        Tab5_background = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Tab5_BG.png", 1280, 672));
        Tab5_background.setBounds(0, 0, 1280, 672);
        Tab5_background.setVisible(false);
        panel.add(Tab5_background);
    }

    private void addRoomCleaningPanel() {
        // Create panel with grid layout
        roomCleaningPanel = new JPanel();
        roomCleaningPanel.setLayout(new GridLayout(6, 6, 27, 27)); // 6x6 grid with padding
        roomCleaningPanel.setBounds(417, 40, 713, 530);

        // Generate buttons
        for (int floor = 1; floor <= 6; floor++) {
            for (int room = 1; room <= 6; room++) {
                int roomNumber = floor * 100 + room;
                JButton roomCleanButton = new JButton(String.valueOf(roomNumber));
                roomCleanButton.setPreferredSize(new Dimension(96, 71));
                roomCleanButton.setBackground(Color.decode("#B3E8F2"));
                roomCleanButton.setFont(new Font("Mulish", Font.BOLD, 20));
                roomCleanButton.setForeground(Color.decode("#434238"));
                roomCleanButton.setOpaque(true);
                roomCleanButton.setBorderPainted(true);
                roomCleanButton.setFocusable(false);

                initializeRoomCleanButtonColor(roomCleanButton, roomNumber);

                // Add action listener to toggle room status
                roomCleanButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            // Fetch current status from the database
                            String cleaningStatus = roomDaoImpl.getRoomCleaningStatus(roomNumber);

                            if ("Clean".equals(cleaningStatus)) {
                                // Change to 'Unavailable' and update the database
                                roomCleanButton.setBackground(Color.decode("#E1756E")); // unclean color
                                roomCleanButton.setForeground(Color.decode("#F5F2E9"));
                                roomDaoImpl.setRoomUncleaned(roomNumber);
                            } else {
                                // Change to 'Clean' and update the database
                                roomCleanButton.setBackground(Color.decode("#B3E8F2")); // clean color
                                roomCleanButton.setForeground(Color.decode("#000000"));
                                roomDaoImpl.setRoomCleaned(roomNumber);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                roomCleaningPanel.add(roomCleanButton);
            }
        }
        panel.add(roomCleaningPanel);

        //available_unavailable labels
        cleaned_uncleaned = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/Cleaned_Uncleaned.png", 298, 28));
        cleaned_uncleaned.setBounds(576, 576, 399, 35);
        cleaned_uncleaned.setVisible(true);
        panel.add(cleaned_uncleaned);
    }

    private void initializeRoomCleanButtonColor(JButton button, int roomNumber) {
        String cleaningStatus = roomDaoImpl.getRoomCleaningStatus(roomNumber);
        if ("Clean".equals(cleaningStatus)) {
            button.setBackground(Color.decode("#B3E8F2")); // Clean color
            button.setForeground(Color.decode("#434238"));
        } else if ("Unclean".equals(cleaningStatus)){
            button.setBackground(Color.decode("#E1756E")); // Unclean color
            button.setForeground(Color.decode("#F5F2E9"));
        }
    }

    private void createAdminRoomMenu() {
        String adminRoomMenuOption[] = {"Availability", "Cleaning"};
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


    private void createServiceOrderPanel() {
        /*String[][] serviceOrderBaseData = {{" ", " ", " ", " ", " "}};
        String[] serviceOrderColumnNames = {"CustomerID", "ServiceType", "Date", "Time", "Assigned to"};
        serviceOrderTable = new JTable(serviceOrderBaseData, serviceOrderColumnNames);
        serviceOrderTable.setBounds(374, 40, 800, 530);
        serviceOrderTable.getTableHeader().setFont(new Font("Mulish", Font.BOLD, 13));
        serviceOrderTable.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
        serviceOrderTable.setVisible(false);
*/
        
            String[] columnNames = {"User ID", "ServiceType", "Date", "Time"};

            Object[][] data = new Object[serviceOrders.size()][4];
            for (int i = 0; i < serviceOrders.size(); i++) {
                Object[] row = serviceOrders.get(i);
                data[i][0] = row[0]; // User ID
                data[i][1] = row[1]; // ServiceType
                data[i][2] = row[2]; // Date
                data[i][3] = row[3]; // Time
            }

            serviceOrderTable = new JTable(data, columnNames);
            serviceOrderTable.setBounds(374, 40, 800, 530);
            serviceOrderTable.getTableHeader().setFont(new Font("Mulish", Font.BOLD, 13));
            serviceOrderTable.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
            serviceOrderTable.setVisible(true);

            for (int i = 0; i < serviceOrderTable.getColumnCount(); i++) {
                int maxWidth = 0;

                for (int j = 0; j < serviceOrderTable.getRowCount(); j++) {
                    Object value = serviceOrderTable.getValueAt(j, i);
                    if (value != null) {
                        int width = value.toString().length();
                        maxWidth = Math.max(maxWidth, width);
                    }
                }

                TableColumn column = serviceOrderTable.getColumnModel().getColumn(i);
                column.setPreferredWidth(maxWidth * 10);
            }

            serviceOrderScrollPane = new JScrollPane(serviceOrderTable);
            serviceOrderScrollPane.setBounds(374, 40, 800, 530); // Set bounds for JScrollPane
            serviceOrderScrollPane.setVisible(false);
            panel.add(serviceOrderScrollPane);

            serviceOrderPanel = new JPanel();
            serviceOrderPanel.setBounds(374, 40, 800, 530);
            serviceOrderPanel.setOpaque(false);
            serviceOrderPanel.setVisible(false);
            panel.add(serviceOrderPanel);

            
            /*JPanel panel = new JPanel(new BorderLayout());
            panel.add(scrollPane, BorderLayout.CENTER);

            JFrame frame = new JFrame("All Service Orders");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(panel);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);*/
        
    }

    private void addManageUserPanel() {
        if (ManageUserPanel == null) {
            ManageUserPanel = new JPanel();
            ManageUserPanel.setLayout(new BorderLayout(20, 20));
            JPanel gridPanel = new JPanel(new GridLayout(2, 2, 10, 10));
            ManageUserPanel.setBounds(417, 40, 713, 530); //
            // Define buttons for various reservation actions
            JButton viewAllUserButton = createRoundedButton("View All Users");
            viewAllUserButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List<User> users = userDaoImpl.getAllUsers();
                    if (users != null && !users.isEmpty()) {
                        String[] columnNames = {"User_ID", "Username", "Password", "First Name",
                                "Last Name", "Email", "Phone", "Role"};

                        Object[][] data = new Object[users.size()][8];
                        for (int i = 0; i < users.size(); i++) {
                            User user = users.get(i);
                            data[i][0] = user.getUserId();
                            data[i][1] = user.getUsername();
                            data[i][2] = user.getPassword();
                            data[i][3] = user.getFirstName();
                            data[i][4] = user.getLastName();
                            data[i][5] = user.getEmail();
                            data[i][6] = user.getPhone();
                            data[i][7] = user.getRole();
                        }

                        JTable table = new JTable(data, columnNames);

                        for (int i = 0; i < table.getColumnCount(); i++) {
                            int maxWidth = 0;

                            for (int j = 0; j < table.getRowCount(); j++) {
                                Object value = table.getValueAt(j, i);
                                if (value != null) {
                                    int width = value.toString().length();
                                    maxWidth = Math.max(maxWidth, width);
                                }
                            }

                            TableColumn column = table.getColumnModel().getColumn(i);
                            column.setPreferredWidth(maxWidth * 10);
                        }

                        JScrollPane scrollPane = new JScrollPane(table);

                        JPanel panel = new JPanel(new BorderLayout());
                        panel.add(scrollPane, BorderLayout.CENTER);

                        JFrame frame = new JFrame("All User");
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.add(panel);
                        frame.setSize(800, 600);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "No user found.", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
            JButton createNewUserButton = createRoundedButton("Create New User");
            createNewUserButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String usernameInput = JOptionPane.showInputDialog("Enter Username:");
                        if (usernameInput == null || usernameInput.isEmpty())
                            throw new IllegalArgumentException("Username cannot be empty.");

                        String PasswordInput = JOptionPane.showInputDialog("Enter Password:");
                        if (PasswordInput == null || PasswordInput.isEmpty())
                            throw new IllegalArgumentException("Password cannot be empty.");

                        String FirstnameInput = JOptionPane.showInputDialog("Enter First Name:");
                        if (FirstnameInput == null || FirstnameInput.isEmpty())
                            throw new IllegalArgumentException("First Name cannot be empty.");

                        String LastnameInput = JOptionPane.showInputDialog("Enter Last Name:");
                        if (LastnameInput == null || LastnameInput.isEmpty())
                            throw new IllegalArgumentException("Last Name cannot be empty.");

                        String EmailInput = JOptionPane.showInputDialog("Enter Email:");
                        if (EmailInput == null || EmailInput.isEmpty())
                            throw new IllegalArgumentException("Email cannot be empty.");

                        String PhoneInput = JOptionPane.showInputDialog("Enter Phone:");
                        if (PhoneInput == null || PhoneInput.isEmpty())
                            throw new IllegalArgumentException("Phone cannot be empty.");

                        String RoleInput = JOptionPane.showInputDialog("Enter Role:");
                        if (RoleInput == null || RoleInput.isEmpty())
                            throw new IllegalArgumentException("Role cannot be empty.");

                        User newUser = new User();
                        newUser.setUsername(usernameInput);
                        newUser.setPassword(PasswordInput);
                        newUser.setFirstName(FirstnameInput);
                        newUser.setLastName(LastnameInput);
                        newUser.setEmail(EmailInput);
                        newUser.setPhone(PhoneInput);
                        newUser.setRole(RoleInput);

                        userDaoImpl.saveUser(newUser);

                        JOptionPane.showMessageDialog(panel, "User created successfully!");

                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel, "Failed to create user", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });


            JButton updateUserButton = createRoundedButton("Update user");
            updateUserButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String userIdInput = JOptionPane.showInputDialog("Enter User ID to Update:");
                        if (userIdInput == null || userIdInput.isEmpty())
                            throw new IllegalArgumentException("User ID cannot be empty.");
                        int reservationId = Integer.parseInt(userIdInput);

                        User existingUser = userDaoImpl.getUserByID(reservationId);
                        if (existingUser == null) {
                            JOptionPane.showMessageDialog(panel, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String[] options = {"Username", "Password", "First Name", "Last Name", "Email", "Phone", "Role"};
                        int choice = JOptionPane.showOptionDialog(
                                panel,
                                "What would you like to update?",
                                "Update User",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[0]
                        );

                        switch (choice) {
                            case 0:
                                String newUsername = JOptionPane.showInputDialog("Enter new Username:", existingUser.getUsername());
                                if (newUsername != null && !newUsername.isEmpty()) {
                                    existingUser.setUsername(newUsername);
                                }
                                break;

                            case 1:
                                String newPassword = JOptionPane.showInputDialog("Enter new Password:", existingUser.getPassword());
                                if (newPassword != null && !newPassword.isEmpty()) {
                                    existingUser.setUsername(newPassword);
                                }
                                break;

                            case 2:
                                String newFirstName = JOptionPane.showInputDialog("Enter new First Name:", existingUser.getFirstName());
                                if (newFirstName != null && !newFirstName.isEmpty()) {
                                    existingUser.setFirstName(newFirstName);
                                }
                                break;

                            case 3:
                                String newLastName = JOptionPane.showInputDialog("Enter new Last Name:", existingUser.getLastName());
                                if (newLastName != null && !newLastName.isEmpty()) {
                                    existingUser.setLastName(newLastName);
                                }
                                break;

                            case 4:
                                String newEmail = JOptionPane.showInputDialog("Enter new Email:", existingUser.getEmail());
                                if (newEmail != null && !newEmail.isEmpty()) {
                                    existingUser.setEmail(newEmail);
                                }
                                break;

                            case 5:
                                String newPhone = JOptionPane.showInputDialog("Enter new Phone:", existingUser.getPhone());
                                if (newPhone != null && !newPhone.isEmpty()) {
                                    existingUser.setPhone(newPhone);
                                }
                                break;

                            case 6:
                                String newRole = JOptionPane.showInputDialog("Enter new Role:", existingUser.getRole());
                                if (newRole != null && !newRole.isEmpty()) {
                                    existingUser.setRole(newRole);
                                }
                                break;

                            case 7: // Cancel (do nothing)
                                JOptionPane.showMessageDialog(panel, "Update canceled.");
                                return;

                            default:
                                JOptionPane.showMessageDialog(panel, "Invalid selection.");
                                return;
                        }

                        userDaoImpl.updateUser(existingUser);
                        JOptionPane.showMessageDialog(panel, "User updated successfully!");

                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel, "Failed to update user", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            JButton deleteButton = createRoundedButton("Delete User");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idInput = JOptionPane.showInputDialog("Enter User ID to Delete:");
                    try {
                        int userId = Integer.parseInt(idInput);
                        userDaoImpl.deleteUser(userId);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panel, "Invalid ID format.");
                    }
                }
            });

            JButton searchUserButton = createRoundedButton("Search User");
            searchUserButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idInput = JOptionPane.showInputDialog("Enter User ID to Search: ");
                    try {
                        int userID = Integer.parseInt(idInput);
                        User user = userDaoImpl.getUserByID(userID);

                        if (user != null) {
                            String[] columnNames = {
                                    "User ID", "Username", "Password",
                                    "First Name", "Last Name", "Email",
                                    "Phone", "Role"
                            };
                            Object[][] data = {
                                    {
                                            user.getUserId(),
                                            user.getUsername(),
                                            user.getPassword(),
                                            user.getFirstName(),
                                            user.getLastName(),
                                            user.getEmail(),
                                            user.getPhone(),
                                            user.getRole()
                                    }
                            };
                            JTable table = new JTable(data, columnNames);

                            for (int i = 0; i < table.getColumnCount(); i++) {
                                int maxWidth = 0;

                                for (int j = 0; j < table.getRowCount(); j++) {
                                    Object value = table.getValueAt(j, i);
                                    if (value != null) {
                                        int width = value.toString().length();
                                        maxWidth = Math.max(maxWidth, width);
                                    }
                                }

                                TableColumn column = table.getColumnModel().getColumn(i);
                                column.setPreferredWidth(maxWidth * 10);
                            }

                            JScrollPane scrollPane = new JScrollPane(table);

                            JPanel panel = new JPanel(new BorderLayout());
                            panel.add(scrollPane, BorderLayout.CENTER);


                            JFrame frame = new JFrame("User found");
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.add(panel);
                            frame.setSize(800, 600);
                            frame.setLocationRelativeTo(null);
                            frame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(panel, "No user found with ID: " + userID, "Information", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panel, "Invalid ID format. Please enter a numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel, "An error occurred while fetching the user.", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            });


            // Customize the appearance of the buttons
            Font buttonFont = new Font("Mulish", Font.BOLD, 16);
            Color buttonColor = Color.decode("#E3DFD5");
            Color textColor = Color.decode("#000000");

            gridPanel.add(viewAllUserButton);
            gridPanel.add(updateUserButton);
            gridPanel.add(deleteButton);
            gridPanel.add(searchUserButton);
            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            topPanel.add(createNewUserButton);
            ManageUserPanel.add(topPanel, BorderLayout.NORTH);
            ManageUserPanel.add(gridPanel, BorderLayout.CENTER);

            JButton[] buttons = {viewAllUserButton, createNewUserButton, updateUserButton, deleteButton, searchUserButton};

            for (JButton button : buttons) {
                button.setPreferredSize(new Dimension(220, 40));
                button.setFont(buttonFont);
                button.setBackground(buttonColor);
                button.setForeground(textColor);
                button.setFocusable(false);
                button.setVisible(true);
            }
            JLabel dateLabel = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/clock.png", 20, 20));
            dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
            dateLabel.setForeground(Color.DARK_GRAY);
            dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
            String currentDate = dateFormat.format(new Date());
            dateLabel.setText(" " + currentDate);
            ManageUserPanel.add(dateLabel, BorderLayout.SOUTH);
        }

        panel.add(ManageUserPanel);
        ManageUserPanel.setVisible(false);
    }

    private void createTaskListPanel() {
        String[][] taskListBaseData = {{" ", " "}};
        String[] taskListColumnNames = {"Assigned Room", "Cleaning Status"};
        taskListTable = new JTable(taskListBaseData, taskListColumnNames);
        taskListTable.setBounds(374, 40, 800, 530);
        taskListTable.getTableHeader().setFont(new Font("Mulish", Font.BOLD, 13));
        taskListTable.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
        taskListTable.setVisible(false);
        panel.add(taskListTable);

        taskListScrollPane = new JScrollPane(taskListTable);
        taskListScrollPane.setBounds(374, 40, 800, 530); // Set bounds for JScrollPane
        taskListScrollPane.setVisible(false);
        panel.add(taskListScrollPane);

        taskListPanel = new JPanel();
        taskListPanel.setBounds(374, 40, 800, 530);
        taskListPanel.setOpaque(false);
        taskListPanel.setVisible(false);
        panel.add(taskListPanel);
    }

    private void addRoomTabComponents() {
        roomPanel.setVisible(true);
        available_unavailable.setVisible(true);
    }

    private void removeRoomTabComponents() {
        roomPanel.setVisible(false);
        available_unavailable.setVisible(false);
    }

    private void addRoomCleaningTabComponents() {
        roomCleaningPanel.setVisible(true);
        cleaned_uncleaned.setVisible(true);
    }

    private void removeRoomCleaningTabComponents() {
        roomCleaningPanel.setVisible(false);
        cleaned_uncleaned.setVisible(false);
    }

    private void addAdminRoomMenu() {
        adminRoomMenu.setVisible(true);
    }

    private void removeAdminRoomMenu() {
        adminRoomMenu.setVisible(false);
    }

    private void addServiceOrderComponents() {
        serviceOrderPanel.setVisible(true);
        serviceOrderTable.setVisible(true);
        serviceOrderScrollPane.setVisible(true);
    }

    private void removeServiceOrderComponents() {
        if (serviceOrderPanel != null && serviceOrderTable != null && serviceOrderScrollPane != null) {
            serviceOrderPanel.setVisible(false);
            serviceOrderTable.setVisible(false);
            serviceOrderScrollPane.setVisible(false);
        }
    }

    private void addTaskListComponents() {
        taskListPanel.setVisible(true);
        taskListTable.setVisible(true);
        taskListScrollPane.setVisible(true);
    }

    private void removeTaskListComponents() {
        taskListPanel.setVisible(false);
        taskListTable.setVisible(false);
        taskListScrollPane.setVisible(false);
    }

    private void addReservationTabComponents() {
        reservationPanel.setVisible(true);
    }

    private void removeReservationTabComponents() {
        reservationPanel.setVisible(false);
    }

    private void addManageUserComponents() {
        ManageUserPanel.setVisible(true);
    }
    private void removeManageUserComponents() {
        ManageUserPanel.setVisible(false);
    }

    private String getPaymentMethodSelection() {
        String[] paymentMethods = {"Visa", "MasterCard", "PayPal", "Discover"};
        String[] iconPaths = {
            "hms/src/main/java/com/code/hms/assets/visaIcon.png",
            "hms/src/main/java/com/code/hms/assets/mastercardIcon.png",
            "hms/src/main/java/com/code/hms/assets/PaypalIcon.png",
            "hms/src/main/java/com/code/hms/assets/DiscoverIcon.png"
        };

        JDialog dialog = new JDialog((Frame) null, "Select Payment Method", true);
        dialog.setLayout(new GridLayout(1, paymentMethods.length, 10, 10));
        dialog.setSize(500, 150);
        dialog.setLocationRelativeTo(null);

        AtomicReference<String> selectedMethod = new AtomicReference<>(null);

        for (int i = 0; i < paymentMethods.length; i++) {
            String method = paymentMethods[i];
            String iconPath = iconPaths[i];

            // Create button with image and text
            JButton button = new JButton(method, LoadImage.loadScaledImage(iconPath, 80, 40));
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setFocusable(false);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedMethod.set(method); // Save selected method
                    dialog.dispose();          // Close dialog
                }
            });

            dialog.add(button);
        }

        dialog.setVisible(true);
        return selectedMethod.get(); 
    }

    private static JButton createRoundedButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Background
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

                // Border
                g2.setColor(getForeground());
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);

                // Text
                g2.setColor(getForeground());
                FontMetrics fm = g2.getFontMetrics();
                int stringWidth = fm.stringWidth(getText());
                int stringHeight = fm.getAscent();
                g2.drawString(getText(), (getWidth() - stringWidth) / 2, (getHeight() + stringHeight) / 2 - 2);

                g2.dispose();
            }
        };

        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setBackground(new Color(70, 130, 180)); // Light blue background
        button.setForeground(Color.WHITE); // White text
        button.setPreferredSize(new Dimension(150, 50)); // Size of the button
        return button;
    }

    private void addFinancialComponents() {

        financialPanel.setVisible(true); // Make the financial panel visible

    }

    private void removeFinancialComponents() {

        financialPanel.setVisible(false); // Hide the financial panel

    }
}
//debug commit command