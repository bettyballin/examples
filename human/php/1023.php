<?php
function hashPassword($password, $format_and_salt) {
    $hash = crypt($password, $format_and_salt);
    if ($hash === '*0') {
        throw new Exception('Password hashing unsuccessful.');
    }
    return $hash;
}

$password = "mysecretpassword";
$format_and_salt = "$2y$10$anexamplestringforsalt";
try {
    echo hashPassword($password, $format_and_salt);
} catch (Exception $e) {
    echo 'Caught exception: ',  $e->getMessage(), "\n";
}
?>