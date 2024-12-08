package com.code.hms.ui;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.code.hms.connection.DataSourceFactory;
import com.code.hms.daoimpl.BillingDaoImpl;
import com.code.hms.daoimpl.ReservationDaoImpl;
import com.code.hms.daoimpl.ReviewDAOImpl;
import com.code.hms.daoimpl.RoomDaoImpl;
import com.code.hms.daoimpl.Room_ReservationDaoImpl;
import com.code.hms.daoimpl.ServiceDAOImpl;
import com.code.hms.daoimpl.Service_OrderDAOImpl;
import com.code.hms.daoimpl.UserDaoImpl;
import com.code.hms.daoimpl.User_ServiceDAOImpl;
import com.code.hms.entities.Billing;
import com.code.hms.entities.Reservation;
import com.code.hms.entities.Review;
import com.code.hms.entities.Room;
import com.code.hms.entities.Room_Reservation;
import com.code.hms.entities.Room_Reservation_Pk;
import com.code.hms.entities.Service;
import com.code.hms.entities.User;
import com.code.hms.entities.User_Service;
import com.code.hms.entities.User_Service_Pk;
import com.code.hms.loginwindow.LoginWindow;


public class CustomerUI {

    static String selectedPaymentMethod;
    private int userId, serviceId;
    private User user;

    private JLabel hotelNameLabel;
    private JLabel dateLabel;
    private JLabel welcomeLabel;

    static JLabel roomType1;
    static JLabel roomType2;
    static JLabel roomType3;

    static JLabel room1Label;
    static JLabel room2Label;
    static JLabel room3Label;

    static JPanel logOutPanel;

    static JLabel averageRatingLabel;
    static Double averageRating;

    static JFrame frame;
    static JPanel panel;
    static JButton OurHotelTab;
    static JButton RoomTab;
    static JButton ServiceTab;
    static JButton ReviewTab;
    static JButton logOutButton;

    static Service_OrderDAOImpl serviceOrderDAOImpl;
    static ReviewDAOImpl reviewDAOImpl;
    static ServiceDAOImpl serviceDAOImpl;
    static BillingDaoImpl billingDaoImpl;
    static UserDaoImpl userDaoImpl;
    static ReservationDaoImpl reservationDaoImpl;
    static RoomDaoImpl roomDaoImpl;
    static Room_ReservationDaoImpl room_ReservationDaoImpl;
    static User_ServiceDAOImpl userServiceDAOImpl;

    static Reservation reservation;
    static Reservation selectedReservation;

    static JLabel Tab1_background;
    static JLabel Tab2_background;
    static JLabel Tab3_background;
    static JLabel Tab4_background;

    static JLabel EnterBoxFName;
    static JLabel EnterBoxLName;
    static JLabel EnterBoxPNumber;
    static JLabel EnterBoxEmail;

    static JLabel SpaFirstName;
    static JLabel SpaLastName;
    static JLabel SpaPhoneNumber;
    static JLabel SpaEmail;

    static JLabel Daybox;
    static JLabel Monthbox;
    static JLabel Yearbox;

    static JLabel Hourbox;
    static JLabel Minutebox;
    static JLabel Secondbox;

    static JTextField SpaDayEnter;
    static JTextField SpaMonthEnter;
    static JTextField SpaYearEnter;

    static JTextField SpaHourEnter;
    static JTextField SpaMinuteEnter;
    static JTextField SpaSecondEnter;

    static JTextField EnterDateIn;
    static JTextField EnterDateOut;
    static JTextField EnterNumberOfGuests;

    static JLabel ServiceMenu;
    static JLabel SpaCenter;
    static JLabel RestaurantCenter;
    static JLabel RoomCleaningCenter;
    static JLabel MusicLoungeCenter;
    static JLabel CustomerInfo;
    static JLabel BookingInformation;
    static JLabel PaymentMethod;

    static JButton Spa;
    static JButton Restaurant;
    static JButton RoomCleaning;
    static JButton MusicLounge;

    static JLabel FNamePosition;
    static JLabel LNamePosition;
    static JLabel PNumberPosition;
    static JLabel EmailPosition;
    static JLabel DatePosition;
    static JLabel TimePosition;

    static JLabel CreditNumber;
    static JLabel NameOnCard;
    static JLabel Amount;
    static JLabel SecCode;

    static JLabel CreditNumberPos;
    static JLabel NameCardPos;
    static JLabel AmountPos;
    static JLabel SecCodePos;

    static JLabel BookingFirstName;
    static JLabel BookingLastName;
    static JLabel BookingPhoneNumber;
    static JLabel BookingEmail;
    static JTextField BookingCredit;
    static JTextField BookingNamecard;
    static JTextField BookingAmount;
    static JTextField BookingSecCode;

    static JButton NextButton;
    static JButton sendButton;
    static JButton SubmitServiceButton;
    static JButton SubmitReservationButton;

    static JScrollPane RoomSelectionField;

    static List<Integer> selectedRoomIds;

    static JList<String> roomList;

    static List<Room> availableRooms;
    static List<Reservation> reviewedList;

    static String[] roomOptions;

    static DataSourceFactory dsf; 

    public CustomerUI(int userId) {
        this.userId = userId;

        reviewDAOImpl = new ReviewDAOImpl();
        serviceDAOImpl = new ServiceDAOImpl();
        serviceOrderDAOImpl = new Service_OrderDAOImpl();
        reservationDaoImpl = new ReservationDaoImpl();
        userDaoImpl = new UserDaoImpl();
        billingDaoImpl = new BillingDaoImpl();
        roomDaoImpl = new RoomDaoImpl();
        room_ReservationDaoImpl = new Room_ReservationDaoImpl();
        userServiceDAOImpl = new User_ServiceDAOImpl();
        dsf = new DataSourceFactory();

        user = userDaoImpl.getUserByID(userId); 
        
        createMainGUI();
        CreateServiceInfoBox();
        CreateDate_TimeBox();
        CreateBookingInfo();
        logOutPanel.setVisible(true);
        logOutButton.setVisible(true);

        if (user != null) {
            BookingFirstName.setText(user.getFirstName());
            BookingLastName.setText(user.getLastName());
            BookingPhoneNumber.setText(user.getPhone());
            BookingEmail.setText(user.getEmail());
            panel.setComponentZOrder(BookingFirstName,0);
            panel.setComponentZOrder(BookingLastName, 0);
            panel.setComponentZOrder(BookingPhoneNumber,0);
            panel.setComponentZOrder(BookingEmail, 0);
            panel.setComponentZOrder(SpaFirstName,0);
            panel.setComponentZOrder(SpaLastName, 0);
            panel.setComponentZOrder(SpaPhoneNumber,0);
            panel.setComponentZOrder(SpaEmail, 0);
        } else {
            JOptionPane.showMessageDialog(panel, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
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

        CreditNumberPos = new JLabel();
        CreditNumberPos.setText("Credit card number");
        CreditNumberPos.setFont(new Font("Mulish", Font.BOLD, 20));
        CreditNumberPos.setBounds(350, 420, 500, 30);
        CreditNumberPos.setForeground(new Color(136, 120, 81));
        CreditNumberPos.setVisible(false);
        panel.add(CreditNumberPos);

        NameCardPos = new JLabel();
        NameCardPos.setText("Name on card");
        NameCardPos.setFont(new Font("Mulish", Font.BOLD, 20));
        NameCardPos.setBounds(750, 420, 500, 30);
        NameCardPos.setForeground(new Color(136, 120, 81));
        NameCardPos.setVisible(false);
        panel.add(NameCardPos);

        AmountPos = new JLabel();
        AmountPos.setText("Amount");
        AmountPos.setFont(new Font("Mulish", Font.BOLD, 20));
        AmountPos.setBounds(350, 500, 500, 30);
        AmountPos.setForeground(new Color(136, 120, 81));
        AmountPos.setVisible(false);
        panel.add(AmountPos);

        SecCodePos = new JLabel();
        SecCodePos.setText("Security code");
        SecCodePos.setFont(new Font("Mulish", Font.BOLD, 20));
        SecCodePos.setBounds(750, 500, 500, 30);
        SecCodePos.setForeground(new Color(136, 120, 81));
        SecCodePos.setVisible(false);
        panel.add(SecCodePos);

        DatePosition = new JLabel();
        DatePosition.setText("Date");
        DatePosition.setFont(new Font("Mulish", Font.BOLD, 20));
        DatePosition.setBounds(350, 390, 500, 30);
        DatePosition.setForeground(new Color(136, 120, 81));
        DatePosition.setVisible(false);
        panel.add(DatePosition);

        TimePosition = new JLabel();
        TimePosition.setText("Time");
        TimePosition.setFont(new Font("Mulish", Font.BOLD, 20));
        TimePosition.setBounds(798, 390, 500, 30);
        TimePosition.setForeground(new Color(136, 120, 81));
        TimePosition.setVisible(false);
        panel.add(TimePosition);

        JLabel RoomBooking = new JLabel();
        RoomBooking.setText("ROOM BOOKING");
        RoomBooking.setFont(new Font("Mulish", Font.BOLD, 33));
        RoomBooking.setBounds(650, 30, 1000, 33);
        RoomBooking.setForeground(new Color(212, 158, 24));
        RoomBooking.setVisible(false);
        panel.add(RoomBooking);

        JButton RoomList = new JButton();
        RoomList.setText("LIST OF AVAILABLE ROOMS");
        RoomList.setFont(new Font("Mulish", Font.BOLD, 33));
        RoomList.setBounds(430, 220, 710, 150);
        RoomList.setVisible(false);
        RoomList.setBackground(new Color(132, 121, 102));
        RoomList.setForeground(new Color(245, 242, 233));
        panel.add(RoomList);
        RoomList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fetch available rooms
                List<Room> availableRooms = roomDaoImpl.getAllAvailableRooms();
                if (availableRooms != null && !availableRooms.isEmpty()) {
                    String[] columnNames = {"Room ID", "Room Type", "Price", "Room Status", "Cleaning Status", "Room Capacity"};
                    Object[][] tableData = new Object[availableRooms.size()][columnNames.length];
                    for (int i = 0; i < availableRooms.size(); i++) {
                        Room room = availableRooms.get(i);
                        tableData[i][0] = room.getRoomId();
                        tableData[i][1] = room.getRoomType();
                        tableData[i][2] = room.getPrice();
                        tableData[i][3] = room.getRoomStatus();
                        tableData[i][4] = room.getCleaningStatus();
                        tableData[i][5] = room.getRoomCapacity();
                    }

                    JTable roomTable = new JTable(new DefaultTableModel(tableData, columnNames));
                    JScrollPane scrollPane = new JScrollPane(roomTable);

                    roomTable.setFillsViewportHeight(true);
                    roomTable.setRowHeight(25);
                    roomTable.getTableHeader().setFont(new Font("Mulish", Font.BOLD, 15));
                    roomTable.setFont(new Font("Mulish", Font.PLAIN, 14));

                    JDialog tableDialog = new JDialog();
                    tableDialog.setTitle("Available Rooms");
                    tableDialog.setSize(800, 400);
                    tableDialog.setLocationRelativeTo(panel);
                    tableDialog.add(scrollPane);
                    tableDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(panel, "No available rooms at the moment.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // CHECK-IN DATE Section
        JLabel ChooseDateIn = new JLabel();
        ChooseDateIn.setText("CHECK-IN DATE");
        ChooseDateIn.setFont(new Font("Mulish", Font.BOLD, 25));
        ChooseDateIn.setBounds(300, 100, 300, 33);
        ChooseDateIn.setForeground(new Color(212, 158, 24));
        ChooseDateIn.setHorizontalAlignment(SwingConstants.CENTER);
        ChooseDateIn.setVisible(false);
        panel.add(ChooseDateIn);

        EnterDateIn = new JTextField();
        panel.add(EnterDateIn);
        EnterDateIn.setBounds(350, 150, 220, 28);
        EnterDateIn.setBackground(new Color(255, 255, 255));
        EnterDateIn.setVisible(false);
        EnterDateIn.setBorder(BorderFactory.createLineBorder(new Color(132, 121, 102)));

        // CHECK-OUT DATE Section
        JLabel ChooseDateOut = new JLabel();
        ChooseDateOut.setText("CHECK-OUT DATE");
        ChooseDateOut.setFont(new Font("Mulish", Font.BOLD, 25));
        ChooseDateOut.setBounds(950, 100, 315, 33); // Increased width for label
        ChooseDateOut.setForeground(new Color(212, 158, 24));
        ChooseDateOut.setHorizontalAlignment(SwingConstants.CENTER); // Center-aligned text
        ChooseDateOut.setVisible(false);
        panel.add(ChooseDateOut);
        
        EnterDateOut = new JTextField();
        panel.add(EnterDateOut);
        EnterDateOut.setBounds(1000, 150, 220, 28);
        EnterDateOut.setBackground(new Color(255, 255, 255));
        EnterDateOut.setVisible(false);
        EnterDateOut.setBorder(null);
        EnterDateOut.setBorder(BorderFactory.createLineBorder(new Color(132, 121, 102)));

        // NUMBER OF GUESTS Section
        JLabel NumberOfGuests = new JLabel();
        NumberOfGuests.setText("NUMBER OF GUESTS");
        NumberOfGuests.setFont(new Font("Mulish", Font.BOLD, 25));
        NumberOfGuests.setBounds(645, 100, 285, 33);
        NumberOfGuests.setForeground(new Color(212, 158, 24));
        NumberOfGuests.setHorizontalAlignment(SwingConstants.CENTER);
        NumberOfGuests.setVisible(false);
        panel.add(NumberOfGuests);

        EnterNumberOfGuests = new JTextField();
        panel.add(EnterNumberOfGuests);
        EnterNumberOfGuests.setBounds(655, 150, 265, 28);
        EnterNumberOfGuests.setBackground(new Color(255, 255, 255));
        EnterNumberOfGuests.setVisible(false);
        EnterNumberOfGuests.setBorder(null);
        EnterNumberOfGuests.setBorder(BorderFactory.createLineBorder(new Color(132, 121, 102)));

        // ROOM SELECTION Section
        JLabel RoomSelectionLabel = new JLabel();
        RoomSelectionLabel.setText("SELECT ROOM");
        RoomSelectionLabel.setFont(new Font("Mulish", Font.BOLD, 25));
        RoomSelectionLabel.setBounds(645, 400, 285, 33);
        RoomSelectionLabel.setVisible(false);
        RoomSelectionLabel.setForeground(new Color(212, 158, 24));
        RoomSelectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(RoomSelectionLabel);

        JLabel IntroducitonLabel = new JLabel();
        IntroducitonLabel.setText("(Press and hold Ctrl to select multiple rooms)");
        IntroducitonLabel.setFont(new Font("Mulish", Font.BOLD, 15));
        IntroducitonLabel.setBounds(525, 560, 500, 20);
        IntroducitonLabel.setVisible(false);
        IntroducitonLabel.setForeground(new Color(212, 158, 24));
        IntroducitonLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(IntroducitonLabel);

        availableRooms = roomDaoImpl.getAllAvailableRooms();
        if (availableRooms == null || availableRooms.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "No rooms are available for booking.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        roomOptions = new String[availableRooms.size()];
        for (int i = 0; i < availableRooms.size(); i++) {
            Room room = availableRooms.get(i);
            roomOptions[i] = "Room " + room.getRoomId() + " - " + room.getRoomType();
        }
        roomList = new JList<>(roomOptions);
        roomList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        roomList.setBackground(new Color(255, 255, 255));
        roomList.setBorder(BorderFactory.createLineBorder(new Color(132, 121, 102)));

        RoomSelectionField = new JScrollPane(roomList);
        RoomSelectionField.setBounds(635, 450, 300, 100);
        RoomSelectionField.setVisible(false);
        panel.add(RoomSelectionField);

        JLabel BookingTitle = new JLabel();
        BookingTitle.setText("YOUR RESERVATION");
        BookingTitle.setFont(new Font("Mulish", Font.BOLD, 33));
        BookingTitle.setBounds(610, 30, 1000, 33);
        BookingTitle.setForeground(new Color(212, 158, 24));
        BookingTitle.setVisible(false);
        panel.add(BookingTitle);

        JLabel RateExp = new JLabel();
        RateExp.setText("HOW WAS YOUR EXPERIENCE ?");
        RateExp.setFont(new Font("Mulish", Font.BOLD, 33));
        RateExp.setBounds(510, 30, 1000, 33);
        RateExp.setForeground(new Color(212, 158, 24));
        RateExp.setVisible(false);
        panel.add(RateExp);

        RatingStars ratingStars = new RatingStars();
        ratingStars.setBounds(585, 70, 500, 100); // Position and size
        ratingStars.setOpaque(false);
        panel.add(ratingStars);
        panel.setComponentZOrder(ratingStars, 0);
        // Force the panel to repaint immediately
        panel.revalidate();
        panel.repaint();
        ratingStars.setVisible(false);

        JLabel Feedback = new JLabel();
        Feedback.setText("FEEDBACK");
        Feedback.setFont(new Font("Mulish", Font.BOLD, 30));
        Feedback.setBounds(300, 150, 500, 30);
        Feedback.setForeground(new Color(212, 158, 24));
        Feedback.setVisible(false);
        panel.add(Feedback);

        JTextArea WriteFeedback = new JTextArea();
        panel.add(WriteFeedback);

        // Set bounds and appearance
        WriteFeedback.setBounds(300, 180, 600, 300);
        WriteFeedback.setBackground(new Color(244, 242, 235));
        WriteFeedback.setVisible(false);
        WriteFeedback.setLineWrap(true); // Enable word wrapping
        WriteFeedback.setWrapStyleWord(true); // Wrap at word boundaries
        WriteFeedback.setMargin(new Insets(5, 5, 5, 5)); // Add padding for better appearance
        WriteFeedback.setFont(new Font("Mulish", Font.PLAIN, 16)); // Set the font size and style
        WriteFeedback.setBorder(BorderFactory.createLineBorder(new Color(132, 121, 102), 1));

        JButton sendButton = new JButton();
        sendButton.setFocusable(false);
        sendButton.setBackground(new Color(132, 121, 102));
        sendButton.setBorderPainted(false);
        sendButton.setText("Send");
        sendButton.setFont(new Font("Mulish", Font.BOLD, 20));
        sendButton.setBounds(674, 520, 200, 50);
        sendButton.setForeground(new Color(245, 242, 233));
        sendButton.setVisible(false);
        panel.add(sendButton);

        // reservation SELECTION Section
        JLabel ReservationSelectionLabel = new JLabel();
        ReservationSelectionLabel.setText("SELECT RERSERVATION");
        ReservationSelectionLabel.setFont(new Font("Mulish", Font.BOLD, 25));
        ReservationSelectionLabel.setBounds(950, 150, 350, 33);
        ReservationSelectionLabel.setVisible(false);
        ReservationSelectionLabel.setForeground(new Color(212, 158, 24));
        ReservationSelectionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(ReservationSelectionLabel);

        List<Reservation> reservationList = userDaoImpl.getReservationsByCustomer(userId);
        JComboBox<Reservation> reservationPackage = new JComboBox<>();
        reservationPackage.setBounds(950, 200, 300, 30);
        reservationPackage.setFont(new Font("Mulish", Font.BOLD, 16));
        reservationPackage.setBackground(new Color(244, 242, 235));
        reservationPackage.setFocusable(false);
        reservationPackage.setVisible(false);

        Reservation placeholderReservation = new Reservation();  // Create a placeholder reservation
        reservationPackage.addItem(placeholderReservation);
        for (Reservation reservation : reservationList) {
            reservationPackage.addItem(reservation);
        }
        reservationPackage.setSelectedItem(placeholderReservation);
        sendButton.setEnabled(false);

        panel.add(reservationPackage);

        PaymentMethod = new JLabel();
        PaymentMethod.setText("II. Payment Method");
        PaymentMethod.setFont(new Font("Mulish", Font.BOLD, 33));
        PaymentMethod.setBounds(310, 330, 500, 33);
        PaymentMethod.setForeground(new Color(136, 120, 81));
        PaymentMethod.setVisible(false);
        panel.add(PaymentMethod);

        // Create buttons with icons
        JButton visaImage = new JButton(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/visaIcon.png", 80, 40));
        visaImage.setBounds(350, 370, 80, 40);
        panel.add(visaImage);
        visaImage.setVisible(false);
        visaImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedPaymentMethod = "Visa";
                JOptionPane.showMessageDialog(panel, "Visa selected as payment method.", "Payment Method", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton mastercardImage = new JButton(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/mastercardIcon.png", 80, 40));
        mastercardImage.setBounds(450, 370, 80, 40);
        panel.add(mastercardImage);
        mastercardImage.setVisible(false);
        mastercardImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedPaymentMethod = "MasterCard";
                JOptionPane.showMessageDialog(panel, "MasterCard selected as payment method.", "Payment Method", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton PaypalImage = new JButton(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/PaypalIcon.png", 80, 40));
        PaypalImage.setBounds(550, 370, 80, 40);
        panel.add(PaypalImage);
        PaypalImage.setVisible(false);
        PaypalImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedPaymentMethod = "PayPal";
                JOptionPane.showMessageDialog(panel, "PayPal selected as payment method.", "Payment Method", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton DiscoverImage = new JButton(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/DiscoverIcon.png", 80, 40));
        DiscoverImage.setBounds(650, 370, 80, 40);
        panel.add(DiscoverImage);
        DiscoverImage.setVisible(false);
        DiscoverImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedPaymentMethod = "Discover";
                JOptionPane.showMessageDialog(panel, "Discover selected as payment method.", "Payment Method", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton SubmitServiceButton = new JButton("SUBMIT");
        SubmitServiceButton.setBounds(960, 520, 180, 50);
        SubmitServiceButton.setFont(new Font("Mulish", Font.BOLD, 20));
        SubmitServiceButton.setBackground(new Color(132, 121, 102));
        SubmitServiceButton.setForeground(Color.WHITE);
        SubmitServiceButton.setFocusable(false);
        SubmitServiceButton.setVisible(false);
        SubmitServiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Collect customer information
                String day = SpaDayEnter.getText().trim();
                String month = SpaMonthEnter.getText().trim();
                String year = SpaYearEnter.getText().trim();
                String hour = SpaHourEnter.getText().trim();
                String minute = SpaMinuteEnter.getText().trim();
                String second = SpaSecondEnter.getText().trim();
                // String servicepackage = SpaPackBox.getText();

                if (day.isEmpty() || month.isEmpty() || year.isEmpty() || hour.isEmpty() || minute.isEmpty() || second.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all required fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    User_Service_Pk user_Service_Pk = new User_Service_Pk(userId, serviceId);
                    Service service = serviceDAOImpl.getServiceByID(serviceId);

                    if (service.getServiceAvailability().equals("Available")) {

                        User_Service user_Service = new User_Service();
                        user_Service.setPk(user_Service_Pk);
                        user_Service.setDate(java.sql.Date.valueOf(year + "-" + month + "-" + day));
                        user_Service.setTime(java.sql.Time.valueOf(hour + ":" + minute + ":" + second));
                        user_Service.setUser(userDaoImpl.getUserByID(userId));
                        user_Service.setService(service);

                        serviceOrderDAOImpl.saveServiceOrder(user_Service);

                        service.setServiceAvailability("Unavailable");
                        serviceDAOImpl.updateService(service);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Service unavailable", "Sorry", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(frame, "Service booked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        panel.add(SubmitServiceButton);


        JButton NextButton = new JButton();
        NextButton.setFocusable(false);
        NextButton.setBackground(new Color(132, 121, 102));
        NextButton.setBorderPainted(false);
        NextButton.setText("NEXT");
        NextButton.setFont(new Font("Mulish", Font.BOLD, 14));
        NextButton.setBounds(1100, 550, 80, 30);
        NextButton.setForeground(new Color(245, 242, 233));
        NextButton.setVisible(false);
        panel.add(NextButton); 
        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Validate dates and number of guests
                    String checkinDateString = EnterDateIn.getText().trim();
                    String checkoutDateString = EnterDateOut.getText().trim();
                    String numOfGuestsString = EnterNumberOfGuests.getText().trim();
        
                    java.sql.Date checkinDate = java.sql.Date.valueOf(checkinDateString);
                    java.sql.Date checkoutDate = java.sql.Date.valueOf(checkoutDateString);
                    int numOfGuests = Integer.parseInt(numOfGuestsString);
        
                    long differenceInMilliseconds = checkoutDate.getTime() - checkinDate.getTime();
                    int totalDays = (int) (differenceInMilliseconds / (1000 * 60 * 60 * 24));
        
                    // Prepare Reservation
                    reservation = new Reservation();
                    reservation.setCheckinDate(checkinDate);
                    reservation.setCheckoutDate(checkoutDate);
                    reservation.setNumOfGuests(numOfGuests);
                    reservation.setTotalDays(totalDays);
        
                    List<String> selectedRooms = roomList.getSelectedValuesList();
                    if (selectedRooms.isEmpty()) {
                        JOptionPane.showMessageDialog(panel, "Please select at least one room.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
        
                    selectedRoomIds = new ArrayList<>();
                    for (String selectedRoom : selectedRooms) {
                        int roomId = Integer.parseInt(selectedRoom.split(" ")[1]);
                        Room room = roomDaoImpl.getRoomByRoomID(roomId);
                        if (room == null || !room.getRoomStatus().equalsIgnoreCase("Available")) {
                            JOptionPane.showMessageDialog(panel, "Room " + roomId + " is not available!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        } else {
                            selectedRoomIds.add(roomId);
                        }
                    }

        
                    JOptionPane.showMessageDialog(panel, "Fill the information successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Please enter valid input for number of guests.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(panel, "Please enter valid dates in the format YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "An unexpected error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        

        JButton SubmitReservationButton = new JButton();
        SubmitReservationButton.setFocusable(false);
        SubmitReservationButton.setBackground(new Color(132, 121, 102));
        SubmitReservationButton.setBorderPainted(false);
        SubmitReservationButton.setText("SUBMIT");
        SubmitReservationButton.setFont(new Font("Mulish", Font.BOLD, 14));
        SubmitReservationButton.setBounds(1100, 550, 120, 30);
        SubmitReservationButton.setForeground(new Color(245, 242, 233));
        SubmitReservationButton.setVisible(false);
        panel.add(SubmitReservationButton); 
        SubmitReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Session session = dsf.getSessionFactory().openSession()) {
                    Transaction transaction = session.beginTransaction();
                    
                    try {
                        String paymentMethod = selectedPaymentMethod;
                        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(panel, "Please select a valid payment method.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
        
                        double amount = Double.parseDouble(BookingAmount.getText().trim());
        
                        reservation.setUserId(userId);
                        reservationDaoImpl.saveReservation(reservation);
        
                        for (int roomId : selectedRoomIds) {
                            Room room = roomDaoImpl.getRoomByRoomID(roomId);
                            if (room == null || !room.getRoomStatus().equalsIgnoreCase("Available")) {
                                JOptionPane.showMessageDialog(panel, "Room " + roomId + " is not available!", "Error", JOptionPane.ERROR_MESSAGE);
                                throw new Exception("Room " + roomId + " is not available.");
                            }
        
                            Room_Reservation roomReservation = new Room_Reservation();
                            Room_Reservation_Pk pk = new Room_Reservation_Pk(roomId, reservation.getReservationId());
                            roomReservation.setPk(pk);
                            roomReservation.setRoom(room);
                            roomReservation.setReservation(reservation);
                            roomReservation.setDate(reservation.getCheckinDate());
                            roomReservation.setTime(new java.sql.Time(System.currentTimeMillis()));
                            room_ReservationDaoImpl.saveRoomReservation(roomReservation);
        
                            room.setRoomStatus("Unavailable");
                            roomDaoImpl.updateRoom(room);
                        }
        
                        java.sql.Date billingDate = new java.sql.Date(System.currentTimeMillis());
                        Billing billing = new Billing();
                        billing.setReservation(reservation);
                        billing.setAmount(amount);
                        billing.setPaymentMethod(paymentMethod);
                        billing.setDate(billingDate);
                        billingDaoImpl.saveBilling(billing);
                        transaction.commit();
                        JOptionPane.showMessageDialog(panel, "Reservation and Billing saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        reservationPackage.addItem(reservation);
                        reservationPackage.repaint();
                        if (userDaoImpl.getReservationsByCustomer(userId).isEmpty()) {
                            ServiceTab.setEnabled(false);
                        } else {
                            ServiceTab.setEnabled(true);
                        }
                    } catch (Exception ex) {
                        if (transaction != null) {
                            transaction.rollback();
                        }
                        JOptionPane.showMessageDialog(panel, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
                resetFields();
            }
        });

        reservationPackage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reservationPackage.getSelectedIndex() == 0) {
                    // Handle the case where no reservation is selected
                    WriteFeedback.setText(""); // Clear feedback field
                    ratingStars.setSelectedRating(0); // Reset rating stars
                    WriteFeedback.setEditable(false); // Disable feedback input
                    ratingStars.setEnabled(false); // Disable rating stars
                    sendButton.setEnabled(false);
                } else {
                    selectedReservation = (Reservation) reservationPackage.getSelectedItem();

                    if (selectedReservation != null) {
                        // Fetch the existing review for this reservation
                        Review existingReview = reviewDAOImpl.getReviewsByReservationID(selectedReservation.getReservationId());

                        if (existingReview != null) {
                            // Display the existing review in the text fields
                            WriteFeedback.setText(existingReview.getComment());
                            ratingStars.setSelectedRating(existingReview.getRating());
                            sendButton.setEnabled(false);

                        } else {
                            // Allow the user to submit a new review
                            WriteFeedback.setText("");
                            ratingStars.setSelectedRating(0);

                            // Allow creating a new review
                            sendButton.setEnabled(true);
                            WriteFeedback.setEditable(true);
                            ratingStars.setEnabled(true);
                        }
                    }
                }
            }
        });
        
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

        hotelNameLabel = new JLabel("Hotel Group 3");   
        hotelNameLabel.setFont(new Font("Mulish", Font.BOLD, 50));
        hotelNameLabel.setForeground(new Color(43, 42, 38));
        hotelNameLabel.setBounds(630, 50, 500, 50);
        panel.add(hotelNameLabel);

        roomType1 = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/RoomType1.jpg", 250, 250));
        roomType1.setBounds(400, 200, 250, 250);
        panel.add(roomType1);

        roomType2 = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/RoomType2.jpg", 250, 250));
        roomType2.setBounds(670, 200, 250, 250);
        panel.add(roomType2);

        roomType3 = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/RoomType3.jpg", 250, 250));
        roomType3.setBounds(940, 200, 250, 250);
        panel.add(roomType3);

        welcomeLabel = new JLabel("Welcome to Our Hotel!");
        welcomeLabel.setFont(new Font("Mulish", Font.ITALIC, 50));
        welcomeLabel.setForeground(new Color(132, 121, 102));
        welcomeLabel.setBounds(550, 120, 1000, 50);
        panel.add(welcomeLabel);

        room1Label = new JLabel("Single Room");
        room1Label.setFont(new Font("Mulish", Font.ITALIC, 35));
        room1Label.setForeground(new Color(132, 121, 102));
        room1Label.setBounds(420, 470, 250, 50);
        panel.add(room1Label);

        room2Label = new JLabel("Double Room");
        room2Label.setFont(new Font("Mulish", Font.ITALIC, 35));
        room2Label.setForeground(new Color(132, 121, 102));
        room2Label.setBounds(685, 470, 250, 50);
        panel.add(room2Label);

        room3Label = new JLabel("Triple Room");
        room3Label.setFont(new Font("Mulish", Font.ITALIC, 35));
        room3Label.setForeground(new Color(132, 121, 102));
        room3Label.setBounds(960, 470, 250, 50);
        panel.add(room3Label);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Mulish", Font.PLAIN, 30));
        dateLabel.setForeground(new Color(43, 42, 38));
        dateLabel.setBounds(600, 530, 1000, 40);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMM dd, yyyy");
        String currentDate = dateFormat.format(new Date());
        dateLabel.setText("Date: " + currentDate);
        panel.add(dateLabel);

        averageRatingLabel = new JLabel();
        averageRatingLabel.setFont(new Font("Mulish", Font.PLAIN, 15));
        averageRatingLabel.setForeground(new Color(43, 42, 38));
        averageRatingLabel.setBounds(680, 570, 400, 30);
        averageRating = getAverageRatingFromDatabase();
        averageRatingLabel.setText("Customer Average Rating: " + String.format("%.1f", averageRating) + " / 5.0");
        panel.add(averageRatingLabel);

        OurHotelTab.addActionListener(e -> {
            logOutPanel.setVisible(true);
            logOutButton.setVisible(true);
            hotelNameLabel.setVisible(true);
            welcomeLabel.setVisible(true);
            dateLabel.setVisible(true);
            roomType1.setVisible(true);
            roomType2.setVisible(true);
            roomType3.setVisible(true);
            room1Label.setVisible(true);
            room2Label.setVisible(true);
            room3Label.setVisible(true);
            IntroducitonLabel.setVisible(false);
            averageRating = getAverageRatingFromDatabase();
            averageRatingLabel.setText("Customer Average Rating: " + String.format("%.1f", averageRating) + " / 5.0");
            averageRatingLabel.setVisible(true);
            
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
            RestaurantCenter.setVisible(false);
            RoomCleaningCenter.setVisible(false);
            MusicLoungeCenter.setVisible(false);
            CustomerInfo.setVisible(false);
            BookingInformation.setVisible(false);
            PaymentMethod.setVisible(false);

            SpaFirstName.setVisible(false);
            SpaLastName.setVisible(false);
            SpaPhoneNumber.setVisible(false);
            SpaEmail.setVisible(false);

            EnterBoxFName.setVisible(false);
            EnterBoxLName.setVisible(false);
            EnterBoxPNumber.setVisible(false);
            EnterBoxEmail.setVisible(false);

            FNamePosition.setVisible(false);
            LNamePosition.setVisible(false);
            PNumberPosition.setVisible(false);
            EmailPosition.setVisible(false);
            DatePosition.setVisible(false);
            TimePosition.setVisible(false);

            Daybox.setVisible(false);
            Monthbox.setVisible(false);
            Yearbox.setVisible(false);

            Hourbox.setVisible(false);
            Minutebox.setVisible(false);
            Secondbox.setVisible(false);

            SpaDayEnter.setVisible(false);
            SpaMonthEnter.setVisible(false);
            SpaYearEnter.setVisible(false);

            SpaHourEnter.setVisible(false);
            SpaMinuteEnter.setVisible(false);
            SpaSecondEnter.setVisible(false);

            Hourbox.setVisible(false);
            Minutebox.setVisible(false);
            Secondbox.setVisible(false);

            RateExp.setVisible(false);
            ratingStars.setVisible(false);
            WriteFeedback.setVisible(false);
            Feedback.setVisible(false);
            ReservationSelectionLabel.setVisible(false);
            reservationPackage.setVisible(false);

            RoomBooking.setVisible(false);
            ChooseDateIn.setVisible(false);
            ChooseDateOut.setVisible(false);
            NumberOfGuests.setVisible(false);
            EnterDateIn.setVisible(false);
            EnterDateOut.setVisible(false);
            EnterNumberOfGuests.setVisible(false);
            RoomSelectionField.setVisible(false);
            RoomSelectionLabel.setVisible(false);
            RoomList.setVisible(false);

            NextButton.setVisible(false);
            sendButton.setVisible(false);
            SubmitServiceButton.setVisible(false);
            SubmitReservationButton.setVisible(false);

            BookingTitle.setVisible(false);

            visaImage.setVisible(false);
            mastercardImage.setVisible(false);
            PaypalImage.setVisible(false);
            DiscoverImage.setVisible(false);

            CreditNumber.setVisible(false);
            NameOnCard.setVisible(false);
            Amount.setVisible(false);
            SecCode.setVisible(false);

            CreditNumberPos.setVisible(false);
            NameCardPos.setVisible(false);
            AmountPos.setVisible(false);
            SecCodePos.setVisible(false);

            BookingFirstName.setVisible(false);
            BookingLastName.setVisible(false);
            BookingPhoneNumber.setVisible(false);
            BookingEmail.setVisible(false);
            BookingCredit.setVisible(false);
            BookingNamecard.setVisible(false);
            BookingAmount.setVisible(false);
            BookingSecCode.setVisible(false);
        });

        // RoomTab setup
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
        RoomTab.addActionListener(e -> {
            logOutPanel.setVisible(true);
            logOutButton.setVisible(true);
            availableRooms = roomDaoImpl.getAllAvailableRooms();
            if (availableRooms == null || availableRooms.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "No rooms are available for booking.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            roomOptions = new String[availableRooms.size()];

            for (int i = 0; i < availableRooms.size(); i++) {
                Room room = availableRooms.get(i);
                roomOptions[i] = "Room " + room.getRoomId() + " - " + room.getRoomType();
            }
            roomList.setListData(roomOptions);
    
            RoomSelectionField.setViewportView(roomList);
            
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

            NextButton.setVisible(true);
            sendButton.setVisible(false);
            SubmitServiceButton.setVisible(false);
            SubmitReservationButton.setVisible(false);

            
            hotelNameLabel.setVisible(false);
            welcomeLabel.setVisible(false);
            dateLabel.setVisible(false);
            roomType1.setVisible(false);
            roomType2.setVisible(false);
            roomType3.setVisible(false);
            room1Label.setVisible(false);
            room2Label.setVisible(false);
            room3Label.setVisible(false);
            averageRatingLabel.setVisible(false);

            SpaCenter.setVisible(false);
            RestaurantCenter.setVisible(false);
            RoomCleaningCenter.setVisible(false);
            MusicLoungeCenter.setVisible(false);
            CustomerInfo.setVisible(false);
            BookingInformation.setVisible(false);
            PaymentMethod.setVisible(false);

            SpaFirstName.setVisible(false);
            SpaLastName.setVisible(false);
            SpaPhoneNumber.setVisible(false);
            SpaEmail.setVisible(false);

            EnterBoxFName.setVisible(false);
            EnterBoxLName.setVisible(false);
            EnterBoxPNumber.setVisible(false);
            EnterBoxEmail.setVisible(false);

            FNamePosition.setVisible(false);
            LNamePosition.setVisible(false);
            PNumberPosition.setVisible(false);
            EmailPosition.setVisible(false);
            DatePosition.setVisible(false);
            TimePosition.setVisible(false);

            Daybox.setVisible(false);
            Monthbox.setVisible(false);
            Yearbox.setVisible(false);

            Hourbox.setVisible(false);
            Minutebox.setVisible(false);
            Secondbox.setVisible(false);

            SpaDayEnter.setVisible(false);
            SpaMonthEnter.setVisible(false);
            SpaYearEnter.setVisible(false);

            SpaHourEnter.setVisible(false);
            SpaMinuteEnter.setVisible(false);
            SpaSecondEnter.setVisible(false);

            RateExp.setVisible(false);
            ratingStars.setVisible(false);
            WriteFeedback.setVisible(false);
            Feedback.setVisible(false);
            ReservationSelectionLabel.setVisible(false);
            reservationPackage.setVisible(false);

            RoomBooking.setVisible(true);
            ChooseDateIn.setVisible(true);
            ChooseDateOut.setVisible(true);
            NumberOfGuests.setVisible(true);
            EnterDateIn.setVisible(true);
            EnterDateOut.setVisible(true);
            EnterNumberOfGuests.setVisible(true);
            RoomSelectionField.setVisible(true);
            RoomSelectionLabel.setVisible(true);
            RoomList.setVisible(true);
            IntroducitonLabel.setVisible(true);


            BookingTitle.setVisible(false);

            visaImage.setVisible(false);
            mastercardImage.setVisible(false);
            PaypalImage.setVisible(false);
            DiscoverImage.setVisible(false);

            CreditNumber.setVisible(false);
            NameOnCard.setVisible(false);
            Amount.setVisible(false);
            SecCode.setVisible(false);

            CreditNumberPos.setVisible(false);
            NameCardPos.setVisible(false);
            AmountPos.setVisible(false);
            SecCodePos.setVisible(false);

            BookingFirstName.setVisible(false);
            BookingLastName.setVisible(false);
            BookingPhoneNumber.setVisible(false);
            BookingEmail.setVisible(false);
            BookingCredit.setVisible(false);
            BookingNamecard.setVisible(false);
            BookingAmount.setVisible(false);
            BookingSecCode.setVisible(false);

        });

        // ReservationTab setup
        ServiceMenu = new JLabel();
        ServiceMenu.setText("SERVICE MENU");
        ServiceMenu.setFont(new Font("Mulish", Font.BOLD, 33));
        ServiceMenu.setBounds(310, 20, 300, 33);
        ServiceMenu.setForeground(new Color(212, 158, 24));
        ServiceMenu.setVisible(false);
        panel.add(ServiceMenu);

        CustomerInfo = new JLabel();
        CustomerInfo.setText("I. CUSTOMER INFORMATION");
        CustomerInfo.setFont(new Font("Mulish", Font.BOLD, 33));
        CustomerInfo.setBounds(310, 115, 500, 33);
        CustomerInfo.setForeground(new Color(136, 120, 81));
        CustomerInfo.setVisible(false);
        panel.add(CustomerInfo);

        BookingInformation = new JLabel();
        BookingInformation.setText("II. BOOKING INFORMATION");
        BookingInformation.setFont(new Font("Mulish", Font.BOLD, 33));
        BookingInformation.setBounds(310, 330, 500, 33);
        BookingInformation.setForeground(new Color(136, 120, 81));
        BookingInformation.setVisible(false);
        panel.add(BookingInformation);

        SpaCenter = new JLabel();
        SpaCenter.setText("SPA CENTER");
        SpaCenter.setFont(new Font("Mulish", Font.BOLD, 33));
        SpaCenter.setBounds(310, 20, 300, 33);
        SpaCenter.setForeground(new Color(212, 158, 24));
        SpaCenter.setVisible(false);
        panel.add(SpaCenter);

        Spa = new JButton();
        Spa.setText("Spa Center");
        Spa.setFont(new Font("Mulish", Font.BOLD, 33));
        Spa.setFocusable(false);
        Spa.setBackground(new Color(217, 217, 217));
        Spa.setForeground(new Color(136, 120, 81));
        Spa.setBounds(400, 150, 350, 200);
        Spa.setVisible(false);
        panel.add(Spa);
        Spa.addActionListener(e -> {
            logOutPanel.setVisible(true);
            logOutButton.setVisible(true);
            Service service = serviceDAOImpl.getServiceByID(1);
            if (service == null) {
                JOptionPane.showMessageDialog(frame, "Service not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit if the service does not exist
            }

            if (service.getServiceAvailability() != null && service.getServiceAvailability().equals("Unavailable")) {
                JOptionPane.showMessageDialog(frame, "The Spa service is currently unavailable. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit if the service is unavailable
            }

            JOptionPane.showMessageDialog(frame, "The Spa service is available. You can proceed to book!", "Info", JOptionPane.INFORMATION_MESSAGE);

            FNamePosition.setVisible(true);
            LNamePosition.setVisible(true);
            PNumberPosition.setVisible(true);
            EmailPosition.setVisible(true);
            DatePosition.setVisible(true);
            TimePosition.setVisible(true);

            Tab1_background.setVisible(false);
            Tab2_background.setVisible(false);
            Tab3_background.setVisible(true);
            Tab4_background.setVisible(false);

            hotelNameLabel.setVisible(false);
            welcomeLabel.setVisible(false);
            dateLabel.setVisible(false);
            roomType1.setVisible(false);
            roomType2.setVisible(false);
            roomType3.setVisible(false);
            room1Label.setVisible(false);
            room2Label.setVisible(false);
            room3Label.setVisible(false);
            averageRatingLabel.setVisible(false);
            IntroducitonLabel.setVisible(false);


            Restaurant.setVisible(false);
            Spa.setVisible(false);
            RoomCleaning.setVisible(false);
            MusicLounge.setVisible((false));

            ServiceMenu.setVisible(false);
            SpaCenter.setVisible(true);
            CustomerInfo.setVisible(true);
            BookingInformation.setVisible(true);
            SubmitServiceButton.setVisible(true);

            EnterBoxFName.setVisible(true);
            EnterBoxLName.setVisible(true);
            EnterBoxPNumber.setVisible(true);
            EnterBoxEmail.setVisible(true);

            SpaFirstName.setVisible(true);
            SpaLastName.setVisible(true);
            SpaPhoneNumber.setVisible(true);
            SpaEmail.setVisible(true);

            Daybox.setVisible(true);
            Monthbox.setVisible(true);
            Yearbox.setVisible(true);
            Hourbox.setVisible(true);
            Minutebox.setVisible(true);
            Secondbox.setVisible(true);
            //Clear Date Time Textfields
            SpaDayEnter.setText("");
            SpaMonthEnter.setText("");
            SpaYearEnter.setText("");
            SpaHourEnter.setText("");
            SpaMinuteEnter.setText("");
            SpaSecondEnter.setText("");

            SpaDayEnter.setVisible(true);
            SpaMonthEnter.setVisible(true);
            SpaYearEnter.setVisible(true);
            SpaHourEnter.setVisible(true);
            SpaMinuteEnter.setVisible(true);
            SpaSecondEnter.setVisible(true);

            RateExp.setVisible(false);
            ratingStars.setVisible(false);

            serviceId = 1;

        });

        RestaurantCenter = new JLabel();
        RestaurantCenter.setText("RESTAURANT");
        RestaurantCenter.setFont(new Font("Mulish", Font.BOLD, 33));
        RestaurantCenter.setBounds(310, 20, 300, 33);
        RestaurantCenter.setForeground(new Color(212, 158, 24));
        RestaurantCenter.setVisible(false);
        panel.add(RestaurantCenter);

        Restaurant = new JButton();
        Restaurant.setText("Restaurant");
        Restaurant.setFont(new Font("Mulish", Font.BOLD, 33));
        Restaurant.setFocusable(false);
        Restaurant.setBackground(new Color(217, 217, 217));
        Restaurant.setForeground(new Color(136, 120, 81));
        Restaurant.setBounds(800, 150, 350, 200);
        Restaurant.setVisible(false);
        panel.add(Restaurant);
        Restaurant.addActionListener(e -> {
            logOutPanel.setVisible(true);
            logOutButton.setVisible(true);
            Service service = serviceDAOImpl.getServiceByID(2);
            if (service == null) {
                JOptionPane.showMessageDialog(frame, "Service not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit if the service does not exist
            }

            if (service.getServiceAvailability() != null && service.getServiceAvailability().equals("Unavailable")) {
                JOptionPane.showMessageDialog(frame, "The Restaurant service is currently unavailable. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit if the service is unavailable
            }

            JOptionPane.showMessageDialog(frame, "The Restaurant service is available. You can proceed to book!", "Info", JOptionPane.INFORMATION_MESSAGE);

            Tab1_background.setVisible(false);
            Tab2_background.setVisible(false);
            Tab3_background.setVisible(true);
            Tab4_background.setVisible(false);
            Restaurant.setVisible(false);
            Spa.setVisible(false);
            RoomCleaning.setVisible(false);
            MusicLounge.setVisible((false));
            
            hotelNameLabel.setVisible(false);
            welcomeLabel.setVisible(false);
            dateLabel.setVisible(false);
            roomType1.setVisible(false);
            roomType2.setVisible(false);
            roomType3.setVisible(false);
            room1Label.setVisible(false);
            room2Label.setVisible(false);
            room3Label.setVisible(false);
            averageRatingLabel.setVisible(false);
            IntroducitonLabel.setVisible(false);


            CustomerInfo.setVisible(true);
            BookingInformation.setVisible(true);
            RestaurantCenter.setVisible(true);
            ServiceMenu.setVisible(false);
            SubmitServiceButton.setVisible(true);

            EnterBoxFName.setVisible(true);
            EnterBoxLName.setVisible(true);
            EnterBoxPNumber.setVisible(true);
            EnterBoxEmail.setVisible(true);

            SpaFirstName.setVisible(true);
            SpaLastName.setVisible(true);
            SpaPhoneNumber.setVisible(true);
            SpaEmail.setVisible(true);

            FNamePosition.setVisible(true);
            LNamePosition.setVisible(true);
            PNumberPosition.setVisible(true);
            EmailPosition.setVisible(true);
            DatePosition.setVisible(true);
            TimePosition.setVisible(true);

            Daybox.setVisible(true);
            Monthbox.setVisible(true);
            Yearbox.setVisible(true);
            Hourbox.setVisible(true);
            Minutebox.setVisible(true);
            Secondbox.setVisible(true);
            //Clear Date Time Textfields
            SpaDayEnter.setText("");
            SpaMonthEnter.setText("");
            SpaYearEnter.setText("");
            SpaHourEnter.setText("");
            SpaMinuteEnter.setText("");
            SpaSecondEnter.setText("");

            SpaDayEnter.setVisible(true);
            SpaMonthEnter.setVisible(true);
            SpaYearEnter.setVisible(true);
            SpaHourEnter.setVisible(true);
            SpaMinuteEnter.setVisible(true);
            SpaSecondEnter.setVisible(true);

            RateExp.setVisible(false);
            serviceId = 2;

        });

        RoomCleaningCenter = new JLabel();
        RoomCleaningCenter.setText("ROOM CLEANING");
        RoomCleaningCenter.setFont(new Font("Mulish", Font.BOLD, 33));
        RoomCleaningCenter.setBounds(310, 20, 300, 33);
        RoomCleaningCenter.setForeground(new Color(212, 158, 24));
        RoomCleaningCenter.setVisible(false);
        panel.add(RoomCleaningCenter);

        RoomCleaning = new JButton();
        RoomCleaning.setText("Room Cleaning");
        RoomCleaning.setFont(new Font("Mulish", Font.BOLD, 33));
        RoomCleaning.setFocusable(false);
        RoomCleaning.setBackground(new Color(217, 217, 217));
        RoomCleaning.setForeground(new Color(136, 120, 81));
        RoomCleaning.setBounds(400, 380, 350, 200);
        RoomCleaning.setVisible(false);
        panel.add(RoomCleaning);
        RoomCleaning.addActionListener(e -> {
            logOutPanel.setVisible(true);
            logOutButton.setVisible(true);
            Service service = serviceDAOImpl.getServiceByID(3);
            if (service == null) {
                JOptionPane.showMessageDialog(frame, "Service not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit if the service does not exist
            }

            if (service.getServiceAvailability() != null && service.getServiceAvailability().equals("Unavailable")) {
                JOptionPane.showMessageDialog(frame, "The Room Cleaning service is currently unavailable. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit if the service is unavailable
            }

            JOptionPane.showMessageDialog(frame, "The Room Cleaning service is available. You can proceed to book!", "Info", JOptionPane.INFORMATION_MESSAGE);

            Tab1_background.setVisible(false);
            Tab2_background.setVisible(false);
            Tab3_background.setVisible(true);
            Tab4_background.setVisible(false);
            Restaurant.setVisible(false);
            Spa.setVisible(false);
            RoomCleaning.setVisible(false);
            MusicLounge.setVisible((false));
            
            hotelNameLabel.setVisible(false);
            welcomeLabel.setVisible(false);
            dateLabel.setVisible(false);
            roomType1.setVisible(false);
            roomType2.setVisible(false);
            roomType3.setVisible(false);
            room1Label.setVisible(false);
            room2Label.setVisible(false);
            room3Label.setVisible(false);
            averageRatingLabel.setVisible(false);
            IntroducitonLabel.setVisible(false);


            CustomerInfo.setVisible(true);
            BookingInformation.setVisible(true);
            RoomCleaningCenter.setVisible(true);
            ServiceMenu.setVisible(false);
            SubmitServiceButton.setVisible(true);

            EnterBoxFName.setVisible(true);
            EnterBoxLName.setVisible(true);
            EnterBoxPNumber.setVisible(true);
            EnterBoxEmail.setVisible(true);

            SpaFirstName.setVisible(true);
            SpaLastName.setVisible(true);
            SpaPhoneNumber.setVisible(true);
            SpaEmail.setVisible(true);

            FNamePosition.setVisible(true);
            LNamePosition.setVisible(true);
            PNumberPosition.setVisible(true);
            EmailPosition.setVisible(true);
            DatePosition.setVisible(true);
            TimePosition.setVisible(true);

            Daybox.setVisible(true);
            Monthbox.setVisible(true);
            Yearbox.setVisible(true);
            Hourbox.setVisible(true);
            Minutebox.setVisible(true);
            Secondbox.setVisible(true);
            //Clear Date Time Textfields
            SpaDayEnter.setText("");
            SpaMonthEnter.setText("");
            SpaYearEnter.setText("");
            SpaHourEnter.setText("");
            SpaMinuteEnter.setText("");
            SpaSecondEnter.setText("");

            SpaDayEnter.setVisible(true);
            SpaMonthEnter.setVisible(true);
            SpaYearEnter.setVisible(true);
            SpaHourEnter.setVisible(true);
            SpaMinuteEnter.setVisible(true);
            SpaSecondEnter.setVisible(true);

            RateExp.setVisible(false);
            serviceId = 3;
        });

        MusicLoungeCenter = new JLabel();
        MusicLoungeCenter.setText("MUSIC LOUNGE");
        MusicLoungeCenter.setFont(new Font("Mulish", Font.BOLD, 33));
        MusicLoungeCenter.setBounds(310, 20, 300, 33);
        MusicLoungeCenter.setForeground(new Color(212, 158, 24));
        MusicLoungeCenter.setVisible(false);
        panel.add(MusicLoungeCenter);

        MusicLounge = new JButton();
        MusicLounge.setText("Music Lounge");
        MusicLounge.setFont(new Font("Mulish", Font.BOLD, 33));
        MusicLounge.setFocusable(false);
        MusicLounge.setBackground(new Color(217, 217, 217));
        MusicLounge.setForeground(new Color(136, 120, 81));
        MusicLounge.setBounds(800, 380, 350, 200);
        MusicLounge.setVisible(false);
        panel.add(MusicLounge);
        MusicLounge.addActionListener(e -> {
            logOutPanel.setVisible(true);
            logOutButton.setVisible(true);
            Service service = serviceDAOImpl.getServiceByID(4);
            if (service == null) {
                JOptionPane.showMessageDialog(frame, "Service not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit if the service does not exist
            }

            if (service.getServiceAvailability() != null && service.getServiceAvailability().equals("Unavailable")) {
                JOptionPane.showMessageDialog(frame, "The Music Lounge service is currently unavailable. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit if the service is unavailable
            }

            JOptionPane.showMessageDialog(frame, "The Music Lounge service is available. You can proceed to book!", "Info", JOptionPane.INFORMATION_MESSAGE);

            Tab1_background.setVisible(false);
            Tab2_background.setVisible(false);
            Tab3_background.setVisible(true);
            Tab4_background.setVisible(false);
            Restaurant.setVisible(false);
            Spa.setVisible(false);
            RoomCleaning.setVisible(false);
            MusicLounge.setVisible((false));
            
            hotelNameLabel.setVisible(false);
            welcomeLabel.setVisible(false);
            dateLabel.setVisible(false);
            roomType1.setVisible(false);
            roomType2.setVisible(false);
            roomType3.setVisible(false);
            room1Label.setVisible(false);
            room2Label.setVisible(false);
            room3Label.setVisible(false);
            averageRatingLabel.setVisible(false);
            IntroducitonLabel.setVisible(false);


            CustomerInfo.setVisible(true);
            BookingInformation.setVisible(true);
            MusicLoungeCenter.setVisible(true);
            ServiceMenu.setVisible(false);
            SubmitServiceButton.setVisible(true);

            EnterBoxFName.setVisible(true);
            EnterBoxLName.setVisible(true);
            EnterBoxPNumber.setVisible(true);
            EnterBoxEmail.setVisible(true);

            SpaFirstName.setVisible(true);
            SpaLastName.setVisible(true);
            SpaPhoneNumber.setVisible(true);
            SpaEmail.setVisible(true);

            FNamePosition.setVisible(true);
            LNamePosition.setVisible(true);
            PNumberPosition.setVisible(true);
            EmailPosition.setVisible(true);
            DatePosition.setVisible(true);
            TimePosition.setVisible(true);

            Daybox.setVisible(true);
            Monthbox.setVisible(true);
            Yearbox.setVisible(true);
            Hourbox.setVisible(true);
            Minutebox.setVisible(true);
            Secondbox.setVisible(true);
            //Clear Date Time Textfields
            SpaDayEnter.setText("");
            SpaMonthEnter.setText("");
            SpaYearEnter.setText("");
            SpaHourEnter.setText("");
            SpaMinuteEnter.setText("");
            SpaSecondEnter.setText("");

            SpaDayEnter.setVisible(true);
            SpaMonthEnter.setVisible(true);
            SpaYearEnter.setVisible(true);
            SpaHourEnter.setVisible(true);
            SpaMinuteEnter.setVisible(true);
            SpaSecondEnter.setVisible(true);

            RateExp.setVisible(false);
            serviceId = 4;
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
        if (userDaoImpl.getReservationsByCustomer(userId).isEmpty()) {
            ServiceTab.setEnabled(false);
        } else {
            ServiceTab.setEnabled(true);
        }
        ServiceTab.addActionListener(e -> {
            logOutPanel.setVisible(true);
            logOutButton.setVisible(true);
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
            BookingInformation.setVisible(false);
            RestaurantCenter.setVisible(false);
            RoomCleaningCenter.setVisible(false);
            MusicLoungeCenter.setVisible(false);
            PaymentMethod.setVisible(false);

            EnterBoxFName.setVisible(false);
            EnterBoxLName.setVisible(false);
            EnterBoxPNumber.setVisible(false);
            EnterBoxEmail.setVisible(false);

            SpaFirstName.setVisible(false);
            SpaLastName.setVisible(false);
            SpaPhoneNumber.setVisible(false);
            SpaEmail.setVisible(false);
            
            hotelNameLabel.setVisible(false);
            welcomeLabel.setVisible(false);
            dateLabel.setVisible(false);
            roomType1.setVisible(false);
            roomType2.setVisible(false);
            roomType3.setVisible(false);
            room1Label.setVisible(false);
            room2Label.setVisible(false);
            room3Label.setVisible(false);
            averageRatingLabel.setVisible(false);
            IntroducitonLabel.setVisible(false);


            FNamePosition.setVisible(false);
            LNamePosition.setVisible(false);
            PNumberPosition.setVisible(false);
            EmailPosition.setVisible(false);
            DatePosition.setVisible(false);
            TimePosition.setVisible(false);

            Daybox.setVisible(false);
            Monthbox.setVisible(false);
            Yearbox.setVisible(false);

            Hourbox.setVisible(false);
            Minutebox.setVisible(false);
            Secondbox.setVisible(false);

            SpaDayEnter.setVisible(false);
            SpaMonthEnter.setVisible(false);
            SpaYearEnter.setVisible(false);

            SpaHourEnter.setVisible(false);
            SpaMinuteEnter.setVisible(false);
            SpaSecondEnter.setVisible(false);

            RateExp.setVisible(false);
            ratingStars.setVisible(false);
            WriteFeedback.setVisible(false);
            Feedback.setVisible(false);
            ReservationSelectionLabel.setVisible(false);
            reservationPackage.setVisible(false);

            RoomBooking.setVisible(false);
            ChooseDateIn.setVisible(false);
            ChooseDateOut.setVisible(false);
            NumberOfGuests.setVisible(false);
            EnterDateIn.setVisible(false);
            EnterDateOut.setVisible(false);
            EnterNumberOfGuests.setVisible(false);
            RoomSelectionField.setVisible(false);
            RoomSelectionLabel.setVisible(false);
            RoomList.setVisible(false);

            NextButton.setVisible(false);
            sendButton.setVisible(false);
            SubmitServiceButton.setVisible(false);
            SubmitReservationButton.setVisible(false);

            BookingTitle.setVisible(false);

            visaImage.setVisible(false);
            mastercardImage.setVisible(false);
            PaypalImage.setVisible(false);
            DiscoverImage.setVisible(false);

            CreditNumber.setVisible(false);
            NameOnCard.setVisible(false);
            Amount.setVisible(false);
            SecCode.setVisible(false);

            CreditNumberPos.setVisible(false);
            NameCardPos.setVisible(false);
            AmountPos.setVisible(false);
            SecCodePos.setVisible(false);

            BookingFirstName.setVisible(false);
            BookingLastName.setVisible(false);
            BookingPhoneNumber.setVisible(false);
            BookingEmail.setVisible(false);
            BookingCredit.setVisible(false);
            BookingNamecard.setVisible(false);
            BookingAmount.setVisible(false);
            BookingSecCode.setVisible(false);

        });

        NextButton.addActionListener(e -> {
            logOutPanel.setVisible(true);
            logOutButton.setVisible(true);
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

            NextButton.setVisible(false);
            sendButton.setVisible(false);
            SubmitServiceButton.setVisible(false);
            SubmitReservationButton.setVisible(true);

            hotelNameLabel.setVisible(false);
            welcomeLabel.setVisible(false);
            dateLabel.setVisible(false);
            roomType1.setVisible(false);
            roomType2.setVisible(false);
            roomType3.setVisible(false);
            room1Label.setVisible(false);
            room2Label.setVisible(false);
            room3Label.setVisible(false);
            averageRatingLabel.setVisible(false);
            IntroducitonLabel.setVisible(false);


            SpaCenter.setVisible(false);
            RestaurantCenter.setVisible(false);
            RoomCleaningCenter.setVisible(false);
            MusicLoungeCenter.setVisible(false);
            CustomerInfo.setVisible(true);
            BookingInformation.setVisible(false);
            PaymentMethod.setVisible(true);

            EnterBoxFName.setVisible(true);
            EnterBoxLName.setVisible(true);
            EnterBoxPNumber.setVisible(true);
            EnterBoxEmail.setVisible(true);

            FNamePosition.setVisible(true);
            LNamePosition.setVisible(true);
            PNumberPosition.setVisible(true);
            EmailPosition.setVisible(true);
            DatePosition.setVisible(false);
            TimePosition.setVisible(false);

            Daybox.setVisible(false);
            Monthbox.setVisible(false);
            Yearbox.setVisible(false);

            Hourbox.setVisible(false);
            Minutebox.setVisible(false);
            Secondbox.setVisible(false);

            SpaDayEnter.setVisible(false);
            SpaMonthEnter.setVisible(false);
            SpaYearEnter.setVisible(false);

            SpaHourEnter.setVisible(false);
            SpaMinuteEnter.setVisible(false);
            SpaSecondEnter.setVisible(false);

            RateExp.setVisible(false);
            ratingStars.setVisible(false);
            WriteFeedback.setVisible(false);
            Feedback.setVisible(false);
            ReservationSelectionLabel.setVisible(false);
            reservationPackage.setVisible(false);

            RoomBooking.setVisible(false);
            ChooseDateIn.setVisible(false);
            ChooseDateOut.setVisible(false);
            NumberOfGuests.setVisible(false);
            EnterDateIn.setVisible(false);
            EnterDateOut.setVisible(false);
            EnterNumberOfGuests.setVisible(false);
            RoomSelectionField.setVisible(false);
            RoomSelectionLabel.setVisible(false);
            RoomList.setVisible(false);

            BookingTitle.setVisible(true);

            visaImage.setVisible(true);
            mastercardImage.setVisible(true);
            PaypalImage.setVisible(true);
            DiscoverImage.setVisible(true);

            CreditNumber.setVisible(true);
            NameOnCard.setVisible(true);
            Amount.setVisible(true);
            SecCode.setVisible(true);

            CreditNumberPos.setVisible(true);
            NameCardPos.setVisible(true);
            AmountPos.setVisible(true);
            SecCodePos.setVisible(true);

            BookingFirstName.setVisible(true);
            BookingLastName.setVisible(true);
            BookingPhoneNumber.setVisible(true);
            BookingEmail.setVisible(true);
            BookingCredit.setVisible(true);
            BookingNamecard.setVisible(true);
            BookingAmount.setVisible(true);
            BookingSecCode.setVisible(true);
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
        ReviewTab.addActionListener(e -> {
            logOutPanel.setVisible(true);
            logOutButton.setVisible(true);
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

            hotelNameLabel.setVisible(false);
            welcomeLabel.setVisible(false);
            dateLabel.setVisible(false);
            roomType1.setVisible(false);
            roomType2.setVisible(false);
            roomType3.setVisible(false);
            room1Label.setVisible(false);
            room2Label.setVisible(false);
            room3Label.setVisible(false);
            averageRatingLabel.setVisible(false);
            IntroducitonLabel.setVisible(false);


            SpaCenter.setVisible(false);
            RestaurantCenter.setVisible(false);
            RoomCleaningCenter.setVisible(false);
            MusicLoungeCenter.setVisible(false);
            CustomerInfo.setVisible(false);
            BookingInformation.setVisible(false);
            PaymentMethod.setVisible(false);

            SpaFirstName.setVisible(false);
            SpaLastName.setVisible(false);
            SpaPhoneNumber.setVisible(false);
            SpaEmail.setVisible(false);

            EnterBoxFName.setVisible(false);
            EnterBoxLName.setVisible(false);
            EnterBoxPNumber.setVisible(false);
            EnterBoxEmail.setVisible(false);

            FNamePosition.setVisible(false);
            LNamePosition.setVisible(false);
            PNumberPosition.setVisible(false);
            EmailPosition.setVisible(false);
            DatePosition.setVisible(false);
            TimePosition.setVisible(false);

            Daybox.setVisible(false);
            Monthbox.setVisible(false);
            Yearbox.setVisible(false);

            Hourbox.setVisible(false);
            Minutebox.setVisible(false);
            Secondbox.setVisible(false);

            SpaDayEnter.setVisible(false);
            SpaMonthEnter.setVisible(false);
            SpaYearEnter.setVisible(false);

            SpaHourEnter.setVisible(false);
            SpaMinuteEnter.setVisible(false);
            SpaSecondEnter.setVisible(false);

            RateExp.setVisible(true);
            ratingStars.setVisible(true);
            WriteFeedback.setVisible(true);
            Feedback.setVisible(true);
            ReservationSelectionLabel.setVisible(true);
            reservationPackage.setVisible(true);

            RoomBooking.setVisible(false);
            ChooseDateIn.setVisible(false);
            ChooseDateOut.setVisible(false);
            EnterDateIn.setVisible(false);
            EnterDateOut.setVisible(false);
            RoomList.setVisible(false);
            NumberOfGuests.setVisible(false);
            EnterNumberOfGuests.setVisible(false);
            RoomSelectionField.setVisible(false);
            RoomSelectionLabel.setVisible(false);

            NextButton.setVisible(false);
            sendButton.setVisible(true);
            SubmitServiceButton.setVisible(false);
            SubmitReservationButton.setVisible(false);

            BookingTitle.setVisible(false);

            visaImage.setVisible(false);
            mastercardImage.setVisible(false);
            PaypalImage.setVisible(false);
            DiscoverImage.setVisible(false);

            CreditNumberPos.setVisible(false);
            NameCardPos.setVisible(false);
            AmountPos.setVisible(false);
            SecCodePos.setVisible(false);

            CreditNumber.setVisible(false);
            NameOnCard.setVisible(false);
            Amount.setVisible(false);
            SecCode.setVisible(false);

            BookingFirstName.setVisible(false);
            BookingLastName.setVisible(false);
            BookingPhoneNumber.setVisible(false);
            BookingEmail.setVisible(false);
            BookingCredit.setVisible(false);
            BookingNamecard.setVisible(false);
            BookingAmount.setVisible(false);
            BookingSecCode.setVisible(false);

        });

        sendButton.addActionListener(e -> {
            logOutPanel.setVisible(true);
            logOutButton.setVisible(true);
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

            NextButton.setVisible(false);
            sendButton.setVisible(true);
            SubmitServiceButton.setVisible(false);
            SubmitReservationButton.setVisible(false);
            
            hotelNameLabel.setVisible(false);
            welcomeLabel.setVisible(false);
            dateLabel.setVisible(false);
            roomType1.setVisible(false);
            roomType2.setVisible(false);
            roomType3.setVisible(false);
            room1Label.setVisible(false);
            room2Label.setVisible(false);
            room3Label.setVisible(false);
            averageRatingLabel.setVisible(false);
            IntroducitonLabel.setVisible(false);


            SpaCenter.setVisible(false);
            RestaurantCenter.setVisible(false);
            RoomCleaningCenter.setVisible(false);
            MusicLoungeCenter.setVisible(false);
            CustomerInfo.setVisible(false);
            BookingInformation.setVisible(false);
            PaymentMethod.setVisible(false);

            EnterBoxFName.setVisible(false);
            EnterBoxLName.setVisible(false);
            EnterBoxPNumber.setVisible(false);
            EnterBoxEmail.setVisible(false);

            FNamePosition.setVisible(false);
            LNamePosition.setVisible(false);
            PNumberPosition.setVisible(false);
            EmailPosition.setVisible(false);
            DatePosition.setVisible(false);
            TimePosition.setVisible(false);

            Daybox.setVisible(false);
            Monthbox.setVisible(false);
            Yearbox.setVisible(false);

            Hourbox.setVisible(false);
            Minutebox.setVisible(false);
            Secondbox.setVisible(false);

            SpaDayEnter.setVisible(false);
            SpaMonthEnter.setVisible(false);
            SpaYearEnter.setVisible(false);

            SpaHourEnter.setVisible(false);
            SpaMinuteEnter.setVisible(false);
            SpaSecondEnter.setVisible(false);

            RateExp.setVisible(true);
            ratingStars.setVisible(true);
            WriteFeedback.setVisible(true);
            Feedback.setVisible(true);
            ReservationSelectionLabel.setVisible(true);
            reservationPackage.setVisible(true);

            RoomBooking.setVisible(false);
            ChooseDateIn.setVisible(false);
            ChooseDateOut.setVisible(false);
            NumberOfGuests.setVisible(false);

            EnterDateIn.setVisible(false);
            EnterDateOut.setVisible(false);
            EnterNumberOfGuests.setVisible(false);
            RoomList.setVisible(false);
            RoomSelectionLabel.setVisible(false);
            RoomSelectionField.setVisible(false);
            BookingTitle.setVisible(false);

            CreditNumber.setVisible(false);
            NameOnCard.setVisible(false);
            Amount.setVisible(false);
            SecCode.setVisible(false);

            CreditNumberPos.setVisible(false);
            NameCardPos.setVisible(false);
            AmountPos.setVisible(false);
            SecCodePos.setVisible(false);

            BookingFirstName.setVisible(false);
            BookingLastName.setVisible(false);
            BookingPhoneNumber.setVisible(false);
            BookingEmail.setVisible(false);
            BookingCredit.setVisible(false);
            BookingNamecard.setVisible(false);
            BookingAmount.setVisible(false);
            BookingSecCode.setVisible(false);

            if (ratingStars.getSelectedRating() == 0) {
                JOptionPane.showMessageDialog(frame, "Please select a rating before sending your review.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to send your review?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Thank you for your feedback!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    java.sql.Date reviewDate = new java.sql.Date(System.currentTimeMillis());

                    Review review = new Review();
                    review.setUser(userDaoImpl.getUserByID(userId));
                    review.setReservation(selectedReservation); // Link the Reservation
                    review.setRating(ratingStars.getSelectedRating());
                    review.setComment(WriteFeedback.getText());
                    review.setReviewDate(reviewDate);
                    try {
                        reviewDAOImpl.saveReview(review);
                        System.out.println("Review sent successfully!");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("Error sending review!");
                    }

                    sendButton.setEnabled(false);
                }
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
        addLogOutPanel();
        logOutPanel.setVisible(true);
        // Make frame visible
        frame.setVisible(true);

    }

    public void CreateServiceInfoBox() {
        //box for first name
        EnterBoxFName = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        EnterBoxFName.setBounds(350, 200, 300, 30);
        panel.add(EnterBoxFName);
        panel.setComponentZOrder(EnterBoxFName, 0); // Brings it to the top of the component stack
        EnterBoxFName.setVisible(false);

        SpaFirstName = new JLabel(userDaoImpl.getUserByID(userId).getFirstName());
        panel.add(SpaFirstName);
        SpaFirstName.setBounds(352, 201, 295, 28);
        SpaFirstName.setBackground(new Color(244, 242, 235));
        SpaFirstName.setVisible(false);
        SpaFirstName.setBorder(null);

        //box for last name
        EnterBoxLName = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        EnterBoxLName.setBounds(750, 200, 300, 30);
        panel.add(EnterBoxLName);
        panel.setComponentZOrder(EnterBoxLName, 0); // Brings it to the top of the component stack
        EnterBoxLName.setVisible(false);

        SpaLastName = new JLabel(userDaoImpl.getUserByID(userId).getLastName());
        panel.add(SpaLastName);
        SpaLastName.setBounds(752, 201, 295, 28);
        SpaLastName.setBackground(new Color(244, 242, 235));
        SpaLastName.setVisible(false);
        SpaLastName.setBorder(null);

        //box for phone number
        EnterBoxPNumber = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        EnterBoxPNumber.setBounds(350, 280, 300, 30);
        panel.add(EnterBoxPNumber);
        panel.setComponentZOrder(EnterBoxPNumber, 0); // Brings it to the top of the component stack
        EnterBoxPNumber.setVisible(false);

        SpaPhoneNumber = new JLabel(userDaoImpl.getUserByID(userId).getPhone());
        panel.add(SpaPhoneNumber);
        SpaPhoneNumber.setBounds(352, 281, 295, 28);
        SpaPhoneNumber.setBackground(new Color(244, 242, 235));
        SpaPhoneNumber.setVisible(false);
        SpaPhoneNumber.setBorder(null);

        //box for email
        EnterBoxEmail = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        EnterBoxEmail.setBounds(750, 280, 300, 30);
        panel.add(EnterBoxEmail);
        panel.setComponentZOrder(EnterBoxEmail, 0); // Brings it to the top of the component stack
        EnterBoxEmail.setVisible(false);

        SpaEmail = new JLabel(userDaoImpl.getUserByID(userId).getEmail());
        panel.add(SpaEmail);
        SpaEmail.setBounds(752, 281, 295, 28);
        SpaEmail.setBackground(new Color(244, 242, 235));
        SpaEmail.setVisible(false);
        SpaEmail.setBorder(null);

        CreditNumber = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        CreditNumber.setBounds(350, 450, 300, 30);
        panel.add(CreditNumber);
        panel.setComponentZOrder(CreditNumber, 0); // Brings it to the top of the component stack
        CreditNumber.setVisible(false);

        NameOnCard = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        NameOnCard.setBounds(750, 450, 300, 30);
        panel.add(NameOnCard);
        panel.setComponentZOrder(NameOnCard, 0); // Brings it to the top of the component stack
        NameOnCard.setVisible(false);

        Amount = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        Amount.setBounds(350, 530, 300, 30);
        panel.add(Amount);
        panel.setComponentZOrder(Amount, 0); // Brings it to the top of the component stack
        Amount.setVisible(false);

        SecCode = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        SecCode.setBounds(750, 530, 300, 30);
        panel.add(SecCode);
        panel.setComponentZOrder(SecCode, 0); // Brings it to the top of the component stack
        SecCode.setVisible(false);
    }

    public void CreateBookingInfo() {
        //box for first name
        BookingFirstName = new JLabel();
        panel.add(BookingFirstName);
        BookingFirstName.setBounds(352, 201, 295, 28);
        BookingFirstName.setBackground(new Color(244, 242, 235));
        BookingFirstName.setVisible(false);
        BookingFirstName.setBorder(null);

        //box for last name
        BookingLastName = new JLabel();
        panel.add(BookingLastName);
        BookingLastName.setBounds(752, 201, 295, 28);
        BookingLastName.setBackground(new Color(244, 242, 235));
        BookingLastName.setVisible(false);
        BookingLastName.setBorder(null);

        //box for phone number
        BookingPhoneNumber = new JLabel();
        panel.add(BookingPhoneNumber);
        BookingPhoneNumber.setBounds(352, 281, 295, 28);
        BookingPhoneNumber.setBackground(new Color(244, 242, 235));
        BookingPhoneNumber.setVisible(false);
        BookingPhoneNumber.setBorder(null);

        //box for email
        BookingEmail = new JLabel();
        panel.add(BookingEmail);
        BookingEmail.setBounds(752, 281, 295, 28);
        BookingEmail.setBackground(new Color(244, 242, 235));
        BookingEmail.setVisible(false);
        BookingEmail.setBorder(null);

        BookingCredit = new JTextField();
        panel.add(BookingCredit);
        BookingCredit.setBounds(352, 451, 295, 28);
        BookingCredit.setBackground(new Color(244, 242, 235));
        BookingCredit.setVisible(false);
        BookingCredit.setBorder(null);

        BookingNamecard = new JTextField();
        panel.add(BookingNamecard);
        BookingNamecard.setBounds(752, 451, 295, 28);
        BookingNamecard.setBackground(new Color(244, 242, 235));
        BookingNamecard.setVisible(false);
        BookingNamecard.setBorder(null);

        BookingAmount = new JTextField();
        panel.add(BookingAmount);
        BookingAmount.setBounds(352, 531, 295, 28);
        BookingAmount.setBackground(new Color(244, 242, 235));
        BookingAmount.setVisible(false);
        BookingAmount.setBorder(null);

        BookingSecCode = new JTextField();
        panel.add(BookingSecCode);
        BookingSecCode.setBounds(752, 531, 295, 28);
        BookingSecCode.setBackground(new Color(244, 242, 235));
        BookingSecCode.setVisible(false);
        BookingSecCode.setBorder(null);
    }

    public void CreateDate_TimeBox() {
        
        Daybox = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/BookingBox.png", 100, 30));
        Daybox.setBounds(350, 420, 100, 30);
        panel.add(Daybox);
        panel.setComponentZOrder(Daybox, 0); // Brings it to the top of the component stack
        Daybox.setVisible(false);

        SpaDayEnter = new JTextField();
        panel.add(SpaDayEnter);
        SpaDayEnter.setBounds(351, 421, 98, 28);
        SpaDayEnter.setBackground(new Color(244, 242, 235));
        SpaDayEnter.setVisible(false);
        SpaDayEnter.setBorder(null);

        Monthbox = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/BookingBox.png", 100, 30));
        Monthbox.setBounds(460, 420, 100, 30);
        panel.add(Monthbox);
        panel.setComponentZOrder(Monthbox, 0); // Brings it to the top of the component stack
        Monthbox.setVisible(false);

        SpaMonthEnter = new JTextField();
        panel.add(SpaMonthEnter);
        SpaMonthEnter.setBounds(461, 421, 98, 28);
        SpaMonthEnter.setBackground(new Color(244, 242, 235));
        SpaMonthEnter.setVisible(false);
        SpaMonthEnter.setBorder(null);

        Yearbox = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/BookingBox.png", 100, 30));
        Yearbox.setBounds(570, 420, 100, 30);
        panel.add(Yearbox);
        panel.setComponentZOrder(Yearbox, 0); // Brings it to the top of the component stack
        Yearbox.setVisible(false);

        SpaYearEnter = new JTextField();
        panel.add(SpaYearEnter);
        SpaYearEnter.setBounds(571, 421, 98, 28);
        SpaYearEnter.setBackground(new Color(244, 242, 235));
        SpaYearEnter.setVisible(false);
        SpaYearEnter.setBorder(null);

        Hourbox = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/BookingBox.png", 100, 30));
        Hourbox.setBounds(800, 420, 100, 30);
        panel.add(Hourbox);
        panel.setComponentZOrder(Hourbox, 0); // Brings it to the top of the component stack
        Hourbox.setVisible(false);

        SpaHourEnter = new JTextField();
        panel.add(SpaHourEnter);
        SpaHourEnter.setBounds(801, 421, 98, 28);
        SpaHourEnter.setBackground(new Color(244, 242, 235));
        SpaHourEnter.setVisible(false);
        SpaHourEnter.setBorder(null);

        Minutebox = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/BookingBox.png", 100, 30));
        Minutebox.setBounds(910, 420, 100, 30);
        panel.add(Minutebox);
        panel.setComponentZOrder(Minutebox, 0); // Brings it to the top of the component stack
        Minutebox.setVisible(false);

        SpaMinuteEnter = new JTextField();
        panel.add(SpaMinuteEnter);
        SpaMinuteEnter.setBounds(911, 421, 98, 28);
        SpaMinuteEnter.setBackground(new Color(244, 242, 235));
        SpaMinuteEnter.setVisible(false);
        SpaMinuteEnter.setBorder(null);

        Secondbox = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/BookingBox.png", 100, 30));
        Secondbox.setBounds(1020, 420, 100, 30);
        panel.add(Secondbox);
        panel.setComponentZOrder(Secondbox, 0); // Brings it to the top of the component stack
        Secondbox.setVisible(false);

        SpaSecondEnter = new JTextField();
        panel.add(SpaSecondEnter);
        SpaSecondEnter.setBounds(1021, 421, 98, 28);
        SpaSecondEnter.setBackground(new Color(244, 242, 235));
        SpaSecondEnter.setVisible(false);
        SpaSecondEnter.setBorder(null);
    }


    private void addLogOutPanel() {
            createLogOutButton();
            logOutPanel = new JPanel();
            logOutPanel.setBounds(20, 550, 100, 35);
            logOutPanel.setBackground(new Color(132, 121, 102));
            logOutPanel.add(logOutButton);
            panel.add(logOutPanel);
            panel.setComponentZOrder(logOutPanel, 0);
    }

    private void createLogOutButton() {
        logOutButton = new JButton("Log Out");
        logOutButton.setBounds(20, 550, 100, 35);
        logOutButton.setFont(new Font("Mulish", Font.BOLD, 17));
        logOutButton.setBackground(Color.decode("#847966"));
        logOutButton.setForeground(new Color(255, 255, 255));
        logOutButton.setBorder(new LineBorder(new Color(255, 255, 255), 1));
        logOutButton.setVisible(false);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {          
                SwingUtilities.invokeLater(() -> new LoginWindow().setVisible(true));
                frame.dispose();
            }
        });
    }

    private void resetFields() {
        BookingCredit.setText("");
        BookingNamecard.setText("");
        BookingAmount.setText("");
        BookingSecCode.setText("");   
        EnterDateIn.setText("");   
        EnterDateOut.setText("");
        EnterNumberOfGuests.setText("");
        EnterDateOut.setText("");
        roomList.clearSelection();
        selectedPaymentMethod = null;
        availableRooms = roomDaoImpl.getAllAvailableRooms();
        if (availableRooms == null || availableRooms.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "No rooms are available for booking.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            roomOptions = new String[availableRooms.size()];
            for (int i = 0; i < availableRooms.size(); i++) {
                Room room = availableRooms.get(i);
                roomOptions[i] = "Room " + room.getRoomId() + " - " + room.getRoomType();
            }
            roomList.setListData(roomOptions);
        }
        panel.repaint();
    }

    private double getAverageRatingFromDatabase() {
        // Assuming you have a ReviewDAOImpl class with a method getAverageRating
        ReviewDAOImpl reviewDao = new ReviewDAOImpl();
        return reviewDao.getAverageRating();
    }
}

