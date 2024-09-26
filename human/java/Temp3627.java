html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Add Friend Form</title>
</head>
<body>
    <form action="#" th:action="@{/home/addFriend}" th:object="${formData}" method="post">
        <input type="hidden" th:field="*{friendId}" />
        <input type="hidden" th:field="*{customerId}" />
        <input type="submit" value="Add Friend" class="btn btn-primary flex-grow-1" />
    </form>

    <!-- Include the Thymeleaf JavaScript files (if necessary) -->
    <script th:src="@{/js/thymeleaf.js}"></script>
</body>
</html>