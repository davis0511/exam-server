<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.augmentum.exam.model.Question"%>
<%@ page import="com.augmentum.exam.model.Pagination"%>
<%@ page import="com.augmentum.exam.util.StringUtil"%> 
<%@ page import="com.augmentum.exam.util.PathUtil"%>
<%@ page import="com.augmentum.exam.util.AppPropertyUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/WEB-INF/block.tld" prefix="block" %>
  <script src="<%=AppPropertyUtil.getStaticUrl()%>/js/question_manager.js"></script>
  <%Pagination pagination = (Pagination)request.getAttribute("pagination");
  %>
  <div class="content"> 
    <div class="mark_manager">
      <h4>Question Manager &gt; Question List</h4>
    </div>
    <div class="show_question_list">
      <div class="submit_form">
      <!-- question form start -->
        <form action="<%=PathUtil.getFullPath("question/showQuestion")%>" method="Get" id="questionList" name="questionList">
          <div class="question_title">
            &nbsp;Question Title: 
            <input type="text" name="questionTitle" id ="questionTitle" class="title_qt" value="${requestScope.questionTitle}"/>
            <input type="button" value="Search" class="btn_create" onclick="btnQtTitle()"/>
            <div class="btn_c_question">
              <a href="<%=PathUtil.getFullPath("question/createQuestion")%>">
                <input type="button" value="Create Question" name="btn_question" class="btn_create "/>
              </a>
            </div>
          </div>
          <!-- question list  start-->
          <div class="qt_list">
            <div id="table_header">
              <div class="id">ID</div>
              <div class="qt_title">Question Title</div>
              <div class="answer">Standard Answer</div>
              <div class="operation">Operations</div> 
            </div>
            <%
            int i = 0;
            List<Question> questions = (List<Question>)request.getAttribute("questions");
            for (Question question : questions) {
                i++;
            %>
            <div id="table_content">
              <div class="id"><%=question.getId()%></div>
              <div class="qt_title_z"><%=StringUtil.htmlEncode(question.getQuestionTitle().length() > 30 ? question.getQuestionTitle().substring(0, 30) + "..." : question.getQuestionTitle())%></div>
              <div class="answer"><%=question.getStandardAnswer()%></div>
              <div class="operation">
                <div class="is_delete">
                  <a href="<%=PathUtil.getFullPath("question/editQuestion")%>?id=<%=question.getId()%>">
                    <label class="is_delete">Edit</label>
                  </a>
                  <label class="is_delete"  onclick="DeleteQuestion(<%=question.getId()%>,<%=pagination.getCurrentPage()%>)" >Delete</label>
                </div>
              </div>
            </div>
            <%}%>
          </div>
        </form>
        <input type="hidden" id="pageCount" value="<%=pagination.getPageCount()%>">
        <input type="hidden" name="errorFlashMessage" id="errorFlashMessage" />
        <!-- question list  end-->

        <!-- question form end -->
        <br/>
        <!-- page block start -->
        <block:display name="PaginationBlock"/>
        <!-- page block end -->
      </div>
    </div>
  </div>
