<?php
$password = 'your_secret_password'; // replace with your password

$is_authenticated = false;
if (isset($_POST['password']) && $_POST['password'] == $password) {
    $is_authenticated = true;
}

if ($is_authenticated) {
    // ... code ...
    echo "Authenticated!";
} else {
    echo "Authentication failed.";
}

// simple form to test the code
?>

<form action="" method="post">
    <input type="password" name="password" placeholder="Enter password">
    <input type="submit" value="Submit">
</form>