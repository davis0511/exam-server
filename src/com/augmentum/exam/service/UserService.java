package com.augmentum.exam.service;
import java.util.List;

import com.augmentum.exam.exception.ParamException;
import com.augmentum.exam.exception.ServiceException;
import com.augmentum.exam.model.Pagination;
import com.augmentum.exam.model.User;

public interface UserService {

    public User login(String userName, String password)throws ParamException, ServiceException;
    public String getUserRoleByName(String userName);
    public void updateUserInfo(User user);
    public List<User> find(Pagination pagination);
    public int save(User user);
    public void deleteUserById(int id);
    public User getUserById(int id);
}
