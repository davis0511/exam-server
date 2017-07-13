package com.augmentum.exam.service.impl;

import java.util.List;

import com.augmentum.exam.Constants;
import com.augmentum.exam.dao.QuestionDao;
import com.augmentum.exam.exception.ParamException;
import com.augmentum.exam.model.Pagination;
import com.augmentum.exam.model.Question;
import com.augmentum.exam.service.QuestionService;
import com.augmentum.exam.util.StringUtil;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao ;

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> find(Pagination pagination) {

        List<Question> questionList = questionDao.findQuery(pagination);
        return questionList;
    }

    @Override
    public int saveQuestion(Question question) throws ParamException{
        ParamException paramException = new ParamException();

        if (StringUtil.isEmpty(question.getQuestionTitle())) {
            paramException.addErrorFiled(Constants.QTTITLE, Constants.INPUT_QUESTION);
        }
        if (StringUtil.isEmpty(question.getSelectA())) {
            paramException.addErrorFiled(Constants.SELECTA, Constants.INPUT_SELECTA);
        }
        if (StringUtil.isEmpty(question.getSelectB())) {
            paramException.addErrorFiled(Constants.SELECTB, Constants.INPUT_SELECTB);
        }
        if (StringUtil.isEmpty(question.getSelectC())) {
            paramException.addErrorFiled(Constants.SELECTC, Constants.INPUT_SELECTC);
        }
        if (StringUtil.isEmpty(question.getSelectD())) {
            paramException.addErrorFiled(Constants.SELECTD, Constants.INPUT_SELECTD);
        }
        if (paramException.isErrorFiled()) {
            throw paramException;
        }

        if (question.getId() > 0) {
            questionDao.update(question);
        } else {
            questionDao.create(question);
        }
        return question.getId();
    }

    @Override
    public void deleteQuestionById(int id) {
        questionDao.deleteById(id);
    }

    @Override
    public Question getQuestionById(int id) {
        Question question = questionDao.getById(id);
        return question;
    }
}
