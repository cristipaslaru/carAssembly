package assembly;

import car.AssemblyCarEntity;
import car.Car;
import stations.Chain;


public class AssemblyLine {

    public Car produce(AssemblyCarEntity assemblyCarEntity) {
        Chain.start().apply(assemblyCarEntity);
        return assemblyCarEntity.getCar();
    }
}
