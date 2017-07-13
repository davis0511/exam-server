package com.augmentum.exam.dao;

import java.util.List;

import com.augmentum.exam.model.Pagination;
import com.augmentum.exam.model.Question;

public interface QuestionDao {

    public List<Question> findQuery(Pagination pagination);
    public int create(Question question);
    public void deleteById(int id);
    public Question getById(int id);
    public void update(Question question);
    public int getQuestionCount(String questionTitle);
}
