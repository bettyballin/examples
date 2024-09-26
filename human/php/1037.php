<?php
$entries = array_map('htmlentities', $_POST['entries']);
$username = htmlentities($_POST['username']);
$message = array_map('htmlentities', $_POST['message']);

print_r($entries);
echo "\n";
print_r($username);
echo "\n";
print_r($message);
?>