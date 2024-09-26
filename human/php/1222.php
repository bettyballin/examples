<?php
$password = "your_password_here";
$hashToStoreInDb = password_hash($password, PASSWORD_DEFAULT);
echo $hashToStoreInDb;
?>