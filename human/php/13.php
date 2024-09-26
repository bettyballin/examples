<?php
$str = "Your input string here";
$str = mb_convert_encoding($str, 'UTF-8', 'UTF-8');
$str = htmlentities($str, ENT_QUOTES, 'UTF-8');
print($str);
?>