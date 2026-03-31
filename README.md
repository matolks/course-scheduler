# Course Scheduler

A Java desktop application for managing semesters, students, courses, and class scheduling using a local SQL database

---

## Features

### Admin

- Add semesters
- Add students
- Add courses
- Add students to classes
- View all students
- View all courses for the current semester
- View course rosters
- Drop a student from a class
- Automatically promote the first waitlisted student when a seat opens

### Student

- Load a student by ID
- View schedule for the current semester
- Add a class
- Drop a class

---

## Tech Stack

- Java
- Java Swing (GUI)
- Maven (build tool)
- Apache Derby (embedded SQL database)

---

## Project Structure

- `MainFrame.java` - main GUI and event handling
- `DBConnection.java` - database connection
- `SemesterQueries.java` - semester database operations
- `StudentQueries.java` - student database operations
- `CourseQueries.java` - course database operations
- `ScheduleQueries.java` - scheduling database operations
- `StudentEntry.java` - student data model
- `CourseEntry.java` - course data model
- `ScheduleEntry.java` - schedule data model

---

## Database

This project uses **Apache Derby**, an embedded relational SQL database.

### Key Characteristics

- Embedded directly in the application (no external server required)
- Uses standard SQL for querying and updates
- Stores data locally on the user’s machine
- Automatically created and initialized when the application runs

### Tables

- `semester` – stores available semesters
- `student` – stores student information
- `course` – stores course data and capacity
- `schedule` – manages enrollments and waitlists

### Scheduling Logic

- Students are added with status:
  - `"s"` = scheduled
  - `"w"` = waitlisted
- If a class is full, students are placed on a waitlist
- When a student drops a class, the earliest waitlisted student is automatically promoted

---

## Java Concepts Used

This project demonstrates several core Java and software design principles:

- **Object-Oriented Programming**
  - Classes for data models (`StudentEntry`, `CourseEntry`, `ScheduleEntry`)
  - Encapsulation of data and behavior

- **Separation of Concerns**
  - UI handled in `MainFrame`
  - Database logic handled in query classes (`*Queries.java`)
  - Data models separated from logic

- **JDBC (Java Database Connectivity)**
  - Prepared statements for safe SQL execution
  - ResultSet processing for data retrieval

- **Event-Driven Programming**
  - Swing action listeners for user interaction

- **Data Structures**
  - Use of `ArrayList` for dynamic data handling

- **State Management**
  - Tracking current semester and current student within the application

---

## How to Run

### Using Terminal (Maven)

1. Navigate to the project root directory:

   '''cd course-scheduler

2. Compile the project:

   '''mvn clean compile

3. Run the application:

   '''mvn exec:java -Dexec.mainClass="com.vincematolka.coursescheduler.MainFrame"

---

### Notes

- The database is created automatically on first run using Apache Derby
- No additional setup is required

## Notes

- The application operates on a selected **current semester**
- All course and scheduling operations are scoped to that semester
- Waitlist promotion is handled automatically upon student removal

---

## Author

Vince Matolka
