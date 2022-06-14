<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>menu.jsp</title>
</head>
<body>
  <p style="text-align:left">
  	<a href="${ctxPath}/">홈으로</a> |
  	<a href="${ctxPath}/guest/guestList">방명록</a> |
  	<a href="${ctxPath}/board/boardList">게시판</a> |
  	<a href="${ctxPath}/pds/pdsList">자료실</a> |
  	<a href="${ctxPath}/member/mList">회원목록</a> |
  	<a href="${ctxPath}/member/mInput">회원가입</a> |
  	<a href="${ctxPath}/member/mLogin">로그인</a> 
  	<a href="${ctxPath}/member/mLogout">로그아웃</a> 
  </p>
</body>
</html>