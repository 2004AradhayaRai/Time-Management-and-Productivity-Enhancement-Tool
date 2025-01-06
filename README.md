# EduTimeManager: Time Management Tool

## **Project Overview**

EduTimeManager is a web-based time management tool designed to help users organize their tasks, set priorities, and track deadlines efficiently. This tool allows users to register, log in, manage tasks, and view detailed task information. Built with modern Java web technologies, it provides an interactive and responsive UI using **JSP**, **Servlets**, **JSTL**, and **JavaScript** for validation and interactivity. The project also uses **MySQL** for persistent data storage.

## **Key Features**

- **User Registration & Login:**
  - Users can sign up with their username, email, and password.
  - Secure password storage using **BCrypt hashing**.
  - Users can log in using their credentials to access their personalized dashboard.

- **Task Management:**
  - Users can create, update, and delete tasks.
  - Tasks have associated details such as **title**, **description**, **category**, **priority**, and **due date**.
  - Task statuses (e.g., Incomplete/Completed) and priorities (e.g., High, Medium, Low) help users manage their workload effectively.

- **Task Dashboard:**
  - The dashboard displays all tasks associated with the logged-in user.
  - Users can filter tasks by priority, category, or due date.
  
- **Responsive UI:**
  - Designed with **Bootstrap** to ensure the app is mobile-friendly.
  - Includes **JavaScript** validation and interactivity for an enhanced user experience.

- **Admin Features (Optional):**
  - Admins can manage user tasks across multiple accounts, providing control over the system.

## **Technology Stack**

- **Frontend:** 
  - **HTML/CSS** for basic structuring and styling.
  - **Bootstrap** for responsive layout and modern UI components.
  - **JavaScript** for form validation, interactivity, and client-side logic.
  - **JSTL (JavaServer Pages Standard Tag Library)** for dynamic page content rendering.

- **Backend:**
  - **Java** for business logic and functionality.
  - **Servlets** for HTTP request processing.
  - **JSP** for rendering dynamic web pages.
  - **JDBC (Java Database Connectivity)** for interacting with the MySQL database.
  - **MySQL** for persistent data storage.
  
- **Authentication:**
  - Passwords are securely hashed using the **BCrypt** algorithm.

- **Servlet Container:**
  - **Apache Tomcat 10.1** is used as the servlet container to run the application.

- **Build Tool:**
  - **Maven** for dependency management and building the project.

## **Installation & Setup**

### **Prerequisites**

Before setting up the project, ensure you have the following installed:

- **JDK 11+** (For compiling and running Java code)
- **Apache Tomcat 10.1** (As the servlet container)
- **MySQL** (For database storage)
- **Maven** (For dependency management)

### **Steps to Setup**

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your-username/EduTimeManager.git
   cd EduTimeManager

   Configure the MySQL database:

Create a new database in MySQL:

sql
Copy code
CREATE DATABASE edu_time_manager;
Use the SQL scripts in db/ folder to create tables for Users and Tasks.

Configure Tomcat:

Add the project to your Tomcat server as a web application.
Set the Tomcat version to 10.1.
Build the project using Maven:

In the project root folder, run:

bash
Copy code
mvn clean install
This will build the application and create the .war file in the target/ directory.

Deploy the application to Tomcat:

Copy the .war file from target/ directory to the webapps/ folder of your Tomcat installation.
Start Tomcat and open your browser. Go to http://localhost:8080/EduTimeManager.
Start Using the Application:

Register a new user.
Log in and start managing your tasks.
Usage Instructions
Once deployed successfully, you can:

Sign Up: Register with a username, email, and password.
Login: Use your credentials to log in to your account.
Create Tasks: Add tasks with details such as title, category, priority, and due date.
View Tasks: Check your tasks in the dashboard and filter by priority or category.
Edit Tasks: Modify existing tasks or mark them as complete.
Delete Tasks: Remove tasks from your list.
Testing
JUnit Testing: Unit tests are written to verify the correctness of service and DAO layers.
Mocking: The Mockito framework is used to mock the dependencies in unit tests.
Integration Testing: Ensures proper communication between the servlets and database.
Security Considerations
Password Security: User passwords are hashed using BCrypt before being stored in the database.
SQL Injection Prevention: Prepared statements are used to prevent SQL injection vulnerabilities.
Session Management: User sessions are used to manage logged-in users.
Contributing
Feel free to contribute to this project by opening an issue or submitting a pull request.

Steps to contribute:
Fork the repository.
Create a new branch (git checkout -b feature-branch).
Make your changes and commit them (git commit -am 'Add feature').
Push the changes to your forked repository (git push origin feature-branch).
Open a pull request on GitHub.
License
This project is licensed under the MIT License - see the LICENSE.md file for details.

Acknowledgements
Thanks to the open-source community for providing libraries and tools that made this project possible.
Special thanks to the Java Servlet and JSP documentation for helpful references during development.

