package com.augmentum.exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.exam.Constants;
import com.augmentum.exam.exception.ParamException;
import com.augmentum.exam.model.Pagination;
import com.augmentum.exam.model.Question;
import com.augmentum.exam.service.QuestionService;
import com.augmentum.exam.util.StringUtil;

@Controller
@RequestMapping("/page/question")
public class QuestionController extends BaseController {

    private final String EXAM_QUESTION_JSP = "exam_question";
    private final String SHOW_QUESTION_PAGE = "question/showQuestion";

    private ModelAndView modelAndView = new ModelAndView();

    @Autowired
    private QuestionService questionService ;

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    // save
    @RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
    public  ModelAndView save(
                              @RequestParam(value = "textArea", defaultValue = "") String questionTitle,
                              @RequestParam(value = "answer", defaultValue = "") String standardAnswer,
                              @RequestParam(value = "selectA", defaultValue = "") String selectA,
                              @RequestParam(value = "selectB", defaultValue = "") String selectB,
                              @RequestParam(value = "selectC", defaultValue = "") String selectC,
                              @RequestParam(value = "selectD", defaultValue = "") String selectD,
                              @RequestParam(value = "id", defaultValue = "") String idStr
                              ) {
        int id = 0;
        if (!StringUtil.isEmpty(idStr)) {
           id = Integer.parseInt(idStr);
        }
        Question question = new Question();
        question.setId(id);
        question.setQuestionTitle(questionTitle);
        question.setStandardAnswer(standardAnswer);
        question.setSelectA(selectA);
        question.setSelectB(selectB);
        question.setSelectC(selectC);
        question.setSelectD(selectD);
        try {
            questionService.saveQuestion(question);
        } catch (ParamException e) {
            e.printStackTrace();
        }
        modelAndView.setView(this.getRedirectView(SHOW_QUESTION_PAGE));
        return modelAndView;
    }

    // delete
    @RequestMapping(value = "/deleteQuestion", method = RequestMethod.GET)
    public  ModelAndView delete(
                                @RequestParam(value = "id", defaultValue = "") int id,
                                @RequestParam(value = "currentPage", defaultValue = "1") int currentPage
                                ) {
        questionService.deleteQuestionById(id);
        modelAndView.setView(this.getRedirectView(SHOW_QUESTION_PAGE +"?currentPage=" + currentPage));
        return modelAndView;
    }

    // update
    @RequestMapping(value = "/editQuestion", method = RequestMethod.GET)
    public  ModelAndView edit(@RequestParam(value = "id", defaultValue = "") int id) {
        Question question = questionService.getQuestionById(id);
        modelAndView.addObject(Constants.SINGLE_QUESTION, question);
        modelAndView.addObject(Constants.MARK, Constants.UPDATE_QUESTION);
        modelAndView.setViewName(EXAM_QUESTION_JSP);
        return modelAndView;
    }

    //create
    @RequestMapping(value = "/createQuestion", method = RequestMethod.GET)
    public ModelAndView create() {
        Question question = null;
        modelAndView.addObject(Constants.SINGLE_QUESTION, question);
        modelAndView.addObject(Constants.MARK, Constants.CREATE_QUESTION);
        modelAndView.setViewName(EXAM_QUESTION_JSP);
        return modelAndView;
    }

    // show question
    @RequestMapping(value = "/showQuestion", method = RequestMethod.GET)
    public ModelAndView showQuestion(
                                     @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                     @RequestParam(value = "questionTitle", defaultValue = "") String questionTitle
                                     ) {
        List<Question> questions;
        Pagination pagination = new Pagination();
        if (currentPage < 1) {
            currentPage = 1;
        }
        pagination.setCurrentPage(currentPage);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constants.QTTITLE, questionTitle);

        modelAndView.addObject(Constants.QTTITLE, questionTitle);
        pagination.setParameterMap(map);
        modelAndView.addObject(Constants.PAGINATION, pagination);
        questions = questionService.find(pagination);

        modelAndView.addObject(Constants.QUESTION_LIST, questions);
        modelAndView.addObject(Constants.MARK, Constants.QUESTION_MANAGER);

        modelAndView.setViewName(EXAM_QUESTION_JSP);
        return modelAndView;
    }
}
