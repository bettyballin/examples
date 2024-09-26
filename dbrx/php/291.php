<?php
$allowed_chars = 'A-Za-z0-9\\(\\)\\+\\-\\*\\/\\^%\\s';
$formula = "example formula";
$formula = preg_replace('/[^' . $allowed_chars . ']/', '', $formula);
print($formula);
?>