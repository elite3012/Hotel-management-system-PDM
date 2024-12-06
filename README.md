# Hotel Management System (HMS)

This is a hotel management system built to streamline the operations of a hotel. The application manages guests, rooms, and bookings, providing a smooth user experience for hotel staff. 

## Prerequisites

Before using the application, ensure you have the following installed:

- **Java 8 or higher**
- **MySQL Database** (The application will automatically set up the database for you)
- **IDE** (IntelliJ IDEA, Eclipse, or any IDE of your choice)

## Steps to Use the Application

1. **Open MySQL:**
   - Make sure MySQL is running on your system. If not, start the MySQL service.
   
2. **Run `DatabaseServerPreparingInitializer`:**
   - First, run the `DatabaseServerPreparingInitializer` class. This class will automatically create a database called `hms` for you if it doesn't already exist. It will set up the required tables and initial configuration for the application.

3. **Open `LoginWindow` Class:**
   - After the database is set up, navigate to and open the `LoginWindow` class. This is the entry point of the application. You can use this window to log in and start managing the hotel operations.

4. **Using the Application:**
   - Once logged in, you can manage the hotel database, including adding guests, creating room bookings, and generating reports.

## Features

- **User Authentication:** Secure login system.
- **Room Management:** Add, update, and remove rooms.
- **Guest Management:** Add and manage guest details.
- **Booking System:** Book rooms for guests with date and time management.

## Running the Application

1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/hotel-management-system.git
   ```

2. Import the project into your IDE.

3. Ensure the required dependencies are installed (such as JDBC for MySQL integration).

4. Follow the steps listed above to run the `DatabaseServerPreparingInitializer` and `LoginWindow` classes.

## Troubleshooting

- If the application cannot connect to MySQL, ensure that MySQL is running, and the credentials are correct.
- The database `hms` will be automatically created by the application. If it isn't, check the MySQL server status and logs.
