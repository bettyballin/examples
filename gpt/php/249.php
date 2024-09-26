
function randomPassword() {
    $alphabet = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ0123456789";
    $pass = ""; // Initialize as a string
    for ($i = 0; $i < 8; $i++) {
        $n = rand(0, strlen($alphabet) - 1); // Use strlen() for string length
        $pass .= $alphabet[$n]; // Append the character to the string
    }
    return $pass;
}

