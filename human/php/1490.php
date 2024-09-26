<?php
$username = filter_input(INPUT_POST, 'username', FILTER_SANITIZE_STRING);
echo $username;
?>
<form action="" method="post">
  <input type="text" name="username" placeholder="Enter username">
  <input type="submit" value="Submit">
</form>