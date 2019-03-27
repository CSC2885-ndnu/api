DROP DATABASE IF EXISTS senior_project_database;

CREATE DATABASE IF NOT EXISTS senior_project_database;

USE senior_project_database;

DROP TABLE IF EXISTS course;
CREATE TABLE course
(
    id INT NOT NULL AUTO_INCREMENT,
    courseCode INT(4),
    dept VARCHAR(255),
    name VARCHAR(255),
    description VARCHAR(255),
    section INT(2),
    syllabus TEXT(65535),
    semester VARCHAR(255),
    year INT(4),
    prof VARCHAR(255),
    link VARCHAR(255),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    studentID INT(6),
    email VARCHAR(255),
    password VARCHAR(255),
    avatar VARCHAR(255),
    isAdmin BIT,
    flagged BIT,
    isLoggedIn BIT,
    createdTS DATETIME, 
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS enrolled;
CREATE TABLE enrolled
(
    courseID INT,
    userID INT,
    FOREIGN KEY (courseID) REFERENCES course(id),
    FOREIGN KEY (userID) REFERENCES user(id)
);

DROP TABLE IF EXISTS post;
CREATE TABLE post
(
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255),
    courseID INT,
    classDate DATETIME,
    postDate DATETIME,
    note TEXT(65535),
    userID INT,
    flagged BIT,
    PRIMARY KEY(id),
    FOREIGN KEY(courseID) REFERENCES course(id),
    FOREIGN KEY(userID) REFERENCES user(id)
);

DROP TABLE IF EXISTS comment;
CREATE TABLE comment
(
    id INT NOT NULL AUTO_INCREMENT,
    postID INT,
    user INT, 
    createdTS DATETIME,
    modified DATETIME,
    comment VARCHAR(255),
    flagged BOOLEAN,
    PRIMARY KEY(id),
    FOREIGN KEY(postID) REFERENCES post(id),
    FOREIGN KEY(user) REFERENCES user(id)
);

DROP TABLE IF EXISTS attachments;
CREATE TABLE attachments
(
    id INT NOT NULL AUTO_INCREMENT,
    postID INT,
    link VARCHAR(255),
    type VARCHAR(255),
    PRIMARY KEY(id),
    FOREIGN KEY(postID) REFERENCES post(id)
);

DROP TABLE IF EXISTS post_flag;
CREATE TABLE post_flag
(
    notes TEXT(65535),
    postID INT,
    flagger INT,
    flagDate DATETIME,
    active BIT,
    FOREIGN KEY(postID) REFERENCES post(id),
    FOREIGN KEY(flagger) REFERENCES user(id)
);

DROP TABLE IF EXISTS post_rank;
CREATE TABLE post_rank
(
    postID INT,
    userID INT,
    postRank INT,
    FOREIGN KEY(postID) REFERENCES post(id),
    FOREIGN KEY(userID) REFERENCES user(id)
);

DROP TABLE IF EXISTS comment_flag;
CREATE TABLE comment_flag
(
    commentID INT,
    flagger INT,
    flagDate DATETIME,
    active BIT,
    notes VARCHAR(255),
    FOREIGN KEY(commentID) REFERENCES comment(id),
    FOREIGN KEY(flagger) REFERENCES user(id)
);

DROP TABLE IF EXISTS comment_rank;
CREATE TABLE comment_rank
(
    commentID INT,
    userID INT,
    commentRank INT,
    FOREIGN KEY(commentID) REFERENCES comment(id),
    FOREIGN KEY(userID) REFERENCES user(id)
);


USE senior_project_database;

INSERT INTO course VALUES (
    1,
    1,
    'History',
    'World History 101',
    'World History',
    10,
    'We gon learn some history',
    'Fall',
    '2019',
    'Youssefi',
    'www.worldhistory.com'
);
INSERT INTO course VALUES (
    2,
    2,
    'History',
    'World History 101',
    'World History',
    20,
    'We gon learn some history',
    'Fall',
    '2019',
    'Youssefi',
    'www.worldhistory.com'
);

INSERT INTO user VALUES (
    1,
    'Megan',
    'Wong',
    100001,
    'mwong@student.ndnu.edu',
    'password',
    'flickr.com',
    0,
    0,
    0,
    '2019-02-09 00:00:00'
);
INSERT INTO user VALUES (
    2,
    'Megan',
    'Wong',
    200001,
    'mwong@student.ndnu.edu',
    'password',
    'flickr.com',
    0,
    0,
    0,
    '2019-02-09 00:00:00'
);

INSERT INTO enrolled VALUES (
    1,
    1
);

INSERT INTO post VALUES (
    1,
    'First post',
    1,
    '2019-02-09 00:00:00',
    '2019-02-09 00:00:00',
    'Notes',
    1,
    0
);

INSERT INTO attachments VALUES (
    1,
    1,
    'www.ndnu.edu',
    'picture'
);

INSERT INTO post_flag VALUES (
    'notes',
    1,
    1,
    now(),
    0
);

INSERT INTO post_rank VALUES (
    1,
    1,
    1
);

INSERT INTO comment VALUES (
    1,
    1,
    1,
    now(),
    now(),
    'Comment',
    0
);

INSERT INTO comment_flag VALUES (
    1,
    1,
    now(),
    0,
    'Notes'
);

INSERT INTO comment_rank VALUES (
    1,
    1,
    1
);