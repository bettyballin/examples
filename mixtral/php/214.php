<?php
  $hashedPassword = password_hash($_POST['password'], PASSWORD_DEFAULT);
  // Store $hashedPassword in your database
?>