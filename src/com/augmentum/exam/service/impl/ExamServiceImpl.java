package com.augmentum.exam.service.impl;

import java.util.List;

import com.augmentum.exam.dao.ExamDao;
import com.augmentum.exam.model.Exam;
import com.augmentum.exam.model.Pagination;
import com.augmentum.exam.service.ExamService;

public class ExamServiceImpl implements ExamService {

    private ExamDao examDao ;

    public void setExamDao(ExamDao examDao) {
        this.examDao = examDao;
    }

    @Override
    public List<Exam> find(Pagination pagination) {
        List<Exam> examList = examDao.findQuery(pagination);
        return examList;
    }

    @Override
    public int saveExam(Exam exam) {
        examDao.create(exam);
        return exam.getId();
    }
}
