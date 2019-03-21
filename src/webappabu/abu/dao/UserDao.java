/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappabu.abu.dao;

import java.util.List;

import webappabu.abu.model.User;

/**
 *
 * @author khoerulAbu
 */
public interface UserDao {
    
    public void addUser(User user);
    public List<User> getAllUsers();
}
