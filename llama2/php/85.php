<?php
$security_code = "1234567";
$random_position = rand(0, strlen($security_code) - 1);
$selected_character = substr($security_code, $random_position, 1);
print($selected_character);
?>