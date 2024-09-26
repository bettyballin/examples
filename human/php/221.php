<?php
$authField = 'user:hash:digestToken';
list ($user, $hash, $digestToken) = explode(':', $authField);
print($user . "\n");
print($hash . "\n");
print($digestToken . "\n");
?>