<?php
function protect($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}

// Test the function
$input = "  <script>alert('XSS')</script>  ";
$protected_input = protect($input);
echo "Protected input: $protected_input";
?>