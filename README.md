# Hotel Management System (HMS)

This is a hotel management system built to streamline the operations of a hotel. The application manages guests, rooms, and bookings, providing a smooth user experience for hotel staff. 

## Prerequisites

Before using the application, ensure you have the following installed:

- **Java 8 or higher**
- **MySQL Database** (The application will automatically set up the database for you)
- **IDE** (IntelliJ IDEA, Eclipse, or any IDE of your choice)

## Setup Instructions

### Step 1: Run the `DatabaseServerPreparingInitializer` Class
- The application will automatically create a database named `hms` in MySQL when you run the class `DatabaseServerPreparingInitializer`. This step is necessary to initialize the database schema for the hotel management system.

### Step 2: Open the `LoginWindow` Class
- After the database is created, you can run the `LoginWindow` class to access the login interface.

### Step 3: Log in with Pre-Created Accounts
- The application comes with 4 pre-created accounts for different user roles. You can use any of the following credentials to log in or CREATE a new account by the Sign In feature:
  - **Admin**
    - Username: `admin`
    - Password: `123`
  - **Receptionist**
    - Username: `receptionist`
    - Password: `123`
  - **Customer**
    - Username: `customer`
    - Password: `123`
  - **Housekeeper**
    - Username: `housekeeper`
    - Password: `123`

### Step 4: Explore the Application
- Once logged in, you can use the application to manage hotel operations based on the role you've logged into.

## Running the Application
1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/hotel-management-system.git
   ```

2. Import the project into your IDE.

3. Ensure the required dependencies are installed (such as JDBC for MySQL integration).

4. Follow the steps listed above to run the `DatabaseServerPreparingInitializer` and `LoginWindow` classes.

## Features
- **Admin**: Full access to all features including managing users, rooms, and reservations.
- **Receptionist**: Can manage customer check-ins, check-outs, and reservations.
- **Customer**: Limited access to view available rooms and make bookings.
- **Housekeeper**: View assigned rooms and mark them as cleaned.

## Notes
- The database is automatically created upon running the `DatabaseServerPreparingInitializer` class.
- The application uses a MySQL database named `hms`.
  
## Troubleshooting

- If the application cannot connect to MySQL, ensure that MySQL is running, and the credentials are correct.
- The database `hms` will be automatically created by the application. If it isn't, check the MySQL server status and logs.
Here is the updated README for your Hotel Management System repository:
