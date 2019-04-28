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
    meetingDay VARCHAR(255),
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
    createdTS DATETIME DEFAULT CURRENT_TIMESTAMP, 
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
    postDate DATETIME,
    note TEXT(65535),
    userID INT,
    flagged BIT,
    PRIMARY KEY(id),
    FOREIGN KEY(courseID) REFERENCES course(id),
    FOREIGN KEY(userID) REFERENCES user(id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS comment;
CREATE TABLE comment
(
    id INT NOT NULL AUTO_INCREMENT,
    postID INT,
    userID INT, 
    createdTS DATETIME,
    modified DATETIME,
    comment VARCHAR(255),
    flagged BOOLEAN,
    PRIMARY KEY(id),
    FOREIGN KEY(postID) REFERENCES post(id) ON DELETE CASCADE,
    FOREIGN KEY(userID) REFERENCES user(id)
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

DROP TABLE IF EXISTS comment_flag;
CREATE TABLE comment_flag
(
    id INT NOT NULL AUTO_INCREMENT,
    commentID INT,
    flagger INT,
    flagDate DATETIME,
    active BIT,
    notes VARCHAR(255),
    PRIMARY KEY(id),
    FOREIGN KEY(commentID) REFERENCES comment(id) ON DELETE CASCADE,
    FOREIGN KEY(flagger) REFERENCES user(id)
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
    'M',
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
    'MWF',
    '2019',
    'Youssefi',
    'www.worldhistory.com'
);

INSERT INTO course VALUES (
   3,
   1256,
   'Computer Science',
   'Quantum Computing',
   'The magistry of observable data exchange through hypothetical data spheres',
   2,
   'Quantum Computing 101',
   'Fall',
   'W',
   '2019',
   'Captain Jean Luc Picard',
   'www.QuantumComputing.com'
);

INSERT INTO course VALUES (
   4,
   5436,
   'Industrial Engineering',
   'SkyFort Engineering',
   'The art of desgining anti gravity defensible fortresses for your small kingdoms',
   1,
   'Skyforts? Which one is best for me?',
   'Spring',
   'MF',
   '2019',
   'Captain Kathryn Janeway',
   'www.skyfortdigest.com'
);


INSERT INTO course VALUES (
   5,
   2002,
   'Agricultural Design',
   'Palm Tree Design',
   'In depth Analysis of the building of AAA palm trees in the corporate environment',
   2,
   'Figs, Leaves and Wood-you rather have a palm tree?',
   'Fall',
   'MWF',
   '2019',
   'Captain Benjamin Sisko',
   'www.facepalmtree.com'
);

INSERT INTO course VALUES (
   6,
   2345,
   'Physics',
   'Linear Contemplation 101',
   'Technical field involving thinking in straight lines',
   1,
   'Lines of thought',
   'Spring',
   'F',
   '2019',
   'Captain James T Kirk',
   'www.straightthinking.com'
);

INSERT INTO course VALUES (
   7,
   1233,
   'Mathematics',
   'Mathematical Graphing',
   'Graphing things in a way that could be considering mathematical in nature',
   3,
   'Graph Math Good',
   'Fall',
   'MF',
   '2019',
   'Captain Johnathan Archer',
   'www.mathgraph.com'
);

INSERT INTO course VALUES (
   8,
   5367,
   'Mathematics',
   'Calculus 4',
   'Four dimensional integrals of things like lima beans and kidneys',
   1,
   'Calc 4d Forever',
   'Summer',
   'MWF',
   '2019',
   'High Chancelor Gowron',
   'www.calcfour.com'
);

INSERT INTO course VALUES (
   9,
   2673,
   'Physics',
   'Electrical Engineering',
   'Concepts of electrical things and like how to build them',
   10,
   'Wires And Current 101',
   'Fall',
   'F',
   '2019',
   'Lieutenant Commander Data',
   'www.electEngineer.com'
);

INSERT INTO course VALUES (
   10,
   2673,
   'Art',
   'Advanced Basket Weaving',
   'Theortical design patterns of plant based recepticals',
   2,
   'Tap that Weave',
   'Spring',
   'W',
   '2019',
   'Chief Morale Officer Neelix',
   'www.tapdatweaver.com'
);

INSERT INTO course VALUES (
   11,
   5544,
   'History',
   'Quidditch Theory',
   'Survey of the complex history surrounding the magical sport of quidditch',
   3,
   'Broomstick Gods',
   'Fall',
   'MW',
   '2019',
   'Harry Potters Owl',
   'www.quidditchyfever.com'
);

INSERT INTO course VALUES (
   12,
   1200,
   'Space Transportation',
   'Advanced Warp Theory',
   'Advanced topics in warp drive designs and implementation',
   1,
   'Warp 10?',
   'Spring',
   'MWF',
   '2019',
   'Lieutenant Geordie LaForge',
   'www.warp10isnotaMYTHiveSEENit.com'
);

INSERT INTO user VALUES (
    1,
    'Megan',
    'Wong',
    100001,
    'mwong@student.ndnu.edu',
    '000000',
    'flickr.com',
    1,
    0,
    0,
    now()
);
INSERT INTO user VALUES (
    2,
    'Ahmed',
    'AlOtaibi',
    200001,
    'Ahmed@student.ndnu.edu',
    '111111',
    'flickr.com',
    1,
    0,
    0,
    now()
);
INSERT INTO user VALUES (
    3,
    'Marc',
    'Matas',
    300001,
    'Marc@student.ndnu.edu',
    '333333',
    'flickr.com',
    0,
    0,
    0,
    now()
);
INSERT INTO user VALUES (
    4,
    'Naomi',
    'Makovkin',
    400001,
    'Naomi@student.ndnu.edu',
    '444444',
    'flickr.com',
    0,
    0,
    0,
    now()
);
INSERT INTO user VALUES (
    5,
    'Martin',
    'Makovkin',
    500001,
    'Martin@student.ndnu.edu',
    '555555',
    'flickr.com',
    0,
    0,
    0,
    now()
);

INSERT INTO post VALUES (

1,
'World History Notes',
1,
now(),
'In Class we discussed the different components that steered the United States of America in World War II',
1,
0
);

INSERT INTO post VALUES (

2,
'World War II',
2,
now(),
'We talked about the bombing on Pearl Harbor and why this day was very important in World War II',
2,
0
);

INSERT INTO post VALUES (

3,
'Quantum Computing',
3,
now(),
'The use of quantum-mechanical phenomena such as superposition and entanglement to perform computation. A quantum computer is used to perform such computation, which can be implemented theoretically or physically.',
1,
0
);

INSERT INTO post VALUES (

4,
'Quantum Computing Notes',
3,
now(),
'A quantum computer is any device for computation that makes direct use of distinctively quantum mechanical phenomena, such as superposition and entanglement, to perform operations on data.',
2,
0
);

INSERT INTO post VALUES (

5,
'SkyFort Engineering',
4,
now(),
'The application of knowledge in the form of science, mathematics, and empirical evidence, to the innovation, design, construction, operation and maintenance of structures, machines, materials, software, devices, systems, processes, and organizations.',
2,
0
);

INSERT INTO post VALUES (

6,
'SkyFort',
4,
now(),
'Proper balance between structures will provide the best SkyFort',
2,
0
);

INSERT INTO post VALUES (

7,
'Palm Tree Design',
5,
now(),
'Shading is used in drawing for depicting levels of darkness on paper by applying media more densely or with a darker shade for darker areas, and less densely or with a lighter shade for lighter areas',
3,
0
);

INSERT INTO post VALUES (

8,
'Agricultural Design Class',
5,
now(),
'Light patterns, such as objects having light and shaded areas, help when creating the illusion of depth on paper.',
4,
0
);

INSERT INTO post VALUES (

9,
'Linear Contemplation 101',
6,
now(),
'The Transtheoretical Model (Prochaska & DiClemente, 1983; Prochaska, DiClemente, & Norcross, 1992) is an integrative, biopsychosocial model to conceptualize the process of intentional behavior change.',
2,
0
);

INSERT INTO post VALUES (

10,
'Linear Contemplation Notes',
6,
now(),
'Studies of change have found that people move through a series of stages when modifying behavior. While the time a person can stay in each stage is variable, the tasks required to move to the next stage are not.',
3,
0
);

INSERT INTO post VALUES (

11,
'Linear Contemplation',
6,
now(),
'Change implies phenomena occurring over time. Surprisingly, none of the leading theories of therapy contained a core construct representing time',
1,
0
);

INSERT INTO post VALUES (

12,
'Mathematics',
7,
now(),
'Linear algebra is the branch of mathematics concerning linear equations such as. linear functions such as. and their representations through matrices and vector spaces. Linear algebra is central to almost all areas of mathematics.',
2,
0
);

INSERT INTO post VALUES (

13,
'Mathematics Notes',
7,
now(),
'In mathematics, the Pythagorean theorem, also known as Pythagoras theorem, is a fundamental relation in Euclidean geometry among the three sides of a right triangle. It states that the square of the hypotenuse (the side opposite the right angle) is equal to the sum of the squares of the other two sides.',
1,
0
);

INSERT INTO post VALUES (

14,
'Calculus 4',
8,
now(),
'Calculus (from Latin calculus, literally small pebble, used for counting and calculations, as on an abacus) is the mathematical study of continuous change, in the same way that geometry is the study of shape and algebra is the study of generalizations of arithmetic operations.',
2,
0
);

INSERT INTO post VALUES (

15,
'Calc 4 Notes',
8,
now(),
'Differential calculus is one side of calculus, the part concerned with continuous change and its applications. By understanding derivatives the student has at his or her disposal a very powerful tool for understanding the behavior of mathematical functions.',
3,
0
);

INSERT INTO post VALUES (

16,
'Electrical Engineering',
9,
now(),
'Electrical engineering is one of the newer branches of engineering, and dates back to the late 19th century. It is the branch of engineering that deals with the technology of electricity.',
4,
0
);

INSERT INTO post VALUES (

17,
'Physics notes',
9,
now(),
'Electronics engineers analyze the requirements and costs of electrical systems. Electrical engineers design, develop, test, and supervise the manufacturing of electrical equipment, such as electric motors, radar and navigation systems, communications systems, or power generation equipment.',
2,
0
);

INSERT INTO post VALUES (

18,
'Art: Advanced Basket Weaving',
10,
now(),
'Basket weaving (also basketry or basket making) is the process of weaving or sewing pliable materials into two- or three dimensional artifacts, such as mats or containers',
1,
0
);

INSERT INTO post VALUES (

19,
'Advanced Basket Weaving',
10,
now(),
'Craftspeople and artists specialized in making baskets are usually referred to as basket makers and basket weavers.Basketry is made from a variety of fibrous or pliable materials—anything that will bend and form a shape.',
2,
0
);

INSERT INTO post VALUES (

20,
'Quidditch Theory',
10,
now(),
'Quidditch is a sport of two teams of seven players each mounted on broomsticks played on a hockey rink-sized pitch. It is based on a fictional game of the same name invented by author J. K. Rowling, which is featured in the Harry Potter series of novels and related media.',
3,
0
);

INSERT INTO post VALUES (

21,
'Space Transportation Notes',
10,
now(),
'NASA stands for National Aeronautics and Space Administration. NASA is a U.S. government agency that is responsible for science and technology related to air and space',
3,
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

INSERT INTO comment VALUES (
1,
1,
1,
    now(),
    now(),
'Thanks! Very helpful',
0
);

INSERT INTO comment VALUES (
2,
2,
1,
    now(),
    now(),
'Thumbs up!',
0
);

INSERT INTO comment VALUES (
3,
3,
1,
    now(),
    now(),
'You rock dude!',
0
);

INSERT INTO comment VALUES (
4,
4,
1,
    now(),
    now(),
'So tubular!',
0
);

INSERT INTO comment VALUES (
5,
5,
2,
    now(),
    now(),
'Your handwriting sucks, one star',
0
);

INSERT INTO comment VALUES (
6,
6,
2,
    now(),
    now(),
'take a shot everytime your notes are unreadable',
0
);

INSERT INTO comment VALUES (
7,
7,
2,
    now(),
    now(),
'Hey its me again, bet you thought youd never see me Ill have you know i was first in my class in the navy seals',
0
);

INSERT INTO comment VALUES (
8,
8,
2,
    now(),
    now(),
'Im really sorry for being mean',
0
);

INSERT INTO comment VALUES (
9,
9,
3,
    now(),
    now(),
'Thank you so much, I had to miss class for my snakes 3rd anniversary',
0
);

INSERT INTO comment VALUES (
10,
10,
3,
    now(),
    now(),
'My grandma broke her 3rd hip so it was really important that these notes be online, you da bomb',
0
);

INSERT INTO comment VALUES (
11,
11,
3,
    now(),
    now(),
'I wish I could have made it but Nelly Furtado had a concert and you know I cant miss that come on',
0
);

INSERT INTO comment VALUES (
12,
12,
3,
    now(),
    now(),
'Was too busy reading the comments on other notes so I missed class so sorry',
0
);

INSERT INTO comment VALUES (
13,
13,
4,
    now(),
    now(),
'I write really slow in class so this was very helpful',
0
);

INSERT INTO comment VALUES (
14,
14,
4,
    now(),
    now(),
'I was listening to Backstreet Boys during class so its really hard for me to pay attention, this was very helpful',
0
);

INSERT INTO comment VALUES (
15,
15,
4,
    now(),
    now(),
'Saw Britney with that snake at the concert last night, and I started having an existential crisis in class, so this was very helpful',
0
);

INSERT INTO comment VALUES (
16,
16,
4,
    now(),
    now(),
'I will try to pay better attention in class, but for now thank you for the notes',
0
);

INSERT INTO comment VALUES (
17,
17,
5,
    now(),
    now(),
'Oh man I was looking for a video of pancakes, but I ended up here by mistake, cool, 5 stars',
0
);

INSERT INTO comment VALUES (
18,
18,
5,
    now(),
    now(),
'I would rather be eating pancakes than looking at these notes, but I would rather look at these notes than being eaten by a raccoon, 5 stars',
0
);

INSERT INTO comment VALUES (
19,
19,
5,
    now(),
    now(),
'Seriously have you ever had pancakes with blueberry syrup, its really good, 5 stars',
0
);

INSERT INTO comment VALUES (
20,
20,
5,
    now(),
    now(),
'I swear I will quit pancakes after this semester, but they give me the strength to go on, 5 stars',
0
);

INSERT INTO comment_flag VALUES (
    1,
    1,
    1,
    now(),
    0,
    'Notes'
);

INSERT INTO enrolled VALUES (
1,
1
);
INSERT INTO enrolled VALUES (
2,
1
);
INSERT INTO enrolled VALUES (
3,
1
);
INSERT INTO enrolled VALUES (
4,
1
);
INSERT INTO enrolled VALUES (
5,
2
);
INSERT INTO enrolled VALUES (
6,
2
);
INSERT INTO enrolled VALUES (
7,
2
);
INSERT INTO enrolled VALUES (
8,
2
);
INSERT INTO enrolled VALUES (
1,
3
);
INSERT INTO enrolled VALUES (
2,
3
);
INSERT INTO enrolled VALUES (
9,
3
);
INSERT INTO enrolled VALUES (
10,
3
);
INSERT INTO enrolled VALUES (
3,
4
);
INSERT INTO enrolled VALUES (
4,
4
);
INSERT INTO enrolled VALUES (
5,
4
);
INSERT INTO enrolled VALUES (
6,
4
);
INSERT INTO enrolled VALUES (
7,
5
);
INSERT INTO enrolled VALUES (
8,
5
);
INSERT INTO enrolled VALUES (
9,
5
);
INSERT INTO enrolled VALUES (
10,
5
);
INSERT INTO enrolled VALUES (
11,
1
);
INSERT INTO enrolled VALUES (
12,
2
);
INSERT INTO enrolled VALUES (
11,
3
);
INSERT INTO enrolled VALUES (
12,
4
);