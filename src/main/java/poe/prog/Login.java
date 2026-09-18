package poe.prog;

import java.util.regex.Pattern;
// Login validation logic
public class Login {
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Default Constructor
    public Login() {}

    // Parameterized Constructor
    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public String getFirstName() { 
        return firstName; 
    }
    
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }
    
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }

    /**
     * Checks if username contains an underscore (_) and is no more than 5 characters long.
     */
    public boolean checkUserName(String username) {
        if (username == null) return false;
        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Checks if password meets complexity rules:
     * - At least 8 characters long
     * - Contains a capital letter
     * - Contains a number
     * - Contains a special character
     */
    public boolean checkPasswordComplexity(String password) {
        if (password == null) return false;

        boolean hasMinLength = password.length() >= 8;
        boolean hasCapital = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecial = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();

        return hasMinLength && hasCapital && hasDigit && hasSpecial;
    }

    /**
     * Regular expression cell phone checker:
     * Validates international country code (+27...) followed by digits.
     */
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        if (cellPhoneNumber == null) return false;
        return cellPhoneNumber.matches("^\\+[0-9]{1,3}[0-9]{7,10}$");
    }

    /**
     * Registers the user and returns the exact messages specified in assignment criteria.
     */
    public String registerUser(String username, String password, String cellPhoneNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        // Store valid user credentials
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;

        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }

    /**
     * Checks entered credentials against stored user details.
     */
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (this.username == null || this.password == null) return false;
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    /**
     * Returns login outcome message formatted according to task requirements.
     */
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + " ," + lastName + " it is great to see you.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

