package com.augmentum.exam.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.augmentum.exam.AppContext;
import com.augmentum.exam.Constants;
import com.augmentum.exam.util.PathUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext*.xml", "classpath:spring-mvc.xml"})
public class UserControllerTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Before
    public void setUp() throws Exception {
        AppContext.setContextPath("/user");
        AppContext appContext = AppContext.getAppContext();
        appContext.addObject(Constants.APP_CONTEXT_SESSION, new MockHttpSession());
    }

    @After
    public void tearDown() throws Exception {
        AppContext appContext= AppContext.getAppContext();
        appContext.clear();
    }

    @Test
    public void testLogin() {
        UserController userController = (UserController) this.applicationContext.getBean("userController");
        ModelAndView modelAndView = userController.login("xing", "123");
        RedirectView redirectView = (RedirectView)modelAndView.getView();
        Assert.assertEquals(PathUtil.getFullPath("question/showQuestion") , redirectView.getUrl());
       // Assert.assertNotNull(SessionUtil.getSession(Constants.USER));
    }
}
