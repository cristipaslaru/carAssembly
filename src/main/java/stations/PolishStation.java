package stations;


import car.AssemblyCarEntity;

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
    public void apply(AssemblyCarEntity assemblyCarEntity) {
        assemblyCarEntity.polish();
        Chain.next(getInstance()).apply(assemblyCarEntity);
    }
}
