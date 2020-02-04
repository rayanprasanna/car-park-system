
public interface CarParkManager {

    int getMaxCapacityInCarPark();//interface is a collection of abstract method. There are can contain constants,default methods and static methods
    int AvailableLotsInCarPark();//This is a example of static methods.But static methods does not need to override.
    int numOfOccupiedLotsInCarPark();

}
