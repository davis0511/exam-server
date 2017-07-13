package com.augmentum.exam.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.augmentum.exam.Constants;
import com.augmentum.exam.dao.ExamDao;
import com.augmentum.exam.model.Exam;
import com.augmentum.exam.model.Pagination;

public class ExamDaoImpl extends SqlSessionDaoSupport implements ExamDao {

    protected static final String CLASS_NAME = Exam.class.getName();
    protected static String SQL_ID_FINDQUERY = ".findQuery";
    protected static String SQL_GET_EXAM_COUNT = ".getExamCount";
    protected static String SQL_CREATE_EXAM = ".create";

    @Override
    public List<Exam> findQuery(Pagination pagination) {
        Map<String, Object> map = pagination.getParameterMap();
        String examName = (String)map.get("examName");
        pagination.setTotalCount(this.getExamCount(examName));

        if (pagination.getCurrentPage() > pagination.getPageCount()) {
            pagination.setCurrentPage(pagination.getPageCount());
            }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("examName", "%"+examName+"%");
        params.put(Constants.OFFSET, pagination.getOffset());
        params.put(Constants.PAGESIZE, pagination.getPageSize());

        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FINDQUERY, params);
    }

    @Override
    public int getExamCount(String examName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("examName", "%"+examName+"%");
        int count = 0;
        count = getSqlSession().selectOne(CLASS_NAME + SQL_GET_EXAM_COUNT, params);

        return count;
    }

    @Override
    public int create(Exam exam) {
        int id = getSqlSession().insert(CLASS_NAME + SQL_CREATE_EXAM, exam);
        return id;
    }
}
