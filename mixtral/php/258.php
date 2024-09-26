<?php
$var = "example input";
$escapedVar = escapeshellarg($var);
exec("your_bash_script $escapedVar");
?>