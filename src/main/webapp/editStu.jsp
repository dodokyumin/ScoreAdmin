<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�л� ���� ��ȸ ����/����</h1>
	<form action="editPageStu.jsp" method="post">
		<table cellspacing=1 width=400 border=0>
			<tr>
				<td width=100><p align="center">��ȸ�� �й�</p></td>
				<td width=200><p align="center">
						<input type="number" name="searchid">
					</p></td>
				<td width=100><input type="submit" value="��ȸ"></td>
			</tr>
			</form>
			<form>

				<table cellspacing=1 width=600 border=1>
					<tr>
						<td align=center>�̸�</td>
						<td align=center><input name="stuName" type="text" value=""
							readonly></input></td>
					</tr>
					<tr>
						<td align=center>�й�</td>
						<td align="center"><input value="" readonly></input></td>
					<tr>
						<td align=center>����</td>
						<td align=center><input name="stuKor" type="number" min='0'
							max="100" value="" readonly></input></td>
					</tr>
					<tr>
						<td align=center>����</td>
						<td align=center><input name="stuEng" type="number" min='0'
							max="100" value="" readonly></input></td>
					</tr>
					<tr>
						<td align=center>����</td>
						<td align=center><input name="stuMat" type="number" min='0'
							max="100" value="" readonly></input></td>
					</tr>

				</table>
			</form>
</body>
</html>