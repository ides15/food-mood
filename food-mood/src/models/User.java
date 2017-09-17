package models;

/**
 *
 * @author john
 */
public class User {
    private String username, password;
    
    /**
     * Default constructor for the User class
     */
    public User() {
        super();
        System.out.println("Drink constructor");
    }
    
    /**
     * Constructor for the User class with all parameters
     */
    public User(String username, String password) {
        super();
        System.out.println("Drink constructor");
    }
    
    /**
     * Authenticates user
     * @param username username to authenticate
     * @param password password to authenticate
     * @return returns whether the user is authenticated or not; true is authenticated
     */
    public boolean authenticate(String username, String password) {
        return true;
    }
}
