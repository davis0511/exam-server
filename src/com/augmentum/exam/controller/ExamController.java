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
import com.augmentum.exam.model.Exam;
import com.augmentum.exam.model.Pagination;
import com.augmentum.exam.service.ExamService;

@Controller
@RequestMapping("/page/exam")
public class ExamController extends BaseController {

    private final String EXAM_QUESTION_JSP = "exam_question";
    private final String SHOW_EXAM_PAGE = "exam/showExam";
    private ModelAndView modelAndView = new ModelAndView();

    @Autowired
    private ExamService examService ;

    public void setExamService(ExamService examService) {
        this.examService = examService;
    }

    @RequestMapping(value = "/showExam", method = RequestMethod.GET)
    public ModelAndView showExam(
                                 @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                 @RequestParam(value = "examName", defaultValue = "") String examName
                                ) {
        List<Exam> exams;
        Pagination pagination = new Pagination();
        if (currentPage < 1) {
            currentPage = 1;
        }
        pagination.setCurrentPage(currentPage);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("examName", examName);

        modelAndView.addObject("examName", examName);
        pagination.setParameterMap(map);
        modelAndView.addObject(Constants.PAGINATION, pagination);
        exams = examService.find(pagination);
        modelAndView.addObject("examList", exams);
        modelAndView.addObject(Constants.MARK, Constants.EXAM_MANAGER);

        modelAndView.setViewName(EXAM_QUESTION_JSP);
        return modelAndView;
    }


    @RequestMapping(value="/createExam", method = RequestMethod.GET)
    public ModelAndView create() {
        modelAndView.addObject(Constants.MARK, "createExam");
        modelAndView.setViewName(EXAM_QUESTION_JSP);
        return modelAndView;
    }

    @RequestMapping(value="/saveExam", method = RequestMethod.POST)
    public ModelAndView save(
                             @RequestParam(value = "name", defaultValue = "") String name,
                             @RequestParam(value = "description", defaultValue = "") String description,
                             @RequestParam(value = "singleScore", defaultValue = "") int singleScore,
                             @RequestParam(value = "questionQuality", defaultValue = "") int quanlity,
                             @RequestParam(value = "duration", defaultValue = "") int examTime
                            ) {
        int totalScore = quanlity*singleScore;
        Exam exam = new Exam();
        exam.setExamName(name);
        exam.setDescription(description);
        exam.setSingleScore(singleScore);
        exam.setQuanlity(quanlity);
        exam.setExamTime(examTime);
        exam.setTotalScore(totalScore);
        examService.saveExam(exam);
        modelAndView.setView(this.getRedirectView(SHOW_EXAM_PAGE));
        return modelAndView;
    }
}
