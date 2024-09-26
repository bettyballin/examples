
<?php
session_start();

// Check if the form has been submitted
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $pass = $_POST['password'];
    $correct_password = 'mypassword'; // Replace this with your actual password

    if ($pass == $correct_password) {
        // Set a session variable to indicate the user is logged in
        $_SESSION['logged_in'] = true;

        // Redirect to the protected page
        header('Location: index.php');
        exit;
    } else {
        echo "Incorrect password!";
    }
}
?>

<!-- The login form -->
<form method="post">
    Password: <input type="password" name="password">
    <input type="submit" value="Login">
</form>

