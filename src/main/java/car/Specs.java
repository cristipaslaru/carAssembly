package car;

public class Specs {

    private String color;
    private MechanicParts mechanicParts;
    private InteriorParts interiorParts;

    public Specs(String color, MechanicParts mechanicParts, InteriorParts interiorParts) {
        this.color = color;
        this.mechanicParts = mechanicParts;
        this.interiorParts = interiorParts;
    }

    public String getColor() {
        return color;
    }

    public MechanicParts getMechanicParts() {
        return mechanicParts;
    }

    public InteriorParts getInteriorParts() {
        return interiorParts;
    }

}
