# Course Scheduler

A Java Swing desktop application for managing semesters, students, courses, enrollment, and waitlists using an embedded Apache Derby SQL database.

## Features

### Admin

- Add semesters, students, and courses
- Add students to available course seats
- View students, courses, and course rosters
- Drop students from enrolled courses
- Automatically promote the earliest waitlisted student when a seat opens

### Student

- Load a student by ID
- View the student's schedule for the current semester
- Add a class
- Drop a class
- Join a waitlist when a course is full

## Scheduling Logic

The application manages course enrollment using scheduled and waitlisted status values.

Students are assigned one of two statuses:

- `"s"`: scheduled
- `"w"`: waitlisted

If a course has available capacity, the student is scheduled into the class. If the course is full, the student is added to the waitlist. When a scheduled student drops the course, the earliest waitlisted student is automatically promoted into the open seat.

## Database

This project uses Apache Derby as an embedded relational SQL database. The database runs locally inside the application and does not require an external server.

### Tables

- `semester`: stores available semesters
- `student`: stores student information
- `course`: stores course information and capacity
- `schedule`: stores course enrollments and waitlist records

## Tech Stack

- **Language:** Java
- **GUI:** Java Swing
- **Build Tool:** Maven
- **Database:** Apache Derby
- **Database Access:** JDBC

## Project Structure

- `MainFrame.java`: main GUI and event handling
- `DBConnection.java`: database connection setup
- `SemesterQueries.java`: semester database operations
- `StudentQueries.java`: student database operations
- `CourseQueries.java`: course database operations
- `ScheduleQueries.java`: scheduling database operations
- `StudentEntry.java`: student data model
- `CourseEntry.java`: course data model
- `ScheduleEntry.java`: schedule data model

## How to Run

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
