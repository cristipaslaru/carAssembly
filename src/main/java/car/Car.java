package car;


public class Car {

    private String color;
    private MechanicParts mechanicParts;
    private InteriorParts interiorParts;
    private Boolean recall;
    private Boolean polish;
    private Boolean isAccepted;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public MechanicParts getMechanicParts() {
        return mechanicParts;
    }

    public void setMechanicParts(MechanicParts mechanicParts) {
        this.mechanicParts = mechanicParts;
    }

    public InteriorParts getInteriorParts() {
        return interiorParts;
    }

    public void setInteriorParts(InteriorParts interiorParts) {
        this.interiorParts = interiorParts;
    }

    public void setRecall(Boolean recall) {
        this.recall = recall;
    }

    public Boolean getRecall() {
        return recall;
    }

    public Boolean getPolish() {
        return polish;
    }

    public void setPolish(Boolean polish) {
        this.polish = polish;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        if (this.isAccepted != null && !this.isAccepted && accepted) {
            this.recall = true;
        }
        isAccepted = accepted;
    }

}
