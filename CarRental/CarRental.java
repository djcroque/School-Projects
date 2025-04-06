 /*
GROUP 1 | ICT-102

Roque, Daryl John Clark
Marcelino, Princess Camille
Marimla, Chleo Jae
Dumas, Kitt Angelu
Gamboa, Rodel Vincent
Sidoy, Christelle Gaile

Our program is a Car Rental System that makes it easy for people to rent a car when they need one. 
Users can look at a list of available cars and see important details like the car model, whether it has a manual or 
automatic transmission, what type of fuel it uses (gas or diesel), and how much it costs to rent.

The admin is in charge of adding and managing cars in the system. They can update car details, set rental prices, 
and make sure only available cars are shown to users.

This system is designed to be simple and user-friendly, making it easy for anyone to rent a car quickly and without confusion. 
Whether someone needs a car for a short trip or a long drive, they can find the right one easily.
 */

 import java.util.*;
 import java.io.*;

public class CarRental
{
        public static Customer cus1 = new Customer("Chappel Roan", 1001, 27);
        public static Customer cus2 = new Customer("Elon Musk", 1002, 53);
        public static Customer cus3 = new Customer("Rene Descartes", 1003, 35);
        static List <Customer> customerList = new ArrayList <Customer>();

        public static Vehicle sedan1 = new Vehicle("Toyota Vios", "Sedan", "Gasoline", "Automatic", 850.00);
        public static Vehicle sedan2 = new Vehicle("Honda Civic", "Sedan", "Gasoline", "Manual", 800.00);
        public static Vehicle suv1 = new Vehicle("Toyota Fortuner", "SUV", "Gasoline", "Automatic", 1200.00);
        public static Vehicle suv2 = new Vehicle("Tamaraw FX", "SUV", "Diesel", "Automatic", 1000.00);
        public static Vehicle van1 = new Vehicle("Hyundai Starex", "Van", "Diesel", "Manual", 1200.00);
        public static Vehicle van2 = new Vehicle("Toyota Hiace", "Van", "Diesel", "Automatic", 1000.00);
        public static Vehicle lux1 = new Vehicle("Mercedes Benz E-Class", "Luxury Car", "Diesel", "Automatic", 15000.00);
        public static Vehicle lux2 = new Vehicle("Audi A6", "Luxury Car", "Gasoline", "Manual", 15000.00);
        static ArrayList <ArrayList<Vehicle>> vehicleList = new ArrayList <ArrayList<Vehicle>>();

        public static int purchaseNum = 1;
       

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {   
        //Main Method only for adding elements to lists
        customerList.add(cus1);
        customerList.add(cus2);
        customerList.add(cus3);
        vehicleList.add(new ArrayList<Vehicle>());
        vehicleList.get(0).add(sedan1);
        vehicleList.get(0).add(sedan2);
        //vehicleList.get(0).get(1).setStatus(false);
        vehicleList.add(new ArrayList<Vehicle>());
        vehicleList.get(1).add(suv1);
        vehicleList.get(1).add(suv2);
        vehicleList.add(new ArrayList<Vehicle>());
        vehicleList.get(2).add(van1);
        vehicleList.get(2).add(van2);
        vehicleList.add(new ArrayList<Vehicle>());
        vehicleList.get(3).add(lux1);
        vehicleList.get(3).add(lux2);

       ident();
        //FIRST PROGRAM APPEARANCE
    }


    public static void ident()
    {
        //Main Identification/Menu
        int a = 0;
        boolean loop = true;

        do { 
            try {
                loop = true;
                a = 0;
                System.out.println("=== WHEELS ON DEMAND ===");
                System.out.println("What is your identification?");
                System.out.println("(1) Admin");
                System.out.println("(2) Customer");
                System.out.println("(3) Exit Program");
                System.out.print("\nPlease type your number (1-3): ");
                a = Integer.parseInt(input.nextLine());
                if (a > 3 || a < 1){
                    System.out.println("You have put an invalid number. Please try again.\n");
                }
                else{
                    loop = false;
                }
                    }
             catch (Exception e) {
                System.out.println("You have put an invalid input. Please try again.\n");
            }
        } while (loop == true);

        switch (a) {
            case 1:
                adminVerify();
                break;
            case 2:
                customerVerify();
                break;
            case 3:
            System.out.println("""
                Thank you for choosing
                 ===WHEELS ON DEMAND===""");
            System.exit(0);
    }
}
    


    public static void adminVerify()
    {
        //Admin Verification via Password
        boolean adminTrue;
        String adminPassword = "Vr00mVr00m";
        String enterPassword = "";

        do {
            adminTrue = false;
            enterPassword = "";
            System.out.print("Enter password (type \"exit\" to exit): ");
            enterPassword = input.nextLine();
            if (enterPassword.equals("exit"))
                ident();
            else if (!(enterPassword.equals(adminPassword)))
                System.out.print("Sorry, that is not the correct password. Please try again.\n");
            else
                adminTrue = true;
    } while (adminTrue == false);
    adminProgSort();
    }



    public static void adminProgSort(){
        //Admin Main Menu
        int sort = 0;
        boolean loopAdmin = true;

        System.out.println("\n=== WHEELS ON DEMAND ===");
        System.out.println("""
                           == ADMIN MAIN MENU ==
                           (1) Add Vehicle to Inventory
                           (2) Remove Vehicle from Inventory
                           (3) Show Vehicle Inventory
                           (4) Show Customer Records
                           (5) Exit Admin""");
        do{
            try{
                loopAdmin = true;
                sort = 0;
                System.out.print("\nPlease type your number (1-5): ");

                sort = Integer.parseInt(input.nextLine());
                if (sort > 5 || sort < 1){
                    System.out.println("You have put an invalid number. Please try again.\n");
                }
                else{
                    loopAdmin = false;
                }
            }
        catch (Exception e) {
            System.out.println("You have put an invalid input. Please try again.\n");
        }
        } while (loopAdmin);

        switch (sort) {
            case 1:
                carTypeSelect(sort, "Admin", -1);
                break;
            case 2:
                carTypeSelect(sort, "Admin", -1);
                break;
            case 3:
                carTypeSelect(sort, "Admin", -1);
                break;
            case 4:
                showCustomers();
                break;
            case 5:
                menuExit("Admin", -1);
                break;
        }

    }



    public static void carTypeSelect(int menuSort, String status, int cusIndex){
        //Showing of Vehicle Types
        int typeSort = 0;
        boolean loopTypeSort = true;

        System.out.println("== Vehicle Inventory ==");
        System.out.println("""
                (1) Sedan
                (2) SUV
                (3) Van
                (4) Luxury Car
                (5) Return to Menu""");
        do{
            try{
                typeSort = 0;
                loopTypeSort = true;
                System.out.print("\nPlease type your number (1-5): ");

                typeSort = Integer.parseInt(input.nextLine());
                if (typeSort > 5 || typeSort < 1){
                    System.out.println("You have put an invalid number. Please try again.\n");
                }
                else{
                    loopTypeSort = false;
                }
            }
        catch (Exception e) {
            System.out.println("You have put an invalid input. Please try again.\n");
        }
        } while (loopTypeSort);

        if (status.equals("Admin")){
            if (menuSort == 2 || menuSort == 3){
            switch (typeSort) {
                case 1:
                    showVehicles(status, menuSort, "Sedan", typeSort, cusIndex);
                    break;
                case 2:
                    showVehicles(status, menuSort, "SUV", typeSort, cusIndex);
                    break;
                case 3:
                    showVehicles(status, menuSort, "Van", typeSort, cusIndex);
                    break;
                case 4:
                    showVehicles(status, menuSort, "Luxury Car", typeSort, cusIndex);
                    break;
                case 5:
                    adminProgSort();
                    break;
                }
            }
            else if (menuSort == 1){
                switch (typeSort) {
                    case 1:
                        addSelect("Sedan", typeSort);
                        break;
                    case 2:
                        addSelect("SUV", typeSort);
                        break;
                    case 3:
                        addSelect("Van", typeSort);
                        break;
                    case 4:
                        addSelect("Luxury Car", typeSort);
                        break;
                    case 5:
                        if (status.equals("Admin"))
                            adminProgSort();
                }
            }
    }
        else if (status.equals("Customer")){
                switch (typeSort) {
                    case 1:
                        showVehicles(status, menuSort, "Sedan", typeSort, cusIndex);
                        break;
                    case 2:
                        showVehicles(status, menuSort, "SUV", typeSort, cusIndex);
                        break;
                    case 3:
                        showVehicles(status, menuSort, "Van", typeSort, cusIndex);
                        break;
                    case 4:
                        showVehicles(status, menuSort, "Luxury Car", typeSort, cusIndex);
                        break;
                    case 5:
                            customerProgSort(cusIndex);
                        break;
        }
    }
    }

    public static void showVehicles(String status, int menuSort, String type, int carSort, int cusIndex){
        //Showing of Vehicle Inventory for Admin and Customer
        int a = carSort - 1;

        if (vehicleList.get(a).size() >= 1){
            System.out.println("== " + type + " Inventory ==");
        for (int b = 0; b < vehicleList.get(a).size(); b++){
            System.out.println("(" + type + " " + (b+1) + ")");
            System.out.println("\tCar Model: " + vehicleList.get(a).get(b).getModel());
            System.out.println("\tCar Type: " + vehicleList.get(a).get(b).getType());
            System.out.println("\tFuel: " + vehicleList.get(a).get(b).getFuel());
            System.out.println("\tTransmission: " + vehicleList.get(a).get(b).getTrans());
            System.out.print("\tRental Price: Php ");
            System.out.print(String.format("%,.2f", vehicleList.get(a).get(b).getPrice()));
            System.out.print("\n\tAvailability: " + (vehicleList.get(a).get(b).getStatus() == true ? "Yes" : "No"));
            System.out.println(" ");
        }
            if (status.equals("Admin")){
                if (menuSort == 2){
                    removeSelect(a);
                }
                else if (menuSort == 3){
                    adminProgSort();
                }
            }
            else if (status.equals("Customer")){
                if (menuSort == 1){
                    vehicleRent(a, cusIndex);
                }
                if (menuSort == 2){
                    vehicleReturn(a, cusIndex);
                }
                if (menuSort == 3){
                    customerProgSort(cusIndex);
                }
            }
        }

        else if (vehicleList.get(a).size() == 0){
            System.out.print("There are no vehicles in the inventory.");
            if (status.equals("Admin")){
                if (menuSort == 3 || menuSort == 2){
                    adminProgSort();
                }
                if (menuSort == 1){
                    addSelect(type, carSort);
                }
            }
            else if (status.equals("Customer")){
                customerProgSort(cusIndex);
            }
        }
    
    }



    public static void vehicleRent(int a, int cusIndex){
        boolean rentLoop = true;
        int select;
        String confirm;

        System.out.println("== Rent Vehicle ==");
        do { 
            try {
                rentLoop = true;
                select = -2;
                System.out.print("Select vehicle to rent (1-" + (vehicleList.get(a).size()) + ") [enter 0 to exit]: ");
                select = Integer.parseInt(input.nextLine());
                select -= 1;
                if (select > vehicleList.get(a).size() || select < -1){
                    System.out.println("You have put an invalid number. Please try again.\n");
                    vehicleReturn(a, cusIndex);
                }
                if (select == -1){
                    rentLoop = false;
                    customerProgSort(cusIndex);
                }
                if (vehicleList.get(a).get(select).getStatus() == false){
                    System.out.println("This car is already rented.");
                    customerProgSort(cusIndex);
                }
                else {
                    System.out.println("(Vehicle)");
                    System.out.println("\tCar Model: " + vehicleList.get(a).get(select).getModel());
                    System.out.println("\tCar Type: " + vehicleList.get(a).get(select).getType());
                    System.out.println("\tFuel: " + vehicleList.get(a).get(select).getFuel());
                    System.out.println("\tTransmission: " + vehicleList.get(a).get(select).getTrans());
                    System.out.print("\tRental Price: Php ");
                    System.out.print(String.format("%,.2f", vehicleList.get(a).get(select).getPrice()));
                    System.out.print("\nAre you sure you want to rent this vehicle? (Y/N): ");
                    confirm = (input.nextLine()).toUpperCase();
                    if (confirm.equals("Y")){
                        rentLoop = false;
                        rentDaysSet(a, select, cusIndex);
                    }
                    else if (confirm.equals("N")){
                        rentLoop = false;
                        customerProgSort(cusIndex);
                    }
                    else {
                        System.out.println("You have put an invalid input. Please try again.");
                        vehicleRent(a, cusIndex);
                    }

                    }
                }
            catch (Exception e) {
                System.out.println("You have put an invalid input. Please try again.");
            }
        } while (rentLoop);
    }



    public static void rentDaysSet(int typeIndex, int carIndex, int cusIndex){
        boolean daysLoop = true;
        int rentDays;
        String confirm;

        do { 
            try {
                System.out.println("== Renting " + vehicleList.get(typeIndex).get(carIndex).getModel() + " ==");
                daysLoop = true;
                rentDays = 0;
                System.out.println("""
                        (A vehicle can only be rented for less than 20 DAYS.
                        Renting for 6 days or more will have a 15% discount to the total price.)
                        """);
                System.out.print("Enter days to rent vehicle (maximum of 20 days): ");
                rentDays = Integer.parseInt(input.nextLine());
                if (rentDays > 20){
                    System.out.println("Sorry, that exceeds the maximum days you can rent a vehicle.");
                    daysLoop = false;
                    rentDaysSet(typeIndex, carIndex, cusIndex);
                }
                else if (rentDays <= 0){
                    System.out.println("You have put an invalid input. Please try again.");
                    daysLoop = false;
                    rentDaysSet(typeIndex, carIndex, cusIndex);
                }
                else{
                    System.out.println("You have chosen to rent this vehicle for " + rentDays + " days.");
                    System.out.print("Are you sure that you will rent for this duration? (Y/N): ");
                    confirm = (input.nextLine()).toUpperCase();
                    if (confirm.equals("Y")){
                        boolean discount = rentDays >= 6 ? true : false;
                        daysLoop = false;
                        rentInsuranceSet(typeIndex, carIndex, cusIndex, rentDays, discount);
                    }
                    else if (confirm.equals("N")){
                        daysLoop = false;
                        rentDaysSet(typeIndex, carIndex, cusIndex);
                    }
                    else {
                        System.out.println("You have put an invalid input. Please try again.");
                        rentDaysSet(typeIndex, carIndex, cusIndex);
                    }
                }
                }
            catch (Exception e) {
                System.out.println("You have put an invalid input. Please try again.");
            }
        } while (daysLoop);
    }



    public static void rentInsuranceSet(int typeIndex, int carIndex, int cusIndex, int rentDays, boolean discount){
        boolean insLoop = true;
        int insSelect;
        String confirm;
        double insPrice = 0;
        String insurance = "None";

        do { 
            try {
                System.out.println("== Renting " + vehicleList.get(typeIndex).get(carIndex).getModel() + " ==");
                insLoop = true;
                insSelect = 0;
                System.out.println("""
                        = CHOICE OF INSURANCE =
                        (1) Premium Insurance [Php 3,000.00]
                        >Includes DAMAGE, THEFT, and THIRD PARTY LIABILITY
                        (2) Silver Insurance [Php 1,500.00]
                        >Includes DAMAGE and THEFT
                        (3) No Insurance 
                        """);
                System.out.print("Enter number of desired insurance (1-3): ");
                insSelect = Integer.parseInt(input.nextLine());
                if (insSelect >= 4 || insSelect <= 0){
                    System.out.println("You have put an invalid input. Please try again.");
                    insLoop = false;
                    rentInsuranceSet(typeIndex, carIndex, cusIndex, rentDays, discount);
                }
                else {
                    if (insSelect == 1){
                        System.out.println("You have chosen PREMIUM INSURANCE worth Php 3,000.00.");
                        System.out.print("Are you sure about your choice of insurance? (Y/N): ");
                    }
                    if (insSelect == 2){
                        System.out.println("You have chosen SILVER INSURANCE worth Php 1,500.00.");
                        System.out.print("Are you sure about your choice of insurance? (Y/N): ");
                    }
                    if (insSelect == 3){
                        System.out.print("Are you sure about not getting an insurance for your vehicle? (Y/N): ");
                    }
                    confirm = (input.nextLine()).toUpperCase();
                    if (confirm.equals("Y")){
                        if (insSelect == 1){
                            insurance = "Premium";
                            insPrice = 3000.00;}
                        else if (insSelect == 2){
                            insurance = "Silver";
                            insPrice = 1500.00;}
                        else if (insSelect == 3){
                            insPrice = 0;}
                        insLoop = false;
                        rentPurchase(typeIndex, carIndex, cusIndex, rentDays, discount, insurance, insPrice);
                    }
                    else if (confirm.equals("N")){
                        insLoop = false;
                        rentInsuranceSet(typeIndex, carIndex, cusIndex, rentDays, discount);
                    }
                    else {
                        System.out.println("You have put an invalid input. Please try again.");
                        insLoop = false;
                        rentInsuranceSet(typeIndex, carIndex, cusIndex, rentDays, discount);
                    }
                }
                }
            catch (Exception e) {
                System.out.println("You have put an invalid input. Please try again.");
            }
        } while (insLoop);
    }




    public static void rentPurchase(int typeIndex, int carIndex, int cusIndex, int rentDays, boolean discount, String insurance, double insPrice){
        boolean purLoop = true;
        String confirm;
        double initialPrice = vehicleList.get(typeIndex).get(carIndex).getIntPrice(rentDays);
        double insuredPrice = 0;
        double finalPrice = 0;

        do { 
            try {
                purLoop = true;
                System.out.println("\n== RENTAL PURCHASE ==");
                System.out.println("(Vehicle Details)");
                System.out.println("\tCar Model: " + vehicleList.get(typeIndex).get(carIndex).getModel());
                System.out.println("\tCar Type: " + vehicleList.get(typeIndex).get(carIndex).getType());
                System.out.println("\tFuel: " + vehicleList.get(typeIndex).get(carIndex).getFuel());
                System.out.println("\tTransmission: " + vehicleList.get(typeIndex).get(carIndex).getTrans());
                System.out.print("\tBase Rental Price: Php ");
                System.out.print(String.format("%,.2f", vehicleList.get(typeIndex).get(carIndex).getPrice()));
                System.out.println("");
                System.out.println("(Rental Details)");
                System.out.println("\tDays to be Rented: " + rentDays);
                System.out.print("\tInitial Price: Php ");
                System.out.print(String.format("%,.2f", initialPrice));
                System.out.println("");
                System.out.println("\tInsurance: " + insurance);
                insuredPrice = initialPrice + insPrice;
                if (!(insurance.equals("None"))){
                    System.out.print("\tInsurance Price: Php ");
                    System.out.print(String.format("%,.2f", insPrice));
                    System.out.print("\n\tInsured Price: Php ");
                    System.out.print(String.format("%,.2f", insuredPrice));
                    System.out.println("");
                }
                System.out.println("\tEligible for Discount?: " + (rentDays >= 6 ? "Yes" : "No"));
                finalPrice = insuredPrice;
                if (rentDays >= 6){
                    finalPrice = insuredPrice * 0.85;
                }
                System.out.print("\tFinal Price: Php ");
                System.out.print(String.format("%,.2f", finalPrice));
                System.out.println("");
                System.out.print("\nAre you sure of your purchase? (Y/N): "); 
                confirm = (input.nextLine()).toUpperCase();
                if (confirm.equals("Y")){
                    vehicleList.get(typeIndex).get(carIndex).setStatus(false);
                    purLoop = false;
                    rentPayment(typeIndex, carIndex, cusIndex, rentDays, discount, insurance, insPrice, initialPrice, insuredPrice, finalPrice);}
                else if (confirm.equals("N")){
                    purLoop = false;
                    customerProgSort(cusIndex);}
                else {
                    System.out.println("You have put an invalid input. Please try again.");
                    purLoop = false;
                    rentPurchase(typeIndex, carIndex, cusIndex, rentDays, discount, insurance, insPrice);
                }
            }
            catch (Exception e) {
                System.out.println("You have put an invalid input. Please try again.");
            }
        } while (purLoop);
    }




    public static void rentPayment(int typeIndex, int carIndex, int cusIndex, int rentDays, boolean discount, String insurance, double insPrice, double initialPrice, double insuredPrice, double finalPrice){
    boolean payLoop = true;
    double payment;
    double change = 0;


    do { 
        try {
            payLoop = true;
            System.out.print("The final price is Php ");
            System.out.print(String.format("%,.2f", finalPrice));
            System.out.println("");
            System.out.print("\nPlease enter your payment: ");
            payment = Double.parseDouble(input.nextLine());
            if (payment <= 0){
                System.out.println("You have put an invalid input. Please try again.");
                payLoop = false;
                rentPayment(typeIndex, carIndex, cusIndex, rentDays, discount, insurance, insPrice, initialPrice, insuredPrice, finalPrice);
            }
            if (finalPrice > payment){
                System.out.println("Your payment is less than the final rental price. Please try again.");
                payLoop = false;
                rentPayment(typeIndex, carIndex, cusIndex, rentDays, discount, insurance, insPrice, initialPrice, insuredPrice, finalPrice);
            }
            else if (finalPrice == payment){
                System.out.println("You have paid the exact final rental price.");
                payLoop = false;
                invoicePrint(typeIndex, carIndex, cusIndex, rentDays, discount, insurance, insPrice, initialPrice, insuredPrice, finalPrice, payment, change);
            }
            else if (finalPrice < payment){
                change = payment - finalPrice;
                System.out.print("You have paid Php ");
                System.out.print(String.format("%,.2f", payment));
                System.out.println("");
                System.out.print("You will receive change of Php ");
                System.out.print(String.format("%,.2f", change));
                System.out.println("");
                payLoop = false;
                invoicePrint(typeIndex, carIndex, cusIndex, rentDays, discount, insurance, insPrice, initialPrice, insuredPrice, finalPrice, payment, change);
            }
        } catch (Exception e) {
            System.out.println("You have put an invalid input. Please try again.");
        }
    } while (payLoop);
    }




    public static void invoicePrint(int typeIndex, int carIndex, int cusIndex, int rentDays, boolean discount, String insurance, double insPrice, double initialPrice, double insuredPrice, double finalPrice, double payment, double change){
        boolean print = true;

        do{
        try {
            print = true;
            FileWriter fwrite = new FileWriter("C://Users//Clark//Desktop//CarRental//Invoice " + purchaseNum +".txt", true);
            fwrite.append("INVOICE " + purchaseNum);
            fwrite.append("\n== RENTAL PURCHASE ==");
            fwrite.append("\n(Vehicle Details)");
            fwrite.append("\n\tCar Model: " + vehicleList.get(typeIndex).get(carIndex).getModel());
            fwrite.append("\n\tCar Type: " + vehicleList.get(typeIndex).get(carIndex).getType());
            fwrite.append("\n\tFuel: " + vehicleList.get(typeIndex).get(carIndex).getFuel());
            fwrite.append("\n\tTransmission: " + vehicleList.get(typeIndex).get(carIndex).getTrans());
            fwrite.append("\n\tBase Rental Price: Php ");
            fwrite.append(String.format("%,.2f", vehicleList.get(typeIndex).get(carIndex).getPrice()));

            fwrite.append("\n(Rental Details)");
            fwrite.append("\n\tDays to be Rented: " + rentDays);
            fwrite.append("\n\tInitial Price: Php ");
            fwrite.append(String.format("%,.2f", initialPrice));
            fwrite.append("\n\tInsurance: " + insurance);
            if (!(insurance.equals("None"))){
                fwrite.append("\n\tInsured Price: Php ");
                fwrite.append(String.format("%,.2f", insuredPrice));
            }
            fwrite.append("\n\tEligible for Discount?: " + (rentDays >= 6 ? "Yes" : "No"));
            fwrite.append("\n\tFinal Price: Php ");
            fwrite.append(String.format("%,.2f", finalPrice));
            fwrite.append("\n\tPayment: Php ");
            fwrite.append(String.format("%,.2f", payment));
            fwrite.append("\n\tChange: Php ");
            fwrite.append(String.format("%,.2f", change));

            fwrite.append("\n\nCUSTOMER INFO");
            fwrite.append("\n\tName: " + customerList.get(cusIndex).getName());
            fwrite.append("\n\tAge (y/o): " + customerList.get(cusIndex).getAge());
            fwrite.append("\n\tLicense?: " + (customerList.get(cusIndex).getLicense() == true ? "Yes" : "No"));
            fwrite.append("\n\tCustomer ID: " + customerList.get(cusIndex).getId());
            fwrite.close();

            purchaseNum += 1;
            System.out.println("Your invoice has been succesfully printed.");
            System.out.println("Thank you for choosing WHEELS ON DEMAND!");

            customerProgSort(cusIndex);
            }     
            catch (IOException e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
            }
        } while (print);
    }


    public static void vehicleReturn(int a, int cusIndex){
        boolean returnLoop = true;
        int select;
        String confirm;

        System.out.println("== Return Vehicle ==");
        do { 
            try {
                returnLoop = true;
                select = -2;
                System.out.print("Select vehicle to return (1-" + (vehicleList.get(a).size()) + ") [type 0 to exit]: ");
                select = Integer.parseInt(input.nextLine());
                select -= 1;
                if (select > vehicleList.get(a).size() || select < -1){
                    System.out.println("You have put an invalid number. Please try again.\n");
                    vehicleReturn(a, cusIndex);
                }
                if (select == -1){
                    returnLoop = false;
                    customerProgSort(cusIndex);
                }
                if (vehicleList.get(a).get(select).getStatus() == true){
                    System.out.println("This car is already in the inventory. It cannot be returned.");
                    customerProgSort(cusIndex);
                }
                else {
                    System.out.println("(Vehicle)");
                    System.out.println("\tCar Model: " + vehicleList.get(a).get(select).getModel());
                    System.out.println("\tCar Type: " + vehicleList.get(a).get(select).getType());
                    System.out.println("\tFuel: " + vehicleList.get(a).get(select).getFuel());
                    System.out.println("\tTransmission: " + vehicleList.get(a).get(select).getTrans());
                    System.out.print("\tRental Price: Php ");
                    System.out.print(String.format("%,.2f", vehicleList.get(a).get(select).getPrice()));
                    System.out.print("\nAre you sure you want to return this vehicle? (Y/N): ");
                    confirm = (input.nextLine()).toUpperCase();
                    if (confirm.equals("Y")){
                        vehicleList.get(a).get(select).setStatus(true);
                        System.out.println("This vehicle has been returned to our inventory.");
                        System.out.println("Thank you for choosing WHEELS ON DEMAND!");
                        returnLoop = false;
                        customerProgSort(cusIndex);
                    }
                    else if (confirm.equals("N")){
                        returnLoop = false;
                        customerProgSort(cusIndex);
                    }
                    else {
                        System.out.println("You have put an invalid input. Please try again.");
                        vehicleReturn(a, cusIndex);
                    }

                    }
                }
            catch (Exception e) {
                System.out.println("You have put an invalid input. Please try again.");
            }
        } while (returnLoop);
    }



    public static void showCustomers(){
        //Showing of Customer Records for Admin
        System.out.println("== Customer Records ==");
        for (int a = 0; a < customerList.size(); a++){
            System.out.println("(Customer " + (a+1) + ")");
            System.out.println("\tName: " + customerList.get(a).getName());
            System.out.println("\tAge (y/o): " + customerList.get(a).getAge());
            System.out.println("\tCustomer ID: " + customerList.get(a).getId());
            System.out.println("\tLicense?: " + ((customerList.get(a).getLicense() ==  true) ? "Y" : "N"));
        }
        adminProgSort();
    }



    public static void addSelect(String type, int carSort){
        boolean addloop = true;
        String model, fuel, trans;
        String decision;
        double price;

        carSort -=1;
        do{
        try{
        addloop = true;
        System.out.println("== Add a Vehicle ==");
        System.out.print("Car Model: ");
        model = input.nextLine();
        System.out.print("Fuel: ");
        fuel = input.nextLine();
        System.out.print("Transmission (Automatic/Manual): ");
        trans = input.nextLine();
        System.out.print("Rental Price: Php ");
        price = Double.parseDouble(input.nextLine());
        if (price <= 0){
            System.out.println("You have put an invalid input. Please try again.");
            addSelect(type, carSort);
        }

        System.out.println("(Vehicle Details)");
        System.out.println("\tCar Model: " + model);
        System.out.println("\tCar Type: " + type);
        System.out.println("\tFuel: " + fuel);
        System.out.println("\tTransmission: " + trans);
        System.out.print("\tRental Price: Php ");
        System.out.print(String.format("%,.2f", price));
        System.out.print("\nAre you sure you want to add this car? (Y/N): ");
        decision = (input.nextLine()).toUpperCase();
        if (decision.equals("Y")){
            addloop = false;
            addVehicle(carSort, model, type, fuel, trans, price);
        }
        else if (decision.equals("N")){
            addloop = false;
            adminProgSort();
        }
        else {
            System.out.println("You have put an invalid input. Please try again.");
            addSelect(type, carSort);
        }
    }
    catch (Exception e){
        System.out.println("You have put an invalid input. Please try again.");
    }
    }while (addloop);

    }



    public static void addVehicle(int a, String model, String type, String fuel, String trans, double price){
        vehicleList.get(a).add(new Vehicle (model, type, fuel, trans, price));
        System.out.println("Vehicle has been added to your inventory!");
        adminProgSort();

    }



    public static void removeSelect(int a){
        boolean remLoop = true;
        int select;
        String confirm;

        System.out.println("== Remove Vehicle ==");
        do { 
            try {
                remLoop = true;
                select = -2;
                System.out.print("Select vehicle to remove (1-" + (vehicleList.get(a).size()) + ") [type 0 to exit]: ");
                select = Integer.parseInt(input.nextLine());
                select -= 1;
                if (select > vehicleList.get(a).size() || select < -1){
                    System.out.println("You have put an invalid number. Please try again.\n");
                    removeSelect(a);
                }
                if (select == -1){
                    remLoop = false;
                    adminProgSort();
                }
                if (vehicleList.get(a).get(select).getStatus() == false){
                    System.out.println("This car is out for rent. It cannot be removed.");
                    adminProgSort();
                }
                else {
                    System.out.println("(Vehicle)");
                    System.out.println("\tCar Model: " + vehicleList.get(a).get(select).getModel());
                    System.out.println("\tCar Type: " + vehicleList.get(a).get(select).getType());
                    System.out.println("\tFuel: " + vehicleList.get(a).get(select).getFuel());
                    System.out.println("\tTransmission: " + vehicleList.get(a).get(select).getTrans());
                    System.out.print("\tRental Price: Php ");
                    System.out.print(String.format("%,.2f", vehicleList.get(a).get(select).getPrice()));
                    System.out.print("\nAre you sure you want to remove this vehicle? (Y/N): ");
                    confirm = (input.nextLine()).toUpperCase();
                    if (confirm.equals("Y")){
                        remLoop = false;
                        removeVehicle(a, select);
                    }
                    else if (confirm.equals("N")){
                        remLoop = false;
                        adminProgSort();
                    }
                    else {
                        remLoop = false;
                        System.out.println("You have put an invalid input. Please try again.");
                        removeSelect(a);
                    }

                    }
                }
            catch (Exception e) {
                System.out.println("You have put an invalid input. Please try again.");
            }
        } while (remLoop);
    }



    public static void removeVehicle(int a, int select){
        vehicleList.get(a).remove(select);
        System.out.println("Vehicle has been removed your inventory!");
        adminProgSort();
    }



    public static void customerVerify(){
        //Customer Identification
        int sort = 0;
        boolean loop= true;

        System.out.println("""
                           == Customer Identification ==
                           (1) Old Customer
                           (2) New Customer
                           (3) Exit Customer Identification""");
        do{
            try{
                loop = true;
                sort = 0;
                System.out.print("\nPlease type your number (1-3): ");

                sort = Integer.parseInt(input.nextLine());
                if (sort > 5 || sort < 1){
                    System.out.println("You have put an invalid number. Please try again.\n");
                }
                else{
                    loop = false;
                }
            }
        catch (Exception e) {
            System.out.println("You have put an invalid input. Please try again.\n");
        }
        } while (loop);

        switch (sort) {
            case 1:
                customerConfirm();
                break;
            case 2:
                customerRegister();
                break;
            case 3:
                ident();
                break;
        }

    }

    public static void menuExit (String status, int cusIndex){
        boolean exitLoop = true;
        String decision;

        do { 
            try {
                exitLoop = true;
                System.out.print("Are you sure you want to exit? (Y/N): ");
                decision = (input.nextLine()).toUpperCase();
                if (decision.equals("Y")){
                    exitLoop = false;
                    ident();
                }
                else if (decision.equals("N")){
                    if (status.equals("Admin")){
                        exitLoop = false;
                        adminProgSort();
                    }
                    else if (status.equals("Customer")){
                        exitLoop = false;
                        customerProgSort(cusIndex);
                    }
                }
            } catch (Exception e) {
                System.out.println("You have put an invalid input. Please try again.");
            }
        } while (exitLoop);
    }

    public static void customerConfirm (){
        int cusIdInput;
        boolean conLoop = true;
        String decision;

        do {
            try {
                conLoop = true;
                System.out.print("If you are an old customer, please enter your customer ID as registered: ");
                cusIdInput = Integer.parseInt(input.nextLine());
                System.out.println(cusIdInput);
                for (int i = 0; i < customerList.size(); i++){
                    if (cusIdInput == customerList.get(i).getId()){
                        System.out.println("(Customer Details)");
                        System.out.println("\tName: " + customerList.get(i).getName());
                        System.out.println("\tAge (y/o): " + customerList.get(i).getAge());
                        System.out.println("\tLicense?: " + (customerList.get(i).getLicense() == true ? "Yes" : "No"));
                        System.out.println("\tCustomer #: " + customerList.get(i).getId());
                        System.out.print("\nAre you sure that this is you? (Y/N): ");
                        decision = (input.nextLine()).toUpperCase();
                        if (decision.equals("Y")){
                            System.out.println("Welcome back, " + customerList.get(i).getName() + " to WHEELS ON DEMAND!");
                            int cusIndex = i;
                            conLoop = false;
                            customerProgSort(cusIndex);
                        }
                        else if (decision.equals("N")){
                            conLoop = false;
                            customerVerify();
                        }
                        else {
                            System.out.println("You have put an invalid input. Please try again.");
                            customerConfirm();
                        }
                    }
                    }
                    System.out.println("Sorry, the number you have inputted is not in our system.");
                    conLoop = false;
                    customerVerify();
                }
            catch (Exception e) {
                System.out.println("You have put an invalid input. Please try again.");
            }
        } while (conLoop);
    }



    public static void customerRegister(){
        boolean regLoop = true;
        String name, license;
        int age;
        int number;
        String decision;

        do{
            try {
            number = 1004;
            for (Customer cus : customerList){
                if (number > cus.getId()){
                }
                else if (number == cus.getId()){
                    number +=1;
                }
            }
            regLoop = true;
            System.out.println("== Customer Registration ==");
            System.out.print("Name: ");
            name = input.nextLine();
            System.out.print("Age (y/o): ");
            age = Integer.parseInt(input.nextLine());
                if (age >= 100 || age <= 0){
                    System.out.println("You have put an invalid input. Please try again.");
                    customerRegister();
                }
                else if (age < 18){
                    System.out.println("Sorry! You are not eligible for our rental service.");
                    customerVerify();
                }
            System.out.print("Do you have a license? (Y/N): ");
            license = (input.nextLine()).toUpperCase();
                if (license.equals("N")){
                    System.out.println("Sorry! You are not eligible for our rental service.");
                    customerVerify();
                }
                else if (license.equals("Y")){
                }
                else{
                    System.out.println("You have put an invalid input. Please try again.");
                    customerRegister();
                }

            System.out.println("(Customer Details)");
            System.out.println("\tName: " + name);
            System.out.println("\tAge (y/o): " + age);
            System.out.println("\tLicense?: " + license);
            System.out.println("\tCustomer #: " + number);
            System.out.print("\nAre you sure that the information you have added is correct? (Y/N): ");
            decision = (input.nextLine()).toUpperCase();
            if (decision.equals("Y")){
                System.out.println("Congratulations! Welcome " + name + " to WHEELS ON DEMAND!");
                customerList.add(new Customer(name, number, age));
                number += 1;
                int cusIndex = customerList.size() - 1;
                regLoop = false;
                customerProgSort(cusIndex);
            }
            else if (decision.equals("N")){
                regLoop = false;
                customerVerify();
            }
            else {
                System.out.println("You have put an invalid input. Please try again.");
                customerRegister();
            }
        }
        catch (Exception e){
            System.out.println("You have put an invalid input. Please try again.");
        }
        } while (regLoop);
    }



    public static void customerProgSort(int cusIndex){
        //Admin Main Menu
        int sort = 0;
        boolean loopCus = true;

        System.out.println("\n=== WHEELS ON DEMAND ===");
        System.out.println("""
                           == CUSTOMER MAIN MENU ==
                           (1) Rent a Vehicle
                           (2) Return a Vehicle
                           (3) Show Vehicle Inventory
                           (4) Exit Customer""");
        do{
            try{
                loopCus = true;
                sort = 0;
                System.out.print("\nPlease type your number (1-4): ");

                sort = Integer.parseInt(input.nextLine());
                if (sort > 5 || sort < 1){
                    System.out.println("You have put an invalid number. Please try again.\n");
                }
                else{
                    loopCus = false;
                }
            }
        catch (Exception e) {
            System.out.println("You have put an invalid input. Please try again.\n");
        }
        } while (loopCus);

        switch (sort) {
            case 1:
                carTypeSelect(sort, "Customer", cusIndex);
                break;
            case 2:
                carTypeSelect(sort, "Customer", cusIndex);
                break;
            case 3:
                carTypeSelect(sort, "Customer", cusIndex);
                break;
            case 4:
                menuExit("Customer", cusIndex);
                break;
        }

    }

    }

    


    