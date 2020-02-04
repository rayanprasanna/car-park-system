
public class Car extends Vehicle { // Car class inherited by Vehicle class (Super class)
                                  //inheritance is a mechanism in which one object can derive all the properties and behaviors of parent object
                                  //Otherwise when one object derive all the properties and behaviors of parent object.
    private String color;
    private int noOfDoor;

    public Car(){//default constructor
        super();
    }

    public Car(String type, String noPlateId, String brand, DateTime dateTime, String color, int noOfDoor) {

        super(type, noPlateId, brand, dateTime);
        this.color = color;
        try {//validate onOfDoor
            this.noOfDoor = noOfDoor;
        }catch (Exception e){
            System.out.println(e);
        }

    }

    //provide getter and setter method for make the class read-only or write-only .
    //Encapsulation in java is a process of wrapping code and data together into a single unit.

    public String getColor() {
        return color;
    }

    public int getNoOfDoor() {
        return noOfDoor;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNoOfDoor(int noOfDoor) {
        this.noOfDoor = noOfDoor;
    }
    //polymorphism mean is 'a state of having many shapes'
    //In java have to type of polymorphism such as dynamic binding and static binding.
    @Override// override printDetails abstract method in Super class.this is example of dynamic polymorphism.
    public void printDetails() {
        System.out.println("Color :"+ this.getColor());
        System.out.println("No of Doors: "+this.noOfDoor);
    }

}
