package com.augmentum.exam;

public class Constants {
    // login start
    public static final String TIP_MESSAGE = "TIP_MESSAGE";
    public static final String ERROR_FILEDS = "errorFileds";
    public static final String USER = "USER";
    public static final String USERNAM_PASSWORD = "username or password is wrong!";
    public static final String USERNAM_REQUIRED = "UserName is required.";
    public static final String PASSWORK_REQUIRED = "Password is required.";
    public static final int USER_CODE = 1000;//When used does not exist,reported a code error message
    public static final int PASSWORD_CODE = 1001;// password is wrong,reported a code error message
    public static final String USERNAME = "userName";//parameters
    public static final String PASSWORD = "password";
    public static final String USER_PARAMETER_ERROR = "user parameter is wrong:";
    public static final String USERNAME_PASSWOD_ERROR = "username or password is wrong:";
    // login end

    //UserDaoImpl start
    public static final String NAME = "user_name";
    //UserDaoImpl end

    public static final String JDBC_PROPERTY = "jdbc.properties";
    public static final String APP_PROPERTY = "app.properties";

    // exam, question start
    public static final String QUESTION_MANAGER = "questionManager";
    public static final String CREATE_QUESTION = "createQuestion";
    public static final String UPDATE_QUESTION = "updateQuestion";
    public static final String MARK = "MARK";//Mark switch pages
    public static final String EXAM_MANAGER = "examManager";
    public static final String USER_MANAGER = "userManager";
    public static final String PROFILE = "profile";
    public static final String QUESTION_LIST = "questions";
    public static final String USER_LIST = "userList";
    public static final String MARKTAG = "mark";
    public static final String LOGOUT = "logout";
    public static final String SELECTA = "selectA";
    public static final String SELECTB = "selectB";
    public static final String SELECTC = "selectC";
    public static final String SELECTD = "selectD";
    public static final String TEXTAREA = "textArea";
    public static final String ANSWER = "answer";
    public static final String ID = "id";
    public static final String SINGLE_QUESTION = "question";
    public static final String GO = "go";
    public static final String GET = "get";
    public static final String CURRENT_PAGE = "currentPage";
    public static final String PAGINATION = "pagination";
    // exam, question end

    //PathUtil start
    public static final String APP_URL_PREFIX = "page";
    //PathUtil end

    //filter start
    public static final String LOGIN_ACTION = "user/login";
    public static final String ENCODING = "encoding";
    public static final String APP_CONTEXT_USER = "APP_CONTEXT_USER";
    public static final String APP_CONTEXT_SESSION = "APP_CONTEXT_SESSION";
    public static final String SERVICE_ERROR = "/static/html/500.html";
    //filter end

    // questionDaoImpl start
    public static final String QTTITLE = "questionTitle";
    public static final String QUESTION_TITLE = "questionTitle";
    public static final String OFFSET = "offset";
    public static final String PAGESIZE = "pageSize";
    // questionDaoImpl end

    // saveQuestion start
    public static final String QUESTION_LIST_NULL = "questionList is null";
    public static final int QUESTION_LIST_CODE = 1004;
    public static final int QUESTION_CODE = 1003;
    public static final String INPUT_QUESTION = "please input questionTitle";
    public static final String INPUT_SELECTA =  "please input selectA";
    public static final String INPUT_SELECTB = "please input selectB";
    public static final String INPUT_SELECTC = "please input selectC";
    public static final String INPUT_SELECTD = "please input selectD";
    public static final String ID_IS_NULL =  "id not null";
    public static final String QUESTION_NULL = "question is null";
    // saveQuestion end

    // Symbol start
    public static final String COMMA = ",";
    public static final String BACKSLASH = "/";
    public static final String BLANK = "";
    // Symbol end

    // util start
    public static final String UTF_8 = "UTF-8";
    public static final String MD5 = "MD5";
    public static final String ZERO = "0";
    public static final String NULL = "null";
    // util end

    //block start
    public static final String BODY_APPEAR = "body colse appear exception:";
    public static final String BLOCK_EXCEPTION = "block include exception:";
    //block end
}