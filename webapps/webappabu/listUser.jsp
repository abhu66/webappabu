<%-- 
    Document   : listUser
    Created on : Mar 19, 2019, 8:42:07 PM
    Author     : khoerulAbu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Show All Users</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Nama</th>
                <th>Email</th>
                <th>Job</th>
                <th>Tanggal</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.nama}</td>
                    <td>${user.email}</td>
                    <td>${user.job}</td>
                    <td><fmt:formatDate pattern="MM-dd-yyyy" value="${user.tanggal}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="UserController?action=tambah-data">Tambah Data</a></p>
</body>
</html>
