<?php
  $salt = random_bytes(16);
  $hash = password_hash('bla', PASSWORD_BCRYPT, ['salt' => $salt]);
  print($hash);
?>