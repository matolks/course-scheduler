package com.vincematolka.coursescheduler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.Base64;
import javax.swing.JOptionPane;
import java.sql.Timestamp;

public class MainFrame extends javax.swing.JFrame {
    private String currentSemester;
    private String author;
    private String project;

    public MainFrame() {
        initComponents();
        checkData();
        rebuildSemesterComboBoxes();
    }

    public void rebuildSemesterComboBoxes() {
        ArrayList<String> semesters = SemesterQueries.getSemesterList();
        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(semesters.toArray(new String[0])));
        if (semesters.size() > 0) {
            currentSemesterLabel.setText(semesters.get(0));
            currentSemester = semesters.get(0);
        } else {
            currentSemesterLabel.setText("None, add a semester.");
            currentSemester = "None";
        }
        rebuildRosterCourseComboBox();
        rebuildStudentCourseComboBox();
        rebuildAdminDropCourseComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Course Scheduler");
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );


        /* Semester tab */
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addSemesterTextfield = new javax.swing.JTextField();
        addSemesterSubmitButton = new javax.swing.JButton();
        addSemesterStatusLabel = new javax.swing.JLabel();

        jLabel3.setText("Semester Name:");
        addSemesterTextfield.setColumns(20);
        addSemesterSubmitButton.setText("Submit");
        addSemesterStatusLabel.setText("                                                   ");
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(addSemesterSubmitButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addSemesterStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(383, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addSemesterSubmitButton)
                .addGap(18, 18, 18)
                .addComponent(addSemesterStatusLabel)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        addSemesterSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSemesterSubmitButtonActionPerformed(evt);
            }
        });

        /* Course tab */
        jPanel4 = new javax.swing.JPanel();
        courseCodeLabel = new javax.swing.JLabel();
        courseDescriptionLabel = new javax.swing.JLabel();
        seatsLabel = new javax.swing.JLabel();
        courseCodeTextField = new javax.swing.JTextField();
        courseDescriptionTextField = new javax.swing.JTextField();
        seatsTextField = new javax.swing.JTextField();
        addCourseButton = new javax.swing.JButton();
        addCourseStatusLabel = new javax.swing.JLabel();

        courseCodeLabel.setText("Course Code:");
        courseDescriptionLabel.setText("Description:");
        seatsLabel.setText("Seats:");
        addCourseButton.setText("Add Course");
        addCourseStatusLabel.setText(" ");
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(courseCodeLabel)
                                .addComponent(courseDescriptionLabel)
                                .addComponent(seatsLabel))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(courseCodeTextField)
                                .addComponent(courseDescriptionTextField)
                                .addComponent(seatsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
                        .addComponent(addCourseButton)
                        .addComponent(addCourseStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(350, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(courseCodeLabel)
                        .addComponent(courseCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(courseDescriptionLabel)
                        .addComponent(courseDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(seatsLabel)
                        .addComponent(seatsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(addCourseButton)
                    .addGap(18, 18, 18)
                    .addComponent(addCourseStatusLabel)
                    .addContainerGap(80, Short.MAX_VALUE))
        );
        addCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseButtonActionPerformed(evt);
            }
        });        

        /* Class tab */
        jPanel6 = new javax.swing.JPanel();
        classStudentIdLabel = new javax.swing.JLabel();
        classCourseCodeLabel = new javax.swing.JLabel();
        studentIdClassTextField = new javax.swing.JTextField();
        courseCodeClassTextField = new javax.swing.JTextField();
        addClassButton = new javax.swing.JButton();
        addClassStatusLabel = new javax.swing.JLabel();

        classStudentIdLabel.setText("Student ID:");
        classCourseCodeLabel.setText("Course Code:");
        addClassButton.setText("Add Class");
        addClassStatusLabel.setText(" ");
        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(classStudentIdLabel)
                                .addComponent(classCourseCodeLabel))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(studentIdClassTextField)
                                .addComponent(courseCodeClassTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
                        .addComponent(addClassButton)
                        .addComponent(addClassStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(350, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(classStudentIdLabel)
                        .addComponent(studentIdClassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(classCourseCodeLabel)
                        .addComponent(courseCodeClassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(addClassButton)
                    .addGap(18, 18, 18)
                    .addComponent(addClassStatusLabel)
                    .addContainerGap(120, Short.MAX_VALUE))
        );
        addClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassButtonActionPerformed(evt);
            }
        });        

        /* Student tab */
        jPanel7 = new javax.swing.JPanel();
        studentIdLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        studentIdTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        addStudentButton = new javax.swing.JButton();
        addStudentStatusLabel = new javax.swing.JLabel();

        studentIdLabel.setText("Student ID:");
        firstNameLabel.setText("First Name:");
        lastNameLabel.setText("Last Name:");
        addStudentButton.setText("Add Student");
        addStudentStatusLabel.setText(" ");
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(studentIdLabel)
                                .addComponent(firstNameLabel)
                                .addComponent(lastNameLabel))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(studentIdTextField)
                                .addComponent(firstNameTextField)
                                .addComponent(lastNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                        .addComponent(addStudentButton)
                        .addComponent(addStudentStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(400, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(studentIdLabel)
                        .addComponent(studentIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(firstNameLabel)
                        .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lastNameLabel)
                        .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(addStudentButton)
                    .addGap(18, 18, 18)
                    .addComponent(addStudentStatusLabel)
                    .addContainerGap(80, Short.MAX_VALUE))
        );
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        /* View Students Tab */
        jPanel8 = new javax.swing.JPanel();
        viewStudentsButton = new javax.swing.JButton();
        studentsScrollPane = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();

        viewStudentsButton.setText("Load Students");
        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "Student ID", "First Name", "Last Name" }
        ));
        studentsScrollPane.setViewportView(studentsTable);
        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(viewStudentsButton)
                        .addComponent(studentsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(viewStudentsButton)
                    .addGap(18, 18, 18)
                    .addComponent(studentsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE))
        );
        viewStudentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStudentsButtonActionPerformed(evt);
            }
        });

        /* View Courses tab */
        jPanel9 = new javax.swing.JPanel();
        viewCoursesButton = new javax.swing.JButton();
        coursesScrollPane = new javax.swing.JScrollPane();
        coursesTable = new javax.swing.JTable();
        viewCoursesStatusLabel = new javax.swing.JLabel();

        viewCoursesButton.setText("Load Courses");
        viewCoursesStatusLabel.setText(" ");
        coursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "Semester", "Course Code", "Description", "Seats" }
        ){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        coursesScrollPane.setViewportView(coursesTable);
        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(viewCoursesButton)
                        .addComponent(viewCoursesStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(coursesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(viewCoursesButton)
                    .addGap(18, 18, 18)
                    .addComponent(viewCoursesStatusLabel)
                    .addGap(18, 18, 18)
                    .addComponent(coursesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE))
        );
        viewCoursesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCoursesButtonActionPerformed(evt);
            }
        });

        /* Student-side main tab */
        jPanel2 = new javax.swing.JPanel();
        studentSelectLabel = new javax.swing.JLabel();
        studentSelectTextField = new javax.swing.JTextField();
        loadStudentButton = new javax.swing.JButton();
        studentSelectStatusLabel = new javax.swing.JLabel();
        loadedStudentLabel = new javax.swing.JLabel();
        viewStudentScheduleButton = new javax.swing.JButton();
        studentScheduleStatusLabel = new javax.swing.JLabel();
        studentScheduleScrollPane = new javax.swing.JScrollPane();
        studentScheduleTable = new javax.swing.JTable();
        studentAddCourseLabel = new javax.swing.JLabel();
        studentAddCourseComboBox = new javax.swing.JComboBox<>();
        studentAddClassButton = new javax.swing.JButton();
        studentAddClassStatusLabel = new javax.swing.JLabel();
        studentDropCourseLabel = new javax.swing.JLabel();
        studentDropCourseComboBox = new javax.swing.JComboBox<>();
        studentDropClassButton = new javax.swing.JButton();
        studentDropClassStatusLabel = new javax.swing.JLabel();

        studentDropCourseLabel.setText("Drop Course:");
        studentDropClassButton.setText("Drop Class");
        studentDropClassStatusLabel.setText(" ");
        studentAddCourseLabel.setText("Course Code:");
        studentAddClassButton.setText("Add Class");
        studentAddClassStatusLabel.setText(" ");
        studentSelectLabel.setText("Student ID:");
        loadStudentButton.setText("Load Student");
        studentSelectStatusLabel.setText(" ");
        loadedStudentLabel.setText("No student loaded.");
        viewStudentScheduleButton.setText("View Schedule");
        studentScheduleStatusLabel.setText(" ");
        studentScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "Course Code", "Description", "Status", "Timestamp" }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.sql.Timestamp.class
            };
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        studentScheduleScrollPane.setViewportView(studentScheduleTable);
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(studentSelectLabel)
                            .addGap(18, 18, 18)
                            .addComponent(studentSelectTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(loadStudentButton)
                            .addGap(18, 18, 18)
                            .addComponent(viewStudentScheduleButton))
                        .addComponent(studentSelectStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(loadedStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(studentScheduleStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(studentScheduleScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(studentAddCourseLabel)
                            .addGap(18, 18, 18)
                            .addComponent(studentAddCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(studentAddClassButton))
                        .addComponent(studentAddClassStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(studentSelectLabel)
                        .addComponent(studentSelectTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(loadStudentButton)
                        .addComponent(viewStudentScheduleButton))
                    .addGap(18, 18, 18)
                    .addComponent(studentSelectStatusLabel)
                    .addGap(18, 18, 18)
                    .addComponent(loadedStudentLabel)
                    .addGap(18, 18, 18)
                    .addComponent(studentScheduleStatusLabel)
                    .addGap(18, 18, 18)
                    .addComponent(studentScheduleScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(studentAddCourseLabel)
                        .addComponent(studentAddCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(studentAddClassButton))
                    .addGap(18, 18, 18)
                    .addComponent(studentAddClassStatusLabel)
                    .addContainerGap(20, Short.MAX_VALUE))
        );
        loadStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadStudentButtonActionPerformed(evt);
            }
        });
        viewStudentScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStudentScheduleButtonActionPerformed(evt);
            }
        });
        studentDropClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDropClassButtonActionPerformed(evt);
            }
        });

        /* View Rosters tab */
        jPanel10 = new javax.swing.JPanel();
        rosterCourseLabel = new javax.swing.JLabel();
        rosterCourseComboBox = new javax.swing.JComboBox<>();
        loadRosterButton = new javax.swing.JButton();
        rosterStatusLabel = new javax.swing.JLabel();
        rosterScrollPane = new javax.swing.JScrollPane();
        rosterTable = new javax.swing.JTable();

        rosterCourseLabel.setText("Course Code:");
        loadRosterButton.setText("Load Roster");
        rosterStatusLabel.setText(" ");
        rosterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "Student ID", "First Name", "Last Name", "Status", "Timestamp" }
        ){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.sql.Timestamp.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        rosterScrollPane.setViewportView(rosterTable);
        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(rosterCourseLabel)
                            .addGap(18, 18, 18)
                            .addComponent(rosterCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(loadRosterButton))
                        .addComponent(rosterStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rosterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rosterCourseLabel)
                        .addComponent(rosterCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(loadRosterButton))
                    .addGap(18, 18, 18)
                    .addComponent(rosterStatusLabel)
                    .addGap(18, 18, 18)
                    .addComponent(rosterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE))
        );
        loadRosterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadRosterButtonActionPerformed(evt);
            }
        });

        /* Admin Drop Class tab */
        jPanel11 = new javax.swing.JPanel();
        adminDropStudentIdLabel = new javax.swing.JLabel();
        adminDropStudentIdTextField = new javax.swing.JTextField();
        adminDropCourseLabel = new javax.swing.JLabel();
        adminDropCourseComboBox = new javax.swing.JComboBox<>();
        adminDropClassButton = new javax.swing.JButton();
        adminDropClassStatusLabel = new javax.swing.JLabel();

        adminDropStudentIdLabel.setText("Student ID:");
        adminDropCourseLabel.setText("Course Code:");
        adminDropClassButton.setText("Drop Class");
        adminDropClassStatusLabel.setText(" ");
        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(adminDropStudentIdLabel)
                                .addComponent(adminDropCourseLabel))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(adminDropStudentIdTextField)
                                .addComponent(adminDropCourseComboBox, 0, 220, Short.MAX_VALUE)))
                        .addComponent(adminDropClassButton)
                        .addComponent(adminDropClassStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(350, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(adminDropStudentIdLabel)
                        .addComponent(adminDropStudentIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(adminDropCourseLabel)
                        .addComponent(adminDropCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(adminDropClassButton)
                    .addGap(18, 18, 18)
                    .addComponent(adminDropClassStatusLabel)
                    .addContainerGap(120, Short.MAX_VALUE))
        );
        adminDropClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminDropClassButtonActionPerformed(evt);
            }
        });

        /* Top bar */
        jLabel2 = new javax.swing.JLabel();
        currentSemesterLabel = new javax.swing.JLabel();
        currentSemesterComboBox = new javax.swing.JComboBox<>();
        changeSemesterButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel2.setText("Current Semester: ");
        currentSemesterLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        currentSemesterLabel.setText("           ");
        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        changeSemesterButton.setText("Change Semester");
        changeSemesterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSemesterButtonActionPerformed(evt);
            }
        });
        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        jTabbedPane1.addTab("Admin", jPanel1);
        jTabbedPane1.addTab("Student", jPanel2);
        jTabbedPane2.addTab("Add Semester", jPanel3);
        jTabbedPane2.addTab("Add Course", jPanel4);
        jTabbedPane2.addTab("Add Class", jPanel6);
        jTabbedPane2.addTab("Add Student", jPanel7);
        jTabbedPane2.addTab("View Students", jPanel8);
        jTabbedPane2.addTab("View Courses", jPanel9);
        jTabbedPane2.addTab("View Rosters", jPanel10);
        jTabbedPane2.addTab("Drop Class", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentSemesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changeSemesterButton)
                                .addGap(31, 31, 31)
                                .addComponent(aboutButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(currentSemesterLabel)
                    .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeSemesterButton)
                    .addComponent(aboutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // display about information.
        JOptionPane.showMessageDialog(null, "Author: " + author + " Project: " + project);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void addSemesterSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSemesterSubmitButtonActionPerformed
        String semester = addSemesterTextfield.getText();
        SemesterQueries.addSemester(semester);
        addSemesterStatusLabel.setText("Semester " + semester + " has been added.");
        rebuildSemesterComboBoxes();
    }//GEN-LAST:event_addSemesterSubmitButtonActionPerformed

    // ADD STUDENT
    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String studentID = studentIdTextField.getText().trim();
        String firstName = firstNameTextField.getText().trim();
        String lastName = lastNameTextField.getText().trim();
        if (studentID.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            addStudentStatusLabel.setText("Please fill in all fields.");
            return;
        }
        StudentEntry student = new StudentEntry(studentID, firstName, lastName);
        StudentQueries.addStudent(student);
        addStudentStatusLabel.setText("Student added.");
        studentIdTextField.setText("");
        firstNameTextField.setText("");
        lastNameTextField.setText("");
    }

    // ADD COURSE
    private void addCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String code = courseCodeTextField.getText().trim();
        String desc = courseDescriptionTextField.getText().trim();
        String seatsText = seatsTextField.getText().trim();
        if (code.isEmpty() || desc.isEmpty() || seatsText.isEmpty()) {
            addCourseStatusLabel.setText("Please fill in all fields.");
            return;
        }
        if (currentSemester == null || currentSemester.equals("None")) {
            addCourseStatusLabel.setText("No active semester selected.");
            return;
        }
        try {
            int seats = Integer.parseInt(seatsText);
            CourseEntry course = new CourseEntry(currentSemester, code, desc, seats);
            CourseQueries.addCourse(course);
            addCourseStatusLabel.setText("Course added.");
            rebuildRosterCourseComboBox();
            rebuildStudentCourseComboBox();
            rebuildAdminDropCourseComboBox();
            courseCodeTextField.setText("");
            courseDescriptionTextField.setText("");
            seatsTextField.setText("");

        } catch (NumberFormatException e) {
            addCourseStatusLabel.setText("Seats must be a number.");
        }
    }

    // ADD CLASS
    private void addClassButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String studentID = studentIdClassTextField.getText().trim();
        String courseCode = courseCodeClassTextField.getText().trim();
        if (studentID.isEmpty() || courseCode.isEmpty()) {
            addClassStatusLabel.setText("Please fill in all fields.");
            return;
        }
        if (currentSemester == null || currentSemester.equals("None")) {
            addClassStatusLabel.setText("No active semester selected.");
            return;
        }
        int seats = CourseQueries.getCourseSeats(currentSemester, courseCode);
        if (seats == 0) {
            addClassStatusLabel.setText("Course not found.");
            return;
        }
        int enrolled = ScheduleQueries.getScheduledStudentCount(currentSemester, courseCode);
        String status = enrolled < seats ? "s" : "w";

        ScheduleEntry entry = new ScheduleEntry(currentSemester, courseCode, studentID, status, null);
        ScheduleQueries.addScheduleEntry(entry);
        if ("s".equals(status)) {
            addClassStatusLabel.setText("Student enrolled.");
        } else {
            addClassStatusLabel.setText("Class full. Student waitlisted.");
        }
        studentIdClassTextField.setText("");
        courseCodeClassTextField.setText("");
    }

    // CHANGE SEMESTERS
    private void changeSemesterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Object selected = currentSemesterComboBox.getSelectedItem();
        if (selected == null) {
            currentSemesterLabel.setText("None, add a semester.");
            currentSemester = "None";
            return;
        }
        currentSemester = selected.toString();
        currentSemesterLabel.setText(currentSemester);
        rebuildRosterCourseComboBox();
        rebuildStudentCourseComboBox();
        rebuildAdminDropCourseComboBox();
    }

    // LOAD STUDENTS
    private void loadStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String studentID = studentSelectTextField.getText().trim();

        if (studentID.isEmpty()) {
            studentSelectStatusLabel.setText("Please enter a student ID.");
            return;
        }
        StudentEntry student = StudentQueries.getStudent(studentID);
        if (student == null) {
            currentStudentID = null;
            loadedStudentLabel.setText("No student loaded.");
            studentSelectStatusLabel.setText("Student not found.");
            return;
        }
        currentStudentID = studentID;
        loadedStudentLabel.setText("Loaded: " + student.completeID());
        studentSelectStatusLabel.setText("Student loaded.");
        studentAddClassStatusLabel.setText(" ");
        rebuildStudentDropCourseComboBox();
    }

    // VIEW STUDENTS
    private void viewStudentsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<StudentEntry> students = StudentQueries.getAllStudents();
        javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) studentsTable.getModel();
        model.setRowCount(0); // clear table
        for (StudentEntry s : students) {
            model.addRow(new Object[]{
                s.getStudentID(),
                s.getFirstName(),
                s.getLastName()
            });
        }
    }

    // VIEW COURSES
    private void viewCoursesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentSemester == null || currentSemester.equals("None")) {
            viewCoursesStatusLabel.setText("No active semester selected.");
            return;
        }
        ArrayList<CourseEntry> courses = CourseQueries.getAllCourses(currentSemester);
        DefaultTableModel model = (DefaultTableModel) coursesTable.getModel();
        model.setRowCount(0);
        for (CourseEntry course : courses) {
            model.addRow(new Object[] {
                course.getSemester(),
                course.getCourseCode(),
                course.getCourseDescription(),
                course.getSeats()
            });
        }
        if (courses.isEmpty()) {
            viewCoursesStatusLabel.setText("No courses found for " + currentSemester + ".");
        } else {
            viewCoursesStatusLabel.setText("Loaded " + courses.size() + " course(s) for " + currentSemester + ".");
        }
    }

    // VIEW ROSTERS
    private void loadRosterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentSemester == null || currentSemester.equals("None")) {
            rosterStatusLabel.setText("No active semester selected.");
            return;
        }
        Object selectedCourse = rosterCourseComboBox.getSelectedItem();
        if (selectedCourse == null) {
            rosterStatusLabel.setText("No course selected.");
            return;
        }
        String courseCode = selectedCourse.toString();
        ArrayList<ScheduleEntry> scheduledStudents =
            ScheduleQueries.getScheduledStudentsByCourse(currentSemester, courseCode);
        ArrayList<ScheduleEntry> waitlistedStudents =
            ScheduleQueries.getWaitlistedStudentsByCourse(currentSemester, courseCode);
        DefaultTableModel model = (DefaultTableModel) rosterTable.getModel();
        model.setRowCount(0);
        for (ScheduleEntry entry : scheduledStudents) {
            StudentEntry student = StudentQueries.getStudent(entry.getStudentID());
            String firstName = "";
            String lastName = "";
            if (student != null) {
                firstName = student.getFirstName();
                lastName = student.getLastName();
            }
            model.addRow(new Object[] {
                entry.getStudentID(),
                firstName,
                lastName,
                "Scheduled",
                entry.getTimestamp()
            });
        }
        for (ScheduleEntry entry : waitlistedStudents) {
            StudentEntry student = StudentQueries.getStudent(entry.getStudentID());
            String firstName = "";
            String lastName = "";
            if (student != null) {
                firstName = student.getFirstName();
                lastName = student.getLastName();
            }
            model.addRow(new Object[] {
                entry.getStudentID(),
                firstName,
                lastName,
                "Waitlisted",
                entry.getTimestamp()
            });
        }
        int total = scheduledStudents.size() + waitlistedStudents.size();
        rosterStatusLabel.setText("Loaded roster for " + courseCode + ". Total students: " + total);
    }

    // HELPER FOR ROSTER
    public void rebuildRosterCourseComboBox() {
        ArrayList<String> courseCodes;
        if (currentSemester == null || currentSemester.equals("None")) {
            courseCodes = new ArrayList<>();
        } else {
            courseCodes = CourseQueries.getAllCourseCodes(currentSemester);
        }
        rosterCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(courseCodes.toArray(new String[0])));
    }

    // VIEW SCHEDULE
    private void viewStudentScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentStudentID == null || currentStudentID.trim().isEmpty()) {
            studentScheduleStatusLabel.setText("No student loaded.");
            return;
        }
        if (currentSemester == null || currentSemester.equals("None")) {
            studentScheduleStatusLabel.setText("No active semester selected.");
            return;
        }
        ArrayList<ScheduleEntry> schedule =
            ScheduleQueries.getScheduleByStudent(currentSemester, currentStudentID);
        javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) studentScheduleTable.getModel();
        model.setRowCount(0);
        ArrayList<CourseEntry> courses = CourseQueries.getAllCourses(currentSemester);
        for (ScheduleEntry entry : schedule) {
            String description = "";
            for (CourseEntry course : courses) {
                if (course.getCourseCode().equals(entry.getCourseCode())) {
                    description = course.getCourseDescription();
                    break;
                }
            }
            String statusText = "";
            if ("s".equals(entry.getStatus())) {
                statusText = "Scheduled";
            } else if ("w".equals(entry.getStatus())) {
                statusText = "Waitlisted";
            } else {
                statusText = entry.getStatus();
            }
            model.addRow(new Object[] {
                entry.getCourseCode(),
                description,
                statusText,
                entry.getTimestamp()
            });
        }
        if (schedule.isEmpty()) {
            studentScheduleStatusLabel.setText("No classes found for " + currentSemester + ".");
        } else {
            studentScheduleStatusLabel.setText("Loaded " + schedule.size() + " class(es).");
        }
    }

    // ADD CLASS STUDENT
    private void studentAddClassButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentStudentID == null || currentStudentID.trim().isEmpty()) {
            studentAddClassStatusLabel.setText("No student loaded.");
            return;
        }
        if (currentSemester == null || currentSemester.equals("None")) {
            studentAddClassStatusLabel.setText("No active semester selected.");
            return;
        }
        Object selectedCourse = studentAddCourseComboBox.getSelectedItem();
        if (selectedCourse == null) {
            studentAddClassStatusLabel.setText("No course selected.");
            return;
        }
        String courseCode = selectedCourse.toString();
        ArrayList<ScheduleEntry> currentSchedule =
            ScheduleQueries.getScheduleByStudent(currentSemester, currentStudentID);
        for (ScheduleEntry entry : currentSchedule) {
            if (entry.getCourseCode().equals(courseCode)) {
                studentAddClassStatusLabel.setText("Student already enrolled or waitlisted for this course.");
                return;
            }
        }
        int seats = CourseQueries.getCourseSeats(currentSemester, courseCode);
        if (seats == 0) {
            studentAddClassStatusLabel.setText("Course not found.");
            return;
        }
        int enrolled = ScheduleQueries.getScheduledStudentCount(currentSemester, courseCode);
        String status = enrolled < seats ? "s" : "w";

        ScheduleEntry entry = new ScheduleEntry(currentSemester, courseCode, currentStudentID, status, null);
        ScheduleQueries.addScheduleEntry(entry);

        if ("s".equals(status)) {
            studentAddClassStatusLabel.setText("Class added successfully.");
        } else {
            studentAddClassStatusLabel.setText("Class full. Student added to waitlist.");
        }
        viewStudentScheduleButtonActionPerformed(null);
    }

    // HELPER FOR ADD CLASS STUDENT
    public void rebuildStudentCourseComboBox() {
        ArrayList<String> courseCodes;
        if (currentSemester == null || currentSemester.equals("None")) {
            courseCodes = new ArrayList<>();
        } else {
            courseCodes = CourseQueries.getAllCourseCodes(currentSemester);
        }
        studentAddCourseComboBox.setModel(
            new javax.swing.DefaultComboBoxModel<>(courseCodes.toArray(new String[0]))
        );
    }

    // STUDENT DROP CLASS
    private void studentDropClassButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentStudentID == null || currentStudentID.trim().isEmpty()) {
            studentDropClassStatusLabel.setText("No student loaded.");
            return;
        }
        if (currentSemester == null || currentSemester.equals("None")) {
            studentDropClassStatusLabel.setText("No active semester selected.");
            return;
        }
        Object selectedCourse = studentDropCourseComboBox.getSelectedItem();
        if (selectedCourse == null) {
            studentDropClassStatusLabel.setText("No course selected.");
            return;
        }
        String courseCode = selectedCourse.toString();
        ScheduleQueries.dropStudentScheduleByCourse(currentSemester, currentStudentID, courseCode);
        promoteFirstWaitlistedStudent(currentSemester, courseCode);
        studentDropClassStatusLabel.setText("Class dropped.");
        viewStudentScheduleButtonActionPerformed(null);
        rebuildStudentDropCourseComboBox();
    }

    // STUDENT COURSES HELPER
    public void rebuildStudentDropCourseComboBox() {
        ArrayList<String> courseCodes = new ArrayList<>();
        if (currentStudentID != null && currentSemester != null && !currentSemester.equals("None")) {
            ArrayList<ScheduleEntry> schedule =
                ScheduleQueries.getScheduleByStudent(currentSemester, currentStudentID);

            for (ScheduleEntry entry : schedule) {
                courseCodes.add(entry.getCourseCode());
            }
        }
        studentDropCourseComboBox.setModel(
            new javax.swing.DefaultComboBoxModel<>(courseCodes.toArray(new String[0]))
        );
    }

    private void promoteFirstWaitlistedStudent(String semester, String courseCode) {
        ArrayList<ScheduleEntry> waitlist =
            ScheduleQueries.getWaitlistedStudentsByCourse(semester, courseCode);
        if (!waitlist.isEmpty()) {
            ScheduleEntry firstWaitlisted = waitlist.get(0);
            ScheduleQueries.updateScheduleEntry(semester, firstWaitlisted);
        }
    }

    // ADMIN DROPPER
    private void adminDropClassButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentSemester == null || currentSemester.equals("None")) {
            adminDropClassStatusLabel.setText("No active semester selected.");
            return;
        }
        String studentID = adminDropStudentIdTextField.getText().trim();
        if (studentID.isEmpty()) {
            adminDropClassStatusLabel.setText("Enter a student ID.");
            return;
        }
        Object selectedCourse = adminDropCourseComboBox.getSelectedItem();
        if (selectedCourse == null) {
            adminDropClassStatusLabel.setText("Select a course.");
            return;
        }
        String courseCode = selectedCourse.toString();
        ScheduleQueries.dropStudentScheduleByCourse(currentSemester, studentID, courseCode);
        promoteFirstWaitlistedStudent(currentSemester, courseCode);
        adminDropClassStatusLabel.setText("Student dropped from class.");
        adminDropStudentIdTextField.setText("");
    }

    // ADMIN DROPPER HELPER
    public void rebuildAdminDropCourseComboBox() {
        ArrayList<String> courseCodes;
        if (currentSemester == null || currentSemester.equals("None")) {
            courseCodes = new ArrayList<>();
        } else {
            courseCodes = CourseQueries.getAllCourseCodes(currentSemester);
        }
        adminDropCourseComboBox.setModel(
            new javax.swing.DefaultComboBoxModel<>(courseCodes.toArray(new String[0]))
        );
    }

    private void checkData() {
        try {
            FileReader reader = new FileReader("xzq789yy.txt");
            BufferedReader breader = new BufferedReader(reader);

            String encodedAuthor = breader.readLine();
            String encodedProject = breader.readLine();
            byte[] decodedAuthor = Base64.getDecoder().decode(encodedAuthor);
            author = new String(decodedAuthor);
            byte[] decodedProject = Base64.getDecoder().decode(encodedProject);
            project = new String(decodedProject);
            reader.close();

        } catch (FileNotFoundException e) {
            //get user info and create file
            author = JOptionPane.showInputDialog("Enter your first and last name.");
            project = "Course Scheduler";
            //write data to the data file.
            try {
                FileWriter writer = new FileWriter("xzq789yy.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                // encode the output data.
                String encodedAuthor = Base64.getEncoder().encodeToString(author.getBytes());
                bufferedWriter.write(encodedAuthor);
                bufferedWriter.newLine();
                String encodedProject = Base64.getEncoder().encodeToString(project.getBytes());
                bufferedWriter.write(encodedProject);
                bufferedWriter.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                System.exit(1);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String args[]) {
        /* <- replace with "/" --- TEMP DATABASE SETUP (RUN ONCE) ---
        try {
            var stmt = DBConnection.getConnection().createStatement();

            stmt.execute("CREATE TABLE semester (semester VARCHAR(50) PRIMARY KEY)");
            stmt.execute("CREATE TABLE student (studentid VARCHAR(10) PRIMARY KEY, firstname VARCHAR(50), lastname VARCHAR(50))");
            stmt.execute("CREATE TABLE course (semester VARCHAR(50), coursecode VARCHAR(10), description VARCHAR(100), seats INT, PRIMARY KEY (semester, coursecode))");
            stmt.execute("CREATE TABLE schedule (semester VARCHAR(50), studentid VARCHAR(10), coursecode VARCHAR(10), status VARCHAR(1), timestamp TIMESTAMP, PRIMARY KEY (semester, studentid, coursecode))");

            System.out.println("Tables created.");

        } catch (Exception e) {
            System.out.println("Tables may already exist, skipping setup.");
        }
        // --- END TEMP SETUP --- */
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private String currentStudentID;
    private javax.swing.JButton aboutButton;
    private javax.swing.JLabel addSemesterStatusLabel;
    private javax.swing.JButton addSemesterSubmitButton;
    private javax.swing.JTextField addSemesterTextfield;
    private javax.swing.JButton changeSemesterButton;
    private javax.swing.JComboBox<String> currentSemesterComboBox;
    private javax.swing.JLabel currentSemesterLabel;
    private javax.swing.JButton addStudentButton;
    private javax.swing.JLabel addStudentStatusLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTextField studentIdTextField;
    private javax.swing.JLabel studentIdLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton addCourseButton;
    private javax.swing.JLabel addCourseStatusLabel;
    private javax.swing.JTextField courseCodeTextField;
    private javax.swing.JTextField courseDescriptionTextField;
    private javax.swing.JTextField seatsTextField;
    private javax.swing.JLabel courseCodeLabel;
    private javax.swing.JLabel courseDescriptionLabel;
    private javax.swing.JLabel seatsLabel;
    private javax.swing.JLabel classStudentIdLabel;
    private javax.swing.JLabel classCourseCodeLabel;
    private javax.swing.JTextField studentIdClassTextField;
    private javax.swing.JTextField courseCodeClassTextField;
    private javax.swing.JButton addClassButton;
    private javax.swing.JLabel addClassStatusLabel;
    private javax.swing.JLabel studentSelectLabel;
    private javax.swing.JTextField studentSelectTextField;
    private javax.swing.JButton loadStudentButton;
    private javax.swing.JLabel studentSelectStatusLabel;
    private javax.swing.JLabel loadedStudentLabel;
    private javax.swing.JButton viewStudentsButton;
    private javax.swing.JTable studentsTable;
    private javax.swing.JScrollPane studentsScrollPane;
    private javax.swing.JButton viewCoursesButton;
    private javax.swing.JScrollPane coursesScrollPane;
    private javax.swing.JTable coursesTable;
    private javax.swing.JLabel viewCoursesStatusLabel;
    private javax.swing.JLabel rosterCourseLabel;
    private javax.swing.JComboBox<String> rosterCourseComboBox;
    private javax.swing.JButton loadRosterButton;
    private javax.swing.JLabel rosterStatusLabel;
    private javax.swing.JScrollPane rosterScrollPane;
    private javax.swing.JTable rosterTable;
    private javax.swing.JButton viewStudentScheduleButton;
    private javax.swing.JLabel studentScheduleStatusLabel;
    private javax.swing.JScrollPane studentScheduleScrollPane;
    private javax.swing.JTable studentScheduleTable;
    private javax.swing.JLabel studentAddCourseLabel;
    private javax.swing.JComboBox<String> studentAddCourseComboBox;
    private javax.swing.JButton studentAddClassButton;
    private javax.swing.JLabel studentAddClassStatusLabel;
    private javax.swing.JLabel studentDropCourseLabel;
    private javax.swing.JComboBox<String> studentDropCourseComboBox;
    private javax.swing.JButton studentDropClassButton;
    private javax.swing.JLabel studentDropClassStatusLabel;
    private javax.swing.JLabel adminDropStudentIdLabel;
    private javax.swing.JTextField adminDropStudentIdTextField;
    private javax.swing.JLabel adminDropCourseLabel;
    private javax.swing.JComboBox<String> adminDropCourseComboBox;
    private javax.swing.JButton adminDropClassButton;
    private javax.swing.JLabel adminDropClassStatusLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
