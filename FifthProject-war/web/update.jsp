<%-- 
    Document   : update
    Created on : 2017-8-16, 1:44:16
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <form action="Update" method="POST">
            <table>
                <tr>
                    <td>
                        New Password:
                    </td> 
                    <td>
                        <input type="text" name="password" size="20">
                    </td>
                </tr>
            </table>
            <p>
                <input type="submit" value="Submit">
            </p>
        </form>
    </body>
</html>
