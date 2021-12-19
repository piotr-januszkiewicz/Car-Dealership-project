package pl.polsl.carsdealership;

/**
 * class responsible for holding information about users
 * @version 1.1
 * @author Piotr Januszkiewicz
 */
public class User {

    /**
     * private fields that hold user data: username, password and permission level
     */
    private final String username;
    private final String password;
    private final int permission;

    /**
     * constructor with parameters used to create a new user in data structure
     * 
     * @param usernameAndPassword users name and password
     * @param perm permission level of user
     */
    public User(String[] usernameAndPassword, int perm) {
        username = usernameAndPassword[0];
        password = usernameAndPassword[1];
        permission = perm;
    }

    /**
     * @return users name and password
     */
    public String[] userLoginDataInfo() {
        return new String[]{username, password};
    }

    /**
     * @return users permmission level
     */
    public int permissionInfo() {
        return permission;
    }
}
