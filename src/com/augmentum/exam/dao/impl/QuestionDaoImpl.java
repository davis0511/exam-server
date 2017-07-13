package com.augmentum.exam.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.augmentum.exam.Constants;
import com.augmentum.exam.dao.QuestionDao;
import com.augmentum.exam.model.Pagination;
import com.augmentum.exam.model.Question;

public class QuestionDaoImpl extends SqlSessionDaoSupport implements QuestionDao {

    protected static String SQL_ID_CREATE = ".create";
    protected static String SQL_ID_UPDATE = ".update";
    protected static String SQL_ID_FINDQUERY = ".findQuery";
    protected static String SQL_ID_DELETE_BY_ID = ".deleteById";
    protected static String SQL_ID_GET_BY_ID = ".getById";
    protected static String SQL_ID_GET_COUNT = ".getQuestionCount";
    private static final String CLASS_NAME = Question.class.getName();

    @Override
    public List<Question> findQuery(Pagination pagination) {

        Map<String, Object> map = pagination.getParameterMap();
        final String questionTitle = (String)map.get(Constants.QUESTION_TITLE);
        pagination.setTotalCount(this.getQuestionCount(questionTitle));

        if (pagination.getCurrentPage() > pagination.getPageCount()) {
            pagination.setCurrentPage(pagination.getPageCount());
            }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(Constants.QUESTION_TITLE, "%"+questionTitle+"%");
        params.put(Constants.OFFSET, pagination.getOffset());
        params.put(Constants.PAGESIZE, pagination.getPageSize());

        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FINDQUERY, params);
    }

    @Override
    public int create(final Question question) {
        int id = getSqlSession().insert(CLASS_NAME + SQL_ID_CREATE, question);
        return id;
    }

    @Override
    public void deleteById(int id) {
        getSqlSession().delete(CLASS_NAME + SQL_ID_DELETE_BY_ID, id);
    }

    @Override
    public Question getById(int id) {
        return getSqlSession().selectOne(CLASS_NAME + SQL_ID_GET_BY_ID, id);
    }

    @Override
    public void update(Question question) {
        getSqlSession().update(CLASS_NAME + SQL_ID_UPDATE, question);
    }

    @Override
    public int getQuestionCount(String questionTitle) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(Constants.QUESTION_TITLE, "%"+questionTitle+"%");
        int count = 0;
        count = getSqlSession().selectOne(CLASS_NAME + SQL_ID_GET_COUNT, params);
        return count;
    }
}
