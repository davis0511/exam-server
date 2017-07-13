package com.augmentum.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.exam.AppContext;
import com.augmentum.exam.Constants;
import com.augmentum.exam.model.User;
import com.augmentum.exam.service.UserService;
import com.augmentum.exam.util.StringUtil;

@Controller
@RequestMapping("/page")
public class ProfileController extends BaseController {

    private final String EXAM_QUESTION_JSP = "exam_question";
    private final String USER_PROFILE_JSP = "user_profile";
    private ModelAndView modelAndView = new ModelAndView();

    @Autowired
    private UserService userService ;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView modifyProfile(
                                      @RequestParam(value="gender", defaultValue="") String gender,
                                      @RequestParam(value="password", defaultValue="") String password,
                                      @RequestParam(value="fullName", defaultValue="") String fullName,
                                      @RequestParam(value="telephone", defaultValue="") String telephone,
                                      @RequestParam(value="address", defaultValue="") String address,
                                      @RequestParam(value="email", defaultValue="") String email
                                     ) {
        User user = null;
        user = AppContext.getAppContext().getUser();
        String userName = user.getUserName();
        String userRole = userService.getUserRoleByName(userName);
        modelAndView.addObject("userRole", userRole);

        user.setGender(gender);
        user.setPassword(password);
        user.setFullName(fullName);
        user.setTelephone(telephone);
        user.setAddress(address);
        user.setEmail(email);
        user.setUserName(userName);
        if (!StringUtil.isEmpty(fullName)) {
           userService.updateUserInfo(user);
        }
        modelAndView.addObject(Constants.MARK, Constants.PROFILE);
        if ("systemAdmin".equals(userRole)) {
            modelAndView.setViewName(USER_PROFILE_JSP);
        }
        if ("contentAdmin".equals(userRole)) {
            modelAndView.setViewName(EXAM_QUESTION_JSP);
        }
        return modelAndView;
    }
}
