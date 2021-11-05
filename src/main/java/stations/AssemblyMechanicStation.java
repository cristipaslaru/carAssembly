package stations;

import car.AssemblyCarEntity;

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
    public void apply(AssemblyCarEntity assemblyCarEntity){
        assemblyCarEntity.assemblyMechanich();
        Chain.next(getInstance()).apply(assemblyCarEntity);
    }
}
