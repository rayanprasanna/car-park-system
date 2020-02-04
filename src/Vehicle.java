public abstract class Vehicle  {//super class.This class can have abstract methods or normal methods(Body type methods)
                                //This parent class is a abstract class because Parent class (Vehicle class)can't create  parent class object but child class can create object.
                                //abstraction is hiding internal details and showing functionality
    private String type;
    private String noPlateId;
    private String brand;
    private DateTime dateTime;

    public Vehicle(){//create default constructor

    }

    public Vehicle(String type, String noPlateId, String brand, DateTime dateTime) {//create constructor with parameters

        this.type = type;
        this.noPlateId = noPlateId;
        this.brand = brand;
        this.dateTime = dateTime;

    }

    //provide getter and setter method for make the class read-only or write-only .
    //Encapsulation in java is a process of wrapping code and data together into a single unit.

    public String getNoPlateId() {
        return noPlateId;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNoPlateId(String noPlateId) {
        this.noPlateId = noPlateId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public DateTime getDateTime() {
        return dateTime;
    }
    public abstract void printDetails();
}
