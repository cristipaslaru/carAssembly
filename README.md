Car Assembly code base

The project contains:
  - AssemblyLine
  - AssemblyCarEntity
  - Car
  - Stations
  - Exception
  
I have added the following classes:
  - Specs - I am storing Car specifications before to be created
  - InteriorParts - Interior details
  - MechanicParts - Mechanic details
  
Stations:
  - PaintStation
  - MechanichStation
  - InteriorStation
  - PolishStation
  - QaStation
    
Station - an abstract class that is extend by all the stations.

Chain - return next station.

NoSpecsException - throwing when we don't receive specs.

Execution:
  - No java main.
  - you can execute the unit tests. (AssemblyLineTest.java)
