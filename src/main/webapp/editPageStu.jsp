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
<meta charset="UTF-8">
<title>학생 성적 정정/삭제</title>
<script>
	function submitForm(mode) {
		var myform = document.myform;
		if (mode == "update") {
			myform.action = "updatePage.jsp";
			//myform.submit();
		} else if (mode == "delete") {
			myform.action = "deletePage.jsp";
			//myform.submit();
		}
	}
</script>

</head>
<body>
	<%
	String searchid = request.getParameter("searchid");
	ScoreItemService scoreItemService = new ScoreItemServiceImpl();
	ScoreItem scoreItem = scoreItemService.selectOne(searchid);

	ServletContext context = getServletContext();
	context.setAttribute("scoreItem", scoreItem);
	%>


	<h1>학생 성적 조회 정정/삭제</h1>
	<form action="editPageStu.jsp" method="post">
		<table cellspacing=1 width=400 border=0>
			<tr>
				<td width=100><p align="center">조회할 학번</p></td>
				<td width=200><p align="center">
						<input type="text" name="searchid">
					</p></td>
				<td width=100><input type="submit" value="조회"></td>
			</tr>
			</form>

			<form method="post" name="myform">
				<table cellspacing=1 width=400 border=1>
					<tr>
						<td align=center>이름</td>
						<td align=center><input name="stuName" type="text"
							value="${scoreItem.name}" readonly></input></td>
						<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
					</tr>
					<tr>
						<td align=center>학번</td>
						<td align="center"><input name="studentid"
							value="${scoreItem.studentid}" readonly></input></td>
						<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
					</tr>
					<tr>
						<td align=center>국어</td>
						<td align=center><input name="stuKor" type="number" min='0'
							max="100" value="${scoreItem.kor}" maxlength=20
							pattern='^[0-9]+$' required></input></td>
						<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
					</tr>
					<tr>
						<td align=center>영어</td>
						<td align=center><input name="stuEng" type="number" min='0'
							max="100" value="${scoreItem.eng}" maxlength=20
							pattern='^[0-9]+$' required></input></td>
						<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
					</tr>
					<tr>
						<td align=center>수학</td>
						<td align=center><input name="stuMat" type="number" min='0'
							max="100" value="${scoreItem.mat}" maxlength=20
							pattern='^[0-9]+$' required></input></td>
						<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
					</tr>

				</table>

				<c:if test="${scoreItem.studentid != 0}">
					<table cellspacing=1 width=400 border=0>
						<tr>
							<td width="200"></td>
							<td width="100"><p align="center">
									<input type="submit" value="수정" onclick="submitForm('update')">
								</p></td>
							<td width="100"><p align="center">
									<input type="submit" value="삭제" onclick="submitForm('delete')">
								</p></td>
						</tr>
					</table>
				</c:if>
			</form>
</body>
</html>