<?php
$input = "Hello, <b>world</b>!";
$your_charset = "UTF-8";
$escaped = htmlspecialchars($input, ENT_QUOTES, $your_charset);
echo $escaped;
?>