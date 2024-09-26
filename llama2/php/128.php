<?php

$mysqli = new mysqli("localhost", "username", "password", "database");

$stmt = $mysqli->prepare("SELECT * FROM users WHERE username = ? AND password = ?");
$stmt->bind_param("ss", $username, $password);

if(isset($_POST['login_submit_button']) && isset($_POST['username']) && $_POST['username'] != "" && isset($_POST['password']) && $_POST['password'] != "") {
    $username = $_POST['username'];
    $password = $_POST['password'];
    $stmt->execute();
    $result = $stmt->get_result();
    while ($row = $result->fetch_assoc()) {
        // rest of the code
        print_r($row);
    }
}

?>
<form action="" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" name="login_submit_button" value="Login">
</form>