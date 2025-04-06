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


class Vehicle
{
    private String carModel;
    private String carType;
    private String carFuel;
    private String carTrans;
    private double basePrice;
    private boolean availStatus;

    public Vehicle(String model, String type, String fuel, String transmission, double price)
    {
        carModel = model;
        carType = type;
        carFuel = fuel;
        carTrans = transmission;
        basePrice = price;
        availStatus = true;
    }

    public void setModel (String name)
    {
        carModel = name;
    }

    public String getModel()
    {
        return carModel;
    }

    public void setType (String type)
    {
        carType = type;
    }

    public String getType()
    {
        return carType;
    }

    public void setFuel (String fuel)
    {
        carFuel = fuel;
    }

    public String getFuel()
    {
        return carFuel;
    }

    public void setTrans (String trans)
    {
        carTrans= trans;
    }

    public String getTrans()
    {
        return carTrans;
    }

    public void setPrice (double price)
    {
        basePrice = price;
    }

    public double getPrice()
    {
        return basePrice;
    }

    public void setStatus (boolean status)
    {
        availStatus = status;
    }

    public boolean getStatus()
    {
        return availStatus;
    }

    public double getIntPrice(int days)
    {
        double intPrice = basePrice * days;
        return intPrice;
    }
}
