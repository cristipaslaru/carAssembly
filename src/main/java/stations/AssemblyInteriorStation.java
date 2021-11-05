package stations;

import car.AssemblyCarEntity;
import exception.NoSpecsException;

public class AssemblyInteriorStation extends Station{

    private static AssemblyInteriorStation assemblyInteriorStation;

    private AssemblyInteriorStation(){}

    public static AssemblyInteriorStation getInstance(){
        if(assemblyInteriorStation==null){
            assemblyInteriorStation = new AssemblyInteriorStation();
        }
        return assemblyInteriorStation;
    }

    @Override
    public void apply(AssemblyCarEntity assemblyCarEntity) throws NoSpecsException {
        assemblyCarEntity.assemblyInterior();
        Chain.next(getInstance()).apply(assemblyCarEntity);
    }
}
