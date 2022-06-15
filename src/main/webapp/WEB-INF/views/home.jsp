<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
  	<jsp:include page="/WEB-INF/views/include/bs4.jsp"></jsp:include>
</head>
<body>
  	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
  	<jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
	<div class="container">
		<h1>
			Hello world!  
		</h1>
		
		<P>  The time on the server is ${serverTime}. </P>
	</div>
  	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>
