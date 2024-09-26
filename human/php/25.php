<?php
$string1 = "Hello";
$string2 = "World";
$salt = "secret";
$hash = sha1($string1 . $string2 . $salt);
$separator = "_";
$str = $string1 . $separator . $string2 . $separator . $hash;
echo $str;
?>