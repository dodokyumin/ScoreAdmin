<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>학생 성적 정정</title>
</head>
<body>
	<h1>학생 성적 정정 완료</h1>
	<%
	String stuName = request.getParameter("stuName");
	String studentid = request.getParameter("studentid");
	String kor = request.getParameter("stuKor");
	String eng = request.getParameter("stuEng");
	String mat = request.getParameter("stuMat");
	String name = new String(stuName.getBytes("8859_1"), "utf-8");
	
	ScoreItemService scoreItemService = new ScoreItemServiceImpl();
	ScoreItem scoreItem = scoreItemService.scoreItemUpdateOne(name, studentid, kor, eng, mat);
	ScoreItem updatedItem = scoreItemService.selectOne(studentid);
	%>

	<table cellspacing=1 width=400 border=1>
		<tr>
			<td width=100><p align="center">이름</p></td>
			<td width=100><p align="center">학번</p></td>
			<td width=100><p align="center">국어</p></td>
			<td width=100><p align="center">영어</p></td>
			<td width=100><p align="center">수학</p></td>
		</tr>
<%
out.println(updatedItem.getName());
out.println(updatedItem.getStudentid());
out.println(updatedItem.getKor());
out.println(updatedItem.getEng());
out.println(updatedItem.getMat());
%>
		<tr>
			<td width=100><p align="center">asdasd</p></td>
			<td width=100><p align="center">${updatedItem.studentid}</p></td>
			<td width=100><p align="center">${updatedItem.kor}</p></td>
			<td width=100><p align="center">${updatedItem.eng}</p></td>
			<td width=100><p align="center">${updatedItem.mat}</p></td>
		</tr>
	</table>
</body>
</html>