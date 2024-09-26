<?php
session_start();
$_SESSION['csrfToken'] = bin2hex(random_bytes(32));
?>

<form action="createNewUser.php" method="post">
  <input type="hidden" name="token" value="<?= $_SESSION['csrfToken']; ?>"/>
</form>