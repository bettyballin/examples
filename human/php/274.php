<?php
$securityCode = 'your_security_code_here';
$randomIndex = mt_rand(0, strlen($securityCode) - 1);
$randomChar = $securityCode[$randomIndex];

print($randomChar);
?>