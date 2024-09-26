<?php
$password = 'your_secret_password'; // replace with your password

if (isset($_POST['password']) && $_POST['password'] == $password) {
    $is_authenticated = true;
} else {
    $is_authenticated = false;
}

if ($is_authenticated) {
    // ... code ...
    echo "You are authenticated!";
} else {
    echo "Invalid password";
}
?>
<form action="" method="post">
    <input type="password" name="password" placeholder="Enter password">
    <input type="submit" value="Submit">
</form>