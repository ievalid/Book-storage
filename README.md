# Book-storage

Used Spring Boot and H2 database.

In order to run the application, please make sure that you will be using Java 11.

I have created an executable jar file, which is in

estate/out/artifacts/storage_jar/storage.jar

Script to execute app:

java -jar PATH_TO_JAR

where PATH_TO_JAR is to the storage.jar

---

If in any case that wouldn't work, you may always run this with Intellij IDEA.

Import project by right clicking on pom.xml file and opening with Intellij.

After project is loaded, select "Maven" on the right side, --> Plugins --> spring-boot --> spring-boot:run

Or you may run the appliction from the main class (StorageApplication.java)

If app is successfully running, please open browser of your choice and navigate to

http://localhost:8080/books
Default port may differ (8080), please adjust as needed.

In this application you may do simple CRUD operations with books.