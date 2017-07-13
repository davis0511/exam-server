package com.augmentum.exam.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.augmentum.exam.Constants;
import com.augmentum.exam.dao.UserDao;
import com.augmentum.exam.model.Pagination;
import com.augmentum.exam.model.User;
import com.augmentum.exam.util.StringUtil;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    private static final String CLASS_NAME = User.class.getName();
    private static final String SQL_ID_USER_GET_USER_BY_NAME = ".getUserByName";
    private static final String SQL_GET_USER_ROLE_BY_NAME = ".getUserRoleByName";
    private static final String SQL_UPDATE_USER_INFO = ".update";
    private static final String SQL_GET_USER_COUNT = ".getUserCount";
    private static final String SQL_FIND_QUERY = ".findQuery";
    private static final String SQL_CREATE_USER = ".create";
    private static final String SQL_GET_ROLE_ID= ".getRoleId";
    private static final String SQL_CREATE_ROLE = ".createRole";
    private static final String SQL_DELETE_BY_ID = ".deleteById";
    private static final String SQL_USER_BY_ID= ".getUserById";
    private static final String SQL_UPDATE_ROLE_BY_USER_ID= ".updateRoleByUserId";

    @Override
    public User getUserByName(String userName) {
        return getSqlSession().selectOne(CLASS_NAME + SQL_ID_USER_GET_USER_BY_NAME, userName);
    }

    @Override
    public String getUserRoleByName(String userName) {
        return getSqlSession().selectOne(CLASS_NAME + SQL_GET_USER_ROLE_BY_NAME, userName);
    }

    @Override
    public void update(User user) {
        if (!StringUtil.isEmpty(user.getPassword()) && user != null) {
            String roleName = user.getName();
            int userId = user.getId();
            getSqlSession().update(CLASS_NAME + SQL_UPDATE_USER_INFO, user);
            this.updateRoleByUserId(userId, roleName);
        }
    }

    @Override
    public List<User> findQuery(Pagination pagination) {
        pagination.setTotalCount(this.getUserCount());

        if (pagination.getCurrentPage() > pagination.getPageCount()) {
            pagination.setCurrentPage(pagination.getPageCount());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(Constants.OFFSET, pagination.getOffset());
        params.put(Constants.PAGESIZE, pagination.getPageSize());
        return getSqlSession().selectList(CLASS_NAME + SQL_FIND_QUERY, params);
    }

    @Override
    public int getUserCount() {
        return getSqlSession().selectOne(CLASS_NAME + SQL_GET_USER_COUNT);
    }

    @Override
    public int create(User user) {
        String roleName = user.getName();
        int id = getSqlSession().insert(CLASS_NAME + SQL_CREATE_USER, user);
        int userId = user.getId();
        this.createRole(userId, roleName);
        return id;
    }

    @Override
    public void createRole(int userId, String roleName) {
        int roleId = this.getRoleId(roleName);
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("userId", userId);
        map.put("roleId", roleId);
        getSqlSession().insert(CLASS_NAME + SQL_CREATE_ROLE, map);
    }

    @Override
    public int getRoleId(String roleName) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("roleName", roleName);
        return getSqlSession().selectOne(CLASS_NAME + SQL_GET_ROLE_ID, map);
    }

    @Override
    public void deleteById(int id) {
        getSqlSession().delete(CLASS_NAME + SQL_DELETE_BY_ID, id);
    }

    @Override
    public User getUserById(int id) {
        return getSqlSession().selectOne(CLASS_NAME + SQL_USER_BY_ID, id);
    }

    @Override
    public void updateRoleByUserId(int userId, String roleName) {
        int roleId = this.getRoleId(roleName);
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("userId", userId);
        map.put("roleId", roleId);
        getSqlSession().update(CLASS_NAME + SQL_UPDATE_ROLE_BY_USER_ID, map);
    }
}
