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
<title>Insert title here</title>
</head>
<body>
	<h1>학생 성적 추가 완료</h1>
	<%
	String stuName = request.getParameter("stuName");
	String stuKor = request.getParameter("stuKor");
	String stuEng = request.getParameter("stuEng");
	String stuMat = request.getParameter("stuMat");
	String stuNameHan = new String(stuName.getBytes("8859_1"), "utf-8");
	
	ScoreItemService scoreItemService = new ScoreItemServiceImpl();
	ScoreItem scoreItem = scoreItemService.scoreItemInsertOne(stuNameHan, stuKor, stuEng, stuMat);
	
	ServletContext context = getServletContext();
	context.setAttribute("scoreItem", scoreItem);
	//context.setAttribute("pagination", pagination);	
	%>

	<!-- <h4>"추가된 학생 : ${scoreItemService.scoreItemInsertOne}번"</h4> -->

	<form action="addStu.jsp" method="post">
		<table cellspacing=1 width=400 border=1>
			<tr>
				<td align=center>이름</td>
				<td align=center><input name="stuName" type="text"
					value="${scoreItem.name}" readonly></input></td>
				<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
			</tr>
			<tr>
				<td align=center>학번</td>
				<td align="center"><input value="${scoreItem.studentid}" readonly></input></td>
				<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
			</tr>
			<tr>
				<td align=center>국어</td>
				<td align=center><input name="stuKor" type="number" min='0'
					max="100" value="${scoreItem.kor}" readonly></input></td>
				<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
			</tr>
			<tr>
				<td align=center>영어</td>
				<td align=center><input name="stuEng" type="number" min='0'
					max="100" value="${scoreItem.eng}" readonly></input></td>
				<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
			</tr>
			<tr>
				<td align=center>수학</td>
				<td align=center><input name="stuMat" type="number" min='0'
					max="100" value="${scoreItem.mat}" readonly></input></td>
				<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
			</tr>

		</table>
		<input type="submit" value="뒤로가기">
	</form>

</body>
</html>