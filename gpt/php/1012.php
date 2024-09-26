
function secure_setcookie($name, $value, $expire, $path = '', $domain = '', $secure = true, $httponly = true) {
    setcookie($name, $value, $expire, $path, $domain, $secure, $httponly);
}

// Now, use your secure_setcookie function to set cookies
secure_setcookie("ABC_user", "", time() + 3600);

