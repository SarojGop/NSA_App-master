# NSA_App
NSA_TTU

                                                     Texas Tech University
                                      Computer Science Department - Software Engineering
                                                                                                                  Date: Feb 14, 2020
                                                    NSA Ride Sharing App
Team Members: Bimal Karki, Bipin Chhetri, Saroj Gopali, Subash Subedi
Project Goal:
The Project Goal is to provide An Easy to access ride sharing platform for the students going home. In short it is an Android Application which provides a communication between the person who has ride and on the other hand who requires one. The Initial idea for the development of the project is keeping under the facts that Some Students do not have access to Transportation on the way home and need to wait long period of time. However, Some Students are on their ride and despite having the common destination have no means to give them a ride. NSA Android application is developed on this incident basis. The app will create a communication between rider and the one who requests it providing an easy ride access.
Users of the Application:
The name of the application NSA refers to Nepalese Student Association which is a club in Texas Tech University and initial focus of the application is within the Nepalese group so there will be an easy understanding between the community of the same group. After the successful test of the application the app can further be extended to students form all background within the college area. The application is created only for students signing up with a Texas tech official Email address. The person who requires ride sign up the app using their Texas tech email and then after successful creation requires a ride. Similarly, the person who has ride also creates an account and if there are any ride requests, he/she will accept it depending upon the destination is where he/she is going or is willing to drop the rider requestor. The Application is Entirely voluntary, and no fee is charged or requested.
 
Use Case Specifications
NSA Ride Sharing Application: 
The admin of the system stores the email ID and phone number of the costumer when they request for the ride using our mobile application. If the costumer hasn’t registered for the system yet, then they will be redirected to the registration page where they will be required to put their full name, email, and phone number. As this system is totally designed for the volunteering purpose, there won’t be any charges for the costumer, which in this case are the Nepalese Student at Texas Tech. There will be separate page for the driver login and the costumer login which will be the convenient way for using the app. Our use case will contain the Login option, Request option, Match option, Accept option.
Use Case Name: Ride Sharing 
Actors:
•	Costumer (Specifically, Nepalese Student at Texas Tech)
•	Admin (Our group of four students who will be handling all the data of driver and costumer using the Firebase.)
Triggers:
•	The costumer needs to login through our app
•	The costumer wants the ride by opening our mobile app.
Preconditions:
•	Check if there is any driver available around them or not.
Postconditions:
•	The driver needs to logout from the current ride after dropping the costumer
Normal Flow:
•	The costumer will need to put login information to request for the ride
•	They will be logged in if and only if the information they provided match the admin’s database.
•	If the costumer is new in our app, they will need to sign up using Register option.
•	After logging in through our app, the costumer will be redirected to the google map where they need to provide the drop off location.
•	The system will search for the drivers available around the costumer.
•	The driver will then press the accept request bottom to complete the ride.
•	The driver will pick up from the customer location and will drop them to their destination.
•	The system will then ask for the driver rating in the costumer account.
•	The history of the costumer ride will be recorded inside the Ride history option in costumer account.





Work Distribution:
Login Option: 
Saroj Gopali is working to build the login option for the driver and costumer. He has created the app in such a way that both costumer and driver will need to fill the sign up information in order to get registered on our system.

Request option:
 This work is done by Subash Subedi. After the costumer is successfully logged in through our system, they will be redirected to the google map where they need to provide the destination area. After that, the system will look for the nearest driver available.

Match Option:
Bimal Karki is assigned for this task. He will design the app in such a way that there should be driver available around the area. Only in that case, the driver will accept the request and will pick up the costumer. If the system can’t find any driver, then it will print no driver available in costumer account.

Accept Option:
Bipin Chhetri is assigned for the task. The system will look for the driver available, and only after that there will be an accept option available for the driver. The driver will pick up the costumer from their area and will drop them to the destination area. The driver will then logout from the current ride option. He will also design the option for the driver review and costumer ride history in costumer account.


