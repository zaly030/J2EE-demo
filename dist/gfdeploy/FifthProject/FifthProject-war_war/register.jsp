<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Register Page</title>
    </head>
    <body>
        <form action="Register" method="POST">
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
                        Gender :
                    </td> 
                    <td>
                        <input type="text" name="gender" size="20">
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
                <tr>
                    <td>
                        Balance (RM) :
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
    </body>
</html>
