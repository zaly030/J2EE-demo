<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="Login" method="POST">
            <p><a href="register.jsp">Register</a></p>
            <table>
                <tr>
                    <td>
                        User Name :
                    </td> 
                    <td>
                        <input type="text" name="username" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Password :
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
