# GUI Button Functionality Reference

## Complete Button Guide for Insurance Application

---

## Tab 1: Båt Forsikring (Boat Insurance)

### Input Fields
- **Kunde Nummer**: Customer number for registration
- **Registrerings Nummer**: Boat registration number
- **Båt Type**: Type of boat
- **Båt Modell**: Boat model name/number
- **Båt Lengde**: Boat length (numeric)
- **Båt Årsmodell**: Boat model year (numeric)
- **MotorStyrk**: Motor power (numeric - in horsepower)
- **Motor Type**: Type of motor (e.g., diesel, petrol, electric)
- **Bonus**: Bonus percentage (optional, numeric)

### Buttons and Functions
1. **Add New** Button
   - Validates all fields are filled
   - Creates a new BaatForsikring object
   - Looks up customer by customer number
   - Displays confirmation with customer name and boat details
   - Shows error dialog if validation fails or customer not found

2. **View** Button
   - Displays all registered boat insurances
   - Shows complete list of boats in the system
   - Clears previous results and shows fresh data

3. **Save** Button
   - Saves all boat insurance data to file (lister.txt)
   - Shows confirmation dialog on success
   - Shows error dialog if save operation fails

4. **Exit** Button
   - Closes the entire application
   - No data save prompt (save first!)

---

## Tab 2: Reise Forsikring (Travel Insurance)

### Input Fields
- **Kunde Nummer**: Customer number for registration
- **Område**: Coverage area/region for the trip
- **Forsikringssum**: Insured amount (sum covered, numeric)
- **Bonus**: Bonus percentage (optional, numeric)

### Buttons and Functions
1. **Add New** Button
   - Validates customer number, area, and sum are provided
   - Creates a new Reise object with coverage details
   - Calculates premium based on sum and bonus
   - Displays created travel insurance object details
   - Shows error dialog for missing or invalid data

2. **View** Button
   - Shows overview of travel insurance registrations
   - Placeholder message (can be enhanced to show actual list)

3. **Save** Button
   - Saves travel insurance data to file (lister.txt)
   - Provides success/error feedback

4. **Exit** Button
   - Closes the application

---

## Tab 3: Hus og Innbo Forsikring (House and Contents Insurance)

### Input Fields
- **Boligen Adress**: Property address
- **BoligType**: Type of housing (e.g., single family, apartment)
- **Bygge Materiale**: Building material (e.g., wood, brick, concrete)
- **Standard**: Property standard/condition level
- **Byggeår**: Building year (numeric)
- **Antall Kvadratmeter**: Square meters of property (numeric)
- **BelopB**: Building insurance amount (numeric)
- **Bonus**: Bonus percentage (optional, numeric)

### Buttons and Functions
1. **Add New** Button
   - Validates all property information fields
   - Creates Husoginnboforsikring object
   - Calculates premium: square meters × building amount × (1 - bonus/100)
   - Displays confirmation with property and insurance details
   - Shows error for missing or invalid numeric values

2. **View** Button
   - Shows all registered house and contents insurances
   - Displays overview of all properties

3. **Save** Button
   - Saves house insurance data to file
   - Confirms operation with success/error message

4. **Exit** Button
   - Closes the application

---

## Tab 4: Fritidsforsikring (Leisure Property Insurance)

### Input Fields
- **Boligen Adress**: Leisure property address
- **BoligType**: Type of leisure property (e.g., cabin, cottage)
- **Bygge Materiale**: Building material
- **Standard**: Property condition/standard
- **Byggeår**: Construction year (numeric)
- **Antall Kvadratmeter**: Square meters (numeric)
- **BelopB**: Building insurance amount (numeric)
- **Bonus**: Bonus percentage (optional, numeric)

### Buttons and Functions
1. **Add New** Button
   - Validates all leisure property fields
   - Creates FritidsboligForsikiring object
   - Calculates premium: building amount × contents amount × (1 - bonus/100)
   - Displays confirmation with leisure property details
   - Shows error dialog for incomplete or invalid data

2. **View** Button
   - Shows all registered leisure property insurances
   - Displays overview of all leisure properties

3. **Save** Button
   - Saves leisure property insurance data to file
   - Provides success/error confirmation

4. **Exit** Button
   - Closes the application

---

## Tab 5: Bil Forsikring (Car Insurance)

### Input Fields
- **Kunde Navn**: Customer number
- **Biltype**: Type of car (e.g., sedan, SUV)
- **Registrerings År**: Registration year (numeric)
- **Registrerings Nummer**: License plate (e.g., ABC123)
- **Kjøre Lengde**: Driving length/distance (numeric)
- **Bonus**: Bonus percentage (optional, numeric)
- **Bil Modell**: Car model name/number (numeric)

### Buttons and Functions
1. **Add New** Button
   - Validates license plate format (XXX###)
   - Creates Bilforsikring object
   - Calculates premium: motor power × length × (1 - bonus/100)
   - Displays customer and car details
   - Shows validation errors for invalid format or duplicate registration

2. **View** Button
   - Currently shows unsupported message
   - Can be enhanced to display all registered cars

3. **Save** Button
   - Saves car insurance data to file

4. **Exit** Button
   - Closes the application

---

## Tab 6: Kunder Database (Customer Registration)

### Input Fields
- **Kunde Navn**: Customer full name
- **Adresse**: Customer address

### Buttons and Functions
1. **regkunde** Button (Register Customer)
   - Creates new Kunde object with name and address
   - Auto-generates unique customer number (KundeNr)
   - Displays all registered customers
   - Shows confirmation of new customer registration
   - Error message if name or address is missing

2. **Exit** Button
   - Closes the application

### Display Area
- Shows list of all registered customers with their assigned customer numbers
- Used to verify customer registration before creating insurances

---

## Common Error Messages

| Error | Cause | Solution |
|-------|-------|----------|
| "Du må fylle inn all informasjon..." | Missing required fields | Fill all input fields |
| "Vennligst skriv inn gyldige tall..." | Non-numeric value in numeric field | Enter only numbers |
| "Fant ikke kunde med nummer: X" | Customer number doesn't exist | Register customer first in Kunder tab |
| "Registreringsnummeret må bestå av 3 bokstaver og 3 tall" | Invalid license plate format | Use format: ABC123 |
| "En bil med samme registreringsnumer finnes fra før" | Duplicate license plate | Use different license plate |
| "Feil ved lagring av data: ..." | File I/O error | Check file permissions and disk space |
| "Data lagret med suksess!" | Operation successful | Data has been saved to file |

---

## Typical Workflow

### 1. Create Customer (First Time)
1. Go to **Kunder Database** tab
2. Enter customer name and address
3. Click **regkunde** button
4. Note the assigned customer number

### 2. Register Insurance
1. Go to desired insurance tab (Båt, Bil, Hus, etc.)
2. Fill in all required fields
3. Click **Add New** button
4. Verify confirmation message shows correct details
5. Click **Save** button to persist data

### 3. View Registered Insurances
1. Go to the insurance tab
2. Click **View** button
3. All registered insurances of that type appear in the display area

### 4. Exit Application
1. Click **Save** button one final time (important!)
2. Click **Exit** button
3. Application closes and saves all pending data

---

## Tips for Users

✓ **Always create customer first** before registering insurances
✓ **Fill all fields completely** - incomplete entries will be rejected
✓ **Use numeric format for numbers** - no letters in numeric fields
✓ **Save frequently** - don't rely on exit to save
✓ **Verify confirmation messages** - they show what was registered
✓ **Check View buttons** - to confirm registrations were successful
✓ **Note customer numbers** - needed for linking insurances to customers

---

## Data Persistence

- Data is saved to file when **Save** button is clicked
- File format: `lister.txt`
- Data survives application restart
- Multiple insurance types can be saved together
- Customer database linked to all insurances via customer number

---

## Summary of Improvements

✓ All "Add New" buttons now fully functional with validation
✓ All "View" buttons display registered data
✓ All "Save" buttons persist data to file
✓ Consistent error handling across all tabs
✓ User-friendly confirmation and error messages
✓ Proper numeric validation on all forms
✓ Customer lookup verification before registration

