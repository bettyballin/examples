<?php
// login form
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // validate input
    $username = $_POST['username'];
    $password = $_POST['password'];

    if (empty($username) || empty($password)) {
        echo "Please fill out all fields.";
    } else {
        // your login logic here
        echo "Login successful!";
    }
} else {
?>

<form action="" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br><br>
    <input type="submit" value="Login">
</form>

<?php } ?>