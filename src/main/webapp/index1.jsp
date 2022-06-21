<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="kr.ac.kopo.ctc.kopo44.scoreItemservice.ScoreItemService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
p

	ScoreItemServiceImpl scoreItemService = new ScoreItemServiceImpl();
	int n = scoreItemService.add(1,2);
	
	List<scoreItem> scoreItems = scoreItemService.selectAll(1,10,10);
%>
dd
<%=n %>
</body>
</html>