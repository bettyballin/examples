html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5">
<head>
    <title>Login Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <form th:action="@{/loginauth}" method="post">
            <span sec:authorize="!isAuthenticated()">
                <div class="form-group">
                    <input type="text" name="email" placeholder="e-mail" class="form-control" required="true"/>
                </div>
                <div class="form-group">
                    <input type="password" name="password" placeholder="password" class="form-control" required="true"/>
                </div>
                <button type="submit" class="btn btn-success btn-xs">Log in</button>
            </span>
        </form>
    </div>
</body>
</html>