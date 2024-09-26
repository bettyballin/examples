<?php
$value = "test'value";
$escaped_value = mysql_real_escape_string(mysql_real_escape_string($value));
print($escaped_value);
?>