package fr.mistral.demodoc.domain;

/**
 * This service will handle all the user interactions
 */
public interface UserService {

    /**
     * This method will register a user
     * @param user user that will be registered
     */
    void register(User user);

    /**
     * Fetches a user with a given Identifier
     * @param id unique identifier of a user
     * @return User Object
     */
    User fetchUser(Integer id);
}
