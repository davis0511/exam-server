package com.augmentum.exam.service;

import java.util.List;

import com.augmentum.exam.exception.ParamException;
import com.augmentum.exam.model.Pagination;
import com.augmentum.exam.model.Question;

public interface QuestionService {

    public List<Question> find(Pagination pagination);
    public int saveQuestion(Question question) throws ParamException;
    public void deleteQuestionById(int id) ;
    public Question getQuestionById(int id);
}
