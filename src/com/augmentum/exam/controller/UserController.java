package com.augmentum.exam.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.exam.AppContext;
import com.augmentum.exam.Constants;
import com.augmentum.exam.exception.ParamException;
import com.augmentum.exam.exception.ServiceException;
import com.augmentum.exam.model.Pagination;
import com.augmentum.exam.model.User;
import com.augmentum.exam.service.UserService;
import com.augmentum.exam.util.StringUtil;

@Controller
@RequestMapping("/page/user")
public class UserController extends BaseController{

    private final String LOGIN_JSP = "login";
    private final String SHOW_QUESTION_PAGE = "question/showQuestion";
    private final String SHOW_USER_PAGE = "user/showUser";
    private final String USER_PROFILE_JSP = "user_profile";

    private ModelAndView modelAndView = new ModelAndView();

    @Autowired
    private UserService userService ;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "mark", defaultValue = "") String logout) {
        User user = AppContext.getAppContext().getUser();
        if (user != null) {
            modelAndView.setView(this.getRedirectView(SHOW_QUESTION_PAGE));
            if (Constants.LOGOUT.equals(logout)) {
                this.invalidate();
                user = null;
                modelAndView.setViewName(LOGIN_JSP);
            }
        } else {
            modelAndView.setViewName(LOGIN_JSP);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(
                                  @RequestParam(value = "userName", defaultValue = "") String userName,
                                  @RequestParam(value = "password", defaultValue = "") String password
                                  ) {
        //Business
        try {
            User user = null;
            user = userService.login(userName, password);
            user.setPassword(null);
            this.addSession(Constants.USER, user);
            String roleStr = userService.getUserRoleByName(user.getUserName());
            int role = 0;
            if ("systemAdmin".equals(roleStr)) {
                role = 1;
            }
            if ("contentAdmin".equals(roleStr)) {
                role = 2;
            }
            switch(role) {
                case 1: modelAndView.setView(this.getRedirectView(SHOW_USER_PAGE));
                        break;
                case 2: modelAndView.setView(this.getRedirectView(SHOW_QUESTION_PAGE));
                        break;
            }
        } catch (ParamException paramException) {
            Map<String, String> errorFileds=paramException.getErrorFileds();
            modelAndView.addObject(Constants.ERROR_FILEDS, errorFileds);
            modelAndView.setViewName(LOGIN_JSP);
        } catch (ServiceException serviceException) {
            modelAndView.addObject(Constants.TIP_MESSAGE, serviceException.getMessage());
            modelAndView.setViewName(LOGIN_JSP);
        }
        return modelAndView;
    }

    //show user
    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public ModelAndView showUser( @RequestParam(value = "currentPage", defaultValue = "1") int currentPage ) {

        List<User> userList;
        Pagination pagination = new Pagination();
        if (currentPage < 1) {
            currentPage = 1;
        }
        pagination.setCurrentPage(currentPage);
        modelAndView.addObject(Constants.PAGINATION, pagination);
        userList = userService.find(pagination);

        modelAndView.addObject(Constants.USER_LIST, userList);

        modelAndView.addObject(Constants.MARK, Constants.USER_MANAGER);
        modelAndView.setViewName(USER_PROFILE_JSP);
        return modelAndView;
    }

    //create user
    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public ModelAndView createUser() {
        User user = null;
        modelAndView.addObject("user", user);
        modelAndView.addObject(Constants.MARK, "createUser");
        modelAndView.setViewName(USER_PROFILE_JSP);
        return modelAndView;
    }

    //delete user
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(
                                   @RequestParam(value = "id", defaultValue = "") int id,
                                   @RequestParam(value = "currentPage", defaultValue = "1") int currentPage
                                   ) {
        userService.deleteUserById(id);
        modelAndView.setView(this.getRedirectView(SHOW_USER_PAGE + "?currentPage=" + currentPage));
        return modelAndView;
    }

    //edit user
    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam(value = "id", defaultValue = "") int id) {

        User user = userService.getUserById(id);
        modelAndView.addObject("user", user);
        modelAndView.addObject(Constants.MARK, "updateUser");
        modelAndView.setViewName(USER_PROFILE_JSP);
        return modelAndView;
    }

    // save user
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public  ModelAndView save(
                              @RequestParam(value = "userName", defaultValue = "") String userName,
                              @RequestParam(value = "gender", defaultValue = "") String gender,
                              @RequestParam(value = "fullName", defaultValue = "") String fullName,
                              @RequestParam(value = "select", defaultValue = "") String name,
                              @RequestParam(value = "telephone", defaultValue = "") String telephone,
                              @RequestParam(value = "email", defaultValue = "") String email,
                              @RequestParam(value = "address", defaultValue = "") String address,
                              @RequestParam(value = "id", defaultValue = "") String idStr
                              ) {
        int id = 0;
        if (!StringUtil.isEmpty(idStr)) {
            id = Integer.parseInt(idStr);
        }
        User user = new User();
        user.setUserName(userName);
        user.setGender(gender);
        user.setFullName(fullName);
        user.setTelephone(telephone);
        user.setEmail(email);
        user.setAddress(address);
        user.setName(name);

        user.setId(id);
        userService.save(user);

        modelAndView.setView(this.getRedirectView(SHOW_USER_PAGE));
        return modelAndView;
    }
}
