# cs4900-Emberlights-API
## Overview
This project serves as the API for Off-the-Charts, an app for creating and curating randomized playlists by genre to help listeners find new music. See the main project repository here: [Off-the-Charts](https://github.com/Mizeress/cs4900-Emberlights)

## Required Tools
- Java 17
- Docker
- Spring 3.5.16
- Vscode w/Spotless and Java extensions (for convenience)
- Bruno (for testing API endpoints)

## How to Run the API
- Ensure the database is running
  - [Database folder](db/)
- Go to the Debug and Run tab in VS Code and run the MariaDB run configuration

## How to Test
- Check supported endpoints
  - [Api Definitions](homework/api-definitions/api-routes.md)
- Test running these endpoints
  - [Bruno Collection](Bruno/)
- The database is prepopulated with sample data. To get started, test the get all methods for each entity and ensure they return something. Then, test getting these entities by ID. Afterwards, POST and PUT requests may be tested, ensuring the PUT updates an object that already exists. Finally, test the endpoints more unique to this api - random song, multirandom song, and the search endpoints to ensure they return their expected result. 
