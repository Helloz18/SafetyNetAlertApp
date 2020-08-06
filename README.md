# SafetyNetAlerts

Application for rescue. It gives informations about people through endPoints.
For now, only the backEnd is set.
The data used are in data.json file. (no database).

## Getting Started

This is a spring-boot application.

### Prerequisites

- Java 1.8
- Maven 3.6.2


### Endpoints and Urls examples

http://localhost:8080/firestation
This endpoint will allow to add, delete and update a firestation.

http://localhost:8080/person
This endpoint will allow to add, delete and update a person.

http://localhost:8080/medicalRecord
This endpoint will allow to add, delete and update a medicalRecord.

http://localhost:8080/firestation?stationNumber=<station_number>
--> This url will return a list of people supervised by a station number.
The response will be returned in json format.

The other Urls available 
http://localhost:8080/childAlert?address=<address>
http://localhost:8080/fire?address=<address>
http://localhost:8080/phoneAlert?firestation=<firestation_number>
http://localhost:8080/flood/stations?stations=<a list of station_numbers>
http://localhost:8080/personInfo?firstName=<firstName>&lastName=<lastName>
http://localhost:8080/communityEmail?city=<city>


### Tests

Unit tests are written, they can be execute with maven with this command :
`mvn test`

A jacoco and a surefire report will be available.