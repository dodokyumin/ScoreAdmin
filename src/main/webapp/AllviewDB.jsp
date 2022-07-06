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
<meta charset="UTF-8">
<title>전교생 성적 조회</title>
</head>
<body>
	<h1>전교생 성적 조회</h1>
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
				List<ScoreItem> scoreItems = scoreItemService.selectAll(strcPage);
				Pagination pagination = scoreItemService.getPagination(strcPage);
				
				ServletContext context = getServletContext();
				context.setAttribute("scoreItems", scoreItems);
				context.setAttribute("pagination", pagination);	
		%>		

		<c:forEach var="scoreItem" items="${scoreItems}">
		<tr>
			<td><p class="center"><a href="selectOne.jsp?studentid=${scoreItem.studentid}">${scoreItem.name}</a></td>
			<td><p class="center">${scoreItem.studentid}</td>
					<td><p class="center">${scoreItem.kor}</td>
					<td><p class="center">${scoreItem.eng}</td>
					<td><p class="center">${scoreItem.mat}</td>
		<tr>
		</c:forEach>
	</table>
	<div>
		
		<c:if test="${pagination.getcPage() > pagination.getPageSize()}">
		<!--  if(pagination.getcPage() > pagination.getPageSize()){ -->
			<a href='AllviewDB.jsp?strcPage=${pagination.getPpPage()}'> << </a>
			<a href='AllviewDB.jsp?strcPage=${pagination.getpPage()}'> < </a>
		<!-- //} -->
		</c:if>
		
		<!-- int i = pagination.getFirstPage(); -->
		
		
		<!-- context.setAttribute("scoreItems", scoreItems); -->
		
		<c:forEach var="noPage" begin="${pagination.firstPage}" end="${pagination.lastPage}">
			<c:if test="${noPage != 0}">
				<c:choose>
					<c:when test="${noPage == pagination.cPage}">
						<b><a style='text-decoration: underline;' href='AllviewDB.jsp?strcPage=${noPage}'>${noPage}</a></b>
					</c:when>
					<c:when test="${noPage != pagination.getcPage()}">
						<a href='AllviewDB.jsp?strcPage=${noPage}'>${noPage}</a>
					</c:when>
				</c:choose>
			</c:if>
		<!--  for(int i = pagination.getFirstPage(); i <= pagination.getLastPage(); pagination.setFirstPage(pagination.getFirstPage() + 1)){
			out.print("<a href='AllviewDB.jsp?strcPage="+i+"'> "+i+" </a>");
		} -->
		</c:forEach>
		
		
		<c:if test="${pagination.firstPage + pagination.pageSize <= pagination.nnPage}">
		<!--  if(pagination.getFirstPage() + pagination.getPageSize() <= pagination.getNnPage()){ -->
			<a href='AllviewDB.jsp?strcPage=${pagination.nPage}'> > </a>
			<a href='AllviewDB.jsp?strcPage=${pagination.nnPage}'> >> </a>
		<!-- } -->
		</c:if>
	</div>
</body>
</html>