#Avalanche homework
This project is a full-stack application made for an assignment.

It's a calculator that sends the user input to the backend service,
saves the user query with the result and returns an answer

##Frontend
Frontend is built with react. 

To run it locally, cd into the frontend folder and run *npm run start*.

##Backend
Backend is built on spring. It uses a local H2 database connection to
store past calculations. I chose to use mybatis, even though it's a bit
overkill for this application, because it was faster to set it up as I
have worked with it before and didn't feel like I could remind myself
of all the datasource and JPA logic in time.

To run it locally, simply run it with *gradle bootRun* task or build the
project with *gradle build* and execute the jar in the build folder.

##Sonarqube
I ran sonarqube on the project and fixed the vulnerabilities and code
smells that it found for me. Unfortunately as of now I haven't gotten around
to finding the logic behind code coverage and a 0% code coverage is failing
the quality gate. Even though I have written unit tests.