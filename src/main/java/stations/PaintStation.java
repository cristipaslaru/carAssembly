package stations;

import car.AssemblyCarEntity;

public class PaintStation extends Station{

    private static PaintStation paintStation;

    private PaintStation(){}

    public static PaintStation getInstance(){
        if(paintStation==null){
            paintStation = new PaintStation();
        }
        return paintStation;
    }

    @Override
    public void apply(AssemblyCarEntity assemblyCarEntity) {
        assemblyCarEntity.paint();
        Chain.next(getInstance()).apply(assemblyCarEntity);
    }
}
