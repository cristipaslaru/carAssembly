package stations;

import car.AssemblyCarEntity;


public class QAStation extends Station{

    private static QAStation qaStation;

    private QAStation(){}

    public static QAStation getInstance(){
        if(qaStation==null){
            qaStation=new QAStation();
        }
        return qaStation;
    }
    @Override
    public void apply(AssemblyCarEntity assemblyCarEntity){
        assemblyCarEntity.build();
    }
}
