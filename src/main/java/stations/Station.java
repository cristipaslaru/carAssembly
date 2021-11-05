package stations;

import car.AssemblyCarEntity;
import exception.NoSpecsException;

public abstract class Station {

    public abstract void apply(AssemblyCarEntity assemblyCarEntity) throws NoSpecsException;
}
