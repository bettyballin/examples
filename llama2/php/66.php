<?php
function cleanMe($input) {
    $input = mysqli_real_escape_string($input);
    $input = htmlspecialchars($input, ENT_QUOTES, 'utf-8');
    return $input;
}

// Test the function
$input = "Test input with <script>alert('XSS')</script>";
echo cleanMe($input);
?>