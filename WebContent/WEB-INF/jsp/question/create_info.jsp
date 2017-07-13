<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.augmentum.exam.util.PathUtil"%>
  <!-- create question start -->
  <div class="creat_question">
    <div class="submit_form">
      <form action="<%=PathUtil.getFullPath("question/saveQuestion")%>" method="POST" id="createQuestion" name="createQuestion">
        <input type="hidden" name="id" value="${requestScope.question.id}">
        <div class="question_title">
          &nbsp;<div class="title_q">Question Title:</div>
          <textarea onkeydown="this.value=this.value.substring(0, 90)" rows="3" cols="40" class="text_area" id="textArea" name="textArea">${requestScope.question.questionTitle}</textarea>&nbsp;
          <label class="title_xing">&nbsp;*</label>
        </div>
        <div class="question_select">
          <p><input type="radio" value="A" name="answer" <c:if test="${requestScope.question.standardAnswer eq 'A'}">checked="checked"</c:if>/>A&nbsp;
            <input type="text" name="selectA" class="question_select_width" id="selectA" value="${requestScope.question.selectA}" maxlength="40"/>&nbsp;
            <label class="xingHao">*</label>
          <p><input type="radio" value="B" name="answer" <c:if test="${requestScope.question.standardAnswer eq 'B'}">checked="checked"</c:if>/>B&nbsp;
            <input type="text" name="selectB" class="question_select_width" id="selectB" value="${requestScope.question.selectB}" maxlength="40" />&nbsp;
            <label class="xingHao">*</label>
          <p><input type="radio" value="C" name="answer" <c:if test="${requestScope.question.standardAnswer eq 'C'}">checked="checked"</c:if> />C&nbsp;
            <input type="text" name="selectC" class="question_select_width" id="selectC" value="${requestScope.question.selectC}" maxlength="40" />&nbsp;
            <label class="xingHao">*</label>
          <p><input type="radio" value="D" name="answer" <c:if test="${requestScope.question.standardAnswer eq 'D'}">checked="checked"</c:if> />D&nbsp;
            <input type="text" name="selectD" class="question_select_width" id="selectD" value="${requestScope.question.selectD}" maxlength="40" />&nbsp;
            <label class="xingHao">*</label>  
            <div id="errorMessage" class="errorMessage"> </div>
          <p>&nbsp;&nbsp;<input type="button" value="Submit" onclick="saveQuestion()" class="btn_create" />&nbsp;
            <input type="button" value="Cancel" onclick="cancelQuestion(${requestScope.pagination.currentPage})" class="btn_create" />
        </div>
      </form>
    </div>
  </div>
  <!-- create question end -->