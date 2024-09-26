
function generate_salt($length = 32) {
    return bin2hex(random_bytes($length));
}

$salt = generate_salt();
echo $salt;  // This will give you a 64-character hexadecimal string

