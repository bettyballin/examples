<?php

$password = readline("Enter your admin password: ");
$hash = password_hash($password, PASSWORD_DEFAULT);

$fp = fopen("config.txt", "w");
fwrite($fp, $hash);
fclose($fp);

echo "Password hash stored in config.txt\n";

?>