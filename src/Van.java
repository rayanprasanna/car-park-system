
public class Van extends Vehicle{ //Van class inherited by Vehicle class (Super class)
                                 //inheritance is a mechanism in which one object can derive all the properties and behaviors of parent object
                                 //Otherwise when one object derive all the properties and behaviors of parent object.
    private double cargoVolume;


    public Van(String type, String noPlateId, String brand, DateTime dateTime, double cargoVolume) {
        super(type, noPlateId, brand, dateTime);
        try {
            this.cargoVolume = cargoVolume;//validate cargoVolume inside the constructor
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //polymorphism mean is 'a state of having many shapes'
    //In java have to type of polymorphism such as dynamic binding and static binding.
    @Override // override printDetails abstract method in Super class.This is example of dynamic polymorphism
    public void printDetails() {
        System.out.println("CargoVolume: "+this.getCargoVolume()+"cm3");
    }
    //provide getter method for make the class read-only .
    //Encapsulation in java is a process of wrapping code and data together into a single unit.
    public double getCargoVolume() {
        return cargoVolume;
    }


}
