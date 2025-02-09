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
   cd EduTimeManager[Project Documentation.docx](https://github.com/user-attachments/files/18317417/Project.Documentation.docx)

