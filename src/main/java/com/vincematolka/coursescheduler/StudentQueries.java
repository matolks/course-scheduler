package com.vincematolka.coursescheduler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentQueries {
    private static Connection connection;
    private static PreparedStatement addStudent;
    private static PreparedStatement getAllStudents;
    private static ResultSet resultSet;
    private static ResultSet getStudentIDResults;
    private static PreparedStatement getStudentID;

    public static void addStudent(StudentEntry student)
    {
        connection = DBConnection.getConnection();
        try
        {
            addStudent = connection.prepareStatement("insert into app.student (studentid, firstname, lastname) values (?, ?, ?)");
            addStudent.setString(1, student.getStudentID());
            addStudent.setString(2, student.getFirstName());
            addStudent.setString(3, student.getLastName());
            addStudent.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }

    public static ArrayList<StudentEntry> getAllStudents()
    {
        ArrayList<StudentEntry> faculty = new ArrayList<StudentEntry>();
        connection = DBConnection.getConnection();
        try
        {
            getAllStudents = connection.prepareStatement("select studentid, firstname, lastname from app.student");
            resultSet = getAllStudents.executeQuery();
            
            while(resultSet.next())
            {
                faculty.add(new StudentEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
            }

        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();   
        }
        return faculty;
    }
    
    public static String getStudentID(String lastname, String firstname)
    {
        connection = DBConnection.getConnection();
        String id = "";
        try
        {
            getStudentID = connection.prepareStatement("select studentid from app.student where lastname = ? and firstname = ?");
            getStudentID.setString(1, lastname);
            getStudentID.setString(2, firstname);
            getStudentIDResults = getStudentID.executeQuery();
            
            while(getStudentIDResults.next())
            {
                id = getStudentIDResults.getString("studentid");
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return id;
        
        
    }
   
    public static StudentEntry getStudent(String studentID)
    {
        connection = DBConnection.getConnection();
        try
        {
            getAllStudents = connection.prepareStatement(
                "select studentid, firstname, lastname from app.student where studentid = ?"
            );
            getAllStudents.setString(1, studentID);
            resultSet = getAllStudents.executeQuery();

            if (resultSet.next()) {
                return new StudentEntry(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
                );
            }
            return null;
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
            return null;
        }
    }

    public static void dropStudent(String studentID)
    {
        connection = DBConnection.getConnection();
        try
        {
            getAllStudents = connection.prepareStatement("delete from app.student where studentid = ?");
            getAllStudents.setString(1, studentID);
            getAllStudents.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
}