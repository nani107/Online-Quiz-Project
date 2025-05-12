<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSTL Test</title>
</head>
<body>
    <c:set var="test" value="Hello, JSTL!" />
    <c:out value="${test}" />
</body>
</html>