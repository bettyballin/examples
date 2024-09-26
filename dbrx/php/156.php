<?php
function sanitize_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}

// Usage:
$clean_post_data = array_map('sanitize_input', $_POST);
print_r($clean_post_data);
?>