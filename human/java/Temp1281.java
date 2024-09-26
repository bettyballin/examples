html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
</head>
<body>

<form action="/login" method="POST">
    <table align="Center">
        <tr>
            <td id="tdlogin">Email Address</td>
            <td><input type="text" name="username" id="username"/></td>
        </tr>
        <tr>
            <td id="tdlogin">Password</td>
            <td><input type="text" name="password" id="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="checkbox" name="staySignIn" value="staySignIn"> Stay Sign In </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" id="Submit" value="SUBMIT"></td>
        </tr>
    </table>
</form>

<% if (request.getAttribute("error") != null) { %>
    <div class="error"><%= request.getAttribute("error") %></div>
<% } %>
<% if (request.getAttribute("msg") != null) { %>
    <div class="msg"><%= request.getAttribute("msg") %></div>
<% } %>

</body>
</html>