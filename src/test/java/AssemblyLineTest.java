import assembly.AssemblyLine;
import car.*;
import exception.NoSpecsException;
import org.junit.Assert;
import org.junit.Test;

public class AssemblyLineTest {

    @Test
    public void testCar() throws NoSpecsException {
        MechanicParts mechanicParts = createMechanicParts(500, 150, "55kw");
        InteriorParts interiorParts = createInteriorParts(false, 10, "white");
        Car car = createCar("dark", mechanicParts, interiorParts, null);
        Assert.assertNotNull(car);
        Assert.assertTrue(car.getAccepted());
        Assert.assertFalse(car.getInteriorParts().getLeather());
    }

    @Test()
    public void testRecallStation() throws NoSpecsException {
        MechanicParts mechanicParts = createMechanicParts(null, 150, "55kw");
        InteriorParts interiorParts = createInteriorParts(false, 10, "white");
        Car car = createCar("dark", mechanicParts, interiorParts, null);
        Assert.assertFalse(car.getAccepted());
        mechanicParts = createMechanicParts(250, 150, "55kw");
        car = createCar("dark", mechanicParts, interiorParts, car);
        Assert.assertNotNull(car);
        Assert.assertTrue(car.getAccepted());
        Assert.assertTrue(car.getRecall());
    }

    @Test()
    public void testColor() throws NoSpecsException {
        MechanicParts mechanicParts = createMechanicParts(null, 150, "55kw");
        InteriorParts interiorParts = createInteriorParts(true, 10, "white");
        Car car = createCar("dark", mechanicParts, interiorParts, null);
        Assert.assertFalse(car.getAccepted());
        Assert.assertNotNull(car.getInteriorParts());
        Assert.assertNotNull(car.getMechanicParts());
        Assert.assertEquals("dark", car.getColor());
    }

    @Test()
    public void testMechanicParts() throws NoSpecsException {
        MechanicParts mechanicParts = createMechanicParts(600, 150, "55kw");
        InteriorParts interiorParts = createInteriorParts(null, 10, "white");
        Car car = createCar("dark", mechanicParts, interiorParts, null);
        Assert.assertFalse(car.getAccepted());
        Assert.assertNotNull(car.getMechanicParts());
        Assert.assertNotNull(car.getInteriorParts());
        Assert.assertEquals(600, (int) car.getMechanicParts().getAutonomy());
        Assert.assertEquals(150, (int) car.getMechanicParts().getHorsePower());
        Assert.assertEquals("55kw", car.getMechanicParts().getBattery());
    }

    @Test()
    public void testInteriorParts() throws NoSpecsException {
        MechanicParts mechanicParts = createMechanicParts(null, 450, "75kw");
        InteriorParts interiorParts = createInteriorParts(true, 10, "white");
        Car car = createCar("dark", mechanicParts, interiorParts, null);
        Assert.assertFalse(car.getAccepted());
        Assert.assertNotNull(car.getInteriorParts());
        Assert.assertNotNull(car.getMechanicParts());
        Assert.assertTrue(car.getInteriorParts().getLeather());
        Assert.assertEquals(10, (int) car.getInteriorParts().getDisplaySize());
        Assert.assertEquals("white", car.getInteriorParts().getInteriorColor());
    }

    @Test()
    public void testPolish() throws NoSpecsException {
        MechanicParts mechanicParts = createMechanicParts(100, 450, "75kw");
        InteriorParts interiorParts = createInteriorParts(true, null, "black");
        Car car = createCar("dark", mechanicParts, interiorParts, null);
        Assert.assertFalse(car.getAccepted());
        Assert.assertNotNull(car.getInteriorParts());
        Assert.assertNotNull(car.getMechanicParts());
        Assert.assertTrue(car.getPolish());
    }

    @Test
    public void testFullCar() throws NoSpecsException {
        MechanicParts mechanicParts = createMechanicParts(650, 450, "75kw");
        InteriorParts interiorParts = createInteriorParts(true, 17, "black");
        Car car = createCar("red", mechanicParts, interiorParts, null);
        Assert.assertNotNull(car);
        Assert.assertNotNull(car.getColor());
        Assert.assertNotNull(car.getInteriorParts());
        Assert.assertNotNull(car.getMechanicParts());
        Assert.assertNotNull(car.getPolish());
        Assert.assertNotNull(car.getAccepted());
        Assert.assertEquals("red", car.getColor());
        Assert.assertTrue(car.getAccepted());
        Assert.assertTrue(car.getInteriorParts().getLeather());
        Assert.assertEquals(650, (int) car.getMechanicParts().getAutonomy());
        Assert.assertEquals(450, (int) car.getMechanicParts().getHorsePower());
        Assert.assertEquals("75kw", car.getMechanicParts().getBattery());
        Assert.assertTrue(car.getInteriorParts().getLeather());
        Assert.assertEquals(17, (int) car.getInteriorParts().getDisplaySize());
        Assert.assertEquals("black", car.getInteriorParts().getInteriorColor());
        Assert.assertTrue(car.getPolish());
        Assert.assertTrue(car.getAccepted());
    }

    @Test(expected = NoSpecsException.class)
    public void noColorTest() throws NoSpecsException {
        MechanicParts mechanicParts = createMechanicParts(650, 450, "75kw");
        InteriorParts interiorParts = createInteriorParts(true, 17, "black");
        Car car = createCar(null, mechanicParts, interiorParts, null);
    }

    @Test(expected = NoSpecsException.class)
    public void noMechanicPartsTest() throws NoSpecsException {
        InteriorParts interiorParts = createInteriorParts(true, 17, "black");
        Car car = createCar("red", null, interiorParts, null);
    }

    @Test(expected = NoSpecsException.class)
    public void noInteriorPartsTest() throws NoSpecsException {
        MechanicParts mechanicParts = createMechanicParts(650, 450, "75kw");
        Car car = createCar("red", mechanicParts, null, null);
    }

    private Car createCar(String color, MechanicParts mechanicParts, InteriorParts interiorParts, Car car) throws NoSpecsException {
        AssemblyLine assemblyLine = new AssemblyLine();
        AssemblyCarEntity assemblyCarEntity = new AssemblyCarEntity(new Specs(color, mechanicParts, interiorParts));
        if(car!=null){
            assemblyCarEntity.setCar(car);
        }
        return assemblyLine.produce(assemblyCarEntity);
    }

    private MechanicParts createMechanicParts(Integer autonomy, Integer horsePower, String battery) {
        MechanicParts mechanicParts = new MechanicParts();
        mechanicParts.setAutonomy(autonomy);
        mechanicParts.setHorsePower(horsePower);
        mechanicParts.setBattery(battery);
        return mechanicParts;
    }

    private InteriorParts createInteriorParts(Boolean hasLeather, Integer displaySize, String interiorColor) {
        InteriorParts interiorParts = new InteriorParts();
        interiorParts.setInteriorColor(interiorColor);
        interiorParts.setDisplaySize(displaySize);
        interiorParts.setLeather(hasLeather);
        return interiorParts;
    }
}
