package stations;

import car.AssemblyCarEntity;
import exception.NoSpecsException;

public class AssemblyMechanicStation extends Station{

    private static AssemblyMechanicStation assemblyMechanichStation;

    private AssemblyMechanicStation(){}

    public static AssemblyMechanicStation getInstance(){
        if(assemblyMechanichStation==null){
            assemblyMechanichStation = new AssemblyMechanicStation();
        }
        return assemblyMechanichStation;
    }

    @Override
    public void apply(AssemblyCarEntity assemblyCarEntity) throws NoSpecsException {
        assemblyCarEntity.assemblyMechanic();
        Chain.next(getInstance()).apply(assemblyCarEntity);
    }
}
