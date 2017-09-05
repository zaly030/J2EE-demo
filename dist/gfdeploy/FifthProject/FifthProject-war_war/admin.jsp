<%-- 
    Document   : admin
    Created on : Aug 30, 2017, 3:11:23 PM
    Author     : TP037327
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <form action="Admin" method="POST">
            <table>
                <tr>
                    <td>
                        Gender :
                    </td> 
                    <td>
                        <input type="text" name="gender" size="20">
                    </td>
                </tr>
            </table>
            <p>
                <input type="submit" value="Submit">
            </p>
        </form>
    </body>
</html>
