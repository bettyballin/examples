<?php

// Start session
session_start();

// Generate token on login
$_SESSION['token'] = bin2hex(random_bytes(32));

?>

<!-- Include hidden form field with token value -->
<form action="delete-user.php" method="post">
    <input type="hidden" name="token" value="<?= $_SESSION['token']; ?>">
    <button type="submit">Delete User</button>
</form>

<?php

// Verify token on server-side (in delete-user.php)
if (!isset($_POST['token']) || $_POST['token'] !== $_SESSION['token']) {
    // Reject request
    header('HTTP/1.0 403 Forbidden');
    exit;
}

// Delete user
// ...

?>