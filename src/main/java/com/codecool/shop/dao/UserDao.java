package com.codecool.shop.dao;

import com.codecool.shop.model.User;
import java.util.List;

/**
 * <h1>Interface of User Data Access Object</>
 * @author Fanni Skoda
 * @since 2017.05.08.
 */
public interface UserDao {

    /**
     * Add user object to DAO
     * @param user This parameter is represented the new user, what we want to add
     */
    void add(User user);

    /**
     * Find user object in DAO
     * @param id This parameter is the link to find the correct user
     * @return This returns the found user object
     */
    User find(int id);

    /**
     * Remove user object from DAO
     * @param id This parameter is the link to find the correct user
     */
    void remove(int id);

    /**
     * Collect all users from DAO
     * @return This returns a List with all users
     */
    List<User> getAll();
}
