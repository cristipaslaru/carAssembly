package stations;

import car.AssemblyCarEntity;
import exception.NoSpecsException;

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
    public void apply(AssemblyCarEntity assemblyCarEntity) throws NoSpecsException {
        assemblyCarEntity.paint();
        Chain.next(getInstance()).apply(assemblyCarEntity);
    }
}
