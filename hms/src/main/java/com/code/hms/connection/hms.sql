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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table hms.reservation: ~0 rows (approximately)
DELETE FROM `reservation`;

-- Dumping structure for table hms.review
CREATE TABLE IF NOT EXISTS `review` (
  `Review_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) DEFAULT NULL,
  `Reservation_ID` int(11) DEFAULT NULL,
  `Rating` int(11) DEFAULT NULL,
  `Comment` text DEFAULT NULL,
  `ReviewDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`Review_ID`),
  KEY `FK_review_user` (`User_ID`),
  KEY `FK_review_reservation` (`Reservation_ID`),
  CONSTRAINT `FK_review_reservation` FOREIGN KEY (`Reservation_ID`) REFERENCES `reservation` (`Reservation_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_review_user` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table hms.room: ~0 rows (approximately)
DELETE FROM `room`;

-- Dumping structure for table hms.room_reservation
CREATE TABLE IF NOT EXISTS `room_reservation` (
  `Room_ID` int(11) DEFAULT NULL,
  `Reservation_ID` int(11) DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `Date` date DEFAULT NULL,
  KEY `FK_room_reservation_room` (`Room_ID`),
  KEY `FK_room_reservation_reservation` (`Reservation_ID`),
  CONSTRAINT `FK_room_reservation_reservation` FOREIGN KEY (`Reservation_ID`) REFERENCES `reservation` (`Reservation_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_room_reservation_room` FOREIGN KEY (`Room_ID`) REFERENCES `room` (`Room_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table hms.room_reservation: ~0 rows (approximately)
DELETE FROM `room_reservation`;

-- Dumping structure for table hms.service
CREATE TABLE IF NOT EXISTS `service` (
  `Service_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ServiceName` varchar(255) DEFAULT NULL,
  `ServiceAvailability` varchar(255) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Type_Max` int(11) DEFAULT NULL,
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
  `First_name` varchar(255) DEFAULT NULL,
  `Last_name` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table hms.user: ~0 rows (approximately)
DELETE FROM `user`;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
