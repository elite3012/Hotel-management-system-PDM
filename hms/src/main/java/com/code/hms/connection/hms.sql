-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for hms
CREATE DATABASE IF NOT EXISTS `hms` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `hms`;

-- Dumping structure for table hms.billing
CREATE TABLE IF NOT EXISTS `billing` (
  `Billing_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Reservation_ID` int(11) DEFAULT NULL,
  `Amount` double DEFAULT NULL,
  `Payment_Method` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`Billing_ID`),
  KEY `FK_billing_reservation` (`Reservation_ID`),
  CONSTRAINT `FK_billing_reservation` FOREIGN KEY (`Reservation_ID`) REFERENCES `reservation` (`Reservation_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table hms.billing: ~0 rows (approximately)
DELETE FROM `billing`;

-- Dumping structure for table hms.reservation
CREATE TABLE IF NOT EXISTS `reservation` (
  `Reservation_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) DEFAULT NULL,
  `Checkin_Date` date DEFAULT NULL,
  `Checkout_Date` date DEFAULT NULL,
  `Total_Days` int(11) DEFAULT NULL,
  `Num_of_guests` int(11) DEFAULT NULL,
  PRIMARY KEY (`Reservation_ID`),
  KEY `FK_reservation_user` (`User_ID`),
  CONSTRAINT `FK_reservation_user` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table hms.reservation: ~0 rows (approximately)
DELETE FROM `reservation`;

-- Dumping structure for table hms.review
CREATE TABLE IF NOT EXISTS `review` (
  `Review_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) DEFAULT NULL,
  `Reservation_ID` int(11) DEFAULT NULL,
  `Rating` int(11) DEFAULT NULL,
  `Comment` varchar(255) DEFAULT NULL,
  `ReviewDate` date DEFAULT NULL,
  PRIMARY KEY (`Review_ID`),
  KEY `FK_review_user` (`User_ID`),
  KEY `FK_review_reservation` (`Reservation_ID`),
  CONSTRAINT `FK_review_reservation` FOREIGN KEY (`Reservation_ID`) REFERENCES `reservation` (`Reservation_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_review_user` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table hms.review: ~0 rows (approximately)
DELETE FROM `review`;

-- Dumping structure for table hms.room
CREATE TABLE IF NOT EXISTS `room` (
  `Room_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Room_Type` varchar(255) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Room_Status` varchar(255) DEFAULT NULL,
  `Room_Capacity` int(11) DEFAULT NULL,
  `Cleaning_Status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Room_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=607 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table hms.room: ~36 rows (approximately)
DELETE FROM `room`;
INSERT INTO `room` (`Room_ID`, `Room_Type`, `Price`, `Room_Status`, `Room_Capacity`, `Cleaning_Status`) VALUES
	(101, 'Single', 100, 'Available', 1, 'Clean'),
	(102, 'Single', 100, 'Available', 1, 'Clean'),
	(103, 'Single', 100, 'Available', 1, 'Clean'),
	(104, 'Single', 100, 'Available', 1, 'Clean'),
	(105, 'Single', 100, 'Available', 1, 'Clean'),
	(106, 'Single', 100, 'Available', 1, 'Clean'),
	(201, 'Single', 100, 'Available', 1, 'Clean'),
	(202, 'Single', 100, 'Available', 1, 'Clean'),
	(203, 'Single', 100, 'Available', 1, 'Clean'),
	(204, 'Single', 100, 'Available', 1, 'Clean'),
	(205, 'Single', 100, 'Available', 1, 'Clean'),
	(206, 'Single', 100, 'Available', 1, 'Clean'),
	(301, 'Double', 200, 'Available', 2, 'Clean'),
	(302, 'Double', 200, 'Available', 2, 'Clean'),
	(303, 'Double', 200, 'Available', 2, 'Clean'),
	(304, 'Double', 200, 'Available', 2, 'Clean'),
	(305, 'Double', 200, 'Available', 2, 'Clean'),
	(306, 'Double', 200, 'Available', 2, 'Clean'),
	(401, 'Double', 200, 'Available', 2, 'Clean'),
	(402, 'Double', 200, 'Available', 2, 'Clean'),
	(403, 'Double', 200, 'Available', 2, 'Clean'),
	(404, 'Double', 200, 'Available', 2, 'Clean'),
	(405, 'Double', 200, 'Available', 2, 'Clean'),
	(406, 'Double', 200, 'Available', 2, 'Clean'),
	(501, 'Triple', 300, 'Available', 3, 'Clean'),
	(502, 'Triple', 300, 'Available', 3, 'Clean'),
	(503, 'Triple', 300, 'Available', 3, 'Clean'),
	(504, 'Triple', 300, 'Available', 3, 'Clean'),
	(505, 'Triple', 300, 'Available', 3, 'Clean'),
	(506, 'Triple', 300, 'Available', 3, 'Clean'),
	(601, 'Triple', 300, 'Available', 3, 'Clean'),
	(602, 'Triple', 300, 'Available', 3, 'Clean'),
	(603, 'Triple', 300, 'Available', 3, 'Clean'),
	(604, 'Triple', 300, 'Available', 3, 'Clean'),
	(605, 'Triple', 300, 'Available', 3, 'Clean'),
	(606, 'Triple', 300, 'Available', 3, 'Clean');

-- Dumping structure for table hms.room_reservation
CREATE TABLE IF NOT EXISTS `room_reservation` (
  `Room_ID` int(11) NOT NULL,
  `Reservation_ID` int(11) NOT NULL,
  `Time` time DEFAULT NULL,
  `Date` date DEFAULT NULL,
  KEY `FK_room_reservation_room` (`Room_ID`),
  KEY `FK_room_reservation_reservation` (`Reservation_ID`),
  CONSTRAINT `FK_room_reservation_reservation` FOREIGN KEY (`Reservation_ID`) REFERENCES `reservation` (`Reservation_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_room_reservation_room` FOREIGN KEY (`Room_ID`) REFERENCES `room` (`Room_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table hms.room_reservation: ~3 rows (approximately)
DELETE FROM `room_reservation`;
INSERT INTO `room_reservation` (`Room_ID`, `Reservation_ID`, `Time`, `Date`) VALUES
	(NULL, NULL, '21:00:05', '2000-01-01'),
	(NULL, NULL, '21:02:59', '2000-01-01'),
	(NULL, NULL, '21:07:22', '2000-01-01'),
  (606, 4, '2024-12-03', '21:00:05');
  

-- Dumping structure for table hms.service
CREATE TABLE IF NOT EXISTS `service` (
  `Service_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ServiceName` varchar(255) DEFAULT NULL,
  `ServiceAvailability` varchar(255) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Type_Max` int(11) DEFAULT NULL,
  `TypeMax` int(11) DEFAULT NULL,
  PRIMARY KEY (`Service_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table hms.service: ~0 rows (approximately)
DELETE FROM `service`;

-- Dumping structure for table hms.service_order
CREATE TABLE IF NOT EXISTS `service_order` (
  `Service_ID` int(11) DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `User_ID` int(11) DEFAULT NULL,
  KEY `FK_service_order_service` (`Service_ID`),
  KEY `FK_service_order_user` (`User_ID`),
  CONSTRAINT `FK_service_order_service` FOREIGN KEY (`Service_ID`) REFERENCES `service` (`Service_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_service_order_user` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table hms.service_order: ~0 rows (approximately)
DELETE FROM `service_order`;

-- Dumping structure for table hms.user
CREATE TABLE IF NOT EXISTS `user` (
  `User_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table hms.user: ~3 rows (approximately)
DELETE FROM `user`;
INSERT INTO `user` (`User_ID`, `Username`, `Password`, `Firstname`, `Lastname`, `Email`, `Phone`, `Role`) VALUES
	(1, 'admin', '123', 'Quys', 'Tran', 'Quy@gmaii.com', '0923876286', 'Admin'),
	(2, 'customer', '123', 'Nhan', 'Nguyen', 'Nhan@gmail.com', '0123654789', 'Customer'),
	(3, 'receptionist', '123', 'Minh', 'Tran', 'Minh@gmail.com', '0321456987', 'Receptionist');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
