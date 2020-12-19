-----------------------------------------

AddStudent

http://localhost:9097/Student

````json
{
  "name" : "Abhishek",
  "rollNumber" : 1,
  "subject" : [
    {
      "subjectName" : "Computer"
    }
  ]
}
````


````json
{
  "id": "5fde39079bdde259e9592575",
  "name": "Abhishek",
  "rollNumber": "1",
  "subject": [
    {
      "subjectName": "Computer"
    }
  ]
}
````
---------------------------------------------

GetAllStudent

http://localhost:9097/Student

GetStudentById

http://localhost:9097/Student/5fde39079bdde259e9592575


----------------------------------------------------

UpdateStudent

````json
{
    "name" : "Abhishek",
    "rollNumber" : 2,
    "subject" : [
        {
            "subjectName" : "Electronics"
        }
    ]
}
````

````json
{
    "id": "5fde39079bdde259e9592575",
    "name": "Abhishek",
    "rollNumber": "2",
    "subject": [
        {
            "subjectName": "Electronics"
        }
    ]
}
````


http://localhost:9097/Student/5fde39079bdde259e9592575


