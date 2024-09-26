<?php
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['logged_out'])) {
    // logout logic here
    session_destroy();
    header('Location: login.php');
    exit;
}
?>

<form id="logout-form" method="post">
    <input type="hidden" name="logged_out" value="true">
    <button type="submit">Logout</button>
</form>