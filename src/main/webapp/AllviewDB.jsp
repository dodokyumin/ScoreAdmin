<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.ac.kopo.ctc.kopo44.service.ScoreItemServiceImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo44.service.ScoreItemService"%>
<%@page import="kr.ac.kopo.ctc.kopo44.domain.ScoreItem"%>
<%@page import="kr.ac.kopo.ctc.kopo44.dto.Pagination"%>
<%@page import="kr.ac.kopo.ctc.kopo44.dto.ScoreItemDto"%>
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
				String strcPage = request.getParameter("strcPage");
				
				ScoreItemService scoreItemService = new ScoreItemServiceImpl();
				List<ScoreItem> scoreItems = scoreItemService.selectAll(strcPage).getScoreItems();
				Pagination pagination = scoreItemService.selectAll(strcPage).getPagenation();
				
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
	<div>
		<%
		if(pagination.getcPage() > pagination.getPageSize()){
			out.print("<a href='AllviewDB.jsp?strcPage="+pagination.getPpPage()+"'> << </a>");
			out.print("<a href='AllviewDB.jsp?strcPage="+pagination.getpPage()+"'> < </a>");
		}
		int i = pagination.getFirstPage();
		while(i <= pagination.getPageSize()	){
			out.print("<a href='AllviewDB.jsp?strcPage="+i+"'> "+i+" </a>");
			i++;
		}
		if(pagination.getFirstPage() + pagination.getPageSize() < pagination.getNnPage()){
			out.print("<a href='AllviewDB.jsp?strcPage="+pagination.getNnPage()+"'> > </a>");
			out.print("<a href='AllviewDB.jsp?strcPage="+pagination.getnPage()+"'> >> </a>");
		}
		%>
	</div>
</body>
</html>