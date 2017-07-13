package com.augmentum.exam.service;

import java.util.List;

import com.augmentum.exam.model.Exam;
import com.augmentum.exam.model.Pagination;

public interface ExamService {
    public List<Exam> find(Pagination pagination);
    public int saveExam(Exam exam);
}
