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


class Customer
{
    private String cusName;
    private boolean cusLicense;
    private int cusId;
    private int cusAge;


    public Customer(String name, int num, int age)
    {
        cusName = name;
        cusLicense = true;
        cusId = num;
        cusAge = age;
    }

    public void setName (String name)
    {
        cusName = name;
    }

    public String getName()
    {
        return cusName;
    }

    public void setLicense (boolean register)
    {
        cusLicense = register;
    }

    public boolean getLicense()
    {
        return cusLicense;
    }

    public void setId (int num)
    {
        cusId = num;
    }

    public int getId()
    {
        return cusId;
    }

    public void setAge (int age)
    {
        cusAge = age;
    }

    public int getAge()
    {
        return cusAge;
    }
}
