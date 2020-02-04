public class MotorBike extends Vehicle {//MotorBike class inherited by Vehicle class (Super class)
                                        //inheritance is a mechanism in which one object can derive all the properties and behaviors of parent object
                                        //Otherwise when one object derive all the properties and behaviors of parent object.

    private double engineSize;

    public MotorBike(String type, String noPlateId, String brand, DateTime dateTime, double engineSize) {
        super(type, noPlateId, brand, dateTime);//create constructor
        this.engineSize = engineSize;
    }
    //polymorphism mean is 'a state of having many shapes' otherwise when one task performed by different ways
    //In java have to type of polymorphism such as dynamic binding and static binding.
    @Override // override printDetails abstract method in Super class.This is example of dynamic polymorphism
    public void printDetails() {
        System.out.println("Engine Size: "+this.getEngineSize()+"cc");
    }
    //provide getter method for make the class read-only.
    //Encapsulation in java is a process of wrapping code and data together into a single unit.
    public double getEngineSize() {
        return engineSize;
    }

}
