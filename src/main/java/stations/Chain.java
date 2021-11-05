package stations;

public class Chain {

    public static Station next(Station currentStation) {
        if (currentStation instanceof PaintStation) {
            return AssemblyMechanichStation.getInstance();
        } else if (currentStation instanceof AssemblyMechanichStation) {
            return AssemblyInteriorStation.getInstance();
        } else if (currentStation instanceof AssemblyInteriorStation) {
            return PolishStation.getInstance();
        } else {
            return QAStation.getInstance();
        }
    }

    public static Station start() {
        return PaintStation.getInstance();
    }
}
