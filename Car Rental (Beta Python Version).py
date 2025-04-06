#MEMBERS: Roque DJC, Marcelino PC, Aquino KR, Ting DE, Sicat J
#Car inventory (nested dictionary)
car_inventory = {
    "Sedan": {
        "availability": [True, True, True],
        "models": ["Toyota Camry", "Honda City", "Mitsubishi Mirage"],
        "transmission": ["Automatic", "Manual", "Automatic"],
        "fuel": ["Gasoline", "Unleaded", "Unleaded"],
        "base_price": [4500.00 * 1.4, 4500.00, 4500.00 * 1.4]
    },
    "SUV": {
        "availability": [True, True, True],
        "models": ["Toyota Fortuner", "Nissan Terra", "Mitsubishi Montero Sport"],
        "transmission": ["Automatic", "Automatic", "Manual"],
        "fuel": ["Diesel", "Diesel", "Diesel"],
        "base_price": [6000.00 * 1.4, 6000.00 * 1.4, 6000.00]
    },
    "Van": {
        "availability": [True, False, True],
        "models": ["Toyota Hiace", "Nissan Urvan NV350", "Hyundai Starex"],
        "transmission": ["Automatic", "Manual", "Automatic"],
        "fuel": ["Gasoline", "Gasoline", "Gasoline"],
        "base_price": [8500.00 * 1.4, 8500.00, 8500.00 * 1.4]
    },
    "Pick Up": {
        "availability": [True, True, True],
        "models": ["Toyota Hilux", "Nissan Navarra", "Ford Raptor"],
        "transmission": ["Automatic", "Automatic", "Manual"],
        "fuel": ["Gasoline", "Gasoline", "Gasoline"],
        "base_price": [7000.00 * 1.4, 7000.00 * 1.4, 7000.00]
    },
    "Luxury Car": {
        "availability": [False, True, True],
        "models": ["BMW 5 Series", "Mercedes-Benz E-Class", "Audi A6"],
        "transmission": ["Automatic", "Automatic", "Manual"],
        "fuel": ["Gasoline", "Diesel", "Gasoline"],
        "base_price": [15000.00 * 1.4, 15000.00 * 1.4, 15000.00]
    }
}

# Car Selection function
def car_valid(number):
    match number:
        case "1":
            return "Sedan"
        case "2":
            return "SUV"
        case "3":
            return "Van"
        case "4":
            return "Pick Up"
        case "5":
            return "Luxury Car"
        case _:
            return None

#Transmission Selection function
def trans_valid(status):
    match status:
        case "1":
            return "Automatic"
        case "2":
            return "Manual"


#Car List and Filter function
def display_car_list(cartype, transmission):
    details = car_inventory[cartype]
    print("\n=== CAR LIST ===")
    available_cars = False
    print(f"{cartype}s available with {transmission} Transmission:")
    for i in range(3):
        if details["transmission"][i] == transmission and details["availability"][i]:
            print(f"{i + 1}. {details['models'][i]}, Transmission: {transmission}, Fuel: {details['fuel'][i]}, Base Price: P{details['base_price'][i]:,.2f}")
            available_cars = True
        else:
            pass
        
    if available_cars==False:
        print(f"Currently, there are no {transmission} cars available in the {cartype} category. Please choose a different transmission or car type.")
        return True
    
    return False
    
#Discount function
def apply_discount(price, days):
    if days >= 5:
        return price * 0.92, "Yes"
    return price, "None"

#Return car function (changes availability status to be rented again)
def return_car():
    car_selection = "0"
    while car_selection == "0":
        print("\n=== RETURN CAR SERVICE ===")
        print("What type of car are you returning?\n1. Sedan\n2. SUV\n3. Van\n4. Pick Up\n5. Luxury Car\n6. Return to Main Menu")
        
        car_selection = input("Enter the number of your car type you rented: ")

        match car_selection:
            case "6":
                return "0"
            case "1" | "2" | "3" | "4" | "5":
                cartype = car_valid(car_selection)

                # Display the available models in the chosen category
                model_num = "0"
                while model_num == "0":
                    print(f"\nAvailable models in the {cartype} category:")
                    details = car_inventory[cartype]
                        
                    for i in range(3):
                        if details["availability"][i]:
                            print(f"{i + 1}. {details['models'][i]} (Available)")
                        else:
                            print(f"{i + 1}. {details['models'][i]} (Currently Rented)")
                    print("4. Return to Car Type")

                    model_num = input("\nEnter the number of the car model you'd like to return (e.g., 1, 2, 3): ")
                        
                    if model_num == "4":
                        car_selection = "0"
                    elif model_num in ["1", "2", "3"]:
                        model_num = int(model_num) - 1
                        
                            
                        if details["availability"][model_num] == False:

                            details["availability"][model_num] = True
                            print(f"\nThank you for returning the {details['models'][model_num]}! It is now available for rental again.")

                            return "0"
                        else:
                            print(f"\nThe {details['models'][model_num]} is not out for rent and is currently available.")
                            return "0"
                    else:
                        print("\nInvalid model number.")
                        model_num = "0"
                    
            case _:
                print("You have put an invalid input. Please choose from numbers 1-6.")
                car_selection = "0"


#Exit Program function
def exitprog():
    prog = True
    while prog:
        prog_exit = input("\nAre you sure you want to exit the program? [Yes/No]: ")
        match prog_exit:
            case "yes" | "y" | "Yes" | "Y":
                print("\nThank you for choosing Wheels on Demand! We hope to see you again.")
                exit()
                prog=False
            case "no" | "n" | "No" | "N":
                return "0"
            case _:
                print("Invalid Input. Please enter 'Yes' or 'No'")



print("\t\t========== WHEELS ON DEMAND ==========\n")
print("============ Connecting you to the road, one click away! ============\n")

age_valid = True
dlicense_valid = True

while age_valid:
    age = input("To proceed, please enter your age as a number: ")
    if not age.isdigit():
        print("You have not put the number of your age. Please try again.")
    else:
        age = int(age)
        if age < 18 or age > 100:
            print("Sorry, you are not eligible for our rental service.")
            exit()
        else:
            age_valid = False

while dlicense_valid:
    dlicense = input("Do you have a driver's license? [Yes/No]: ")
    match dlicense:
        case "yes" | "y" | "Yes" | "Y":
            dlicense_valid = False
        case "no" | "n" | "No" | "N":
            print("Sorry, you are not eligible for our rental service.")
            exit()
        
#Main program loop will lopp until the user chooses to exit
main_selection = "0"
while main_selection == "0":
    
    print("\n=== MAIN MENU ===\nWhat would you like to do with our services?\n1. Rent\n2. Return\n3. Exit")
    main_selection = input("Enter the number of your choice: ")
    
    match main_selection:
        case "1":
            car_selection = True
            #Car type selection
            while car_selection:
                print("\n=== CAR TYPE (Rent) ===\nWhat type of car are you looking for?\n(Base prices shown are for Manual cars.)\n1. Sedan (Base Price: 4500.00)\n2. SUV (Base Price: 6000.00)\n3. Van (Base Price: 8500.00)\n4. Pick Up (Base Price: 7000.00)\n5. Luxury Car (Base Price: 15000.00)\n6. Return to Main Menu")
                car_select = input("Enter the number of your desired vehicle (1-6): ")
                match car_select:
                    case "6": #Return to main menu
                        main_selection = "0"
                        car_selection = False 
                    case "1" | "2" | "3" | "4" | "5":
                        cartype = car_valid(car_select)
                        car_details = car_inventory[cartype]
                        
                        car_selection = False
                        #Transmission selection
                        trans_select = True
                        while trans_select:
                            print("\n=== TRANSMISSION ===\nWhat transmission would you like your car to have?\n1. Automatic\n2. Manual\n3. Return to Car Type")
                            trans_selection = input("Enter the number of your desired transmission (1-3): ")
                            match trans_selection:
                                case "3":
                                    car_selection = "0"
                                    trans_select = False
                                case "1" | "2":
                                    transmission = trans_valid(trans_selection)
                                    trans_select = False
                                    trans_select = display_car_list(cartype, transmission)

                                    if trans_select == False:
                                        model_choice = True
                                        while model_choice == True:
                                            model_num = input("\nEnter the number of your desired model here (e.g., 1, 2, 3, or enter 0 if you wish to return to Car Transmissions.): ")
                                            model_num = int(model_num) - 1
                                            #Check if car is available
                                            if model_num == -1:
                                                model_choice = False
                                                trans_select = True
                                            elif 0 <= model_num < len(car_details["models"]):
                                                if car_details["availability"][model_num]:
                                                    car_details["availability"][model_num] = False
                                                    print(f"\nYou have chosen to rent the {car_details['models'][model_num]}.")
                                                    base_price = car_details["base_price"][model_num]
                                                    modelchoice = False
                                                    #Rental duration (input)    
                                                    print("\n=== RENTAL DAYS ===\nHow many days would you like to rent the car?\nNote: 5 or more days of rent includes an 8% DISCOUNT PROMO!")
                                                    dayselect = True
                                                    while dayselect:
                                                        rent_days = int(input("\nEnter the number of your desired days to rent the car: "))
                                                        if rent_days <= 0:
                                                            print("You have put an invalid number of days. Please try again.")
                                                        else:
                                                            dayselect = False
                                                    #Insurance selection (input)               
                                                    print("\n=== INSURANCE ===\nWould you like to add an insurance?\n1. Premium Package: 3000\n(Includes DAMAGE, THEFT, and THIRD PARTY LIABILITY)")
                                                    print("\n2. Silver Package: 1500\n(Includes DAMAGE and THEFT) \n\n3. NO INSURANCE \n=== INSURANCE IS NON-REFUNDABLE ===")

                                                    price_dis = apply_discount(base_price, rent_days)
                                                    
                                                    insure = True
                                                    while insure:
                                                        insurance = input("Would you like to add insurance? (1-3): ")
                                                        match insurance:
                                                            case "1":
                                                                total_price = (price_dis[0] * rent_days) + 3000.00
                                                                insurance_status = "Premium Insurance (P3000.00)"
                                                                insure = False
                                                            case "2":
                                                                total_price = (price_dis[0] * rent_days) + 1500.00
                                                                insurance_status = "Silver Insurance (P1500.00)"
                                                                insure = False
                                                            case "3":
                                                                total_price = price_dis[0] * rent_days
                                                                insurance_status = "None"
                                                                insure = False
                                                            case _:
                                                                print("Invalid input. Enter a number between 1 and 3.")
                                                    #Apply discount
                                                    
                                                    #Dsiplay invoice
                                                    print("\n\t=== INVOICE ===")
                                                    print(f"Car Model: {car_details['models'][model_num]}")  
                                                    print(f"Transmission: {transmission}")
                                                    print(f"Fuel Type: {car_details['fuel'][model_num]}")
                                                    print(f"Base Price: P{car_details['base_price'][model_num]:,.2f}")
                                                    print(f"Rental Days: {rent_days}")
                                                    print(f"Total Cost: {rent_days * base_price:,.2f}")
                                                    print("Discount Status:", price_dis[1])
                                                    if price_dis[1] == "Yes":
                                                        print(f"Discounted Price: P{price_dis[0] * rent_days:,.2f}")
                                                    print("Insurance Status:", insurance_status)
                                                    print(f"Final Cost: P{total_price:,.2f}")
                                                    #Payment process
                                                    change_cycle = True
                                                    while change_cycle:
                                                        payment = float(input("\nEnter your amount of payment in numbers: "))
                                                        change = payment - total_price
                                                        if change > 0:
                                                            print("Your change is P" + format(change, ',.2f'))
                                                            change_cycle = False
                                                        elif change == 0:
                                                            print("You have paid the exact amount and thus have no more change.")
                                                            change_cycle = False
                                                        else:
                                                            print("You are paying insufficient money. Please try again.")
                                                    model_choice = False
                                                    trans_select = False
                                                    main_selection = "0" 
                                                    
                                                else:
                                                    print("Sorry, that model is not available. Please choose another model.")

                                                  
                                            else:
                                                print("Invalid model number. Please enter a number corresponding to the available models.")

                                    
                                case _:
                                    print("Invalid Input. Enter a number between 1-3")
                            
                            
                    case _:
                        print("Invalid Input. Enter a number between 1-6")
                        continue

                       
                                               
        #If user chose "Return"
        case "2":
            main_selection = return_car()
        #If user chose "Exit"
        case "3":
            main_selection = exitprog()
            
        case _:
            print("\nInvalid selection. Please choose a number between 1-3.")
            main_selection = "0"
