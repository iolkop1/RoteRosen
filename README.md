## Pension Rote Rosen

Website for viewing and reservations at pension rote rosen. A guest user can visit the site, view the photo gallery and learn about the accomodation and eventualy make a reservation for a certain date. The guest is going to be notified when the reservation date approaches. For changing the prices and the info about the location an admin mode is available.

## Features

- View photo gallery
- Info page about location & other attractions nearby.
- Reservation form
- Admin BO acces (TD)

## OBSERVERS

Within our Java BootSpring application, we have implemented a robust observer pattern to enhance user interaction and provide timely notifications. The implementation includes three key observers that significantly improve the user experience.

Reservation Observer:
Description: Notifies when a new reservation is made.

## JUNIT TESTING :

To ensure the reliability and easy maintenance of our code, we conducted comprehensive JUnit testing for the service classes in our application. All methods were thoroughly tested using the Mockito library, which allowed us to mock objects and dependencies and make assertions about the code's behavior. By writing these tests, we were able to identify and resolve issues early in the development process, saving time and effort in the long run. JUnit tests were created for all classes containing business logic.

## Endpoints

POST /addRoom (/addGuest..)
Adds a new room with the given description and price per night.

GET /findRoomById/{id}
Retrieves the room with the specified ID.

PUT /update
Updates the description of a room with the given ID.

DELETE /delete/{id}
Deletes the room with the specified ID.

POST /addReservation
Adds a new reservation with the provided details.

POST /addGuest
Adds a new guest with the provided name and email.

GET /findGuestById/{id}
Retrieves a certain guest by their ID.

DELETE /deleteGuest/{id}
Deletes a guest by their ID.

## Tech

- Java spring

![image](https://user-images.githubusercontent.com/128998426/236702748-cbb055c2-afca-47cc-a013-5922b96f5ebd.png)
