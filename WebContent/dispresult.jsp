<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="dataSource" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/ceamitic" user="root" password="CadreInfo1" />

	<sql:query dataSource="${dataSource}" var="categories" scope="session">
        SELECT * FROM indicateur
</sql:query>
	<c:set var="categories" value="${sessionScope.categories}" />
	<c:set var="rowsPerPage" value="3" />
	<c:set var="pageNumber" value="${param.pageNumber}" />
	<c:set var="a">
		<fmt:formatNumber value="${categories.rowCount/rowsPerPage}"
			maxFractionDigits="0" />
	</c:set>

	<c:set var="b" value="${categories.rowCount/rowsPerPage}" />


	<c:choose>
		<c:when test="${a==0}">
			<c:set var="numberOfPages" value="1" scope="session" />
		</c:when>

		<c:when test="${b>a}">
			<c:set var="xxx" value="${b%a}" />
			<c:if test="${xxx>0}">
				<c:set var="numberOfPages" value="${b-xxx+1}" scope="session" />
			</c:if>
		</c:when>

		<c:when test="${a>=b}">
			<c:set var="numberOfPages" value="${a}" scope="session" />
		</c:when>
	</c:choose>

	<c:set var="start" value="${pageNumber*rowsPerPage-rowsPerPage}" />
	<c:set var="stop" value="${pageNumber*rowsPerPage-1}" />
	<center>
			<c:set var="columns" value="0" scope="session" />
			<c:forEach items="${categories.columnNames}" var="name">
				<c:set var="columns" value="${columns+1}" />
			</c:forEach>
			<c:set var="columns" value="${columns-1}" />

			<c:forEach items="${categories.rowsByIndex}" var="row"
				begin="${start}" end="${stop}">
					<c:forEach begin="0" end="${columns}" var="x">
						<div><c:out value="${row[x]}" /></div>
					</c:forEach>
			</c:forEach>
		
		<%--For displaying Previous link --%>
		<c:if test="${pageNumber gt 1}">
			<a href="dispresult.jsp?pageNumber=${pageNumber - 1}">Previous</a>
		</c:if>
		<c:forEach begin="1" end="${numberOfPages}" var="i">
			<c:choose>
				<c:when test="${i!=pageNumber}">
					<a href="dispresult.jsp?pageNumber=<c:out value="${i}"/>"><c:out
							value="${i}" /></a>
				</c:when>
				<c:otherwise>
					<c:out value="${i}" />
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<%--For displaying Next link --%>
		<c:if test="${pageNumber lt numberOfPages}">
			<a href="dispresult.jsp?pageNumber=${pageNumber + 1}">Next</a>
		</c:if>
	</center>
</body>
</html>