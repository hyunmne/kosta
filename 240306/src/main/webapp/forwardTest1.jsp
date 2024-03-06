<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<!-- 둘이 똑 같 다 -->
<%-- <% pageContext.forward(request.getParameter("forwardPage"); %> --%>
<jsp:forward page='<%= request.getParameter("forwardPage") %>'></jsp:forward>
