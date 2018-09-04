# DEMO API
Here's a demo of a RESTFUL API, utilizing Lambda Expressions, Parallel Streams and Spring Boot. Test driven development concepts have been utilized along with complete a Javadoc, describing each method and class. Everything implemented in a single afternoon for a Hackathon challenge.
I've also built a SOAP API for example's sake in case a contract-driven webservice ever needs to be implemented :)

Prints can be found in the file Relevant Prints.pdf

# services
This API has 6 services as listed bellow:
 - fetchAllCourriers, which gets all courriers
 - fetchAllActiveCourriers, which gets all courriers who are active
 - updateCourrier, which updates an existing courrier
 - addCourrier, which inserts a new courrier
 - fetchCourrierById, which gets a specific courrier
 - deleteCourrier, which deletes a specific courrier

# documentation
This project implements Springfox's Swagger UI for generating documentation by way of annotations, which can be seen on:
 - http://localhost:8080/swagger-ui.html
