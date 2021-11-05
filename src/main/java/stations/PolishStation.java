package stations;


import car.AssemblyCarEntity;
import exception.NoSpecsException;

public class PolishStation extends Station{

    private static PolishStation polishStation;

    private PolishStation(){}

    public static PolishStation getInstance(){
        if(polishStation==null){
            polishStation = new PolishStation();
        }
        return polishStation;
    }


    @Override
    public void apply(AssemblyCarEntity assemblyCarEntity) throws NoSpecsException {
        assemblyCarEntity.polish();
        Chain.next(getInstance()).apply(assemblyCarEntity);
    }
}
