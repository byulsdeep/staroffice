# Star Office 1.0

Star Office 1.0 is a lightweight officeware web application designed to streamline workplace communication and document management. It provides authentication, contact management, document handling, messaging, and notifications for an efficient workflow.

## Features

### 1. Authentication System
- User sign-up, sign-in, and sign-out
- Change password and update account info
- Profile picture upload
- Account deletion

### 2. Contact Management
- Save and manage contacts
- Filter contacts by department

### 3. Document System
- Create, read, delete, and favorite documents
- Support for text, images, and file attachments
- Filter documents by department

### 4. Messaging System
- Send and receive persistent messages
- Integrated small chat system

### 5. Notifications
- Receive notifications for new messages
- Get notified when new documents are created in your department

## Tech Stack
- **Backend**: Java with Struts2, MyBatis
- **Frontend**: Struts2 Dojo AJAX
- **Database**: MySQL 5.6
- **Build Tool**: Maven
- **Logging**: Log4j, SLF4J

## Setup & Installation

### Prerequisites
- JDK 1.8+
- Apache Tomcat (or any compatible servlet container)
- MySQL 5.6
- Maven
- Eclipse IDE (optional, for compatibility)

### Installation Steps
1. Clone the repository:
   ```sh
   git clone https://github.com/byulsdeep/staroffice.git
   ```
2. Configure MySQL database:
   - Run SQL in `documents/ddl.txt` in your MySQL database.
3. Build the project with Maven:
   ```sh
   mvn clean package
   ```
4. Deploy the generated WAR file to Tomcat:
   ```sh
   cp target/staroffice.war /path/to/tomcat/webapps/
   ```
5. Start the Tomcat server and access the application at `http://localhost:8080/staroffice`
