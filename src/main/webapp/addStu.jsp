<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 성적 추가</h1>
	<form action="addDoneStu.jsp" method="post">
		<table cellspacing=1 width=400 border=1>
			<tr>
				<td align=center>이름</td>
				<td align=center><input name="stuName" type="text" required
					placeholder="이름을 입력하세요." maxlength=20 required pattern='^[가-힣a-zA-Z]+$'></input></td>
				<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
			</tr>
			<tr>
				<td align=center>학번</td>
				<td align="center">자동부여</td>
				<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
			</tr>
			<tr>
				<td align=center>국어</td>
				<td align=center><input name="stuKor" type="number" min='0'
					max="100" maxlength=20 required pattern='^[0-9]+$'></input></td>
				<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
			</tr>
			<tr>
				<td align=center>영어</td>
				<td align=center><input name="stuEng" type="number" min='0'
					max="100" maxlength=20 pattern='^[0-9]+$' required></input></td>
				<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
			</tr>
			<tr>
				<td align=center>수학</td>
				<td align=center><input name="stuMat" type="number" min='0'
					max="100" maxlength=20 pattern='^[0-9]+$' required></input></td>
				<!-- 출력하여 보여줄 ui 테이블 맨 윗 항목 설정-->
			</tr>

		</table>
		<input type="submit" value="추가">
	</form>
</body>
</html>