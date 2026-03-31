CREATE TABLE semester (
    semester VARCHAR(50) PRIMARY KEY
);

CREATE TABLE student (
    studentid VARCHAR(10) PRIMARY KEY,
    firstname VARCHAR(50),
    lastname VARCHAR(50)
);

CREATE TABLE course (
    semester VARCHAR(50),
    coursecode VARCHAR(10),
    description VARCHAR(100),
    seats INT,
    PRIMARY KEY (semester, coursecode)
);

CREATE TABLE schedule (
    semester VARCHAR(50),
    studentid VARCHAR(10),
    coursecode VARCHAR(10),
    status VARCHAR(1),
    timestamp TIMESTAMP,
    PRIMARY KEY (semester, studentid, coursecode)
);