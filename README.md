# Course Scheduler

A Java desktop application for managing semesters, students, courses, class enrollment, and waitlists using a local embedded SQL database.

---

## Overview

Course Scheduler is a Java Swing desktop application that allows administrators and students to manage course registration data across academic semesters.

The application supports course enrollment, student scheduling, waitlist handling, and automatic promotion of waitlisted students when seats become available.

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
- Drop students from classes
- Automatically promote the first waitlisted student when a seat opens

### Student

- Load a student by ID
- View schedule for the current semester
- Add a class
- Drop a class

---

## Tech Stack

- **Language:** Java
- **GUI:** Java Swing
- **Build Tool:** Maven
- **Database:** Apache Derby embedded SQL database
- **Database Access:** JDBC

---

## Database

This project uses **Apache Derby**, an embedded relational SQL database.

Apache Derby runs locally inside the application, so no external database server is required. The database is automatically created and initialized when the application runs.

### Tables

- `semester` — stores available semesters
- `student` — stores student information
- `course` — stores course information and capacity
- `schedule` — manages enrollments and waitlists

### Scheduling Logic

Students are assigned one of two scheduling statuses:

- `"s"` — scheduled
- `"w"` — waitlisted

If a class is full, the student is placed on the waitlist. When a scheduled student drops the class, the earliest waitlisted student is automatically promoted into the open seat.

---

## Project Structure

- `MainFrame.java` — main GUI and event handling
- `DBConnection.java` — database connection setup
- `SemesterQueries.java` — semester database operations
- `StudentQueries.java` — student database operations
- `CourseQueries.java` — course database operations
- `ScheduleQueries.java` — scheduling database operations
- `StudentEntry.java` — student data model
- `CourseEntry.java` — course data model
- `ScheduleEntry.java` — schedule data model

---

## Concepts Demonstrated

- Object-oriented programming
- Java Swing GUI development
- Event-driven programming
- JDBC database access
- Embedded SQL database usage
- Separation of concerns
- Data modeling
- Waitlist and enrollment state management

---

## How to Run

### Using Maven

1. Navigate to the project root directory:

```bash
cd course-scheduler
```

2. Compile the project:

```bash
mvn clean compile
```

3. Run the application:

```bash
mvn exec:java -Dexec.mainClass="com.vincematolka.coursescheduler.MainFrame"
```

---

## Notes

- The application operates on a selected current semester.
- Course and scheduling operations are scoped to the current semester.
- The Apache Derby database is created automatically on first run.
- No external database setup is required.

---

## Author

Vince Matolka
