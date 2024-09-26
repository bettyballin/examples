<?php
// Create a simple form to test the code
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $_POST['email'] = filter_var($_POST['email'], FILTER_SANITIZE_EMAIL);
    echo $_POST['email'];
}
?>
<form method="post">
    <input type="email" name="email">
    <input type="submit">
</form>