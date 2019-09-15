<h1> Steps on how to run and test the address book api </h1>

<b> Assumptions: </b>

1) Project has been successfully forked/cloned from github
2) Java 8 is installed and working on your machine
3) Maven is installed and working on your machine
3) No other applications are running on port 8080


<b> Notes on the application </b>

Very Basic test data has been created in the SpringBoot Main class (AddressbookApplication.java)
This will allow you to search for 3 Customers - "Smith", "Adams" and "Scott"

<h3> Running the application </h3>
1) <b>Create the artifact</b>

 From a Terminal navigate to the root directory of the project 

 Run the command 'mvn clean compile package'

 This will generate an executable jar in the <b>target</b> directory called <b>addressbook-0.0.1.jar</b>

2)<b>Running the Application</b>

 In Terminal navigate to the target directory

 Run the generated executable jar using <b> java -jar addressbook-0.0.1.jar </b>

 The endpoint can be accessed via a browser or api testing tool like Postman using the following endpoint <b> http://localhost:8080/addressbook/api/v1/customer/Smith </b>
 
 As mentioned above Adams and Scott will also return valid data.

