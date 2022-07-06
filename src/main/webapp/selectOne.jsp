<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.ac.kopo.ctc.kopo444.service.ScoreItemServiceImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo444.service.ScoreItemService"%>
<%@page import="kr.ac.kopo.ctc.kopo444.domain.ScoreItem"%>
<%@page import="kr.ac.kopo.ctc.kopo44.dto.Pagination"%>
<%@page import="kr.ac.kopo.ctc.kopo44.dto.ScoreItemDto"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>학생 성적 조회</title>
</head>
<body>
	<h1>학생 성적 조회</h1>
	<table cellspacing=1 width=400 border=1>
		<tr>
			<td align=center>이름</td>
			<td align=center>학번</td>
			<td align=center>국어</td>
			<td align=center>영어</td>
			<td align=center>수학</td>
		</tr>
		<%
		String strStudentid = request.getParameter("studentid");
		ScoreItemService scoreItemService = new ScoreItemServiceImpl();
		ScoreItem scoreItem = scoreItemService.selectOne(strStudentid);
		Pagination pagination = scoreItemService.getPagination(strStudentid);

		ServletContext context = getServletContext();
		context.setAttribute("scoreItem", scoreItem);
		context.setAttribute("pagination", pagination);
		%>
		<tr>
			<td><p class="center">${scoreItem.name}</td>
			<td><p class="center">${scoreItem.studentid}</td>
			<td><p class="center">${scoreItem.kor}</td>
			<td><p class="center">${scoreItem.eng}</td>
			<td><p class="center">${scoreItem.mat}</td>
		<tr>
</body>
</html>