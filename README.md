# robot
This project is about the survivors information.
To setup the project, follow the below steps
1.Checkout the code from github.
2.Run the sql(src\main\resources\dbHistory\create_tables.sql) in the DB.
3.Update the username, password in application.properties.
4.To sort the robots by key, modify the robot.sort.key in application.properties
5.Build the jar and run it.
6.API endpoints in below provides the survivors and robots information,
http://localhost:8080/robots/survivors/infectedPer				
http://localhost:8080/robots/survivors/nonInfectedPer
http://localhost:8080/robots/survivors/infected					
http://localhost:8080/robots/survivors/nonInfected
http://localhost:8080/robots/all								

