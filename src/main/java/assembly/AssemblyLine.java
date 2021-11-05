package assembly;

import car.AssemblyCarEntity;
import car.Car;
import exception.NoSpecsException;
import stations.Chain;


public class AssemblyLine {

    public Car produce(AssemblyCarEntity assemblyCarEntity) throws NoSpecsException {
        Chain.start().apply(assemblyCarEntity);
        return assemblyCarEntity.getCar();
    }
}
