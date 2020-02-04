import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WestminsterCarParkManager implements CarParkManager{

    private static int maxCapacity = 20;
    private static Scanner sc = new Scanner(System.in);//Create a new object of the Scanner class and store it the variable sc
    private static ArrayList<Vehicle> carParkArray = new ArrayList<>(maxCapacity);// This maxCapacity is initialCapacity of ArrayList
    // Create ArrayList, it made of Vehicle type


    public int getMaxCapacityInCarPark(){//static methods in interface never inherited
        return maxCapacity;
    }

    @SuppressWarnings("static-access")
	public int AvailableLotsInCarPark() {
        return this.getMaxCapacityInCarPark() - this.carParkArray.size();
    }

    @SuppressWarnings("static-access")
	public int numOfOccupiedLotsInCarPark() {
        return this.carParkArray.size();
    }
    public static void main(String args[]){
        Menu();
    }
    public static void Menu(){

        String choice;

        do {
            System.out.println("Welcome Westminster Car Park"+"\n");
            System.out.println("1. Add vehicle ---->Enter 1");
            System.out.println("2. Delete Vehicle ---->Enter 2");
            System.out.println("3. Print Current Parking ---->Enter 3 ");
            System.out.println("4. Percentage of Vehicle type--->Enter 4");
            System.out.println("5. print long time parked vehicle and last vehicle---> Enter 5");
            System.out.println("6. Print parked vehicle specified date---> Enter 6");
            System.out.println("7. Get Total Charge for vehicle ---> Enter 7");
            System.out.println("8. Exit the program ----->Enter 8"+"\n");
            System.out.print("Choice: ");
            choice = sc.next();
            if("1".equals(choice)){
                addAllVehicle();
            }else if ("2".equals(choice)){
                deleteVehicle();
            }else if ("3".equals(choice)){
                printAllVehicle();
            }else if ("4".equals(choice)){
                getPercentageOfVehicleType();
            }else if ("5".equals(choice)){
                findFirstAndLastVehicle();
            }else if ("6".equals(choice)){
                printVehicleSpecifiedDay();
            }else if ("7".equals(choice)){
                getCarParkCharge();
            }
        }while (!"8".equals(choice));

    }

    public  static void addAllVehicle(){

        WestminsterCarParkManager westminsterCarParkManager = new WestminsterCarParkManager();

        if (westminsterCarParkManager.AvailableLotsInCarPark() > 0){

            String type;
            String noPlateId;
            String brand;
            int entryDay = 0;
            int entryMonth = 0;
            int entryYear = 0;
            int entryHour = 0;
            int entryMinute = 0;
            int numOfDoor = 0;
            String color;
            int cargoVolume = 0;
            double engineSize = 0;

            do {
                System.out.println("1. Add Car -----> enter Car ");
                System.out.println("2. Add Van -----> enter Van ");
                System.out.println("3. Add MotorBike---> enter MotorBike");
                System.out.println("4. Back to Main menu----> enter Back"+"\n");
                System.out.print("Type: ");
                type = sc.next();
                if("Car".equals(type)){
                    Vehicle carDetails = new Car();
                    DateTime dateTimeValidate = new DateTime();

                    Car car = new Car();
                    carDetails.setType(type);//set vehicle type

                    System.out.print("ID Plate: ");
                    noPlateId = sc.next();
                    carDetails.setNoPlateId(noPlateId);//set No ID plate

                    System.out.print("Brand: ");
                    brand = sc.next();
                    carDetails.setBrand(brand);//set vehicle brand

                    System.out.print("Color: ");
                    color = sc.next();
                    car.setColor(color);//set color

                    System.out.print("Number of Door: ");
                    try {
                        numOfDoor = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter integer number!.");
                        sc.next();
                    }
                    while (numOfDoor < 2 || numOfDoor > 4){     //Validate user input for get num of doors
                        System.out.println("Invalid input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            numOfDoor = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!.");
                            sc.next();
                            continue;
                        }
                    }
                    car.setNoOfDoor(numOfDoor);//set number of doors

                    System.out.println();
                    System.out.println("Entry Date----->\n");

                    System.out.print("Day: ");
                    try {//Validate user input for entry day
                        entryDay = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter Integer value!!");
                        sc.next();

                    }
                    while (entryDay < 1 || entryDay >31){
                        System.out.println("Invalid input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryDay = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setDay(entryDay);//set day

                    System.out.print("Month: ");
                    try {//Validate user input for entry month
                        entryMonth = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter Integer value!!");
                        sc.next();
                    }

                    while (entryMonth < 1 || entryMonth >12){
                        System.out.println("Invalid input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryMonth = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setMonth(entryMonth);//set month

                    System.out.print("Year: ");
                    try {//Validate user input for entry year
                        entryYear = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter Integer value!!");
                        sc.next();
                    }

                    while (entryYear <= 2016 || entryYear > 2018){
                        System.out.println("Invalid input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryYear = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setYear(entryYear);//set year
                    System.out.println("\nEntry Time: \n");
                    System.out.print("Hour: ");
                    try {
                        entryHour = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter integer Value!");
                        sc.next();
                    }
                    while (entryHour < 1 || entryHour > 23){    //Validate user input for entry hour
                        System.out.println("Invalid Input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryHour = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setHour(entryHour);//set hour

                    System.out.print("Minute: ");
                    try {
                        entryMinute = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter integer value!");
                        sc.next();
                    }
                    while (entryMinute < 1 || entryMinute > 59){    //Validate user input for entry minutes
                        System.out.println("Invalid Input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryMinute = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter Integer value!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setMinute(entryMinute);//set minutes

                    DateTime dateTime = new DateTime(dateTimeValidate.getDay(),dateTimeValidate.getMonth()//Create for DateTime class
                            ,dateTimeValidate.getYear(),dateTimeValidate.getHour(),dateTimeValidate.getMinute());


                    Vehicle car1 = new Car(carDetails.getType(),carDetails.getNoPlateId(),
                            carDetails.getBrand(),dateTime,car.getColor(),car.getNoOfDoor());

                    carParkArray.add(car1);//Add Vehicle object in carParkArray

                    System.out.println("\nNo of Parked vehicles: "+ westminsterCarParkManager.numOfOccupiedLotsInCarPark());
                    System.out.println("No of Available Lots: "+ westminsterCarParkManager.AvailableLotsInCarPark()+"\n");

                }
                if("Van".equals(type)){
                    System.out.print("ID Plate: ");
                    noPlateId = sc.next();

                    System.out.print("Brand: ");
                    brand = sc.next();

                    System.out.print("Cargo Volume: ");
                    try {
                        cargoVolume = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter integer value!");
                        sc.next();
                    }
                    while (cargoVolume < 1 || cargoVolume > 5000){  //Validate user input for cargo Volume
                        System.out.println("Invalid input");
                        System.out.print("Re-Input: ");
                        try {
                            cargoVolume = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter Integer Value!");
                            sc.next();
                            continue;
                        }
                    }
                    DateTime dateTimeValidate = new DateTime();
                    System.out.println();
                    System.out.println("Entry Date----->\n");

                    System.out.print("Day: ");
                    try {//Validate user input for entry day
                        entryDay = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter Integer value!!");
                        sc.next();

                    }
                    while (entryDay < 1 || entryDay >31){
                        System.out.println("Invalid input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryDay = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setDay(entryDay);//set day

                    System.out.print("Month: ");
                    try {//Validate user input for entry month
                        entryMonth = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter Integer value!!");
                        sc.next();
                    }

                    while (entryMonth < 1 || entryMonth >12){
                        System.out.println("Invalid input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryMonth = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setMonth(entryMonth);//set month

                    System.out.print("Year: ");
                    try {//Validate user input for entry year
                        entryYear = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter Integer value!!");
                        sc.next();
                    }

                    while (entryYear <= 2016 || entryYear > 2018){
                        System.out.println("Invalid input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryYear = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setYear(entryYear);//set year
                    System.out.println("\nEntry Time: \n");
                    System.out.print("Hour: ");
                    try {
                        entryHour = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter integer Value!");
                        sc.next();
                    }
                    while (entryHour < 1 || entryHour > 23){    //Validate user input for entry hour
                        System.out.println("Invalid Input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryHour = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setHour(entryHour);//set hour

                    System.out.print("Minute: ");
                    try {
                        entryMinute = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter integer value!");
                        sc.next();
                    }
                    while (entryMinute < 1 || entryMinute > 59){    //Validate user input for entry minutes
                        System.out.println("Invalid Input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryMinute = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter Integer value!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setMinute(entryMinute);//set minutes

                    DateTime dateTime = new DateTime(dateTimeValidate.getDay(),dateTimeValidate.getMonth()//Create object for DateTime class
                            ,dateTimeValidate.getYear(),dateTimeValidate.getHour(),dateTimeValidate.getMinute());
                    Vehicle van1 = new Van(type,noPlateId,brand,dateTime,cargoVolume);

                    carParkArray.add(van1);
                    maxCapacity--;

                    System.out.println("\nNo. of Parked vehicles: " +(westminsterCarParkManager.numOfOccupiedLotsInCarPark()));
                    System.out.println("No of Available Lots: "+(westminsterCarParkManager.AvailableLotsInCarPark())+"\n");

                }
                if ("MotorBike".equals(type)){
                    System.out.print("ID Plate: ");
                    noPlateId = sc.next();

                    System.out.print("Brand: ");
                    brand = sc.next();

                    System.out.print("Engine Size: ");
                    try {
                        engineSize = sc.nextDouble();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter integer value!");
                        sc.next();
                    }
                    while (engineSize < 0 || engineSize > 2000){
                        System.out.println("Invalid input");
                        System.out.print("Re-Input: ");
                        try {
                            engineSize = sc.nextDouble();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!");
                            sc.next();
                            continue;
                        }
                    }

                    DateTime dateTimeValidate = new DateTime();
                    System.out.println();
                    System.out.println("Entry Date----->\n");

                    System.out.print("Day: ");
                    try {//Validate user input for entry day
                        entryDay = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter Integer value!!");
                        sc.next();

                    }
                    while (entryDay < 1 || entryDay >31){
                        System.out.println("Invalid input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryDay = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setDay(entryDay);//set day

                    System.out.print("Month: ");
                    try {//Validate user input for entry month
                        entryMonth = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter Integer value!!");
                        sc.next();
                    }

                    while (entryMonth < 1 || entryMonth >12){
                        System.out.println("Invalid input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryMonth = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setMonth(entryMonth);//set month

                    System.out.print("Year: ");
                    try {//Validate user input for entry year
                        entryYear = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter Integer value!!");
                        sc.next();
                    }

                    while (entryYear <= 2016 || entryYear > 2018){
                        System.out.println("Invalid input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryYear = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setYear(entryYear);//set year
                    System.out.println("\nEntry Time: \n");
                    System.out.print("Hour: ");
                    try {
                        entryHour = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter integer Value!");
                        sc.next();
                    }
                    while (entryHour < 1 || entryHour > 23){    //Validate user input for entry hour
                        System.out.println("Invalid Input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryHour = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter integer value!!");
                            sc.next();
                            continue;
                        }
                    }
                    dateTimeValidate.setHour(entryHour);//set hour

                    System.out.print("Minute: ");
                    try {
                        entryMinute = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter integer value!");
                        sc.next();
                    }
                    while (entryMinute < 1 || entryMinute > 59){    //Validate user input for entry minutes
                        System.out.println("Invalid Input!!!");
                        System.out.print("Re-Input: ");
                        try {
                            entryMinute = sc.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Please enter Integer value!");
                            sc.next();
                            continue;
                        }
                    }

                    dateTimeValidate.setMinute(entryMinute);//set minutes
                    DateTime dateTime = new DateTime(dateTimeValidate.getDay(),dateTimeValidate.getMonth()//Create for DateTime class
                            ,dateTimeValidate.getYear(),dateTimeValidate.getHour(),dateTimeValidate.getMinute());

                    Vehicle motorbike1 = new MotorBike(type,noPlateId,brand,dateTime,engineSize);
                    carParkArray.add(motorbike1);

                    System.out.println("\nNo. of Parked vehicles: " + westminsterCarParkManager.numOfOccupiedLotsInCarPark());
                    System.out.println("No of Available Lots: "+ westminsterCarParkManager.AvailableLotsInCarPark()+"\n");
                }
            }while ("!Back".equals(type));

        }else {
            System.out.println("Car Park Full!!");
        }
    }
   public static void deleteVehicle(){
        String choice;
        String id;
        boolean isIDPlate = false;
        WestminsterCarParkManager westminsterCarParkManager = new WestminsterCarParkManager();
        do {
            System.out.println("1.Delete Car ----> Press 1");
            System.out.println("2.Delete Van ----> Press 2");
            System.out.println("3.Delete MotorBike ---> Press 3");
            System.out.print("Choice: ");
            choice = sc.next();

            if("1".equals(choice)){
                System.out.print("Please enter Id Plate do you want delete: ");
                id = sc.next();
                for (int i = carParkArray.size() - 1; i >= 0; --i){
                    final Vehicle vehicle = carParkArray.get(i);
                    System.out.println("Check Vehicle ID: "+carParkArray.get(i).getNoPlateId());
                    if (vehicle.getNoPlateId().equals(id)){
                        isIDPlate = true;
                        System.out.println("Found vehicle ID Plate "+ vehicle.getNoPlateId());
                        carParkArray.remove(i);
                        System.out.println("Vehicle type of "+vehicle.getType()+"  IDPlate  "+ vehicle.getNoPlateId()+" was gone out.\n");
                        System.out.println("No of free Lots: "+ westminsterCarParkManager.AvailableLotsInCarPark()+"\n");
                    }
                }
                if (isIDPlate == false){
                    System.out.println("But, No vehicle parked in this ID plate: "+ id+"\n");
                }

            }
            if("2".equals(choice)){
                System.out.print("Please enter Id Plate do you want delete: ");
                id = sc.next();
                for (int i = carParkArray.size() - 1; i >= 0; --i){
                    final Vehicle v = carParkArray.get(i);
                    System.out.println("Check Vehicle ID: "+carParkArray.get(i).getNoPlateId());
                    if (v.getNoPlateId().equals(id)){
                        isIDPlate = true;
                        System.out.println("Found that vehicle ID Plate "+ v.getNoPlateId());
                        carParkArray.remove(i);
                        System.out.println("Vehicle type of "+v.getType()+ "  IDPlate  " + v.getNoPlateId()+" was gone out.\n");
                        System.out.println("No of free Lots: "+ westminsterCarParkManager.AvailableLotsInCarPark()+"\n");
                    }
                }
                if (isIDPlate == false){
                    System.out.println("But, No vehicle parked in this ID plate: "+ id+"\n");
                }

            }
            if("3".equals(choice)){
                System.out.print("Please enter Id Plate do you want delete: ");
                id = sc.next();
                for (int i = carParkArray.size() - 1; i >= 0; --i){
                    final Vehicle v = carParkArray.get(i);
                    System.out.println("Check Vehicle ID: "+carParkArray.get(i).getNoPlateId());
                    if (v.getNoPlateId().equals(id)){
                        isIDPlate = true;
                        System.out.println("Found vehicle ID Plate "+ v.getNoPlateId());
                        carParkArray.remove(i);
                        System.out.println("Vehicle type of "+v.getType()+"  IDPlate  "+v.getNoPlateId()+" was gone out.\n");
                        System.out.println("No of free Lots: "+ westminsterCarParkManager.AvailableLotsInCarPark()+"\n");
                    }
                }
                if (isIDPlate == false){
                    System.out.println("But, No vehicle parked in this ID plate: "+ id+"\n");
                }

            }
        }while ("4".equals(choice));

   }
   public static void printAllVehicle(){
       System.out.println("\n"+"Display current parked vehicle\n");
       for (int i = carParkArray.size() - 1; i >=0; --i){
           final Vehicle v = carParkArray.get(i);
           System.out.println("ID plate: "+v.getNoPlateId());
           v.printDetails();
           System.out.println("Entry Date: "+v.getDateTime().getDay()+"/"+v.getDateTime().getMonth()+"/"+v.getDateTime().getYear());
           System.out.println("Entry Time: "+v.getDateTime().getHour()+":"+v.getDateTime().getMinute());
           System.out.println("Type:"+v.getType());
           System.out.println("***********************************************************************\n");
       }

   }
   public static void getPercentageOfVehicleType(){

       String choice;
       String type;
       boolean isVehicleType = false;
       double numOfCar = 0;
       double numOfVan = 0;
       double numOfMotorBike = 0;
       do {
           System.out.println("1.Get percentage of Car ----> Press 1");
           System.out.println("2.Get percentage of Van ----> Press 2");
           System.out.println("3.Get percentage of MotorBike ---> Press 3");

           System.out.print("Choice: ");
           choice = sc.next();
           if("1".equals(choice)){
               System.out.print("Please enter vehicle type: ");
               type = sc.next();
               for (int i = carParkArray.size() - 1; i >= 0; --i){

                   final Vehicle vehicle = carParkArray.get(i);
                   if(vehicle.getType().equals(type)){
                       isVehicleType = true;
                       numOfCar++;
                   }
               }
               if (isVehicleType == false){
                   System.out.println(type+" is wrong input!. Please enter valid input.");
               }else {
                   System.out.println("Percentage of Car: "+(numOfCar / carParkArray.size())*100+"\n");
               }
           }
           if("2".equals(choice)){
               System.out.print("Please enter vehicle type: ");
               type = sc.next();
               for (int i = carParkArray.size() - 1; i >= 0; --i){

                   final Vehicle vehicle = carParkArray.get(i);
                   if(vehicle.getType().equals(type)){
                       isVehicleType = true;
                       numOfVan++;
                   }
               }
               if (isVehicleType == false){
                   System.out.println(type+" is wrong input!. Please enter valid input.");
               }else {
                   System.out.println("Percentage of Van: "+(numOfVan / carParkArray.size())*100+"\n");
               }
           }
           if("3".equals(choice)){
               System.out.print("Please enter vehicle type: ");
               type = sc.next();
               for (int i = carParkArray.size() - 1; i >= 0; --i){

                   final Vehicle vehicle = carParkArray.get(i);
                   if(vehicle.getType().equals(type)){
                       isVehicleType = true;
                       numOfMotorBike++;
                   }
               }
               if (isVehicleType == false){
                   System.out.println(type+" is wrong input!. Please enter valid input.");
               }else {
                   System.out.println("Percentage of Car: "+(numOfMotorBike / carParkArray.size())*100+"\n");
               }
           }
       }while ("4".equals(choice));
   }
   public static void findFirstAndLastVehicle(){
       for(int i = 0; i <= carParkArray.size()-1;i++){
           final Vehicle vehicle = carParkArray.get(i);

           if (i == 0){

               System.out.println("First vehicle in Park: \n");
               System.out.println("Type: "+vehicle.getType());
               System.out.println("ID Plate: "+vehicle.getNoPlateId());
               System.out.println("Brand: "+vehicle.getBrand());
               System.out.println("Date: "+vehicle.getDateTime().getDay()+" / "+vehicle.getDateTime().getMonth()+" / "+vehicle.getDateTime().getYear());
               vehicle.printDetails();

           }else if (i == carParkArray.size() - 1){

               System.out.println("\nLast vehicle in Park: \n");
               System.out.println("Type: "+vehicle.getType());
               System.out.println("ID Plate: "+vehicle.getNoPlateId());
               System.out.println("Brand: "+vehicle.getBrand());
               System.out.println("Date: "+vehicle.getDateTime().getDay()+ " / "+vehicle.getDateTime().getMonth()+" / "+vehicle.getDateTime().getYear());
               vehicle.printDetails();

           }
       }
   }
   public static void printVehicleSpecifiedDay(){

       int day;
       int month;
       int year;
       boolean isDate = false;
       System.out.println("Enter Specified date: ");
       System.out.print("Day: ");
       day = sc.nextInt();
       System.out.print("Month: ");
       month = sc.nextInt();
       System.out.print("Year: ");
       year = sc.nextInt();
       for (int i = carParkArray.size() - 1; i>=0;--i){
           final Vehicle vehicle = carParkArray.get(i);

           if ( (vehicle.getDateTime().getDay() == day) && (vehicle.getDateTime().getMonth() == month) && (vehicle.getDateTime().getYear()) == year){
               isDate = true;
               System.out.println("\nType: "+vehicle.getType());
               System.out.println("ID plate: "+vehicle.getNoPlateId());
               System.out.println("Brand: "+vehicle.getBrand());
               System.out.println("Entry time: "+vehicle.getDateTime().getHour()+":"+vehicle.getDateTime().getMinute());
               System.out.println();

           }
       }if (isDate == false){
           System.out.println("No vehicle were parked in that day.!!!"+"\n");
       }

   }
   public static void getCarParkCharge(){

       int day;
       int month;
       int year;
       int hour;
       int minute;
       boolean isIDPlate = false;
       double totalPrice;
       String idPlate;

       System.out.println("Enter current date: ");

       System.out.print("Day: ");
       day = sc.nextInt();

       System.out.print("Month: ");
       month = sc.nextInt();

       System.out.print("Year: ");
       year = sc.nextInt();

       System.out.println("\n"+"Enter current time: ");

       System.out.print("Hour: ");
       hour = sc.nextInt();
       System.out.print("Minute: ");
       minute = sc.nextInt();

       System.out.print("\n"+"Enter your vehicle ID plate:");
       idPlate = sc.next();
       for (int i = carParkArray.size() - 1 ; i >= 0; --i){
           final Vehicle vehicle = carParkArray.get(i);
           if (vehicle.getNoPlateId().equals(idPlate)) {
               totalPrice = (((day - vehicle.getDateTime().getDay()) * 30) + ((month - vehicle.getDateTime().getMonth()) * 30 * 30) + ((hour - vehicle.getDateTime().getHour() * 1) + 3) + (minute - vehicle.getDateTime().getMinute()) * 0.016 + (year - vehicle.getDateTime().getYear()) * 30 * 30 * 12);
               System.out.println("Total Charge: " + totalPrice + " $" + "\n");
               isIDPlate = true;
           }
       }
       if (isIDPlate == false){
           System.out.println("But, No vehicle parked in this ID plate: "+ idPlate+"\n");
       }
   }
}
