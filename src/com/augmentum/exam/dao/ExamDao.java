package com.augmentum.exam.dao;

import java.util.List;

import com.augmentum.exam.model.Exam;
import com.augmentum.exam.model.Pagination;

public interface ExamDao {
    public List<Exam> findQuery(Pagination pagination);
    public int getExamCount(String questionTitle);
    public int create(Exam exam);
}
