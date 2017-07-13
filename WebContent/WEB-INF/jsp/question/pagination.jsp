<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.augmentum.exam.model.Pagination"%>
<%@ page import="com.augmentum.exam.util.StringUtil"%> 
<%@ page import="com.augmentum.exam.util.PathUtil"%>
<%@ page import="com.augmentum.exam.util.AppPropertyUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%Pagination pagination = (Pagination)request.getAttribute("pagination");
  %>
  <!-- page start -->
  <div class="page_header">  
    <div class="page_lt" style="display: <%=pagination.isFirstPage() ? "none" : "block"%>">
      <%if (!pagination.isFirstPage() && pagination.getPageCount() > 1) {%>
        <a href="<%=PathUtil.getFullPath("question/showQuestion")%>?currentPage=<%=pagination.getCurrentPage() - 1%>&questionTitle=${requestScope.questionTitle}">
          <label class="page_a">&lt;</label>
        </a>
      <%}%>
    </div>
    <div class="page">
      <div class="page_eq">
        <div class="page_right" style="float: left; display: <%= pagination.getCurrentPage() > 5 ? "block" : "none"%>">...</div>
          <%for (int j = ((pagination.getCurrentPage()-1)/5*5), k=0; j < pagination.getPageCount() && k < 5 ; j++, k++) { %>
          <div class="page_id" style="background-color:<%=j == pagination.getCurrentPage()-1 ? "#00C5CD" : "none"%> ">
            <c:if test="${(requestScope.pagination.pageCount > 0)}"> 
              <a href="<%=PathUtil.getFullPath("question/showQuestion")%>?currentPage=<%=j + 1%>&questionTitle=${requestScope.questionTitle}"> 
                <label class="page_a"><%=j + 1 %></label>
              </a>
            </c:if>
          </div>
          <%}%>
        </div>
      </div>
      <div class="page_dian">
        <%if (((pagination.getCurrentPage()-1)/5) < ((pagination.getPageCount()-1)/5)) { %>
          ...
        <%} %>
      </div>
      <div class="page_gt" style="display: <%=pagination.isLastPage() ? "none" : "block"%>" > 
        <%if (!pagination.isLastPage() && pagination.getPageCount() > 1) {%>
          <a href="<%=PathUtil.getFullPath("question/showQuestion")%>?currentPage=<%=pagination.getCurrentPage() + 1%>&questionTitle=${requestScope.questionTitle}">
            <label class="page_a">&gt;</label>
          </a>
       <%}%>
      </div>
      <div class="page_num"> Pages:<%=pagination.getCurrentPage()%>/<%=pagination.getPageCount()%>&nbsp;To</div>
        <input type="text" class="page_to" value="<%=pagination.getCurrentPage()%>" id="currentPage" name="currentPage"/>
        <div class="page_final">Page</div>
        <div class="page_go" onclick="paginationGo()">Go</div>
  </div>
  <!-- page end -->