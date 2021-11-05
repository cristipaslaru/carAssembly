package stations;

import car.AssemblyCarEntity;

public class AssemblyMechanichStation extends Station{

    private static AssemblyMechanichStation assemblyMechanichStation;

    private AssemblyMechanichStation(){}

    public static AssemblyMechanichStation getInstance(){
        if(assemblyMechanichStation==null){
            assemblyMechanichStation = new AssemblyMechanichStation();
        }
        return assemblyMechanichStation;
    }

    @Override
    public void apply(AssemblyCarEntity assemblyCarEntity){
        assemblyCarEntity.assemblyMechanich();
        Chain.next(getInstance()).apply(assemblyCarEntity);
    }
}
