package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.User;

/**
 * Created by Martina
 */

public interface IUserDAO {
    User getUserById(int userId);
}