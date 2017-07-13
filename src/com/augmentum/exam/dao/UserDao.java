package com.augmentum.exam.dao;

import java.util.List;

import com.augmentum.exam.model.Pagination;
import com.augmentum.exam.model.User;

public interface UserDao {

    public User getUserByName(String userName);
    public String getUserRoleByName(String userName);
    public void update(User user);
    public int getUserCount();
    public List<User> findQuery(Pagination pagination);
    public int create(User user);
    public void createRole(int userId, String roleName);
    public int getRoleId(String roleName);
    public void deleteById(int id);
    public User getUserById(int id);
    public void updateRoleByUserId(int userId, String roleName);
}
