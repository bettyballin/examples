<?php
function check_input($data)
 {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
 }

// Example usage:
$input = " Hello, World! ";
echo "Original input: $input\n";
$clean_input = check_input($input);
echo "Cleaned input: $clean_input\n";
?>