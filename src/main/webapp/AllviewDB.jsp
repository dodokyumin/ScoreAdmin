<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.ac.kopo.ctc.kopo44.service.ScoreItemServiceImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo44.service.ScoreItemService"%>
<%@page import="kr.ac.kopo.ctc.kopo44.domain.ScoreItem"%>
<%@page import="kr.ac.kopo.ctc.kopo44.dto.Pagination"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table cellspacing=1 width=400 border=1>
		<tr>
			<td align=center>이름</td>
			<td align=center>학번</td>
			<td align=center>국어</td>
			<td align=center>영어</td>
			<td align=center>수학</td>
		</tr>
		<%
		//String strcPage = request.getParameter("strcPage");
		String strcPage = "1";
		ScoreItemService scoreItemService = new ScoreItemServiceImpl();
		List<ScoreItem> scoreItems = scoreItemService.selectAll(strcPage);
		
		
		
		final int COUNT_PER_PAGE = 10;
		final int PAGE_SIZE = 10;
		final int TOTAL_COUNT = scoreItemService.getRowCount();
		
		//int currPage = Integer.parseInt(request.getParameter("currPage"));

		//scoreItemService.getPagination(currPage, COUNT_PER_PAGE, PAGE_SIZE, TOTAL_COUNT);
		
		
		for (ScoreItem scoreItem : scoreItems) {
		%>

		<tr>
			<td><a
				href="/ScoreAdmin/selectOne.jsp?name=<%=scoreItem.getName()%>"><%=scoreItem.getName()%></a></td>
			<td><%=scoreItem.getStudentid()%></td>
			<td><%=scoreItem.getKor()%></td>
			<td><%=scoreItem.getEng()%></td>
			<td><%=scoreItem.getMat()%></td>
		<tr>
			<%
			}
			%>
		
	</table>
</body>
</html>