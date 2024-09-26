<?php
$user_input = $_GET['user_input'];

// some actions with user input
$command = escapeshellarg($user_input);
exec("ls $command", $output);
print_r($output);
?>