package com.augmentum.exam.service.impl;

import java.util.List;

import com.augmentum.exam.Constants;
import com.augmentum.exam.dao.UserDao;
import com.augmentum.exam.exception.ParamException;
import com.augmentum.exam.exception.ServiceException;
import com.augmentum.exam.model.Pagination;
import com.augmentum.exam.model.User;
import com.augmentum.exam.service.UserService;
import com.augmentum.exam.util.MD5Util;
import com.augmentum.exam.util.StringUtil;

public class UserServiceImpl  implements UserService {

    private UserDao userDao ;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String userName, String password) throws ParamException, ServiceException {
        ParamException paramException = new ParamException();
        //Basic data validation
        if (StringUtil.isEmpty(userName)) {
            paramException.addErrorFiled(Constants.USERNAME, Constants.USERNAM_REQUIRED);
        }
        if (StringUtil.isEmpty(password)) {
            paramException.addErrorFiled(Constants.PASSWORD, Constants.PASSWORK_REQUIRED);
        }
        if (paramException.isErrorFiled()) {
            throw paramException;
        }
        password = MD5Util.getEncryptedPwd(password);
        User user = userDao.getUserByName(userName);

        if (user == null) {
            throw new ServiceException(Constants.USER_CODE, Constants.USERNAM_PASSWORD);
        }
        if (!password.equals(user.getPassword())) {
            throw new ServiceException(Constants.PASSWORD_CODE, Constants.USERNAM_PASSWORD);
        }
        return user;
    }

    @Override
    public String getUserRoleByName(String userName) {
        return userDao.getUserRoleByName(userName);
    }

    @Override
    public void updateUserInfo(User user) {
        String password = user.getPassword();
        user.setPassword(MD5Util.getEncryptedPwd(password));
        if (user.getAddress() != null && !StringUtil.isEmpty(user.getPassword())) {
            userDao.update(user);
        }
    }

    @Override
    public List<User> find(Pagination pagination) {
        return userDao.findQuery(pagination);
    }

    @Override
    public int save(User user) {
        user.setPassword(MD5Util.getEncryptedPwd("123"));
        if (user.getId() > 0) {
            userDao.update(user);
        } else {
            userDao.create(user);
        }
        return user.getId();
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
