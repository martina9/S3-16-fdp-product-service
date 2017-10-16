package com.productService.dao;

import com.productService.model.User;

/**
 * @author  mGabellini
 */

public interface IUserDAO {
    User getUserById(int userId);
}