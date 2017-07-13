<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.augmentum.exam.model.Exam"%>
<%@ page import="com.augmentum.exam.util.AppPropertyUtil"%>
<%@ page import="com.augmentum.exam.util.PathUtil"%>
<%@ page import="com.augmentum.exam.model.Pagination"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/WEB-INF/block.tld" prefix="block" %>
  <script src="<%=AppPropertyUtil.getStaticUrl()%>/js/exam_manager.js"></script>
  <%Pagination pagination = (Pagination)request.getAttribute("pagination");
  %>
  <div class="content"> 
    <div class="mark_manager">
      <h4>Exam Manager &gt; Exam List</h4>
    </div>
    <div class="show_question_list">
      <div class="submit_form">
      <!-- question form start -->
        <form action="" method="Get" id="examList" name="examList">
          <div class="question_title">
            &nbsp;Exam Name: 
            <input type="text" name="examName" id ="examName" class="title_qt" value="${requestScope.examName}"/>
            <input type="button" value="Search" class="btn_create" onclick="btnExam()"/>
            <div class="btn_c_question">
              <a href="<%=PathUtil.getFullPath("exam/createExam")%>">
                <input type="button" value="Create Exam" name="btn_question" class="btn_create "/>
              </a>
            </div>
          </div>
          <!-- question list  start-->
          <div class="qt_list">
            <div id="table_header">
              <div class="id">ID</div>
              <div class="exam_name">Name</div>
              <div class="exam_description">Description</div>
              <div class="operation">Total Score</div> 
              <div class="operation">Question Quality</div> 
            </div>
             <%
            int i = 0;
            List<Exam> exams = (List<Exam>)request.getAttribute("examList");
            for (Exam exam : exams) {
                i++;
            %>
             <div id="table_content">
                <div class="id"><%=exam.getId() %></div>
              <div class="exam_name"><%=exam.getExamName() %></div>
              <div class="exam_description"><%=exam.getDescription() %></div>
              <div class="operation"><%=exam.getTotalScore() %></div> 
              <div class="operation"><%=exam.getQuanlity() %></div> 
             </div>
             <%} %>
          </div>
        </form>
        <input type="hidden" id="pageCount" value="<%=pagination.getPageCount() %>">
        <input type="hidden" name="errorFlashMessage" id="errorFlashMessage" />
        <!-- question list  end-->

        <!-- question form end -->
        <br/>
        <!-- page block start -->
         <block:display name="PaginationExamBlock"/>
        <!-- page block end -->
      </div>
    </div>
  </div>
