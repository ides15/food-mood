package foodmodel;

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
