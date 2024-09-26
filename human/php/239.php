<?php
$salt = substr(sha1(uniqid(mt_rand(), true)), 0, 16);
print($salt);
?>