<?php
function hashPassword($str)
{
        return hash("sha512", $str . "salt");
}

$password = "mysecretpassword";
$hashedPassword = hashPassword($password);
print($hashedPassword);
?>