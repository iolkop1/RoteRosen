## Pension Rote Rosen

Website for viewing and reservations at pension rote rosen. A guest user can visit the site, view the photo gallery and learn about the accomodation and eventualy make a reservation for a certain date. The guest is going to be notified when the reservation date approaches. For changing the prices and the info about the location an admin mode is available.

## Features

- View photo gallery
- Info page about location & other attractions nearby.
- Reservation form
- Admin BO acces

## Endpoints

POST /addRoom (/addGuest..)
Adds a new room with the given description and price per night.

GET /findRoomById/{id}
Retrieves the room with the specified ID.

PUT /update
Updates the description of a room with the given ID.

DELETE /delete/{id}
Deletes the room with the specified ID.

## Tech

- Java spring

![image](https://user-images.githubusercontent.com/128998426/236702748-cbb055c2-afca-47cc-a013-5922b96f5ebd.png)
