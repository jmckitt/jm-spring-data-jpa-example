# Raffle


== Compilation and Getting Started ==

This project was compiled and tested on an Ubuntu 16.04-based system utilizing Oracle JDK 9.0.4+11 x64.

Compilation can be accomplished by running the Maven command from the root project folder for systems with an existing Maven installation on the path.

<PRE>mvn clean package</PRE>

Alternatively in systems without Maven, the built-in scripts may be used.  For example on Linux from the project root, one would run <PRE>./mvnw clean package</PRE>



== Usage ==

Launch the project by running <PRE>java -jar raffle-0.0.1-SNAPSHOT.jar</PRE>

H2 Control Panel:  http://localhost:8080/h2-console<BR/>
    -The JDBC URL is: jdbc:h2:mem:testdb<BR/>
    -All other defaults leave in place, i.e. user: SA, password: <leave blank><BR/>

Swagger-UI: http://localhost:8080/swagger-ui

==== APIs ===

The APIs are illustrated using Swagger.

To use the raffle<BR/>
        -at least one user should be created via the createUser method.<BR/> 
        -at least one raffle ticket must be created for a valid user via createTicket<BR/>
        -createRaffle will return a JSON representation of the raffle based on the previous steps<BR/>
        

<B>Known Limitations:</B>  Further refinement is required to the SQL query embedded within raffle/src/main/java/com/example/raffle/repository/CustomTicketRepository.java
to enforce the rule that a single user may only win a total of two times overall.  The SQL query also does not handle the selection of multiple users in the case of a tie,
though repeated raffles will eventually cycle through all matches.
<BR/>
Only basic error handling and logging is in place.


