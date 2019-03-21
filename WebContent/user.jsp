<%-- 
    Document   : user
    Created on : Mar 19, 2019, 8:45:19 PM
    Author     : khoerulAbu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action='UserController' name="form_tambah_data">
        <table>
            <tr>
                <td>Nama</td>
                <td>:</td>
                <td><input type="text" name="nama"  /></td>
            </tr>
             <tr>
                <td>Email</td>
                <td>:</td>
                <td><input type="text" name="email"  /></td>
            </tr>
             <tr>
                <td>Job</td>
                <td>:</td>
                <td><input type="text" name="job"  /></td>
            </tr>
        </table>
        <input type="submit" value="Submit" />
    </form>
    </body>
</html>
