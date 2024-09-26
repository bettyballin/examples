<?php
// Create a random token in $_SESSION
session_start();
$_SESSION['token'] = md5(time() . rand());
?>

<input type='hidden' value='<?php echo $_SESSION['token']; ?>' name='token' />