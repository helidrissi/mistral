package fr.mistral.demodoc.domain;

/**
 * User object
 */
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;

    /**
     * Creates a new user
     * @param username unique username of the user
     * @param password password of the user
     * @param email email address of the user
     */
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
