# api
Backend
=======
Team Members and their tables:
- Ahmed: User
- Megan: Post
- Naomi: Course + commentsFlag
- Martin: Comments
- Marc: Attachments
- Nadege: post_flag
- Jack:

Tables needs to be built:
- comment_rank
- enrolled
- post_rank                         

Packages:
- service: com.notefinder.service
- controller: com.notefinder.controllers
- model: com.notefinder.models
- dao: com.notefinder.dao

JSON Examples:

- LANDING PAGE:
[ 
	{
   		"id": 1,
   		"submission_course_name": "Math 101",
   		"submission_title": "Quiz Review",
   		"submission_date": "timeStamp"
 	},
 	{
   		"id": 2,
   		"submission_course_name": "Math 101",
   		"submission_title": "Quiz Review",
   		"submission_date": "timeStamp"
 	},
 	{
   		"id": 3,
   		"submission_course_name": "Math 101",
   		"submission_title": "Quiz Review",
   		"submission_date": "timeStamp"
 	}
]

-------

- LOGGED IN (USER’S HOME PAGE FOR THE FIRST TIME):
Courses enrolled in:

[
  {
    "id": 1,
    "instructor": "John",
    "classTitle": "Math 101",
    "meetingDay": "F"
  },
  {
    "id": 2,
    "instructor": "John",
    "classTitle": "History 101",
    "meetingDay": "TF"
  },
  {
    "id": 3,
    "instructor": "John",
    "classTitle": "Religion 101",
    "meetingDay": "W"
  }
]

-------

- Showing your recent submissions:

[
 {
   "id": 2,
   "submission_course_name": "Math 101",
   "submission_title": "Quiz Review",
   "submission_date": "03/22/2019",
   "submission_time_class_meets": "Fidays, 6:00 PM",
   "submission_link": "nameOfAttachment.pdf",
   "submission_flag": "No Flag"
 },
 {
   "id": 3,
   "submission_course_name": "CS 101",
   "submission_title": "Last Class notes",
   "submission_date": "03/25/2019",
   "submission_time_class_meets": "Thu., 6:00 PM",
   "submission_notes": "These are the notes from last week's class",
   "submission_link": "nameOfAttachment.pdf",
   "submission_flag": "No Flag"
 },
 {
   "id": 4,
   "submission_course_name": "Art 101",
   "submission_title": "Lecture Notes",
   "submission_date": "03/27/2019",
   "submission_time_class_meets": "Tue., 6:00 PM",
   "submission_notes": "Attaching a PDF file",
   "submission_link": "nameOfAttachment.pdf",
   "submission_flag": "No Flag"
 }
]

-------

- Course Page: 
(when user clicks on a course, shows all the notes of that course)
[
	{
		"id": 1,
		"postName":"aaaaa",
		"postTitle":"aaaaa",
		"postDate":"1/1/2019",
		"author":"John",
		"post_Description":"askdjfjksaflaskdf",
		"commentNumber":12,
		"flagged": false
	},
	{
		"id": 2,
		"postName":"aaaaa",
		"postDate":"1/1/2019",
		"author":"John",
		"post_Description":"askdjfjksaflaskdf",
		"commentNumber":12,
		"flagged": false
	},
]

-------

- VIEW POST PAGE:

[
	{
    	"id":1,
    	"title":"Question #5 Solution",
    	"course_name":"CIS-2885 Senior Project",
    	"class_date":"1/1/2019",
    	"post_created_date":"1/2/2019",
    	"post_modified_date":"1/2/2019",
    	"note":"Hello Everyone, Here is the answer of Q4",
    	"user":"John",
	"comment": [
    		{
    			"id": 1
        		"text":"message of comment",
        		"postDate":"1/2/2019",
        		"author":"John"
    		},
    		{
    			"id": 2
        		"text":"message of comment",
        		"postDate":"1/2/2019",
        		"author":"John"
    		},
    		{
    			"id": 3
        		"text":"message of comment",
        		"postDate":"1/2/2019",
        		"author":"John"
    		}
    	],
	"attached"
    	"flagged": false
	}
]

-------

- Profile page:
[
  {
    "id": 548670,
    "user_name": "Peter Jackson",
    "user_id": 548670,
    "email": "roberto.jlopez@gmail.com",
    "Password": 123456,
    "Security_Level": "Student",
    "message": "Todays classroom notes for Web Prg class",
    "Dept": "CSC",
    "enrolled_course_section": 2278,
    "enrolled_course_name": "Web Prg II:Srv",
    "Staus": "Current",
    "post_title": "Quantum Computing First Day Notes",
    "post_professor": "Youssefi",
    "post_course_section": 2278,
    "post_course_name": "Web Programming II - Server  Side",
    "Date_Posted": "Janurary 19,2019",
    "Media_Type": "Text Document"
  }
]

