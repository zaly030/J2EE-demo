<%-- 
    Document   : withdraw
    Created on : 2017-8-16, 1:47:36
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Withdraw Page</title>
    </head>
    <body>
        <p></p>
        <form action="Withdraw" method="POST">
            <table>
                <tr>
                    <td>
                        Amount :
                    </td> 
                    <td>
                        <input type="text" name="balance" size="20">
                    </td>
                </tr>
            </table>
            <p>
                <input type="submit" value="Submit">
            </p>
        </form>
</html>
