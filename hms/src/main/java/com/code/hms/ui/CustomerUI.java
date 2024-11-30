package com.code.hms.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.code.hms.entities.Billing;
import com.code.hms.entities.Reservation;
import com.code.hms.entities.Review;
import com.code.hms.entities.Room;
import com.code.hms.entities.Room_Reservation;
import com.code.hms.entities.Room_Reservation_Pk;
import com.code.hms.loginwindow.LoginWindow;
import com.code.hms.ui.LoadImage;
import com.code.hms.daoimpl.BillingDaoImpl;
import com.code.hms.daoimpl.ReservationDaoImpl;
import com.code.hms.daoimpl.ReviewDAOImpl;
import com.code.hms.daoimpl.RoomDaoImpl;
import com.code.hms.daoimpl.Room_ReservationDaoImpl;
import com.code.hms.daoimpl.ServiceDAOImpl;
import com.code.hms.daoimpl.UserDaoImpl;

public class CustomerUI {

    static String selectedPaymentMethod;

    private JLabel hotelNameLabel;
    private JLabel dateLabel;
    private JLabel welcomeLabel;
    private JLabel averageRatingLabel;

    static JFrame frame;
    static JPanel panel;
    static JButton OurHotelTab;
    static JButton RoomTab;
    static JButton ServiceTab;
    static JButton ReviewTab;
    static ReviewDAOImpl reviewDAOImpl;
    static ServiceDAOImpl serviceDAOImpl;
    static BillingDaoImpl billingDaoImpl;
    static UserDaoImpl userDaoImpl;
    static ReservationDaoImpl reservationDaoImpl;
    static RoomDaoImpl roomDaoImpl;
    static Room_ReservationDaoImpl room_ReservationDaoImpl;

    static Reservation reservation;

    static JLabel Tab1_background;
    static JLabel Tab2_background;
    static JLabel Tab3_background;
    static JLabel Tab4_background;

    static JLabel EnterBoxFName;
    static JLabel EnterBoxLName;
    static JLabel EnterBoxPNumber;
    static JLabel EnterBoxEmail;

    static JTextField SpaFirstName;
    static JTextField SpaLastName;
    static JTextField SpaPhoneNumber;
    static JTextField SpaEmail;

    static JTextField RestaurantFirstName;
    static JTextField RestaurantLastName;
    static JTextField RestaurantPhoneNumber;
    static JTextField RestaurantEmail;

    static JTextField RoomCleaningFirstName;
    static JTextField RoomCleaningLastName;
    static JTextField RoomCleaningPhoneNumber;
    static JTextField RoomCleaningEmail;

    static JTextField MusicLoungeFirstName;
    static JTextField MusicLoungeLastName;
    static JTextField MusicLoungePhoneNumber;
    static JTextField MusicLoungeEmail;

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

    static JLabel SpaPackBox;
    static JLabel SpaPackPosition;
    static JLabel ResPackPosition;
    static JLabel RoomcleanPackPosition;
    static JLabel MusicLoungePackPosition;

    static JTextField ResDayEnter;
    static JTextField ResMonthEnter;
    static JTextField ResYearEnter;

    static JTextField ResHourEnter;
    static JTextField ResMinuteEnter;
    static JTextField ResSecondEnter;

    static JTextField RoomCleanDayEnter;
    static JTextField RoomCleanMonthEnter;
    static JTextField RoomCleanYearEnter;

    static JTextField RoomCleanHourEnter;
    static JTextField RoomCleanMinuteEnter;
    static JTextField RoomCleanSecondEnter;

    static JTextField MusicLoungeDayEnter;
    static JTextField MusicLoungeMonthEnter;
    static JTextField MusicLoungeYearEnter;

    static JTextField MusicLoungeHourEnter;
    static JTextField MusicLoungeMinuteEnter;
    static JTextField MusicLoungeSecondEnter;

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

    static JTextField BookingFirstName;
    static JTextField BookingLastName;
    static JTextField BookingPhoneNumber;
    static JTextField BookingEmail;
    static JTextField BookingCredit;
    static JTextField BookingNamecard;
    static JTextField BookingAmount;
    static JTextField BookingSecCode;

    static JComboBox<String> spaPackageMenu;
    static JComboBox<String> ResPackageMenu;
    static JComboBox<String> RcleaningPackageMenu;
    static JComboBox<String> MusicLoungePackageMenu;

    static JButton NextButton;
    static JButton sendButton;
    static JButton submitButton;
    static JButton SubmitReservationButton;

    static JScrollPane RoomSelectionField;

    static List<Integer> selectedRoomIds;

    public CustomerUI() {
        reviewDAOImpl = new ReviewDAOImpl();
        serviceDAOImpl = new ServiceDAOImpl();
        reservationDaoImpl = new ReservationDaoImpl();
        userDaoImpl = new UserDaoImpl();
        billingDaoImpl = new BillingDaoImpl();
        roomDaoImpl = new RoomDaoImpl();
        reservation = new Reservation();
        room_ReservationDaoImpl = new Room_ReservationDaoImpl();

        createMainGUI();
        CreateSpaInfoBox();
        CreateRestaurantInfoBox();
        CreateRoomCleaningInfoBox();
        CreateMusicLoungeInfoBox();
        CreateDate_TimeBox();
        CreateBookingInfo();
        createSpaDropdown();
        createResDropdown();
        createRoomCleanDropdown();
        createMusicLoungeDropdown();
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
        RoomList.setBounds(400, 390, 710, 33);
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
        ChooseDateIn.setBounds(390, 100, 300, 33); 
        ChooseDateIn.setForeground(new Color(212, 158, 24));
        ChooseDateIn.setHorizontalAlignment(SwingConstants.CENTER); 
        ChooseDateIn.setVisible(false);
        panel.add(ChooseDateIn);

        JTextField EnterDateIn = new JTextField();
        panel.add(EnterDateIn);
        EnterDateIn.setBounds(450, 150, 190, 28);
        EnterDateIn.setBackground(new Color(168, 161, 150));
        EnterDateIn.setVisible(false);
        EnterDateIn.setBorder(null);

        // CHECK-OUT DATE Section
        JLabel ChooseDateOut = new JLabel();
        ChooseDateOut.setText("CHECK-OUT DATE");
        ChooseDateOut.setFont(new Font("Mulish", Font.BOLD, 25));
        ChooseDateOut.setBounds(620, 100, 315, 33); // Increased width for label
        ChooseDateOut.setForeground(new Color(212, 158, 24));
        ChooseDateOut.setHorizontalAlignment(SwingConstants.CENTER); // Center-aligned text
        ChooseDateOut.setVisible(false);
        panel.add(ChooseDateOut);

        JTextField EnterDateOut = new JTextField();
        panel.add(EnterDateOut);
        EnterDateOut.setBounds(670, 150, 220, 28); 
        EnterDateOut.setBackground(new Color(168, 161, 150));
        EnterDateOut.setVisible(false);
        EnterDateOut.setBorder(null);

        // TYPE OF ROOM Section
        JLabel TypeOfRoom = new JLabel();
        TypeOfRoom.setText("TYPE OF ROOM");
        TypeOfRoom.setFont(new Font("Mulish", Font.BOLD, 25));
        TypeOfRoom.setBounds(870, 100, 300, 33); // Increased width for label
        TypeOfRoom.setForeground(new Color(212, 158, 24));
        TypeOfRoom.setHorizontalAlignment(SwingConstants.CENTER); // Center-aligned text
        TypeOfRoom.setVisible(false);
        panel.add(TypeOfRoom);

        JTextField ChooseTypeOfRoom = new JTextField();
        panel.add(ChooseTypeOfRoom);
        ChooseTypeOfRoom.setBounds(925, 150, 193, 28);
        ChooseTypeOfRoom.setBackground(new Color(168, 161, 150));
        ChooseTypeOfRoom.setVisible(false);
        ChooseTypeOfRoom.setBorder(null);

        // NUMBER OF GUESTS Section
        JLabel NumberOfGuests = new JLabel();
        NumberOfGuests.setText("NUMBER OF GUESTS");
        NumberOfGuests.setFont(new Font("Mulish", Font.BOLD, 25));
        NumberOfGuests.setBounds(645, 190, 285, 33); 
        NumberOfGuests.setForeground(new Color(212, 158, 24));
        NumberOfGuests.setHorizontalAlignment(SwingConstants.CENTER); 
        NumberOfGuests.setVisible(false); 
        panel.add(NumberOfGuests);

        JTextField EnterNumberOfGuests = new JTextField();
        panel.add(EnterNumberOfGuests);
        EnterNumberOfGuests.setBounds(655, 230, 275, 28); 
        EnterNumberOfGuests.setBackground(new Color(168, 161, 150));
        EnterNumberOfGuests.setVisible(false); 
        EnterNumberOfGuests.setBorder(null);

        // ROOM SELECTION Section
        JLabel RoomSelectionLabel = new JLabel();
        RoomSelectionLabel.setText("SELECT ROOM");
        RoomSelectionLabel.setFont(new Font("Mulish", Font.BOLD, 25));
        RoomSelectionLabel.setBounds(645, 460, 285, 33);  RoomSelectionLabel.setVisible(false);
        RoomSelectionLabel.setForeground(new Color(212, 158, 24));
        RoomSelectionLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        panel.add(RoomSelectionLabel);

        List<Room> availableRooms = roomDaoImpl.getAllAvailableRooms();
        if (availableRooms == null || availableRooms.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "No rooms are available for booking.", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        String[] roomOptions = new String[availableRooms.size()];
        for (int i = 0; i < availableRooms.size(); i++) {
            Room room = availableRooms.get(i);
            roomOptions[i] = "Room " + room.getRoomId() + " - " + room.getRoomType();
        }
        JList<String> roomList = new JList<>(roomOptions);
        roomList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        roomList.setBackground(new Color(168, 161, 150));
        roomList.setBorder(BorderFactory.createLineBorder(new Color(132, 121, 102)));

        JScrollPane RoomSelectionField = new JScrollPane(roomList);
        RoomSelectionField.setBounds(670, 500, 220, 100); 
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
        WriteFeedback.setBounds(300, 180, 940, 300);
        WriteFeedback.setBackground(new Color(244, 242, 235));
        WriteFeedback.setVisible(false);
        WriteFeedback.setLineWrap(true); // Enable word wrapping
        WriteFeedback.setWrapStyleWord(true); // Wrap at word boundaries
        WriteFeedback.setMargin(new Insets(5, 5, 5, 5)); // Add padding for better appearance
        WriteFeedback.setFont(new Font("Mulish", Font.PLAIN, 16)); // Set the font size and style
        WriteFeedback.setBorder(BorderFactory.createLineBorder(new Color(132, 121, 102), 1));

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

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setBounds(960, 520, 180, 50);
        submitButton.setFont(new Font("Mulish", Font.BOLD, 20));
        submitButton.setBackground(new Color(132, 121, 102));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.setVisible(false);
        panel.add(submitButton);

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

                String checkinDateString = EnterDateIn.getText().trim();
                String checkoutDateString = EnterDateOut.getText().trim();
                String numOfGuestsString = EnterNumberOfGuests.getText().trim();

                java.sql.Date checkinDate = java.sql.Date.valueOf(checkinDateString);
                java.sql.Date checkoutDate = java.sql.Date.valueOf(checkoutDateString);
                int numOfGuests = Integer.parseInt(numOfGuestsString);


                long differenceInMilliseconds = checkoutDate.getTime() - checkinDate.getTime();
                int totalDays = (int) (differenceInMilliseconds / (1000 * 60 * 60 * 24));

                reservation.setCheckinDate(checkinDate);
                reservation.setCheckoutDate(checkoutDate);
                reservation.setNumOfGuests(numOfGuests);
                reservation.setTotalDays(totalDays);

                List<String> selectedRooms = roomList.getSelectedValuesList(); 
                if (selectedRooms.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please select at least one room.", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                for (String selectedRoom : selectedRooms) {
                    selectedRoomIds = new ArrayList<>() ;
                    int roomId = Integer.parseInt(selectedRoom.split(" ")[1]);
                    Room room = roomDaoImpl.getRoomByRoomID(roomId);
                    if (room == null || !room.getRoomStatus().equalsIgnoreCase("Available")) {
                        JOptionPane.showMessageDialog(panel, "Room " + roomId + " is not available!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else {
                        selectedRoomIds.add(roomId);
                    }
                }

                for (String selectedRoom : selectedRooms) {
                    int roomId = Integer.parseInt(selectedRoom.split(" ")[1]);
                    Room_Reservation_Pk compositeKey = new Room_Reservation_Pk(roomId, reservation.getReservationId());
                    Room_Reservation roomReservation = new Room_Reservation();
                    roomReservation.setPk(compositeKey);
                    roomReservation.setDate(checkinDate); 
                    roomReservation.setTime(new java.sql.Time(System.currentTimeMillis())); 
                    room_ReservationDaoImpl.saveRoomReservation(roomReservation);
                }

                // Show success message
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
            try {
                for (int roomId : selectedRoomIds) {
                    Room room = roomDaoImpl.getRoomByRoomID(roomId);
                    room.setRoomStatus("Unavailable");
                    roomDaoImpl.updateRoom(room);
                }

                String phone = BookingPhoneNumber.getText().trim();
                int user_Id = userDaoImpl.getUserIDByPhone(phone);
                if (user_Id == 0) {
                    JOptionPane.showMessageDialog(panel, "No user found with the provided phone number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method
                }

                double amount = Double.parseDouble(BookingAmount.getText().trim());
                reservation.setUserId(user_Id);
                reservationDaoImpl.saveReservation(reservation);
                String paymentMethod = selectedPaymentMethod;
                if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please select a valid payment method.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method
                } 

                java.sql.Date billingDate = new java.sql.Date(System.currentTimeMillis());

                Billing billing = new Billing();
                billing.setReservation(reservation); // Link the Reservation
                billing.setAmount(amount);
                billing.setPaymentMethod(paymentMethod);
                billing.setDate(billingDate);
                billingDaoImpl.saveBilling(billing);

                JOptionPane.showMessageDialog(panel, "Reservation and Billing saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid amount format. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "An error occurred while saving the billing or saving the reservation.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
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
        hotelNameLabel.setBounds(630, 150, 500, 50);
        panel.add(hotelNameLabel);

        welcomeLabel = new JLabel("Welcome to Our Hotel!");
        welcomeLabel.setFont(new Font("Mulish", Font.ITALIC, 50));
        welcomeLabel.setForeground(new Color(132, 121, 102));
        welcomeLabel.setBounds(550, 220, 1000, 50);
        panel.add(welcomeLabel);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Mulish", Font.PLAIN, 30));
        dateLabel.setForeground(new Color(43, 42, 38));
        dateLabel.setBounds(600, 530, 1000, 40);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMM dd, yyyy");
        String currentDate = dateFormat.format(new Date());
        dateLabel.setText("Date: " + currentDate);
        panel.add(dateLabel);

        averageRatingLabel = new JLabel();
        averageRatingLabel.setFont(new Font("Mulish", Font.PLAIN, 25));
        averageRatingLabel.setForeground(new Color(43, 42, 38));
        averageRatingLabel.setBounds(600, 480, 400, 30);
        double averageRating = getAverageRatingFromDatabase();
        averageRatingLabel.setText("Customer Average Rating: " + String.format("%.1f", averageRating) + " / 5.0");
        panel.add(averageRatingLabel);

        OurHotelTab.addActionListener(e -> {

            hotelNameLabel.setVisible(true);
            welcomeLabel.setVisible(true);
            dateLabel.setVisible(true);
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

            RestaurantFirstName.setVisible(false);
            RestaurantLastName.setVisible(false);
            RestaurantPhoneNumber.setVisible(false);
            RestaurantEmail.setVisible(false);

            RoomCleaningFirstName.setVisible(false);
            RoomCleaningLastName.setVisible(false);
            RoomCleaningPhoneNumber.setVisible(false);
            RoomCleaningEmail.setVisible(false);

            MusicLoungeFirstName.setVisible(false);
            MusicLoungeLastName.setVisible(false);
            MusicLoungePhoneNumber.setVisible(false);
            MusicLoungeEmail.setVisible(false);

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

            ResDayEnter.setVisible(false);
            ResMonthEnter.setVisible(false);
            ResYearEnter.setVisible(false);

            ResHourEnter.setVisible(false);
            ResMinuteEnter.setVisible(false);
            ResSecondEnter.setVisible(false);

            RoomCleanDayEnter.setVisible(false);
            RoomCleanMonthEnter.setVisible(false);
            RoomCleanYearEnter.setVisible(false);

            RoomCleanHourEnter.setVisible(false);
            RoomCleanMinuteEnter.setVisible(false);
            RoomCleanSecondEnter.setVisible(false);

            MusicLoungeDayEnter.setVisible(false);
            MusicLoungeMonthEnter.setVisible(false);
            MusicLoungeYearEnter.setVisible(false);

            MusicLoungeHourEnter.setVisible(false);
            MusicLoungeMinuteEnter.setVisible(false);
            MusicLoungeSecondEnter.setVisible(false);

            Hourbox.setVisible(false);
            Minutebox.setVisible(false);
            Secondbox.setVisible(false);

            RateExp.setVisible(false);
            ratingStars.setVisible(false);
            WriteFeedback.setVisible(false);
            Feedback.setVisible(false);

            RoomBooking.setVisible(false);
            ChooseDateIn.setVisible(false);
            ChooseDateOut.setVisible(false);
            NumberOfGuests.setVisible(false);
            TypeOfRoom.setVisible(false);
            EnterDateIn.setVisible(false);
            EnterDateOut.setVisible(false);
            EnterNumberOfGuests.setVisible(false);
            ChooseTypeOfRoom.setVisible(false);
            RoomSelectionField.setVisible(false);
            RoomSelectionLabel.setVisible(false);
            RoomList.setVisible(false);

            NextButton.setVisible(false);
            sendButton.setVisible(false);
            submitButton.setVisible(false);
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

            spaPackageMenu.setVisible(false);
            SpaPackBox.setVisible(false);
            SpaPackPosition.setVisible(false);

            ResPackageMenu.setVisible(false);

            RcleaningPackageMenu.setVisible(false);
            RoomcleanPackPosition.setVisible(false);

            MusicLoungePackageMenu.setVisible(false);
            MusicLoungePackPosition.setVisible(false);
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
            submitButton.setVisible(false);
            SubmitReservationButton.setVisible(false);

            
            hotelNameLabel.setVisible(false);
            welcomeLabel.setVisible(false);
            dateLabel.setVisible(false);
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

            RestaurantFirstName.setVisible(false);
            RestaurantLastName.setVisible(false);
            RestaurantPhoneNumber.setVisible(false);
            RestaurantEmail.setVisible(false);

            RoomCleaningFirstName.setVisible(false);
            RoomCleaningLastName.setVisible(false);
            RoomCleaningPhoneNumber.setVisible(false);
            RoomCleaningEmail.setVisible(false);

            MusicLoungeFirstName.setVisible(false);
            MusicLoungeLastName.setVisible(false);
            MusicLoungePhoneNumber.setVisible(false);
            MusicLoungeEmail.setVisible(false);

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

            ResDayEnter.setVisible(false);
            ResMonthEnter.setVisible(false);
            ResYearEnter.setVisible(false);

            ResHourEnter.setVisible(false);
            ResMinuteEnter.setVisible(false);
            ResSecondEnter.setVisible(false);

            RoomCleanDayEnter.setVisible(false);
            RoomCleanMonthEnter.setVisible(false);
            RoomCleanYearEnter.setVisible(false);

            RoomCleanHourEnter.setVisible(false);
            RoomCleanMinuteEnter.setVisible(false);
            RoomCleanSecondEnter.setVisible(false);

            MusicLoungeDayEnter.setVisible(false);
            MusicLoungeMonthEnter.setVisible(false);
            MusicLoungeYearEnter.setVisible(false);

            MusicLoungeHourEnter.setVisible(false);
            MusicLoungeMinuteEnter.setVisible(false);
            MusicLoungeSecondEnter.setVisible(false);

            RateExp.setVisible(false);
            ratingStars.setVisible(false);
            WriteFeedback.setVisible(false);
            Feedback.setVisible(false);

            RoomBooking.setVisible(true);
            ChooseDateIn.setVisible(true);
            ChooseDateOut.setVisible(true);
            NumberOfGuests.setVisible(true);
            TypeOfRoom.setVisible(true);
            EnterDateIn.setVisible(true);
            EnterDateOut.setVisible(true);
            EnterNumberOfGuests.setVisible(true);
            ChooseTypeOfRoom.setVisible(true);
            RoomSelectionField.setVisible(true);
            RoomSelectionLabel.setVisible(true);
            RoomList.setVisible(true);

            BookingTitle.setVisible(false);

            visaImage.setVisible(false);
            mastercardImage.setVisible(false);
            PaypalImage.setVisible(false);
            DiscoverImage.setVisible(false);

            CreditNumber.setVisible(true);

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

            spaPackageMenu.setVisible(false);
            SpaPackBox.setVisible(false);
            SpaPackPosition.setVisible(false);

            ResPackageMenu.setVisible(false);
            ResPackPosition.setVisible(false);

            RcleaningPackageMenu.setVisible(false);
            RoomcleanPackPosition.setVisible(false);

            MusicLoungePackageMenu.setVisible(false);
            MusicLoungePackPosition.setVisible(false);
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

        SpaPackPosition = new JLabel();
        SpaPackPosition.setText("Spa Package");
        SpaPackPosition.setFont(new Font("Mulish", Font.BOLD, 20));
        SpaPackPosition.setBounds(350, 460, 500, 30);
        SpaPackPosition.setForeground(new Color(136, 120, 81));
        SpaPackPosition.setVisible(false);
        panel.add(SpaPackPosition);

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
            averageRatingLabel.setVisible(false);

            Restaurant.setVisible(false);
            Spa.setVisible(false);
            RoomCleaning.setVisible(false);
            MusicLounge.setVisible((false));

            ServiceMenu.setVisible(false);
            SpaCenter.setVisible(true);
            CustomerInfo.setVisible(true);
            BookingInformation.setVisible(true);
            submitButton.setVisible(true);

            EnterBoxFName.setVisible(true);
            EnterBoxLName.setVisible(true);
            EnterBoxPNumber.setVisible(true);
            EnterBoxEmail.setVisible(true);

            SpaFirstName.setVisible(true);
            SpaLastName.setVisible(true);
            SpaPhoneNumber.setVisible(true);
            SpaEmail.setVisible(true);

            RestaurantFirstName.setVisible(false);
            RestaurantLastName.setVisible(false);
            RestaurantPhoneNumber.setVisible(false);
            RestaurantEmail.setVisible(false);

            RoomCleaningFirstName.setVisible(false);
            RoomCleaningLastName.setVisible(false);
            RoomCleaningPhoneNumber.setVisible(false);
            RoomCleaningEmail.setVisible(false);

            MusicLoungeFirstName.setVisible(false);
            MusicLoungeLastName.setVisible(false);
            MusicLoungePhoneNumber.setVisible(false);
            MusicLoungeEmail.setVisible(false);

            Daybox.setVisible(true);
            Monthbox.setVisible(true);
            Yearbox.setVisible(true);

            Hourbox.setVisible(true);
            Minutebox.setVisible(true);
            Secondbox.setVisible(true);

            SpaDayEnter.setVisible(true);
            SpaMonthEnter.setVisible(true);
            SpaYearEnter.setVisible(true);

            SpaHourEnter.setVisible(true);
            SpaMinuteEnter.setVisible(true);
            SpaSecondEnter.setVisible(true);

            ResDayEnter.setVisible(false);
            ResMonthEnter.setVisible(false);
            ResYearEnter.setVisible(false);

            ResHourEnter.setVisible(false);
            ResMinuteEnter.setVisible(false);
            ResSecondEnter.setVisible(false);

            RoomCleanDayEnter.setVisible(false);
            RoomCleanMonthEnter.setVisible(false);
            RoomCleanYearEnter.setVisible(false);

            RoomCleanHourEnter.setVisible(false);
            RoomCleanMinuteEnter.setVisible(false);
            RoomCleanSecondEnter.setVisible(false);

            MusicLoungeDayEnter.setVisible(false);
            MusicLoungeMonthEnter.setVisible(false);
            MusicLoungeYearEnter.setVisible(false);

            MusicLoungeHourEnter.setVisible(false);
            MusicLoungeMinuteEnter.setVisible(false);
            MusicLoungeSecondEnter.setVisible(false);

            RateExp.setVisible(false);
            ratingStars.setVisible(false);

            SpaPackPosition.setVisible(true);
            spaPackageMenu.setVisible(true);
            SpaPackBox.setVisible(true);

            ResPackageMenu.setVisible(false);
            ResPackPosition.setVisible(false);

            RcleaningPackageMenu.setVisible(false);
            RoomcleanPackPosition.setVisible(false);

            MusicLoungePackageMenu.setVisible(false);
            MusicLoungePackPosition.setVisible(false);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Collect customer information
                    String firstName = SpaFirstName.getText();
                    String lastName = SpaLastName.getText();
                    String phoneNumber = SpaPhoneNumber.getText();
                    String email = SpaEmail.getText();
                    String day = SpaDayEnter.getText();
                    String month = SpaMonthEnter.getText();
                    String year = SpaYearEnter.getText();
                    String hour = SpaHourEnter.getText();
                    String minute = SpaMinuteEnter.getText();
                    String second = SpaSecondEnter.getText();
                    String servicepackage = SpaPackBox.getText();


                    if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() ||
                            day.isEmpty() || month.isEmpty() || year.isEmpty() ||
                            hour.isEmpty() || minute.isEmpty() || second.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill in all required fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Service booked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
        });

        RestaurantCenter = new JLabel();
        RestaurantCenter.setText("RESTAURANT");
        RestaurantCenter.setFont(new Font("Mulish", Font.BOLD, 33));
        RestaurantCenter.setBounds(310, 20, 300, 33);
        RestaurantCenter.setForeground(new Color(212, 158, 24));
        RestaurantCenter.setVisible(false);
        panel.add(RestaurantCenter);

        ResPackPosition = new JLabel();
        ResPackPosition.setText("Type of Tables");
        ResPackPosition.setFont(new Font("Mulish", Font.BOLD, 20));
        ResPackPosition.setBounds(350, 460, 500, 30);
        ResPackPosition.setForeground(new Color(136, 120, 81));
        ResPackPosition.setVisible(false);
        panel.add(ResPackPosition);

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
            averageRatingLabel.setVisible(false);

            CustomerInfo.setVisible(true);
            BookingInformation.setVisible(true);
            RestaurantCenter.setVisible(true);
            ServiceMenu.setVisible(false);
            submitButton.setVisible(true);

            EnterBoxFName.setVisible(true);
            EnterBoxLName.setVisible(true);
            EnterBoxPNumber.setVisible(true);
            EnterBoxEmail.setVisible(true);

            SpaFirstName.setVisible(false);
            SpaLastName.setVisible(false);
            SpaPhoneNumber.setVisible(false);
            SpaEmail.setVisible(false);

            RestaurantFirstName.setVisible(true);
            RestaurantLastName.setVisible(true);
            RestaurantPhoneNumber.setVisible(true);
            RestaurantEmail.setVisible(true);

            RoomCleaningFirstName.setVisible(false);
            RoomCleaningLastName.setVisible(false);
            RoomCleaningPhoneNumber.setVisible(false);
            RoomCleaningEmail.setVisible(false);

            MusicLoungeFirstName.setVisible(false);
            MusicLoungeLastName.setVisible(false);
            MusicLoungePhoneNumber.setVisible(false);
            MusicLoungeEmail.setVisible(false);

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

            SpaDayEnter.setVisible(false);
            SpaMonthEnter.setVisible(false);
            SpaYearEnter.setVisible(false);

            SpaHourEnter.setVisible(false);
            SpaMinuteEnter.setVisible(false);
            SpaSecondEnter.setVisible(false);

            ResDayEnter.setVisible(true);
            ResMonthEnter.setVisible(true);
            ResYearEnter.setVisible(true);

            ResHourEnter.setVisible(true);
            ResMinuteEnter.setVisible(true);
            ResSecondEnter.setVisible(true);

            RoomCleanDayEnter.setVisible(false);
            RoomCleanMonthEnter.setVisible(false);
            RoomCleanYearEnter.setVisible(false);

            RoomCleanHourEnter.setVisible(false);
            RoomCleanMinuteEnter.setVisible(false);
            RoomCleanSecondEnter.setVisible(false);

            MusicLoungeDayEnter.setVisible(false);
            MusicLoungeMonthEnter.setVisible(false);
            MusicLoungeYearEnter.setVisible(false);

            MusicLoungeHourEnter.setVisible(false);
            MusicLoungeMinuteEnter.setVisible(false);
            MusicLoungeSecondEnter.setVisible(false);

            RateExp.setVisible(false);

            spaPackageMenu.setVisible(false);
            SpaPackBox.setVisible(false);
            SpaPackPosition.setVisible(false);

            ResPackageMenu.setVisible(true);
            SpaPackBox.setVisible(true);
            ResPackPosition.setVisible(true);

            RcleaningPackageMenu.setVisible(false);
            RoomcleanPackPosition.setVisible(false);

            MusicLoungePackageMenu.setVisible(false);
            MusicLoungePackPosition.setVisible(false);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Collect customer information
                    String firstName = RestaurantFirstName.getText();
                    String lastName = RestaurantLastName.getText();
                    String phoneNumber = RestaurantPhoneNumber.getText();
                    String email = RestaurantEmail.getText();
                    String day = ResDayEnter.getText();
                    String month = ResMonthEnter.getText();
                    String year = ResYearEnter.getText();
                    String hour = ResHourEnter.getText();
                    String minute = ResMonthEnter.getText();
                    String second = ResSecondEnter.getText();


                    if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() ||
                            day.isEmpty() || month.isEmpty() || year.isEmpty() ||
                            hour.isEmpty() || minute.isEmpty() || second.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill in all required fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Service booked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
        });

        RoomCleaningCenter = new JLabel();
        RoomCleaningCenter.setText("ROOM CLEANING");
        RoomCleaningCenter.setFont(new Font("Mulish", Font.BOLD, 33));
        RoomCleaningCenter.setBounds(310, 20, 300, 33);
        RoomCleaningCenter.setForeground(new Color(212, 158, 24));
        RoomCleaningCenter.setVisible(false);
        panel.add(RoomCleaningCenter);

        RoomcleanPackPosition = new JLabel();
        RoomcleanPackPosition.setText("Cleaning Type");
        RoomcleanPackPosition.setFont(new Font("Mulish", Font.BOLD, 20));
        RoomcleanPackPosition.setBounds(350, 460, 500, 30);
        RoomcleanPackPosition.setForeground(new Color(136, 120, 81));
        RoomcleanPackPosition.setVisible(false);
        panel.add(RoomcleanPackPosition);

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
            averageRatingLabel.setVisible(false);

            CustomerInfo.setVisible(true);
            BookingInformation.setVisible(true);
            RoomCleaningCenter.setVisible(true);
            ServiceMenu.setVisible(false);
            submitButton.setVisible(true);

            EnterBoxFName.setVisible(true);
            EnterBoxLName.setVisible(true);
            EnterBoxPNumber.setVisible(true);
            EnterBoxEmail.setVisible(true);

            SpaFirstName.setVisible(false);
            SpaLastName.setVisible(false);
            SpaPhoneNumber.setVisible(false);
            SpaEmail.setVisible(false);

            RestaurantFirstName.setVisible(false);
            RestaurantLastName.setVisible(false);
            RestaurantPhoneNumber.setVisible(false);
            RestaurantEmail.setVisible(false);

            RoomCleaningFirstName.setVisible(true);
            RoomCleaningLastName.setVisible(true);
            RoomCleaningPhoneNumber.setVisible(true);
            RoomCleaningEmail.setVisible(true);

            MusicLoungeFirstName.setVisible(false);
            MusicLoungeLastName.setVisible(false);
            MusicLoungePhoneNumber.setVisible(false);
            MusicLoungeEmail.setVisible(false);

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

            SpaDayEnter.setVisible(false);
            SpaMonthEnter.setVisible(false);
            SpaYearEnter.setVisible(false);

            SpaHourEnter.setVisible(false);
            SpaMinuteEnter.setVisible(false);
            SpaSecondEnter.setVisible(false);

            ResDayEnter.setVisible(false);
            ResMonthEnter.setVisible(false);
            ResYearEnter.setVisible(false);

            ResHourEnter.setVisible(false);
            ResMinuteEnter.setVisible(false);
            ResSecondEnter.setVisible(false);

            RoomCleanDayEnter.setVisible(true);
            RoomCleanMonthEnter.setVisible(true);
            RoomCleanYearEnter.setVisible(true);

            RoomCleanHourEnter.setVisible(true);
            RoomCleanMinuteEnter.setVisible(true);
            RoomCleanSecondEnter.setVisible(true);

            MusicLoungeDayEnter.setVisible(false);
            MusicLoungeMonthEnter.setVisible(false);
            MusicLoungeYearEnter.setVisible(false);

            MusicLoungeHourEnter.setVisible(false);
            MusicLoungeMinuteEnter.setVisible(false);
            MusicLoungeSecondEnter.setVisible(false);

            RateExp.setVisible(false);

            spaPackageMenu.setVisible(false);
            SpaPackBox.setVisible(true);
            SpaPackPosition.setVisible(false);

            ResPackageMenu.setVisible(false);
            ResPackPosition.setVisible(false);

            RcleaningPackageMenu.setVisible(true);
            RoomcleanPackPosition.setVisible(true);

            MusicLoungePackageMenu.setVisible(false);
            MusicLoungePackPosition.setVisible(false);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Collect customer information
                    String firstName = RoomCleaningFirstName.getText();
                    String lastName = RoomCleaningLastName.getText();
                    String phoneNumber = RoomCleaningPhoneNumber.getText();
                    String email = RoomCleaningEmail.getText();
                    String day = RoomCleanDayEnter.getText();
                    String month = RoomCleanMonthEnter.getText();
                    String year = RoomCleanYearEnter.getText();
                    String hour = RoomCleanHourEnter.getText();
                    String minute = RoomCleanMinuteEnter.getText();
                    String second = RoomCleanSecondEnter.getText();


                    if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() ||
                            day.isEmpty() || month.isEmpty() || year.isEmpty() ||
                            hour.isEmpty() || minute.isEmpty() || second.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill in all required fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Service booked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
        });

        MusicLoungeCenter = new JLabel();
        MusicLoungeCenter.setText("MUSIC LOUNGE");
        MusicLoungeCenter.setFont(new Font("Mulish", Font.BOLD, 33));
        MusicLoungeCenter.setBounds(310, 20, 300, 33);
        MusicLoungeCenter.setForeground(new Color(212, 158, 24));
        MusicLoungeCenter.setVisible(false);
        panel.add(MusicLoungeCenter);

        MusicLoungePackPosition = new JLabel();
        MusicLoungePackPosition.setText("Ticket");
        MusicLoungePackPosition.setFont(new Font("Mulish", Font.BOLD, 20));
        MusicLoungePackPosition.setBounds(350, 460, 500, 30);
        MusicLoungePackPosition.setForeground(new Color(136, 120, 81));
        MusicLoungePackPosition.setVisible(false);
        panel.add(MusicLoungePackPosition);

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
            averageRatingLabel.setVisible(false);

            CustomerInfo.setVisible(true);
            BookingInformation.setVisible(true);
            MusicLoungeCenter.setVisible(true);
            ServiceMenu.setVisible(false);
            submitButton.setVisible(true);

            EnterBoxFName.setVisible(true);
            EnterBoxLName.setVisible(true);
            EnterBoxPNumber.setVisible(true);
            EnterBoxEmail.setVisible(true);

            SpaFirstName.setVisible(false);
            SpaLastName.setVisible(false);
            SpaPhoneNumber.setVisible(false);
            SpaEmail.setVisible(false);

            RestaurantFirstName.setVisible(false);
            RestaurantLastName.setVisible(false);
            RestaurantPhoneNumber.setVisible(false);
            RestaurantEmail.setVisible(false);

            RoomCleaningFirstName.setVisible(false);
            RoomCleaningLastName.setVisible(false);
            RoomCleaningPhoneNumber.setVisible(false);
            RoomCleaningEmail.setVisible(false);

            MusicLoungeFirstName.setVisible(true);
            MusicLoungeLastName.setVisible(true);
            MusicLoungePhoneNumber.setVisible(true);
            MusicLoungeEmail.setVisible(true);

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

            SpaDayEnter.setVisible(false);
            SpaMonthEnter.setVisible(false);
            SpaYearEnter.setVisible(false);

            SpaHourEnter.setVisible(false);
            SpaMinuteEnter.setVisible(false);
            SpaSecondEnter.setVisible(false);

            ResDayEnter.setVisible(false);
            ResMonthEnter.setVisible(false);
            ResYearEnter.setVisible(false);

            ResHourEnter.setVisible(false);
            ResMinuteEnter.setVisible(false);
            ResSecondEnter.setVisible(false);

            RoomCleanDayEnter.setVisible(false);
            RoomCleanMonthEnter.setVisible(false);
            RoomCleanYearEnter.setVisible(false);

            RoomCleanHourEnter.setVisible(false);
            RoomCleanMinuteEnter.setVisible(false);
            RoomCleanSecondEnter.setVisible(false);

            MusicLoungeDayEnter.setVisible(true);
            MusicLoungeMonthEnter.setVisible(true);
            MusicLoungeYearEnter.setVisible(true);

            MusicLoungeHourEnter.setVisible(true);
            MusicLoungeMinuteEnter.setVisible(true);
            MusicLoungeSecondEnter.setVisible(true);

            RateExp.setVisible(false);

            spaPackageMenu.setVisible(false);
            SpaPackBox.setVisible(true);
            SpaPackPosition.setVisible(false);

            ResPackageMenu.setVisible(false);
            ResPackPosition.setVisible(false);

            RcleaningPackageMenu.setVisible(false);
            RoomcleanPackPosition.setVisible(false);

            MusicLoungePackageMenu.setVisible(true);
            MusicLoungePackPosition.setVisible(true);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Collect customer information
                    String firstName = MusicLoungeFirstName.getText();
                    String lastName = MusicLoungeLastName.getText();
                    String phoneNumber = MusicLoungePhoneNumber.getText();
                    String email = MusicLoungeEmail.getText();
                    String day = MusicLoungeDayEnter.getText();
                    String month = MusicLoungeMonthEnter.getText();
                    String year = MusicLoungeYearEnter.getText();
                    String hour = MusicLoungeHourEnter.getText();
                    String minute = MusicLoungeMinuteEnter.getText();
                    String second = MusicLoungeSecondEnter.getText();


                    if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() ||
                            day.isEmpty() || month.isEmpty() || year.isEmpty() ||
                            hour.isEmpty() || minute.isEmpty() || second.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill in all required fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Service booked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
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
        ServiceTab.addActionListener(e -> {
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
            averageRatingLabel.setVisible(false);

            RestaurantFirstName.setVisible(false);
            RestaurantLastName.setVisible(false);
            RestaurantPhoneNumber.setVisible(false);
            RestaurantEmail.setVisible(false);

            RoomCleaningFirstName.setVisible(false);
            RoomCleaningLastName.setVisible(false);
            RoomCleaningPhoneNumber.setVisible(false);
            RoomCleaningEmail.setVisible(false);

            MusicLoungeFirstName.setVisible(false);
            MusicLoungeLastName.setVisible(false);
            MusicLoungePhoneNumber.setVisible(false);
            MusicLoungeEmail.setVisible(false);

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

            ResDayEnter.setVisible(false);
            ResMonthEnter.setVisible(false);
            ResYearEnter.setVisible(false);

            ResHourEnter.setVisible(false);
            ResMinuteEnter.setVisible(false);
            ResSecondEnter.setVisible(false);

            RoomCleanDayEnter.setVisible(false);
            RoomCleanMonthEnter.setVisible(false);
            RoomCleanYearEnter.setVisible(false);

            RoomCleanHourEnter.setVisible(false);
            RoomCleanMinuteEnter.setVisible(false);
            RoomCleanSecondEnter.setVisible(false);

            MusicLoungeDayEnter.setVisible(false);
            MusicLoungeMonthEnter.setVisible(false);
            MusicLoungeYearEnter.setVisible(false);

            MusicLoungeHourEnter.setVisible(false);
            MusicLoungeMinuteEnter.setVisible(false);
            MusicLoungeSecondEnter.setVisible(false);

            RateExp.setVisible(false);
            ratingStars.setVisible(false);
            WriteFeedback.setVisible(false);
            Feedback.setVisible(false);

            RoomBooking.setVisible(false);
            ChooseDateIn.setVisible(false);
            ChooseDateOut.setVisible(false);
            NumberOfGuests.setVisible(false);
            TypeOfRoom.setVisible(false);
            EnterDateIn.setVisible(false);
            EnterDateOut.setVisible(false);
            EnterNumberOfGuests.setVisible(false);
            ChooseTypeOfRoom.setVisible(false);
            RoomSelectionField.setVisible(false);
            RoomSelectionLabel.setVisible(false);
            RoomList.setVisible(false);

            NextButton.setVisible(false);
            sendButton.setVisible(false);
            submitButton.setVisible(false);
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

            spaPackageMenu.setVisible(false);
            SpaPackBox.setVisible(false);
            SpaPackPosition.setVisible(false);

            ResPackageMenu.setVisible(false);
            ResPackPosition.setVisible(false);

            RcleaningPackageMenu.setVisible(false);
            RoomcleanPackPosition.setVisible(false);

            MusicLoungePackageMenu.setVisible(false);
            MusicLoungePackPosition.setVisible(false);
        });

        NextButton.addActionListener(e -> {
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
            submitButton.setVisible(false);
            SubmitReservationButton.setVisible(true);

            hotelNameLabel.setVisible(false);
            welcomeLabel.setVisible(false);
            dateLabel.setVisible(false);
            averageRatingLabel.setVisible(false);

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

            ResDayEnter.setVisible(false);
            ResMonthEnter.setVisible(false);
            ResYearEnter.setVisible(false);

            ResHourEnter.setVisible(false);
            ResMinuteEnter.setVisible(false);
            ResSecondEnter.setVisible(false);

            RoomCleanDayEnter.setVisible(false);
            RoomCleanMonthEnter.setVisible(false);
            RoomCleanYearEnter.setVisible(false);

            RoomCleanHourEnter.setVisible(false);
            RoomCleanMinuteEnter.setVisible(false);
            RoomCleanSecondEnter.setVisible(false);

            MusicLoungeDayEnter.setVisible(false);
            MusicLoungeMonthEnter.setVisible(false);
            MusicLoungeYearEnter.setVisible(false);

            MusicLoungeHourEnter.setVisible(false);
            MusicLoungeMinuteEnter.setVisible(false);
            MusicLoungeSecondEnter.setVisible(false);

            RateExp.setVisible(false);
            ratingStars.setVisible(false);
            WriteFeedback.setVisible(false);
            Feedback.setVisible(false);

            RoomBooking.setVisible(false);
            ChooseDateIn.setVisible(false);
            ChooseDateOut.setVisible(false);
            NumberOfGuests.setVisible(false);
            TypeOfRoom.setVisible(false);
            EnterDateIn.setVisible(false);
            EnterDateOut.setVisible(false);
            EnterNumberOfGuests.setVisible(false);
            ChooseTypeOfRoom.setVisible(false);
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

            spaPackageMenu.setVisible(false);
            SpaPackBox.setVisible(false);
            SpaPackPosition.setVisible(false);

            ResPackageMenu.setVisible(false);

            RcleaningPackageMenu.setVisible(false);
            RoomcleanPackPosition.setVisible(false);

            MusicLoungePackageMenu.setVisible(false);
            MusicLoungePackPosition.setVisible(false);

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

            RestaurantFirstName.setVisible(false);
            RestaurantLastName.setVisible(false);
            RestaurantPhoneNumber.setVisible(false);
            RestaurantEmail.setVisible(false);

            RoomCleaningFirstName.setVisible(false);
            RoomCleaningLastName.setVisible(false);
            RoomCleaningPhoneNumber.setVisible(false);
            RoomCleaningEmail.setVisible(false);

            MusicLoungeFirstName.setVisible(false);
            MusicLoungeLastName.setVisible(false);
            MusicLoungePhoneNumber.setVisible(false);
            MusicLoungeEmail.setVisible(false);

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

            ResDayEnter.setVisible(false);
            ResMonthEnter.setVisible(false);
            ResYearEnter.setVisible(false);

            ResHourEnter.setVisible(false);
            ResMinuteEnter.setVisible(false);
            ResSecondEnter.setVisible(false);

            RoomCleanDayEnter.setVisible(false);
            RoomCleanMonthEnter.setVisible(false);
            RoomCleanYearEnter.setVisible(false);

            RoomCleanHourEnter.setVisible(false);
            RoomCleanMinuteEnter.setVisible(false);
            RoomCleanSecondEnter.setVisible(false);

            MusicLoungeDayEnter.setVisible(false);
            MusicLoungeMonthEnter.setVisible(false);
            MusicLoungeYearEnter.setVisible(false);

            MusicLoungeHourEnter.setVisible(false);
            MusicLoungeMinuteEnter.setVisible(false);
            MusicLoungeSecondEnter.setVisible(false);

            RateExp.setVisible(true);
            ratingStars.setVisible(true);
            WriteFeedback.setVisible(true);
            Feedback.setVisible(true);

            RoomBooking.setVisible(false);
            ChooseDateIn.setVisible(false);
            ChooseDateOut.setVisible(false);
            TypeOfRoom.setVisible(false);
            EnterDateIn.setVisible(false);
            EnterDateOut.setVisible(false);
            ChooseTypeOfRoom.setVisible(false);
            RoomList.setVisible(false);
            NumberOfGuests.setVisible(false);
            EnterNumberOfGuests.setVisible(false);
            RoomSelectionField.setVisible(false);
            RoomSelectionLabel.setVisible(false);

            NextButton.setVisible(false);
            sendButton.setVisible(true);
            submitButton.setVisible(false);
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

            spaPackageMenu.setVisible(false);
            SpaPackBox.setVisible(false);
            SpaPackPosition.setVisible(false);

            ResPackageMenu.setVisible(false);
            ResPackPosition.setVisible(false);

            RcleaningPackageMenu.setVisible(false);
            RoomcleanPackPosition.setVisible(false);

            MusicLoungePackageMenu.setVisible(false);
            MusicLoungePackPosition.setVisible(false);
        });

        sendButton.addActionListener(e -> {
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
//            RoomTab.setBackground(new Color(244, 242, 235));
//            ServiceTab.setBackground(new Color(132, 121, 102));
//            ReviewTab.setBackground(new Color(132, 121, 102));
//            RoomTab.setForeground(new Color(43, 42, 38));
//            OurHotelTab.setForeground(new Color(245, 242, 233));
//            ServiceTab.setForeground(new Color(245, 242, 233));
//            ReviewTab.setForeground(new Color(245, 242, 233));

            NextButton.setVisible(false);
            sendButton.setVisible(true);
            submitButton.setVisible(false);
            SubmitReservationButton.setVisible(false);
            
            hotelNameLabel.setVisible(false);
            welcomeLabel.setVisible(false);
            dateLabel.setVisible(false);
            averageRatingLabel.setVisible(false);

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

            ResDayEnter.setVisible(false);
            ResMonthEnter.setVisible(false);
            ResYearEnter.setVisible(false);

            ResHourEnter.setVisible(false);
            ResMinuteEnter.setVisible(false);
            ResSecondEnter.setVisible(false);

            RoomCleanDayEnter.setVisible(false);
            RoomCleanMonthEnter.setVisible(false);
            RoomCleanYearEnter.setVisible(false);

            RoomCleanHourEnter.setVisible(false);
            RoomCleanMinuteEnter.setVisible(false);
            RoomCleanSecondEnter.setVisible(false);

            MusicLoungeDayEnter.setVisible(false);
            MusicLoungeMonthEnter.setVisible(false);
            MusicLoungeYearEnter.setVisible(false);

            MusicLoungeHourEnter.setVisible(false);
            MusicLoungeMinuteEnter.setVisible(false);
            MusicLoungeSecondEnter.setVisible(false);

            RateExp.setVisible(true);
            ratingStars.setVisible(true);
            WriteFeedback.setVisible(true);
            Feedback.setVisible(true);

            RoomBooking.setVisible(false);
            ChooseDateIn.setVisible(false);
            ChooseDateOut.setVisible(false);
            NumberOfGuests.setVisible(false);
            TypeOfRoom.setVisible(false);
            EnterDateIn.setVisible(false);
            EnterDateOut.setVisible(false);
            EnterNumberOfGuests.setVisible(false);
            ChooseTypeOfRoom.setVisible(false);
            RoomList.setVisible(false);
            RoomSelectionLabel.setVisible(false);
            RoomSelectionField.setVisible(false);
            BookingTitle.setVisible(false);

//            visaImage.setVisible(true);
//            mastercardImage.setVisible(true);
//            PaypalImage.setVisible(true);
//            DiscoverImage.setVisible(true);

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

            spaPackageMenu.setVisible(false);
            SpaPackBox.setVisible(false);
            SpaPackPosition.setVisible(false);

            ResPackageMenu.setVisible(false);

            RcleaningPackageMenu.setVisible(false);
            RoomcleanPackPosition.setVisible(false);

            MusicLoungePackageMenu.setVisible(false);
            MusicLoungePackPosition.setVisible(false);

            if (ratingStars.getSelectedRating() == 0) {
                JOptionPane.showMessageDialog(frame, "Please select a rating before sending your review.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to send your review?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Thank you for your feedback!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    Review newReview = new Review();
                    newReview.setRating(ratingStars.getSelectedRating());
                    newReview.setComment(WriteFeedback.getText());
                    System.out.println(newReview.getRating());
                    System.out.println(newReview.getComment());

                    reviewDAOImpl.saveReview(newReview);

                    WriteFeedback.setText(""); // Clear feedback
                    ratingStars.resetRating(); // Reset the stars
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

        // Make frame visible
        frame.setVisible(true);

    }

    public void CreateSpaInfoBox() {
        //box for first name
        EnterBoxFName = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        EnterBoxFName.setBounds(350, 200, 300, 30);
        panel.add(EnterBoxFName);
        panel.setComponentZOrder(EnterBoxFName, 0); // Brings it to the top of the component stack
        EnterBoxFName.setVisible(false);

        SpaFirstName = new JTextField();
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

        SpaLastName = new JTextField();
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

        SpaPhoneNumber = new JTextField();
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

        SpaEmail = new JTextField();
        panel.add(SpaEmail);
        SpaEmail.setBounds(752, 281, 295, 28);
        SpaEmail.setBackground(new Color(244, 242, 235));
        SpaEmail.setVisible(false);
        SpaEmail.setBorder(null);

        SpaPackBox = new JLabel(LoadImage.loadScaledImage("hms/src/main/java/com/code/hms/assets/EnterBox.png", 300, 30));
        SpaPackBox.setBounds(350, 490, 300, 30);
        panel.add(SpaPackBox);
        panel.setComponentZOrder(SpaPackBox, 0); // Brings it to the top of the component stack
        SpaPackBox.setVisible(false);

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

    public void CreateRestaurantInfoBox() {
        //box for first name
        RestaurantFirstName = new JTextField();
        panel.add(RestaurantFirstName);
        RestaurantFirstName.setBounds(352, 201, 295, 28);
        RestaurantFirstName.setBackground(new Color(244, 242, 235));
        RestaurantFirstName.setVisible(false);
        RestaurantFirstName.setBorder(null);

        //box for last name
        RestaurantLastName = new JTextField();
        panel.add(RestaurantLastName);
        RestaurantLastName.setBounds(752, 201, 295, 28);
        RestaurantLastName.setBackground(new Color(244, 242, 235));
        RestaurantLastName.setVisible(false);
        RestaurantLastName.setBorder(null);

        //box for phone number
        RestaurantPhoneNumber = new JTextField();
        panel.add(RestaurantPhoneNumber);
        RestaurantPhoneNumber.setBounds(352, 281, 295, 28);
        RestaurantPhoneNumber.setBackground(new Color(244, 242, 235));
        RestaurantPhoneNumber.setVisible(false);
        RestaurantPhoneNumber.setBorder(null);

        //box for email
        RestaurantEmail = new JTextField();
        panel.add(RestaurantEmail);
        RestaurantEmail.setBounds(752, 281, 295, 28);
        RestaurantEmail.setBackground(new Color(244, 242, 235));
        RestaurantEmail.setVisible(false);
        RestaurantEmail.setBorder(null);
    }

    public void CreateRoomCleaningInfoBox() {
        //box for first name
        RoomCleaningFirstName = new JTextField();
        panel.add(RoomCleaningFirstName);
        RoomCleaningFirstName.setBounds(352, 201, 295, 28);
        RoomCleaningFirstName.setBackground(new Color(244, 242, 235));
        RoomCleaningFirstName.setVisible(false);
        RoomCleaningFirstName.setBorder(null);

        //box for last name
        RoomCleaningLastName = new JTextField();
        panel.add(RoomCleaningLastName);
        RoomCleaningLastName.setBounds(752, 201, 295, 28);
        RoomCleaningLastName.setBackground(new Color(244, 242, 235));
        RoomCleaningLastName.setVisible(false);
        RoomCleaningLastName.setBorder(null);

        //box for phone number
        RoomCleaningPhoneNumber = new JTextField();
        panel.add(RoomCleaningPhoneNumber);
        RoomCleaningPhoneNumber.setBounds(352, 281, 295, 28);
        RoomCleaningPhoneNumber.setBackground(new Color(244, 242, 235));
        RoomCleaningPhoneNumber.setVisible(false);
        RoomCleaningPhoneNumber.setBorder(null);

        //box for email
        RoomCleaningEmail = new JTextField();
        panel.add(RoomCleaningEmail);
        RoomCleaningEmail.setBounds(752, 281, 295, 28);
        RoomCleaningEmail.setBackground(new Color(244, 242, 235));
        RoomCleaningEmail.setVisible(false);
        RoomCleaningEmail.setBorder(null);
    }

    public void CreateMusicLoungeInfoBox() {
        //box for first name
        MusicLoungeFirstName = new JTextField();
        panel.add(MusicLoungeFirstName);
        MusicLoungeFirstName.setBounds(352, 201, 295, 28);
        MusicLoungeFirstName.setBackground(new Color(244, 242, 235));
        MusicLoungeFirstName.setVisible(false);
        MusicLoungeFirstName.setBorder(null);

        //box for last name
        MusicLoungeLastName = new JTextField();
        panel.add(MusicLoungeLastName);
        MusicLoungeLastName.setBounds(752, 201, 295, 28);
        MusicLoungeLastName.setBackground(new Color(244, 242, 235));
        MusicLoungeLastName.setVisible(false);
        MusicLoungeLastName.setBorder(null);

        //box for phone number
        MusicLoungePhoneNumber = new JTextField();
        panel.add(MusicLoungePhoneNumber);
        MusicLoungePhoneNumber.setBounds(352, 281, 295, 28);
        MusicLoungePhoneNumber.setBackground(new Color(244, 242, 235));
        MusicLoungePhoneNumber.setVisible(false);
        MusicLoungePhoneNumber.setBorder(null);

        //box for email
        MusicLoungeEmail = new JTextField();
        panel.add(MusicLoungeEmail);
        MusicLoungeEmail.setBounds(752, 281, 295, 28);
        MusicLoungeEmail.setBackground(new Color(244, 242, 235));
        MusicLoungeEmail.setVisible(false);
        MusicLoungeEmail.setBorder(null);
    }

    public void CreateBookingInfo() {
        //box for first name
        BookingFirstName = new JTextField();
        panel.add(BookingFirstName);
        BookingFirstName.setBounds(352, 201, 295, 28);
        BookingFirstName.setBackground(new Color(244, 242, 235));
        BookingFirstName.setVisible(false);
        BookingFirstName.setBorder(null);

        //box for last name
        BookingLastName = new JTextField();
        panel.add(BookingLastName);
        BookingLastName.setBounds(752, 201, 295, 28);
        BookingLastName.setBackground(new Color(244, 242, 235));
        BookingLastName.setVisible(false);
        BookingLastName.setBorder(null);

        //box for phone number
        BookingPhoneNumber = new JTextField();
        panel.add(BookingPhoneNumber);
        BookingPhoneNumber.setBounds(352, 281, 295, 28);
        BookingPhoneNumber.setBackground(new Color(244, 242, 235));
        BookingPhoneNumber.setVisible(false);
        BookingPhoneNumber.setBorder(null);

        //box for email
        BookingEmail = new JTextField();
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

        ResDayEnter = new JTextField();
        panel.add(ResDayEnter);
        ResDayEnter.setBounds(351, 421, 98, 28);
        ResDayEnter.setBackground(new Color(244, 242, 235));
        ResDayEnter.setVisible(false);
        ResDayEnter.setBorder(null);

        ResMonthEnter = new JTextField();
        panel.add(ResMonthEnter);
        ResMonthEnter.setBounds(461, 421, 98, 28);
        ResMonthEnter.setBackground(new Color(244, 242, 235));
        ResMonthEnter.setVisible(false);
        ResMonthEnter.setBorder(null);

        ResYearEnter = new JTextField();
        panel.add(ResYearEnter);
        ResYearEnter.setBounds(571, 421, 98, 28);
        ResYearEnter.setBackground(new Color(244, 242, 235));
        ResYearEnter.setVisible(false);
        ResYearEnter.setBorder(null);

        ResHourEnter = new JTextField();
        panel.add(ResHourEnter);
        ResHourEnter.setBounds(801, 421, 98, 28);
        ResHourEnter.setBackground(new Color(244, 242, 235));
        ResHourEnter.setVisible(false);
        ResHourEnter.setBorder(null);

        ResMinuteEnter = new JTextField();
        panel.add(ResMinuteEnter);
        ResMinuteEnter.setBounds(911, 421, 98, 28);
        ResMinuteEnter.setBackground(new Color(244, 242, 235));
        ResMinuteEnter.setVisible(false);
        ResMinuteEnter.setBorder(null);

        ResSecondEnter = new JTextField();
        panel.add(ResSecondEnter);
        ResSecondEnter.setBounds(1021, 421, 98, 28);
        ResSecondEnter.setBackground(new Color(244, 242, 235));
        ResSecondEnter.setVisible(false);
        ResSecondEnter.setBorder(null);

        RoomCleanDayEnter = new JTextField();
        panel.add(RoomCleanDayEnter);
        RoomCleanDayEnter.setBounds(351, 421, 98, 28);
        RoomCleanDayEnter.setBackground(new Color(244, 242, 235));
        RoomCleanDayEnter.setVisible(false);
        RoomCleanDayEnter.setBorder(null);

        RoomCleanMonthEnter = new JTextField();
        panel.add(RoomCleanMonthEnter);
        RoomCleanMonthEnter.setBounds(461, 421, 98, 28);
        RoomCleanMonthEnter.setBackground(new Color(244, 242, 235));
        RoomCleanMonthEnter.setVisible(false);
        RoomCleanMonthEnter.setBorder(null);

        RoomCleanYearEnter = new JTextField();
        panel.add(RoomCleanMonthEnter);
        RoomCleanMonthEnter.setBounds(571, 421, 98, 28);
        RoomCleanMonthEnter.setBackground(new Color(244, 242, 235));
        RoomCleanMonthEnter.setVisible(false);
        RoomCleanMonthEnter.setBorder(null);

        RoomCleanHourEnter = new JTextField();
        panel.add(RoomCleanHourEnter);
        RoomCleanHourEnter.setBounds(801, 421, 98, 28);
        RoomCleanHourEnter.setBackground(new Color(244, 242, 235));
        RoomCleanHourEnter.setVisible(false);
        RoomCleanHourEnter.setBorder(null);

        RoomCleanMinuteEnter = new JTextField();
        panel.add(RoomCleanMinuteEnter);
        RoomCleanMinuteEnter.setBounds(911, 421, 98, 28);
        RoomCleanMinuteEnter.setBackground(new Color(244, 242, 235));
        RoomCleanMinuteEnter.setVisible(false);
        RoomCleanMinuteEnter.setBorder(null);

        RoomCleanSecondEnter = new JTextField();
        panel.add(RoomCleanSecondEnter);
        RoomCleanSecondEnter.setBounds(1021, 421, 98, 28);
        RoomCleanSecondEnter.setBackground(new Color(244, 242, 235));
        RoomCleanSecondEnter.setVisible(false);
        RoomCleanSecondEnter.setBorder(null);

        MusicLoungeDayEnter = new JTextField();
        panel.add(MusicLoungeDayEnter);
        MusicLoungeDayEnter.setBounds(351, 421, 98, 28);
        MusicLoungeDayEnter.setBackground(new Color(244, 242, 235));
        MusicLoungeDayEnter.setVisible(false);
        MusicLoungeDayEnter.setBorder(null);

        MusicLoungeMonthEnter = new JTextField();
        panel.add(MusicLoungeMonthEnter);
        MusicLoungeMonthEnter.setBounds(461, 421, 98, 28);
        MusicLoungeMonthEnter.setBackground(new Color(244, 242, 235));
        MusicLoungeMonthEnter.setVisible(false);
        MusicLoungeMonthEnter.setBorder(null);

        MusicLoungeYearEnter = new JTextField();
        panel.add(MusicLoungeYearEnter);
        MusicLoungeYearEnter.setBounds(571, 421, 98, 28);
        MusicLoungeYearEnter.setBackground(new Color(244, 242, 235));
        MusicLoungeYearEnter.setVisible(false);
        MusicLoungeYearEnter.setBorder(null);

        MusicLoungeHourEnter = new JTextField();
        panel.add(MusicLoungeHourEnter);
        MusicLoungeHourEnter.setBounds(801, 421, 98, 28);
        MusicLoungeHourEnter.setBackground(new Color(244, 242, 235));
        MusicLoungeHourEnter.setVisible(false);
        MusicLoungeHourEnter.setBorder(null);

        MusicLoungeMinuteEnter = new JTextField();
        panel.add(MusicLoungeMinuteEnter);
        MusicLoungeMinuteEnter.setBounds(911, 421, 98, 28);
        MusicLoungeMinuteEnter.setBackground(new Color(244, 242, 235));
        MusicLoungeMinuteEnter.setVisible(false);
        MusicLoungeMinuteEnter.setBorder(null);

        MusicLoungeSecondEnter = new JTextField();
        panel.add(MusicLoungeSecondEnter);
        MusicLoungeSecondEnter.setBounds(1021, 421, 98, 28);
        MusicLoungeSecondEnter.setBackground(new Color(244, 242, 235));
        MusicLoungeSecondEnter.setVisible(false);
        MusicLoungeSecondEnter.setBorder(null);
    }

    private void createSpaDropdown() {
        // Step 1: Update the options for Spa Packages
        String spaPackageMenuOption[] = {"Massage", "Facial", "Sauna", "Body Scrub"};

        // Step 2: Create the JComboBox with new options
        spaPackageMenu = new JComboBox(spaPackageMenuOption);
        spaPackageMenu.setBounds(350, 488, 300, 30);
        spaPackageMenu.setFont(new Font("Mulish", Font.BOLD, 16));
        spaPackageMenu.setBackground(new Color(244, 242, 235));
        spaPackageMenu.setFocusable(false);
        spaPackageMenu.setVisible(false);
        panel.add(spaPackageMenu);

        // Step 3: Add an ActionListener to handle selection changes
        spaPackageMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected spa package
                String selectedPackage = (String) spaPackageMenu.getSelectedItem();

                // Perform actions based on the selected package
                if ("Massage".equals(selectedPackage)) {
                    addMassageComponents();  // Display massage-related UI or logic
                } else if ("Facial".equals(selectedPackage)) {
                    addFacialComponents();  // Display facial-related UI or logic
                } else if ("Sauna".equals(selectedPackage)) {
                    addSaunaComponents();  // Display sauna-related UI or logic
                } else if ("Body Scrub".equals(selectedPackage)) {
                    addBodyScrubComponents();  // Display body scrub-related UI or logic
                }
            }
        });
    }

    private void addMassageComponents() {
        // Code to add components related to Massage
        System.out.println("Massage Package Selected");
    }

    private void addFacialComponents() {
        // Code to add components related to Facial
        System.out.println("Facial Package Selected");
    }

    private void addSaunaComponents() {
        // Code to add components related to Massage
        System.out.println("Massage Package Selected");
    }

    private void addBodyScrubComponents() {
        // Code to add components related to Massage
        System.out.println("Massage Package Selected");

    }

    private void createResDropdown() {
        // Step 1: Update the options for Res Packages
        String ResPackageMenuOption[] = {"Booth Tables", "Outdoor Tables", "Indoor Tables", "Specialty Tables"};

        // Step 2: Create the JComboBox with new options
        ResPackageMenu = new JComboBox(ResPackageMenuOption);
        ResPackageMenu.setBounds(350, 488, 300, 30);
        ResPackageMenu.setFont(new Font("Mulish", Font.BOLD, 16));
        ResPackageMenu.setBackground(new Color(244, 242, 235));
        ResPackageMenu.setFocusable(false);
        ResPackageMenu.setVisible(false);
        panel.add(ResPackageMenu);

        // Step 3: Add an ActionListener to handle selection changes
        ResPackageMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected res package
                String selectedPackage = (String) ResPackageMenu.getSelectedItem();

                // Perform actions based on the selected package
                if ("Booth Tables".equals(selectedPackage)) {
                    addBoothTableComponents();  // Display massage-related UI or logic
                } else if ("Outdoor Tables".equals(selectedPackage)) {
                    addOutdoorTableComponents();  // Display facial-related UI or logic
                } else if ("Indoor Tables".equals(selectedPackage)) {
                    addIndoorTableComponents();  // Display sauna-related UI or logic
                } else if ("Specialty Tables".equals(selectedPackage)) {
                    addSpecTableComponents();  // Display body scrub-related UI or logic
                }
            }
        });
    }

    private void addBoothTableComponents() {
        // Code to add components related to Booth table
        System.out.println("Massage Package Selected");
    }

    private void addOutdoorTableComponents() {
        // Code to add components related to Outdoor table
        System.out.println("Facial Package Selected");
    }

    private void addIndoorTableComponents() {
        // Code to add components related to Indoor table
        System.out.println("Massage Package Selected");
    }

    private void addSpecTableComponents() {
        // Code to add components related to Speciality table
        System.out.println("Massage Package Selected");

    }

    private void createRoomCleanDropdown() {
        // Step 1: Update the options for Room cleaning Packages
        String ResPackageMenuOption[] = {"Daily cleaning", "Deep cleaning ", "Turnover cleaning", "Emergency Cleaning"};

        // Step 2: Create the JComboBox with new options
        RcleaningPackageMenu = new JComboBox(ResPackageMenuOption);
        RcleaningPackageMenu.setBounds(350, 488, 300, 30);
        RcleaningPackageMenu.setFont(new Font("Mulish", Font.BOLD, 16));
        RcleaningPackageMenu.setBackground(new Color(244, 242, 235));
        RcleaningPackageMenu.setFocusable(false);
        RcleaningPackageMenu.setVisible(false);
        panel.add(RcleaningPackageMenu);

        // Step 3: Add an ActionListener to handle selection changes
        RcleaningPackageMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected res package
                String selectedPackage = (String) RcleaningPackageMenu.getSelectedItem();

                // Perform actions based on the selected package
                if ("Daily cleaning".equals(selectedPackage)) {
                    addDailyComponents();  // Display massage-related UI or logic
                } else if ("Deep cleaning".equals(selectedPackage)) {
                    addDeepComponents();  // Display facial-related UI or logic
                } else if ("Turnover cleaning".equals(selectedPackage)) {
                    addTurnoverComponents();  // Display sauna-related UI or logic
                } else if ("Emergency cleaning".equals(selectedPackage)) {
                    addEmergencyComponents();  // Display body scrub-related UI or logic
                }
            }
        });
    }

    private void addDailyComponents() {
        // Code to add components related to Booth table
        System.out.println("Massage Package Selected");
    }

    private void addDeepComponents() {
        // Code to add components related to Outdoor table
        System.out.println("Facial Package Selected");
    }

    private void addTurnoverComponents() {
        // Code to add components related to Indoor table
        System.out.println("Massage Package Selected");
    }

    private void addEmergencyComponents() {
        // Code to add components related to Speciality table
        System.out.println("Massage Package Selected");

    }

    private void createMusicLoungeDropdown() {
        // Step 1: Update the options for Room cleaning Packages
        String MusicLoungePackageMenuOption[] = {"General Admission", "VIP Ticket", "Drink-Inclusive Tickets", "Standing"};

        // Step 2: Create the JComboBox with new options
        MusicLoungePackageMenu = new JComboBox(MusicLoungePackageMenuOption);
        MusicLoungePackageMenu.setBounds(350, 488, 300, 30);
        MusicLoungePackageMenu.setFont(new Font("Mulish", Font.BOLD, 16));
        MusicLoungePackageMenu.setBackground(new Color(244, 242, 235));
        MusicLoungePackageMenu.setFocusable(false);
        MusicLoungePackageMenu.setVisible(false);
        panel.add(MusicLoungePackageMenu);

        // Step 3: Add an ActionListener to handle selection changes
        MusicLoungePackageMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected res package
                String selectedPackage = (String) MusicLoungePackageMenu.getSelectedItem();

                // Perform actions based on the selected package
                if ("General Admission".equals(selectedPackage)) {
                    addGeneralAdComponents();  // Display massage-related UI or logic
                } else if ("VIP Ticket".equals(selectedPackage)) {
                    addVipComponents();  // Display facial-related UI or logic
                } else if ("Drink-Inclusive Tickets".equals(selectedPackage)) {
                    addDrinkComponents();  // Display sauna-related UI or logic
                } else if ("Standing".equals(selectedPackage)) {
                    addStandComponents();  // Display body scrub-related UI or logic
                }
            }
        });
    }

    private void addGeneralAdComponents() {
        // Code to add components related to Booth table
        System.out.println("Massage Package Selected");
    }

    private void addVipComponents() {
        // Code to add components related to Outdoor table
        System.out.println("Facial Package Selected");
    }

    private void addDrinkComponents() {
        // Code to add components related to Indoor table
        System.out.println("Massage Package Selected");
    }

    private void addStandComponents() {
        // Code to add components related to Speciality table
        System.out.println("Massage Package Selected");

    }

    private double getAverageRatingFromDatabase() {
        // Assuming you have a ReviewDAOImpl class with a method getAverageRating
        ReviewDAOImpl reviewDao = new ReviewDAOImpl();
        return reviewDao.getAverageRating();
    }
}

