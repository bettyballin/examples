<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $email = filter_var($_POST['email'], FILTER_VALIDATE_EMAIL);
    if ($email !== false) {
        echo "Well, you've got yourself a valid email address!";
    } else {
        echo "Invalid email address!";
    }
}
?>

<form method="post">
    Email: <input type="email" name="email">
    <input type="submit">
</form>