run: FlightMapper.class
	java FlightMapper

FlightMapper.class: FlightMapper.java FlightMapperBackend.class FlightMapperFrontend.class PlaneMapperLoader.class AE_Dijkstra.class
	javac FlightMapper.java

FlightMapperBackend.class: FlightMapperBackend.java
	javac FlightMapperBackend.java

FlightMapperFrontend.class: FlightMapperFrontend.java
	javac FlightMapperFrontend.java

PlaneMapperLoader.class: PlaneMapperLoader.java
	javac PlaneMapperLoader.java

runTests: runFrontendDeveloperTests runBackendDeveloperTests runAlgorithmEngineerTests runDataWranglerTests

runBackendDeveloperTests: BackendDeveloperTests.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=BackendDeveloperTests

BackendDeveloperTests.class: FlightMapperBackend.java BackendDeveloperTests.java FlightsPlaceholderBackend.class PlacePlaceholderBackend.class
	javac -cp .:junit5.jar BackendDeveloperTests.java

FlightsPlaceholderBackend.class: FlightsPlaceholderBackend.java
	javac FlightsPlaceholderBackend.java

PlacePlaceholderBackend.class: PlacePlaceholderBackend.java
	javac PlacePlaceholderBackend.java

runAlgorithmEngineerTests: AE_Dijkstra.class AlgorithmEngineerTests.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=AlgorithmEngineerTests

AE_Dijkstra.class: AE_Dijkstra.java
	javac AE_Dijkstra.java

AlgorithmEngineerTests.class: AlgorithmEngineerTests.java
	javac -cp .:junit5.jar AlgorithmEngineerTests.java

runFrontendDeveloperTests: FlightMapperFrontendTest.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=FlightMapperFrontendTest     

FlightMapperFrontendTest.class: TextUITester.class FlightMapperFrontendTest.java FlightMapperFrontend.class
	javac -cp .:junit5.jar FlightMapperFrontendTest.java

TextUITester.class: TextUITester.java
	javac TextUITester.java

FlightMapperFrontend.class: FDFlightMapperBackend.class FlightMapperFrontend.java
	javac FlightMapperFrontend.java

FDFlightMapperBackend.class: FDFlightMapperBackend.java
	javac FDFlightMapperBackend.java

runDataWranglerTests: DataWranglerTests.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=DataWranglerTests

DataWranglerTests.class: DataWranglerTests.java Flights.java PlaneMapperLoader.java
	javac -cp .:junit5.jar  DataWranglerTests.java

Flights.class: Flights.java
	javac Flights.java

PlaneMapperLoader.class: PlaneMapperLoader.java
	javac PlaneMapperLoader.java

clean:
	rm *.class