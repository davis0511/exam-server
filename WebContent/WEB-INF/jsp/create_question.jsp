<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.augmentum.exam.util.AppPropertyUtil"%>
<%@taglib uri="/WEB-INF/block.tld" prefix="block" %>
  <script src="<%=AppPropertyUtil.getStaticUrl()%>/js/save_question.js"> </script>
  <div class="content"> 
     <div class="mark_manager">
     <input type="hidden" id="questionId" value="${requestScope.question.id}">
       <h4>Question Manager &gt;
         <c:if test="${requestScope.question.id > 0}">
           <c:out value="Update Question"></c:out>
         </c:if>
         <c:if test="${requestScope.question.id eq null}">
           <c:out value="Create Question"></c:out>
         </c:if>
       </h4>
     </div>
     <p></p>
     <!-- create question block start -->
     <block:display name="CreateQuestionBlock"/>
     <!-- create question block end -->
  </div>