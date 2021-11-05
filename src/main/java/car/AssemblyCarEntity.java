package car;


import exception.NoSpecsException;

public class AssemblyCarEntity {

    private Car car = new Car();
    private final Specs specs;

    public AssemblyCarEntity(Specs specs) {
        this.specs = specs;
    }

    public void paint() throws NoSpecsException {
        if(specs.getColor()==null){
            throw new NoSpecsException("Color not found");
        }
        car.setColor(specs.getColor());
    }

    public void assemblyMechanic() throws NoSpecsException {
        MechanicParts mechanicParts = specs != null ? specs.getMechanicParts() : null;
        if (mechanicParts == null) {
            throw new NoSpecsException("MechanicParts not found");
        }
        car.setMechanicParts(mechanicParts);
    }

    public void assemblyInterior() throws NoSpecsException {
        InteriorParts interiorParts = specs != null ? specs.getInteriorParts() : null;
        if (interiorParts == null) {
            throw new NoSpecsException("InteriorParts not found");
        }
        car.setInteriorParts(interiorParts);
    }

    public void polish() {
        car.setPolish(true);
    }

    public void build() {
        car.setAccepted(isColorValid() && isMechanicalValid() && isInteriorValid());
    }

    private boolean isColorValid() {
        return car.getColor() != null;
    }

    private boolean isMechanicalValid() {
        MechanicParts mechanicParts = car.getMechanicParts();
        return mechanicParts != null && mechanicParts.getAutonomy() != null && mechanicParts.getBattery() != null && mechanicParts.getHorsePower() != null;
    }

    private boolean isInteriorValid() {
        InteriorParts interiorParts = car.getInteriorParts();
        return interiorParts != null && interiorParts.getInteriorColor() != null && interiorParts.getLeather() != null && interiorParts.getDisplaySize() != null;
    }

    public Car getCar() {
        return car;
    }

    //used for retry
    public void setCar(Car car) {
        this.car = car;
    }
}
