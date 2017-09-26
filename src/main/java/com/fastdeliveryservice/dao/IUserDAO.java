package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.User;

/**
 * @author  mGabellini
 */

public interface IUserDAO {
    User getUserById(int userId);
}